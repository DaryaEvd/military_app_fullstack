import React, { useEffect, useState } from "react";
import axios from "axios";

export default function FindSoldier() {
    const [soldiers, setSoldiers] = useState([]);
    const [soldierRank, setSoldierRank] = useState("");
    const [subdivisionRank, setSubdivisionRank] = useState("");
    const [soldierTypeList, setSoldierTypeList] = useState([]);
    const [subdivisionList, setSubdivisionList] = useState([]);

    useEffect(() => {
        fetchSoldierTypeList();
        fetchSubdivisionList();
    }, []);

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

    const handleSearch = async () => {
        try {
            const soldierRankInt = soldierRank !== "" ? parseInt(soldierRank, 10) : null;
            const subdivisionRankInt = subdivisionRank !== "" ? parseInt(subdivisionRank, 10) : null;
            const response = await axios.get(`http://localhost:8080/api/soldiers/officers`, {
                params: {
                    soldier_rank: soldierRankInt,
                    subdivision_rank: subdivisionRankInt
                }
            });
            setSoldiers(response.data);
        } catch (error) {
            console.error("Error fetching soldiers:", error);
        }
    };

    return (
        <div className='container'>
            <h2 className='my-4'>Find Soldiers</h2>
            <div className='row'>
                <div className='col-md-6'>
                    <select
                        id="soldierRank"
                        name="soldierRank"
                        className="form-select mb-3"
                        value={soldierRank}
                        onChange={(e) => setSoldierRank(e.target.value)}
                    >
                        <option value="">Select Soldier Rank</option>
                        {soldierTypeList.map(type => (
                            <option key={type.id} value={type.typeRank}>
                                {type.nameOfType}
                            </option>
                        ))}
                    </select>
                    <select
                        id="subdivisionRank"
                        name="subdivisionRank"
                        className="form-select mb-3"
                        value={subdivisionRank}
                        onChange={(e) => setSubdivisionRank(e.target.value)}
                    >
                        <option value="">Select Subdivision Rank</option>
                        {subdivisionList.map(subdivision => (
                            <option key={subdivision.id} value={subdivision.subdivisionRank}>
                                {subdivision.nameOfSubdivision}
                            </option>
                        ))}
                    </select>
                    <button className="btn btn-primary" onClick={handleSearch}>Search</button>
                </div>
            </div>
            <div className='row'>
                <div className='col-md-12'>
                    <table className="table border shadow">
                        <thead>
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">First Name</th>
                                <th scope="col">Last Name</th>
                                {/* Add other soldier fields as needed */}
                            </tr>
                        </thead>
                        <tbody>
                            {soldiers.map((soldier, index) => (
                                <tr key={soldier.id}>
                                    <th scope="row">{index + 1}</th>
                                    <td>{soldier.firstName}</td>
                                    <td>{soldier.lastName}</td>
                                    {/* Add other soldier fields as needed */}
                                </tr>
                            ))}
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    );
}
