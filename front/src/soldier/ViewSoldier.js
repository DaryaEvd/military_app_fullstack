import React from "react";
import { useParams, Link } from "react-router-dom";
import { useState, useEffect } from "react";
import axios from "axios";

export default function ViewSoldier() {
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
    
    const { id } = useParams();

    useEffect(() => {
        loadSoldier();
        fetchMasList();
        fetchSoldierTypeList();
    }, []);

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

    const loadSoldier = async () => {
        try {
            const result = await axios.get(`http://localhost:8080/api/soldiers/${id}`);
            const soldierData = result.data;
            // Ensure the date format is corrected before setting the state
            soldierData.dateOfBirth = soldierData.dateOfBirth.split('T')[0];
            soldierData.dateOfIssueMilitaryCard = soldierData.dateOfIssueMilitaryCard.split('T')[0];
            setSoldier(soldierData);
        } catch (error) {
            console.error("Error loading soldier data:", error);
        }
    };

    const getMasName = (id) => {
        const mas = masList.find(m => m.id === id);
        return mas ? mas.nameOfMas : "";
    };

    const getTypeName = (id) => {
        const type = soldierTypeList.find(t => t.id === id);
        return type ? type.nameOfType : "";
    };

    return (
        <div className='container'>
            <div className='row'>
                <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
                    <h2 className='text-center m-4'>Details Of Soldiers</h2>
                    <div className="card">
                        <div className="card-header">
                            Details of Soldier id : {soldier.id}
                            <ul className="list-group list-group-flush">
                                <li className="list-group-item">
                                    <b>First Name:</b> {soldier.firstName}
                                </li>
                                <li className="list-group-item">
                                    <b>Last Name:</b> {soldier.lastName}
                                </li>
                                <li className="list-group-item">
                                    <b>Date Of Birth:</b> {soldier.dateOfBirth}
                                </li>
                                <li className="list-group-item">
                                    <b>Military Card:</b> {soldier.militaryCard}
                                </li>
                                <li className="list-group-item">
                                    <b>Date Of Issue Military Card:</b> {soldier.dateOfIssueMilitaryCard}
                                </li>
                                <li className="list-group-item">
                                    <b>Mas:</b> {getMasName(soldier.masId)}
                                </li>
                                <li className="list-group-item">
                                    <b>Type Of Soldier:</b> {getTypeName(soldier.typeOfSoldier)}
                                </li>
                            </ul>
                        </div>
                    </div>
                    <Link className="btn btn-primary my-2" to="/soldiers">Back</Link>
                </div>
            </div>
        </div>
    );
}
