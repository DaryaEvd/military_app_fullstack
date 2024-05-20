import React, { useEffect, useState } from "react";
import axios from "axios";

export default function Home() {

    const [combatEquipments, setCombatEquipments] = useState([]);

    useEffect(() => {
        loadCombatEquipments();
    }, []);

    const loadCombatEquipments = async () => {
        const result = await axios.get("http://localhost:8080/api/combat_equipment");
        setCombatEquipments(result.data);
    }

    return (
        <div className='container'>
            <div className='py-4'>
                <table className="table border shadow">
                    <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Name</th>
                            <th scope="col">Experience of using</th>
                            <th scope="col">Condition of vehicle</th>
                            <th scope="col">Number of seats</th>
                            <th scope="col">Name of vehicle</th>
                            <th scope="col">Action</th>
                        </tr>
                    </thead>

                    <tbody>
                        {
                            combatEquipments.map((combatEquipment, index) => (
                                <tr key={combatEquipment.id}>
                                    <th scope="row">
                                        {combatEquipment.id}
                                    </th>
                                    <td>{combatEquipment.nameOfEquipment}</td>
                                    <td>{combatEquipment.experienceOfUsing}</td>
                                    <td>{combatEquipment.conditionOfVehicle}</td>
                                    <td>{combatEquipment.numberOfSeats}</td>
                                    <td>{combatEquipment.nameOfVehicle}</td>

                                    <td>
                                        <button className="btn btn-primary mx-2">View</button>
                                        <button className="btn btn-outline-primary mx-2">Edit</button>
                                        <button className="btn btn-danger mx-2">Delete</button>
                                    </td>
                                </tr>
                            ))
                        }
                    </tbody>
                </table>
            </div>
        </div>
    )
}