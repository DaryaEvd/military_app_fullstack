import React, { useState, useEffect } from "react";
import axios from "axios";

export default function DislocationPlaces() {
    const [subdivisions, setSubdivisions] = useState([]);
    const [dislocationPlaces, setDislocationPlaces] = useState([]);
    const [selectedSubdivision, setSelectedSubdivision] = useState("");

    useEffect(() => {
        loadSubdivisions();
    }, []);

    const loadSubdivisions = async () => {
        const result = await axios.get("http://localhost:8080/api/subdivision");
        setSubdivisions(result.data);
    };

    const fetchAllDislocationPlaces = async () => {
        const result = await axios.get("http://localhost:8080/api/subdivision/dislocation_places");
        setDislocationPlaces(result.data);
    };

    const handleSubdivisionChange = (event) => {
        setSelectedSubdivision(event.target.value);
    };

    const fetchDislocationPlacesBySubdivision = async () => {
        if (selectedSubdivision) {
            const result = await axios.get(`http://localhost:8080/api/subdivision/dislocation_places/${selectedSubdivision}`);
            setDislocationPlaces(result.data);
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
                <h2>Query Dislocation Places</h2>

                <div className='mb-4'>
                    <h4>Get All Dislocation Places</h4>
                    <button className="btn btn-primary mt-2" onClick={fetchAllDislocationPlaces}>
                        Fetch All Dislocation Places
                    </button>
                </div>

                <div className='mb-4'>
                    <h4>Get Dislocation Places by Subdivision</h4>
                    <select value={selectedSubdivision} onChange={handleSubdivisionChange} className="form-select">
                        <option value="">Select Subdivision</option>
                        {subdivisions.map(subdivision => (
                            <option key={subdivision.id} value={subdivision.id}>
                                {subdivision.nameOfSubdivision}
                            </option>
                        ))}
                    </select>
                    <button className="btn btn-primary mt-2" onClick={fetchDislocationPlacesBySubdivision}>
                        Fetch Dislocation Places
                    </button>
                </div>

                <h4>Dislocation Places</h4>
                <table className="table border shadow">
                    <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Type Of Building</th>
                            <th scope="col">Area Of Building</th>
                            <th scope="col">Can Use For Dislocation</th>
                            <th scope="col">Amount Of Rooms</th>
                            <th scope="col">In Subdivision</th>
                        </tr>
                    </thead>
                    <tbody>
                        {dislocationPlaces.map((building, index) => (
                            <tr key={building.id}>
                                <th scope="row">{index + 1}</th>
                                <td>{building.typeOfBuilding}</td>
                                <td>{building.areaOfBuilding}</td>
                                <td>{building.canUseForDislocation ? "Yes" : "No"}</td>
                                <td>{building.amountOfRooms}</td>
                                <td>{getSubdivisionNames(building.subdivisionIds)}</td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            </div>
        </div>
    );
}
