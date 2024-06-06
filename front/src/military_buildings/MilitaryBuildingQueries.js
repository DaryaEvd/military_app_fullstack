import React, { useState, useEffect } from "react";
import axios from "axios";

export default function MilitaryBuildingQueries() {
    const [subdivisions, setSubdivisions] = useState([]);
    const [militaryBuildings, setMilitaryBuildings] = useState([]);
    const [selectedSubdivision, setSelectedSubdivision] = useState("");
    const [dislocatedOption, setDislocatedOption] = useState("none");

    useEffect(() => {
        loadSubdivisions();
    }, []);

    const loadSubdivisions = async () => {
        const result = await axios.get("http://localhost:8080/api/subdivision");
        setSubdivisions(result.data);
    };

    const handleSubdivisionChange = (event) => {
        setSelectedSubdivision(event.target.value);
    };

    const fetchBuildingsBySubdivision = async () => {
        if (selectedSubdivision) {
            const result = await axios.get(`http://localhost:8080/api/military_building/subdivision/${selectedSubdivision}`);
            setMilitaryBuildings(result.data);
        }
    };

    const handleDislocatedOptionChange = (event) => {
        setDislocatedOption(event.target.value);
    };

    const fetchBuildingsByDislocation = async () => {
        let result;
        if (dislocatedOption === "multiple") {
            result = await axios.get("http://localhost:8080/api/military_building/subdivision?is_dislocated=true&min_amount_subdivisions=1");
        } else if (dislocatedOption === "none") {
            result = await axios.get("http://localhost:8080/api/military_building/subdivision?is_dislocated=false");
        }
        setMilitaryBuildings(result.data);
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
                <h2>Query Military Buildings</h2>

                <div className='mb-4'>
                    <h4>Get Military Buildings by Subdivision</h4>
                    <select value={selectedSubdivision} onChange={handleSubdivisionChange} className="form-select">
                        <option value="">Select Subdivision</option>
                        {subdivisions.map(subdivision => (
                            <option key={subdivision.id} value={subdivision.id}>
                                {subdivision.nameOfSubdivision}
                            </option>
                        ))}
                    </select>
                    <button className="btn btn-primary mt-2" onClick={fetchBuildingsBySubdivision}>
                        Fetch Buildings
                    </button>
                </div>

                <div className='mb-4'>
                    <h4>Get Military Buildings by Dislocation</h4>
                    <select value={dislocatedOption} onChange={handleDislocatedOptionChange} className="form-select">
                        <option value="none">No Subdivisions Dislocated</option>
                        <option value="multiple">More Than One Subdivision Dislocated</option>
                    </select>
                    <button className="btn btn-primary mt-2" onClick={fetchBuildingsByDislocation}>
                        Fetch Buildings
                    </button>
                </div>

                <h4>Military Buildings</h4>
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
                        {militaryBuildings.map((militaryBuilding, index) => (
                            <tr key={militaryBuilding.id}>
                                <th scope="row">{index + 1}</th>
                                <td>{militaryBuilding.typeOfBuilding}</td>
                                <td>{militaryBuilding.areaOfBuilding}</td>
                                <td>{militaryBuilding.canUseForDislocation ? "Yes" : "No"}</td>
                                <td>{militaryBuilding.amountOfRooms}</td>
                                <td>{getSubdivisionNames(militaryBuilding.subdivisionIds)}</td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            </div>
        </div>
    );
}
