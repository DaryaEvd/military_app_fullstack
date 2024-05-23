import axios from 'axios';
import React, { useState, useEffect } from 'react';
import { useNavigate, Link } from 'react-router-dom';

export default function AddMilitaryBuilding() {
    let navigate = useNavigate();

    const [militaryBuilding, setMilitaryBuilding] = useState({
        typeOfBuilding: "",
        canUseForDislocation: false,
        areaOfBuilding: "",
        amountOfRooms: "",
        subdivisionId: ""
    });

    const [subdivisions, setSubdivisions] = useState([]);

    useEffect(() => {
        fetchSubdivisions();
    }, []);

    const fetchSubdivisions = async () => {
        try {
            const response = await axios.get("http://localhost:8080/api/subdivision");
            setSubdivisions(response.data);
        } catch (error) {
            console.error("Error fetching military builidings:", error);
        }
    };

    const { canUseForDislocation, typeOfBuilding, areaOfBuilding, amountOfRooms, subdivisionId } = militaryBuilding;

    const onInputChange = (e) => {
        const { name, value, type, checked } = e.target;
        setMilitaryBuilding({
            ...militaryBuilding,
            [name]: type === 'checkbox' ? checked : value
        });
    };

    const onSubmit = async (e) => {
        e.preventDefault();
        try {
            await axios.post("http://localhost:8080/api/military_building", militaryBuilding);
            navigate("/military_building");
        } catch (error) {
            console.error("Error adding military building:", error);
        }
    };

    return (
        <div className='container'>
            <div className='row'>
                <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
                    <h2 className='text-center m-4'>Register Military Building</h2>
                    <form onSubmit={onSubmit}>
                        <div className='mb-3'>
                            <label htmlFor='typeOfBuilding' className='form-label'>Type Of Building</label>
                            <input
                                type="text"
                                className='form-control'
                                placeholder='Enter type of building'
                                name="typeOfBuilding"
                                value={typeOfBuilding}
                                onChange={onInputChange}
                            />
                        </div>
                        <div className='mb-3 form-check'>
                            <input
                                type="checkbox"
                                className='form-check-input'
                                name="canUseForDislocation"
                                id="canUseForDislocation"
                                checked={canUseForDislocation}
                                onChange={onInputChange}
                            />
                            <label className='form-check-label' htmlFor='canUseForDislocation'>
                                Can Use For Dislocation
                            </label>
                        </div>
                        <div className='mb-3'>
                            <label htmlFor='areaOfBuilding' className='form-label'>Area Of Building</label>
                            <input
                                type="number"
                                className='form-control'
                                placeholder='Enter area of building'
                                name="areaOfBuilding"
                                value={areaOfBuilding}
                                onChange={onInputChange}
                            />
                        </div>
                        <div className='mb-3'>
                            <label htmlFor='amountOfRooms' className='form-label'>Amount Of Rooms</label>
                            <input
                                type="number"
                                className='form-control'
                                placeholder='Enter amount of rooms'
                                name="amountOfRooms"
                                value={amountOfRooms}
                                onChange={onInputChange}
                            />
                        </div>
                        <div className='mb-3'>
                            <label htmlFor='subdivisionId' className='form-label'>Subdivision</label>
                            <select
                                className='form-control'
                                name="subdivisionId"
                                value={subdivisionId}
                                onChange={onInputChange}
                            >
                                <option value="">Select Subdivision</option>
                                {subdivisions.map(subdivision => (
                                    <option key={subdivision.id} value={subdivision.id}>{subdivision.name}</option>
                                ))}
                            </select>
                        </div>
                        <button type="submit" className="btn btn-outline-primary">Submit</button>
                        <Link className="btn btn-outline-danger mx-2" to="/military_building">Cancel</Link>
                    </form>
                </div>
            </div>
        </div>
    );
}
