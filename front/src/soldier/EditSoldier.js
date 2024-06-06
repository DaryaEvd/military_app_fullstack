import React, { useState, useEffect } from "react";
import axios from "axios";
import { useNavigate, useParams, Link } from "react-router-dom";

export default function EditSoldier() {
    const navigate = useNavigate();
    const { id } = useParams();
    const [soldier, setSoldier] = useState({
        firstName: "",
        lastName: "",
        dateOfBirth: "",
        militaryCard: "",
        dateOfIssueMilitaryCard: "",
        masId: "",
        typeOfSoldier: "",
        subdivisionId: "",
        isCommander: false
    });

    const [masList, setMasList] = useState([]);
    const [soldierTypeList, setSoldierTypeList] = useState([]);
    const [subdivisionList, setSubdivisionList] = useState([]);

    useEffect(() => {
        fetchMasList();
        fetchSoldierTypeList();
        fetchSubdivisionList();
        loadSoldier();
    }, []);

    const fetchMasList = async () => {
        try {
            const response = await axios.get("http://localhost:8080/api/mas");
            setMasList(response.data);
        } catch (error) {
            console.error("Error fetching Mas list:", error);
        }
    };

    const fetchSoldierTypeList = async () => {
        try {
            const response = await axios.get("http://localhost:8080/api/soldier_type");
            setSoldierTypeList(response.data);
        } catch (error) {
            console.error("Error fetching SoldierType list:", error);
        }
    };

    const fetchSubdivisionList = async () => {
        try {
            const response = await axios.get("http://localhost:8080/api/subdivision");
            setSubdivisionList(response.data);
        } catch (error) {
            console.error("Error fetching Subdivision list:", error);
        }
    };

    const loadSoldier = async () => {
        try {
            const result = await axios.get(`http://localhost:8080/api/soldiers/${id}`);
            setSoldier(result.data);
        } catch (error) {
            console.error("Error loading soldier:", error);
        }
    };

    const onInputChange = e => {
        const { name, value, type, checked } = e.target;
        setSoldier({
            ...soldier,
            [name]: type === 'checkbox' ? checked : value
        });
    };

    const onSubmit = async e => {
        e.preventDefault();
        try {
            await axios.put(`http://localhost:8080/api/soldiers/${id}`, soldier);
            navigate("/soldiers");
        } catch (error) {
            console.error("Error updating soldier:", error);
        }
    };

    return (
        <div className='container'>
            <div className='row'>
                <div className='col-md-6 offset-md-3 border rounded p-4 mt-2 shadow'>
                    <h2 className='text-center m-4'>Edit Soldier</h2>
                    <form onSubmit={onSubmit}>
                        <div className='mb-3'>
                            <label className='form-label'>First Name</label>
                            <input
                                type="text"
                                className="form-control"
                                name="firstName"
                                value={soldier.firstName}
                                onChange={onInputChange}
                                required
                            />
                        </div>
                        <div className='mb-3'>
                            <label className='form-label'>Last Name</label>
                            <input
                                type="text"
                                className="form-control"
                                name="lastName"
                                value={soldier.lastName}
                                onChange={onInputChange}
                                required
                            />
                        </div>
                        <div className='mb-3'>
                            <label className='form-label'>Date of Birth</label>
                            <input
                                type="date"
                                className="form-control"
                                name="dateOfBirth"
                                value={soldier.dateOfBirth}
                                onChange={onInputChange}
                                required
                            />
                        </div>
                        <div className='mb-3'>
                            <label className='form-label'>Military Card</label>
                            <input
                                type="text"
                                className="form-control"
                                name="militaryCard"
                                value={soldier.militaryCard}
                                onChange={onInputChange}
                                required
                            />
                        </div>
                        <div className='mb-3'>
                            <label className='form-label'>Date of Issue Military Card</label>
                            <input
                                type="date"
                                className="form-control"
                                name="dateOfIssueMilitaryCard"
                                value={soldier.dateOfIssueMilitaryCard}
                                onChange={onInputChange}
                                required
                            />
                        </div>
                        <div className='mb-3'>
                            <label className='form-label'>Mas</label>
                            <select
                                className="form-control"
                                name="masId"
                                value={soldier.masId}
                                onChange={onInputChange}
                                required
                            >
                                <option value="">Select Mas</option>
                                {masList.map(mas => (
                                    <option key={mas.id} value={mas.id}>
                                        {mas.nameOfMas}
                                    </option>
                                ))}
                            </select>
                        </div>
                        <div className='mb-3'>
                            <label className='form-label'>Type Of Soldier</label>
                            <select
                                className="form-control"
                                name="typeOfSoldier"
                                value={soldier.typeOfSoldier}
                                onChange={onInputChange}
                                required
                            >
                                <option value="">Select Soldier Type</option>
                                {soldierTypeList.map(type => (
                                    <option key={type.id} value={type.id}>
                                        {type.nameOfType}
                                    </option>
                                ))}
                            </select>
                        </div>
                        <div className='mb-3'>
                            <label className='form-label'>Subdivision</label>
                            <select
                                className="form-control"
                                name="subdivisionId"
                                value={soldier.subdivisionId}
                                onChange={onInputChange}
                                required
                            >
                                <option value="">Select Subdivision</option>
                                {subdivisionList.map(subdivision => (
                                    <option key={subdivision.id} value={subdivision.id}>
                                        {subdivision.nameOfSubdivision}
                                    </option>
                                ))}
                            </select>
                        </div>
                        <div className='mb-3'>
                            <div className='form-check'>
                                <input
                                    className='form-check-input'
                                    type='checkbox'
                                    name='isCommander'
                                    checked={soldier.isCommander}
                                    onChange={onInputChange}
                                />
                                <label className='form-check-label'>Commander</label>
                            </div>
                        </div>
                        <button type="submit" className="btn btn-primary">Submit</button>
                        <Link className="btn btn-danger mx-2" to="/soldiers">Cancel</Link>
                    </form>
                </div>
            </div>
        </div>
    );
}
