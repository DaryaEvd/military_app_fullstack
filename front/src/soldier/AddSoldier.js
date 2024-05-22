import axios from 'axios';
import React, { useState } from 'react'
import { useNavigate, Link } from 'react-router-dom';

export default function AddSoldier() {
    let navigate = useNavigate()

    const [soldiers, serSoldiers] = useState({
        firstName: "",
        lastName: "",
        dateOfBirth: "",
        militaryCard: "",
        dateOfIssueMilitaryCard: "",
        masId: "",
        typeOfSoldier: ""
    });

    const { firstName,
        lastName,
        // dateOfBirth,
        militaryCard,
        // dateOfIssueMilitaryCard,
        masId,
        typeOfSoldier
    } = soldiers;

    const onInputChange = (e) => {
        serSoldiers({ ...soldiers, [e.target.name]: e.target.value });
    };

    const onSubmit = async (e) => {
        e.preventDefault();
        await axios.post("http://localhost:8080/api/soldiers", soldiers);
        navigate("/soldiers");
    };

    return (
        <div className='container'>
            <div className='row'>
                <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
                    <h2 className='text-center m-4'>Register Combat Equipment</h2>
                    <form onSubmit={(e) => onSubmit(e)}>
                        <div className='mb-3'>
                            <label htmlFor='First Name' className='form-label'>First Name</label>
                            <input
                                type="text"
                                className='form-control'
                                placeholder='Enter first name of soldier'
                                name="firstName"
                                value={firstName}
                                onChange={(e) => onInputChange(e)}
                            />
                        </div>
                        <div className='mb-3'>
                            <label htmlFor='Last Name' className='form-label'>Last Name</label>
                            <input
                                type="text"
                                className='form-control'
                                placeholder='Enter experience of using of combat equipment'
                                name="lastName"
                                value={lastName}
                                onChange={(e) => onInputChange(e)}
                            />
                        </div>
                        {/* <div className='mb-3'>
                            <label htmlFor='Date Of Birth' className='form-label'>Date Of Birth</label>
                            <input
                                type="text"
                                className='form-control'
                                placeholder='Enter condition of vehicle'
                                name="dateOfBirth"
                                value={dateOfBirth}
                                onChange={(e) => onInputChange(e)}
                            />
                        </div> */}
                        <div className='mb-3'>
                            <label htmlFor='Military Card' className='form-label'>Military Card</label>
                            <input
                                type="text"
                                className='form-control'
                                placeholder='Enter number of seats'
                                name="militaryCard"
                                value={militaryCard}
                                onChange={(e) => onInputChange(e)}
                            />
                        </div>
                        {/* <div className='mb-3'>
                            <label htmlFor='Date Of Issue Military Card' className='form-label'>Date Of Issue Military Card</label>
                            <input
                                type="text"
                                className='form-control'
                                placeholder='Enter name of vehicle'
                                name="dateOfIssueMilitaryCard"
                                value={dateOfIssueMilitaryCard}
                                onChange={(e) => onInputChange(e)}
                            />
                        </div> */}
                        <div className='mb-3'>
                            <label htmlFor='Mas' className='form-label'>Mas</label>
                            <input
                                type="text"
                                className='form-control'
                                placeholder='Enter name of vehicle'
                                name="masId"
                                value={masId}
                                onChange={(e) => onInputChange(e)}
                            />
                        </div>
                        <div className='mb-3'>
                            <label htmlFor='Type' className='form-label'>Type</label>
                            <input
                                type="text"
                                className='form-control'
                                placeholder='Enter name of vehicle'
                                name="typeOfSoldier"
                                value={typeOfSoldier}
                                onChange={(e) => onInputChange(e)}
                            />
                        </div>

                        <button type="submit" className="btn btn-outline-primary">Submit</button>
                        <Link className="btn btn-outline-danger mx-2" to="/soldiers">Cancel</Link>
                    </form>
                </div>
            </div>
        </div>
    );
}
