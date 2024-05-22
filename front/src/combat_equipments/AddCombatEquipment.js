import axios from 'axios';
import React, { useState } from 'react'
import { useNavigate, Link } from 'react-router-dom';

export default function AddCombatEquipment() {
    let navigate = useNavigate()

    const [combatEquipments, setCombatEquipments] = useState({
        nameOfEquipment: "",
        experienceOfUsing: "",
        conditionOfVehicle: "",
        numberOfSeats: "",
        nameOfVehicle: ""
    });

    const { nameOfEquipment, experienceOfUsing, conditionOfVehicle, numberOfSeats, nameOfVehicle } = combatEquipments;

    const onInputChange = (e) => {
        setCombatEquipments({ ...combatEquipments, [e.target.name]: e.target.value });
    };

    const onSubmit = async (e) => {
        e.preventDefault();
        await axios.post("http://localhost:8080/api/combat_equipment", combatEquipments);
        navigate("/combat_equipment");
    };

    return (
        <div className='container'>
            <div className='row'>
                <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
                    <h2 className='text-center m-4'>Register Combat Equipment</h2>
                    <form onSubmit={(e) => onSubmit(e)}>
                        <div className='mb-3'>
                            <label htmlFor='Name' className='form-label'>Name</label>
                            <input
                                type="text"
                                className='form-control'
                                placeholder='Enter name of combat equipment'
                                name="nameOfEquipment"
                                value={nameOfEquipment}
                                onChange={(e) => onInputChange(e)}
                            />
                        </div>
                        <div className='mb-3'>
                            <label htmlFor='ExperienceOfUsing' className='form-label'>Experience of using</label>
                            <input
                                type="text"
                                className='form-control'
                                placeholder='Enter experience of using of combat equipment'
                                name="experienceOfUsing"
                                value={experienceOfUsing}
                                onChange={(e) => onInputChange(e)}
                            />
                        </div>
                        <div className='mb-3'>
                            <label htmlFor='ConditionOfVehicle' className='form-label'>Condition of vehicle</label>
                            <input
                                type="text"
                                className='form-control'
                                placeholder='Enter condition of vehicle'
                                name="conditionOfVehicle"
                                value={conditionOfVehicle}
                                onChange={(e) => onInputChange(e)}
                            />
                        </div>
                        <div className='mb-3'>
                            <label htmlFor='NumberOfSeats' className='form-label'>Number of seats</label>
                            <input
                                type="text"
                                className='form-control'
                                placeholder='Enter number of seats'
                                name="numberOfSeats"
                                value={numberOfSeats}
                                onChange={(e) => onInputChange(e)}
                            />
                        </div>
                        <div className='mb-3'>
                            <label htmlFor='NameOfVehicle' className='form-label'>Name of vehicle</label>
                            <input
                                type="text"
                                className='form-control'
                                placeholder='Enter name of vehicle'
                                name="nameOfVehicle"
                                value={nameOfVehicle}
                                onChange={(e) => onInputChange(e)}
                            />
                        </div>
                        <button type="submit" className="btn btn-outline-primary">Submit</button>
                        <Link className="btn btn-outline-danger mx-2" to="/combat_equipment">Cancel</Link>
                    </form>
                </div>
            </div>
        </div>
    );
}
