import React from "react";
import { useParams, Link } from "react-router-dom";
import { useState, useEffect } from "react";
import axios from "axios";

 
export default function ViewMilitaryBuilding() {
    const [militaryBuilding, setMilitaryBuilding] = useState({
        typeOfBuilding: "",
        canUseForDislocation: false,
        areaOfBuilding: "",
        amountOfRooms: ""
        // subdivision: {
        //     id: "",
        //     name: ""
        // }
    });

    const { id } = useParams();

    useEffect(() => {
        loadMilitaryBuilding();
    }, []);

    const loadMilitaryBuilding = async () => {
        try {
            const result = await axios.get(`http://localhost:8080/api/military_building/${id}`);
            setMilitaryBuilding(result.data);
        } catch (error) {
            console.error("Error loading military building:", error);
        }
    };

    return (
        <div className='container'>
            <div className='row'>
                <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
                    <h2 className='text-center m-4'>Details Military Building</h2>
                    <div className="card">
                        <div className="card-header">
                            Details of Military Building id : {militaryBuilding.id}
                            <ul className="list-group list-group-flush">
                                <li className="list-group-item">
                                    <b>Type Of Building:</b> {militaryBuilding.typeOfBuilding}
                                </li>
                                <li className="list-group-item">
                                    <b>Can Use For Dislocation:</b> {militaryBuilding.canUseForDislocation ? "Yes" : "No"}
                                </li>
                                <li className="list-group-item">
                                    <b>Area Of Building:</b> {militaryBuilding.areaOfBuilding} sq. meters
                                </li>
                                <li className="list-group-item">
                                    <b>Amount Of Rooms:</b> {militaryBuilding.amountOfRooms}
                                </li>
                                {/* <li className="list-group-item">
                                    <b>Subdivision:</b> {militaryBuilding.subdivisionId.nameOf}
                                </li> */}
                            </ul>
                        </div>
                    </div>
                    <Link className="btn btn-primary my-2" to="/military_building">Back</Link>
                </div>
            </div>
        </div>
    );
}
