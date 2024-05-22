import React from "react";
import { useParams, Link } from "react-router-dom";
import { useState, useEffect } from "react";
import axios from "axios";

export default function ViewCombatEquipment() {
    const [combatEquipments, setCombatEquipments] = useState({
        nameOfEquipment: "",
        experienceOfUsing: "",
        conditionOfVehicle: "",
        numberOfSeats: "",
        nameOfVehicle: ""
    });

    const { id } = useParams();

    useEffect(() => {
        loadCombatEquipments();
    }, []);

    const loadCombatEquipments = async () => {
        const result = await axios.get(`http://localhost:8080/api/combat_equipment/${id}`);
        setCombatEquipments(result.data);
    };

    return (
        <div className='container'>
            <div className='row'>
                <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
                    <h2 className='text-center m-4'>Details Combat Equipment</h2>
                    <div className="card">
                        <div className="card-header">
                            Details of combat Equipment id : {combatEquipments.id}
                            <ul className="list-group list-group-flush">
                                <li className="list-group-item">
                                    <b>Name:</b> {combatEquipments.nameOfEquipment}
                                </li>
                                <li className="list-group-item">
                                    <b>Experience of using:</b> {combatEquipments.experienceOfUsing}
                                </li>
                                <li className="list-group-item">
                                    <b>Condition of vehicle:</b> {combatEquipments.conditionOfVehicle}
                                </li>
                                <li className="list-group-item">
                                    <b>Number of seats:</b> {combatEquipments.numberOfSeats}
                                </li>
                                <li className="list-group-item">
                                    <b>Name of vehicle:</b> {combatEquipments.nameOfVehicle}
                                </li>
                            </ul>
                        </div>
                    </div>
                    <Link className="btn btn-primary my-2" to="/combat_equipment">Back</Link>
                </div>
            </div>
        </div>
    );
}
