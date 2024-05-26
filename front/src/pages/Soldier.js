import React, { useEffect, useState } from "react";
import axios from "axios";
import { Link } from "react-router-dom";
import FindSoldier from "../soldier/FindSoldier";

export default function Soldier() {
    const [soldiers, setSoldiers] = useState([]);
    const [masList, setMasList] = useState([]);
    const [soldierTypeList, setSoldierTypeList] = useState([]);
    const [subdivisionList, setSubdivisionList] = useState([]);

    useEffect(() => {
        loadSoldiers();
        fetchMasList();
        fetchSoldierTypeList();
        fetchSubdivisionList();
    }, []);

    const loadSoldiers = async () => {
        try {
            const result = await axios.get("http://localhost:8080/api/soldiers");
            setSoldiers(result.data);
        } catch (error) {
            console.error("Error loading soldiers:", error);
        }
    };

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

    const deleteSoldier = async (id) => {
        if (window.confirm("Are you sure you want to delete this item?")) {
            try {
                await axios.delete(`http://localhost:8080/api/soldiers/${id}`);
                loadSoldiers();
            } catch (error) {
                console.error("Error deleting soldier:", error);
            }
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
            <div className='py-4'>
                <Link className="btn btn-outline-primary mb-4" to="/soldiers/add">
                    Add Soldier Info
                </Link>
                <Link className="btn btn-outline-secondary mb-4 mx-2" to="/soldiers/find">
                    Find Soldier
                </Link>
                <table className="table border shadow">
                    <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">First Name</th>
                            <th scope="col">Last Name</th>
                            <th scope="col">Date of Birth</th>
                            <th scope="col">Military Card</th>
                            <th scope="col">Date Of Issue Military Card</th>
                            <th scope="col">Mas</th>
                            <th scope="col">Type Of Soldier</th>
                            <th scope="col">Subdivision</th>
                            <th scope="col">Commander</th>
                            <th scope="col">Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        {soldiers.map((soldier, index) => (
                            <tr key={soldier.id}>
                                <th scope="row">{index + 1}</th>
                                <td>{soldier.firstName}</td>
                                <td>{soldier.lastName}</td>
                                <td>{soldier.dateOfBirth}</td>
                                <td>{soldier.militaryCard}</td>
                                <td>{soldier.dateOfIssueMilitaryCard}</td>
                                <td>{getMasName(soldier.masId)}</td>
                                <td>{getTypeName(soldier.typeOfSoldier)}</td>
                                <td>{getSubdivisionName(soldier.subdivisionId)}</td>
                                <td>{soldier.isCommander ? "Yes" : "No"}</td>
                                <td>
                                    <Link className="btn btn-primary mx-2" to={`/soldiers/view/${soldier.id}`}>
                                        View
                                    </Link>
                                    <Link className="btn btn-outline-primary mx-2" to={`/soldiers/edit/${soldier.id}`}>
                                        Edit
                                    </Link>
                                    <button className="btn btn-danger mx-2" onClick={() => deleteSoldier(soldier.id)}>
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
