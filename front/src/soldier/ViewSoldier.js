import React, { useState, useEffect } from "react";
import axios from "axios";
import { Link, useParams } from "react-router-dom";

export default function ViewSoldier() {
    const { id } = useParams();
    const [soldier, setSoldier] = useState({});
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

    const getMasName = (id) => {
        const mas = masList.find(m => m.id === id);
        return mas ? mas.nameOfMas : "";
    };

    const getTypeName = (id) => {
        const type = soldierTypeList.find(t => t.id === id);
        return type ? type.nameOfType : "";
    };

    const getSubdivisionName = (id) => {
        const subdivision = subdivisionList.find(s => s.id === id);
        return subdivision ? subdivision.nameOfSubdivision : "";
    };

    return (
        <div className='container'>
            <div className='row'>
                <div className='col-md-6 offset-md-3 border rounded p-4 mt-2 shadow'>
                    <h2 className='text-center m-4'>Soldier Details</h2>
                    <div className='card'>
                        <div className='card-header'>
                            Details of Soldier id: {soldier.id}
                            <ul className='list-group list-group-flush'>
                                <li className='list-group-item'>
                                    <b>First Name: </b>
                                    {soldier.firstName}
                                </li>
                                <li className='list-group-item'>
                                    <b>Last Name: </b>
                                    {soldier.lastName}
                                </li>
                                <li className='list-group-item'>
                                    <b>Date of Birth: </b>
                                    {soldier.dateOfBirth}
                                </li>
                                <li className='list-group-item'>
                                    <b>Military Card: </b>
                                    {soldier.militaryCard}
                                </li>
                                <li className='list-group-item'>
                                    <b>Date of Issue Military Card: </b>
                                    {soldier.dateOfIssueMilitaryCard}
                                </li>
                                <li className='list-group-item'>
                                    <b>Mas: </b>
                                    {getMasName(soldier.masId)}
                                </li>
                                <li className='list-group-item'>
                                    <b>Type Of Soldier: </b>
                                    {getTypeName(soldier.typeOfSoldier)}
                                </li>
                                <li className='list-group-item'>
                                    <b>Subdivision: </b>
                                    {getSubdivisionName(soldier.subdivisionId)}
                                </li>
                                <li className='list-group-item'>
                                    <b>Commander: </b>
                                    {soldier.isCommander ? "Yes" : "No"}
                                </li>
                            </ul>
                        </div>
                    </div>
                    <Link className="btn btn-primary my-2" to="/soldiers">Back to Home</Link>
                </div>
            </div>
        </div>
    );
}
