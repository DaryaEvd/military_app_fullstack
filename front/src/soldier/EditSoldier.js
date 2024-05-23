import axios from 'axios';
import React, { useState, useEffect } from 'react';
import { useNavigate, Link, useParams } from 'react-router-dom';

export default function EditSoldier() {
    let navigate = useNavigate();
    const { id } = useParams();
    
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
                    withCredentials: false
                });
                setMasList(response.data);
            } catch (error) {
                console.error("Error fetching Mas list:", error);
            }
        };

        const fetchSoldierTypeList = async () => {
            try {
                const response = await axios.get("http://localhost:8080/api/soldier_type", {
                    withCredentials: false
                });
                setSoldierTypeList(response.data);
            } catch (error) {
                console.error("Error fetching SoldierType list:", error);
            }
        };

        fetchMasList();
        fetchSoldierTypeList();
        loadSoldier();
    }, []);

    const { firstName, lastName, dateOfBirth, militaryCard, dateOfIssueMilitaryCard, masId, typeOfSoldier } = soldier;

    const onInputChange = (e) => {
        setSoldier({ ...soldier, [e.target.name]: e.target.value });
    };

    const onSubmit = async (e) => {
        e.preventDefault();
        try {
            await axios.put(`http://localhost:8080/api/soldiers/${id}`, soldier);
            navigate("/soldiers");
        } catch (error) {
            console.error("Error updating soldier:", error);
        }
    };

    const loadSoldier = async () => {
        try {
            const result = await axios.get(`http://localhost:8080/api/soldiers/${id}`);
            // Ensure the date format is corrected before setting the state
            const soldierData = result.data;
            soldierData.dateOfBirth = soldierData.dateOfBirth.split('T')[0];
            soldierData.dateOfIssueMilitaryCard = soldierData.dateOfIssueMilitaryCard.split('T')[0];
            setSoldier(soldierData);
        } catch (error) {
            console.error("Error loading soldier data:", error);
        }
    };

    return (
        <div className='container'>
            <div className='row'>
                <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
                    <h2 className='text-center m-4'>Edit Soldier</h2>
                    <form onSubmit={onSubmit}>
                        <div className='mb-3'>
                            <label htmlFor='firstName' className='form-label'>First Name</label>
                            <input
                                type="text"
                                className='form-control'
                                placeholder='Enter first name of soldier'
                                name="firstName"
                                id="firstName"
                                value={firstName}
                                onChange={onInputChange}
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
                                onChange={onInputChange}
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
                                onChange={onInputChange}
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
                                onChange={onInputChange}
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
                                onChange={onInputChange}
                            />
                        </div>

                        <div className='mb-3'>
                            <label htmlFor='masId' className='form-label'>Mas</label>
                            <select
                                className='form-control'
                                name="masId"
                                id="masId"
                                value={masId}
                                onChange={onInputChange}
                            >
                                <option value="">Select Mas</option>
                                {masList.map(mas => (
                                    <option key={mas.id} value={mas.id}>{mas.nameOfMas}</option>
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
                                onChange={onInputChange}
                            >
                                <option value="">Select Type</option>
                                {soldierTypeList.map(type => (
                                    <option key={type.id} value={type.id}>{type.nameOfType}</option>
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
