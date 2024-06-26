import React, { useEffect, useState } from "react";
import axios from "axios";
import { Link } from "react-router-dom";

export default function Militarybuilding() {
    const [militaryBuildings, setMilitaryBuildings] = useState([]);
    const [subdivisions, setSubdivisions] = useState([]);

    useEffect(() => {
        loadMilitaryBuildings();
        loadSubdivisions();
    }, []);

    const loadMilitaryBuildings = async () => {
        const result = await axios.get("http://localhost:8080/api/military_building");
        setMilitaryBuildings(result.data);
    };

    const loadSubdivisions = async () => {
        const result = await axios.get("http://localhost:8080/api/subdivision");
        setSubdivisions(result.data);
    };

    const deleteMilitaryBuilding = async (id) => {
        if (window.confirm("Are you sure you want to delete this item?")) {
            await axios.delete(`http://localhost:8080/api/military_building/${id}`);
            loadMilitaryBuildings();
        }
    };

    const getSubdivisionNames = (subdivisionIds) => {
        return subdivisionIds.map(id => {
            const subdivision = subdivisions.find(sub => sub.id === id);
            return subdivision ? subdivision.nameOfSubdivision : "Unknown";
        }).join(", ");
    };

    return (
        <div className='container'>
            <div className='py-4'>
                <Link className="btn btn-outline-primary mb-4" to="/military_building/add">
                    Add Military Building
                </Link>

                <Link className="btn btn-outline-primary mb-4" to="/military_building/queries">
                    Queries Military Buildings
                </Link>

                <table className="table border shadow">
                    <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Type Of Building</th>
                            <th scope="col">Area Of Building</th>
                            <th scope="col">Can Use For Dislocation</th>
                            <th scope="col">Amount Of Rooms</th>
                            <th scope="col">In Subdivision</th>
                            <th scope="col">Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        {militaryBuildings.map((militaryBuilding, index) => (
                            <tr key={militaryBuilding.id}>
                                <th scope="row">
                                    {index + 1}
                                </th>
                                <td>{militaryBuilding.typeOfBuilding}</td>
                                <td>{militaryBuilding.areaOfBuilding}</td>
                                <td>{militaryBuilding.canUseForDislocation ? "Yes" : "No"}</td>
                                <td>{militaryBuilding.amountOfRooms}</td>
                                <td>{getSubdivisionNames(militaryBuilding.subdivisionIds)}</td>
                                <td>
                                    <Link className="btn btn-primary mx-2"
                                        to={`/military_building/view/${militaryBuilding.id}`}>
                                        View
                                    </Link>
                                    <Link className="btn btn-outline-primary mx-2"
                                        to={`/military_building/edit/${militaryBuilding.id}`}>
                                        Edit
                                    </Link>
                                    <button className="btn btn-danger mx-2"
                                        onClick={() => deleteMilitaryBuilding(militaryBuilding.id)}>
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
