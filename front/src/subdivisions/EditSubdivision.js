import React, { useState, useEffect } from "react";
import axios from "axios";
import { useNavigate, useParams, Link } from "react-router-dom";

export default function EditSubdivision() {
    const navigate = useNavigate();
    const { id } = useParams();

    const [subdivision, setSubdivision] = useState({
        nameOfSubdivision: "",
        numberOfSubdivision: "",
        isDislocated: false,
        commanderId: "",
        typeOfSubdivisionId: ""
    });

    const [commanderList, setCommanderList] = useState([]);
    const [subdivisionTypeList, setSubdivisionTypeList] = useState([]);

    useEffect(() => {
        fetchCommanderList();
        fetchSubdivisionTypeList();
        loadSubdivision();
    }, []);

    const fetchCommanderList = async () => {
        try {
            const response = await axios.get("http://localhost:8080/api/soldiers");
            setCommanderList(response.data);
        } catch (error) {
            console.error("Error fetching commander list:", error);
        }
    };

    const fetchSubdivisionTypeList = async () => {
        try {
            const response = await axios.get("http://localhost:8080/api/subdivision_types");
            setSubdivisionTypeList(response.data);
        } catch (error) {
            console.error("Error fetching subdivision type list:", error);
        }
    };

    const loadSubdivision = async () => {
        try {
            const result = await axios.get(`http://localhost:8080/api/subdivision/${id}`);
            setSubdivision({
                ...result.data,
                commanderId: result.data.commanderId || "",
                typeOfSubdivisionId: result.data.typeOfSubdivisionId || ""
            });
        } catch (error) {
            console.error("Error loading subdivision:", error);
        }
    };

    const onInputChange = (e) => {
        const { name, value, type, checked } = e.target;
        setSubdivision({
            ...subdivision,
            [name]: type === 'checkbox' ? checked : value
        });
    };

    const onSubmit = async (e) => {
        e.preventDefault();
        try {
            await axios.put(`http://localhost:8080/api/subdivision/${id}`, subdivision);
            navigate("/subdivisions");
        } catch (error) {
            console.error("Error updating subdivision:", error);
        }
    };

    return (
        <div className='container'>
            <div className='row'>
                <div className='col-md-6 offset-md-3 border rounded p-4 mt-2 shadow'>
                    <h2 className='text-center m-4'>Edit Subdivision</h2>
                    <form onSubmit={onSubmit}>
                        <div className='mb-3'>
                            <label className='form-label'>Name Of Subdivision</label>
                            <input
                                type="text"
                                className="form-control"
                                name="nameOfSubdivision"
                                value={subdivision.nameOfSubdivision || ""}
                                onChange={onInputChange}
                                required
                            />
                        </div>
                        <div className='mb-3'>
                            <label className='form-label'>Number Of Subdivision</label>
                            <input
                                type="number"
                                className="form-control"
                                name="numberOfSubdivision"
                                value={subdivision.numberOfSubdivision || ""}
                                onChange={onInputChange}
                                required
                            />
                        </div>
                        <div className='mb-3'>
                            <div className='form-check'>
                                <input
                                    className='form-check-input'
                                    type='checkbox'
                                    name='isDislocated'
                                    checked={subdivision.isDislocated}
                                    onChange={onInputChange}
                                />
                                <label className='form-check-label'>Dislocated</label>
                            </div>
                        </div>
                        <div className='mb-3'>
                            <label className='form-label'>Commander</label>
                            <select
                                className="form-control"
                                name="commanderId"
                                value={subdivision.commanderId || ""}
                                onChange={onInputChange}
                                required
                            >
                                <option value="">Select Commander</option>
                                {commanderList.map(commander => (
                                    <option key={commander.id} value={commander.id}>
                                        {commander.firstName} {commander.lastName}
                                    </option>
                                ))}
                            </select>
                        </div>
                        <div className='mb-3'>
                            <label className='form-label'>Type Of Subdivision</label>
                            <select
                                className="form-control"
                                name="typeOfSubdivisionId"
                                value={subdivision.typeOfSubdivisionId || ""}
                                onChange={onInputChange}
                                required
                            >
                                <option value="">Select Subdivision Type</option>
                                {subdivisionTypeList.map(type => (
                                    <option key={type.id} value={type.id}>
                                        {type.nameOfType}
                                    </option>
                                ))}
                            </select>
                        </div>
                        <button type="submit" className="btn btn-primary">Submit</button>
                        <Link className="btn btn-danger mx-2" to="/subdivisions">Cancel</Link>
                    </form>
                </div>
            </div>
        </div>
    );
}
