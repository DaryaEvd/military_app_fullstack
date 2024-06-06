import React, { useState, useEffect } from "react";
import { useParams, Link } from "react-router-dom";
import axios from "axios";

export default function ViewSubdivision() {
    const [subdivision, setSubdivision] = useState(null);
    const [commander, setCommander] = useState(null);
    const [subdivisionType, setSubdivisionType] = useState(null);
    const { id } = useParams();

    useEffect(() => {
        loadSubdivision();
    }, []);

    const loadSubdivision = async () => {
        try {
            const result = await axios.get(`http://localhost:8080/api/subdivision/${id}`);
            console.log('Fetched subdivision data:', result.data);
            setSubdivision(result.data);
            if (result.data.commanderId) {
                loadCommander(result.data.commanderId);
            }
            if (result.data.typeOfSubdivision) {
                loadSubdivisionType(result.data.typeOfSubdivision);
            }
        } catch (error) {
            console.error("Error loading subdivision:", error);
        }
    };

    const loadCommander = async (commanderId) => {
        try {
            const result = await axios.get(`http://localhost:8080/api/soldiers/${commanderId}`);
            setCommander(result.data);
        } catch (error) {
            console.error("Error loading commander:", error);
        }
    };

    const loadSubdivisionType = async (typeId) => {
        try {
            const result = await axios.get(`http://localhost:8080/api/subdivision_types/${typeId}`);
            setSubdivisionType(result.data);
        } catch (error) {
            console.error("Error loading subdivision type:", error);
        }
    };

    if (!subdivision) {
        return <div>Loading...</div>;
    }

    return (
        <div className='container'>
            <div className='row'>
                <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
                    <h2 className='text-center m-4'>Subdivision Details</h2>
                    <div className="card">
                        <div className="card-header">
                            Details of Subdivision ID: {subdivision.id}
                            <ul className="list-group list-group-flush">
                                <li className="list-group-item">
                                    <b>Name of Subdivision:</b> {subdivision.nameOfSubdivision}
                                </li>
                                <li className="list-group-item">
                                    <b>Number of Subdivision:</b> {subdivision.numberOfSubdivision}
                                </li>
                                <li className="list-group-item">
                                    <b>Dislocated:</b> {subdivision.isDislocated ? "Yes" : "No"}
                                </li>
                                <li className="list-group-item">
                                    <b>Type of Subdivision:</b> {subdivisionType ? subdivisionType.nameOfType : "Loading..."}
                                </li>
                                <li className="list-group-item">
                                    <b>Commander:</b> {commander ? `${commander.firstName} ${commander.lastName}` : "Loading..."}
                                </li>
                            </ul>
                        </div>
                    </div>
                    <Link className="btn btn-primary my-2" to="/subdivisions">Back</Link>
                </div>
            </div>
        </div>
    );
}