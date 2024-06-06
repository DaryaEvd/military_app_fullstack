import React, { useEffect, useState } from "react";
import axios from "axios";
import { Link } from "react-router-dom";

export default function Subdivision() {
    const [subdivisions, setSubdivisions] = useState([]);
    const [subdivisionTypes, setSubdivisionTypes] = useState([]);
    const [showOnlyDislocated, setShowOnlyDislocated] = useState(false);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const [subdivisionsResult, typesResult] = await Promise.all([
                    axios.get("http://localhost:8080/api/subdivision"),
                    axios.get("http://localhost:8080/api/subdivision_types")
                ]);
                setSubdivisions(subdivisionsResult.data);
                setSubdivisionTypes(typesResult.data);
            } catch (error) {
                console.error("Error loading data:", error);
            }
        };

        fetchData();
    }, []);

    const deleteSubdivision = async (id) => {
        if (window.confirm("Are you sure you want to delete this subdivision?")) {
            try {
                await axios.delete(`http://localhost:8080/api/subdivision/${id}`);
                setSubdivisions(subdivisions.filter(subdivision => subdivision.id !== id));
            } catch (error) {
                console.error("Error deleting subdivision:", error);
            }
        }
    };

    const getSubdivisionTypeName = (id) => {
        const type = subdivisionTypes.find(t => t.id === id);
        return type ? type.nameOfType : "Unknown";
    };

    const filteredSubdivisions = showOnlyDislocated
        ? subdivisions.filter(subdivision => subdivision.isDislocated)
        : subdivisions;

    return (
        <div className="container">
            <div className="py-4">
                <Link className="btn btn-outline-primary mb-4" to="/subdivisions/add">
                    Add Subdivision
                </Link>
                <button 
                    className="btn btn-secondary mb-4"
                    onClick={() => setShowOnlyDislocated(!showOnlyDislocated)}
                >
                    {showOnlyDislocated ? "Show All" : "Show Only Dislocated"}
                </button>

                <Link className="btn btn-outline-primary mb-4" to="/subdivisions/buildings">
                    Find Dislocated Places
                </Link>

                <Link className="btn btn-outline-primary mb-4" to="/subdivisions/combat_equipment">
                    Find Combat Equipment
                </Link>

                <Link className="btn btn-outline-primary mb-4" to="/subdivisions/with_commanders">
                    Show Commanders
                </Link>
                 
                <Link className="btn btn-outline-primary mb-4" to="/subdivisions/frequency">
                    Frequency
                </Link>

                <table className="table border shadow">
                    <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Name</th>
                            <th scope="col">Number</th>
                            <th scope="col">Dislocated</th>
                            <th scope="col">Type</th>
                            <th scope="col">Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        {filteredSubdivisions.map((subdivision, index) => (
                            <tr key={subdivision.id}>
                                <th scope="row">{index + 1}</th>
                                <td>{subdivision.nameOfSubdivision}</td>
                                <td>{subdivision.numberOfSubdivision}</td>
                                <td>{subdivision.isDislocated ? "Yes" : "No"}</td>
                                <td>{getSubdivisionTypeName(subdivision.typeOfSubdivision)}</td>
                                <td>
                                    <Link className="btn btn-primary mx-2" to={`/subdivisions/view/${subdivision.id}`}>
                                        View
                                    </Link>
                                    <Link className="btn btn-outline-primary mx-2" to={`/subdivisions/edit/${subdivision.id}`}>
                                        Edit
                                    </Link>
                                    <button className="btn btn-danger mx-2" onClick={() => deleteSubdivision(subdivision.id)}>
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
