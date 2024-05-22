import React, { useEffect, useState } from "react";
import axios from "axios";
import { Link } from "react-router-dom";

export default function CombatEquipment() {
    const [combatEquipments, setCombatEquipments] = useState([]);

    useEffect(() => {
        loadCombatEquipments();
    }, []);

    const loadCombatEquipments = async () => {
        const result = await axios.get("http://localhost:8080/api/combat_equipment");
        setCombatEquipments(result.data);
    };

    const updateCombatEquipment = async (updatedEquipment) => {
        setCombatEquipments(combatEquipments.map(equipment =>
            equipment.id === updatedEquipment.id ? updatedEquipment : equipment
        ));
    };

    const deleteCombatEquipments = async (id) => {
        if (window.confirm("Are you sure you want to delete this item?")) {
            await axios.delete(`http://localhost:8080/api/combat_equipment/${id}`);
            loadCombatEquipments();
        }
    };

    return (
        <div className='container'>
            <div className='py-4'>
                <Link className="btn btn-outline-primary mb-4" to="/addcombatequipment">
                    Add Combat Equipment
                </Link>

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
                        {combatEquipments.map((combatEquipment, index) => (
                            <tr key={combatEquipment.id}>
                                <th scope="row">
                                    {index + 1}
                                </th>
                                <td>{combatEquipment.nameOfEquipment}</td>
                                <td>{combatEquipment.experienceOfUsing}</td>
                                <td>{combatEquipment.conditionOfVehicle}</td>
                                <td>{combatEquipment.numberOfSeats}</td>
                                <td>{combatEquipment.nameOfVehicle}</td>
                                <td>
                                    <Link className="btn btn-primary mx-2"
                                        to={`/viewcombatequipment/${combatEquipment.id}`}>
                                        View
                                    </Link>
                                    <Link className="btn btn-outline-primary mx-2"
                                        to={`/editcombatequipment/${combatEquipment.id}`}
                                        state={{ updateCombatEquipment }}>
                                        Edit
                                    </Link>
                                    <button className="btn btn-danger mx-2"
                                        onClick={() => deleteCombatEquipments(combatEquipment.id)}>
                                        Delete
                                    </button>
                                </td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            </div>
        </div>
    );
}
