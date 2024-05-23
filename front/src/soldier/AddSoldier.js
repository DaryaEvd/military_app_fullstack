import axios from 'axios';
import React, { useState, useEffect } from 'react';
import { useNavigate, Link } from 'react-router-dom';

export default function AddSoldier() {
    let navigate = useNavigate();

    const [soldier, setSoldier] = useState({
        firstName: "",
        lastName: "",
        dateOfBirth: "",
        militaryCard: "",
        dateOfIssueMilitaryCard: "",
        masId: "",
        typeOfSoldier: ""
    });

    const [masList, setMasList] = useState([]);
    const [soldierTypeList, setSoldierTypeList] = useState([]);

    useEffect(() => {
        const fetchMasList = async () => {
            try {
                const response = await axios.get("http://localhost:8080/api/mas", {
                    withCredentials: true
                });
                setMasList(response.data);
            } catch (error) {
                console.error("Error fetching Mas list:", error);
            }
        };

        const fetchSoldierTypeList = async () => {
            try {
                const response = await axios.get("http://localhost:8080/api/soldier_type", {
                    withCredentials: true
                });
                setSoldierTypeList(response.data);
            } catch (error) {
                console.error("Error fetching SoldierType list:", error);
            }
        };

        fetchMasList();
        fetchSoldierTypeList();
    }, []); 
    
    useEffect(() => {
        const fetchMasList = async () => {
            try {
                const response = await axios.get("http://localhost:8080/api/mas", {
                    withCredentials: true
                });
                setMasList(response.data);
            } catch (error) {
                console.error("Error fetching Mas list:", error);
            }
        };

        const fetchSoldierTypeList = async () => {
            try {
                const response = await axios.get("http://localhost:8080/api/soldier_type", {
                    withCredentials: true
                });
                setSoldierTypeList(response.data);
            } catch (error) {
                console.error("Error fetching SoldierType list:", error);
            }
        };

        fetchMasList();
        fetchSoldierTypeList();
    }, []);

    const { firstName, lastName, dateOfBirth, militaryCard, dateOfIssueMilitaryCard, masId, typeOfSoldier } = soldier;

    const onInputChange = (e) => {
        setSoldier({ ...soldier, [e.target.name]: e.target.value });
    };

    const onSubmit = async (e) => {
        e.preventDefault();
        try {
            // Ensure subdivisionIds is initialized
            if (!soldier.subdivisionIds) {
                soldier.subdivisionIds = [];
            }
            
            await axios.post("http://localhost:8080/api/soldiers", soldier);
            navigate("/soldiers");
        } catch (error) {
            if (error.response) {
                console.error("Backend returned an error:", error.response.data);
                console.error("Status code:", error.response.status);
            } else if (error.request) {
                console.error("No response received:", error.request);
            } else {
                console.error("Error in setting up request:", error.message);
            }
        }
    };   

    return (
        <div className='container'>
            <div className='row'>
                <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
                    <h2 className='text-center m-4'>Register Soldier</h2>
                    <form onSubmit={(e) => onSubmit(e)}>

                        <div className='mb-3'>
                            <label htmlFor='firstName' className='form-label'>First Name</label>
                            <input
                                type="text"
                                className='form-control'
                                placeholder='Enter first name of soldier'
                                name="firstName"
                                id="firstName"
                                value={firstName}
                                onChange={(e) => onInputChange(e)}
                            />
                        </div>

                        <div className='mb-3'>
                            <label htmlFor='lastName' className='form-label'>Last Name</label>
                            <input
                                type="text"
                                className='form-control'
                                placeholder='Enter last name of soldier'
                                name="lastName"
                                id="lastName"
                                value={lastName}
                                onChange={(e) => onInputChange(e)}
                            />
                        </div>

                        <div className='mb-3'>
                            <label htmlFor='dateOfBirth' className='form-label'>Date Of Birth</label>
                            <input
                                type="date"
                                className='form-control'
                                name="dateOfBirth"
                                id="dateOfBirth"
                                value={dateOfBirth}
                                onChange={(e) => onInputChange(e)}
                            />
                        </div>

                        <div className='mb-3'>
                            <label htmlFor='militaryCard' className='form-label'>Military Card</label>
                            <input
                                type="text"
                                className='form-control'
                                placeholder='Enter military card'
                                name="militaryCard"
                                id="militaryCard"
                                value={militaryCard}
                                onChange={(e) => onInputChange(e)}
                            />
                        </div>

                        <div className='mb-3'>
                            <label htmlFor='dateOfIssueMilitaryCard' className='form-label'>Date Of Issue Military Card</label>
                            <input
                                type="date"
                                className='form-control'
                                name="dateOfIssueMilitaryCard"
                                id="dateOfIssueMilitaryCard"
                                value={dateOfIssueMilitaryCard}
                                onChange={(e) => onInputChange(e)}
                            />
                        </div>

                        <div className='mb-3'>
                            <label htmlFor='masId' className='form-label'>Mas</label>
                            <select
                                className='form-control'
                                name="masId"
                                id="masId"
                                value={masId}
                                onChange={(e) => onInputChange(e)}
                            >
                                <option value="">Select Mas</option>
                                {masList.map(mas => (
                                    <option key={mas.id} value={mas.id}>{mas.name}</option>
                                ))}
                            </select>
                        </div>

                        <div className='mb-3'>
                            <label htmlFor='typeOfSoldier' className='form-label'>Type Of Soldier</label>
                            <select
                                className='form-control'
                                name="typeOfSoldier"
                                id="typeOfSoldier"
                                value={typeOfSoldier}
                                onChange={(e) => onInputChange(e)}
                            >
                                <option value="">Select Type</option>
                                {soldierTypeList.map(type => (
                                    <option key={type.id} value={type.id}>{type.name}</option>
                                ))}
                            </select>
                        </div>

                        <button type="submit" className="btn btn-outline-primary">Submit</button>
                        <Link className="btn btn-outline-danger mx-2" to="/soldiers">Cancel</Link>
                    </form>
                </div>
            </div>
        </div>
    );
}
