import React, { useState, useEffect } from "react";
import { useParams, Link } from "react-router-dom";
import axios from "axios";

export default function ViewSubdivision() {
    const [subdivision, setSubdivision] = useState({
        nameOfSubdivision: "",
        numberOfSubdivision: "",
        isDislocated: false,
        typeOfSubdivision: {
            id: "",
            nameOfType: ""
        },
        commander: {
            firstName: "",
            lastName: ""
        }
    });

    const { id } = useParams();

    useEffect(() => {
        loadSubdivision();
    }, []);

    const loadSubdivision = async () => {
        try {
            const result = await axios.get(`http://localhost:8080/api/subdivision/${id}`);
            setSubdivision(result.data);
        } catch (error) {
            console.error("Error loading subdivision:", error);
        }
    };

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
                                    <b>Type of Subdivision:</b> {subdivision.typeOfSubdivision.nameOfType}
                                </li>
                                {/* <li className="list-group-item">
                                    <b>Commander:</b> {subdivision.commander.firstName} {subdivision.commander.lastName}
                                </li> */}
                                
                                    <li className="list-group-item">
                                        <b>Commander:</b> {subdivision.commander.id}  
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
