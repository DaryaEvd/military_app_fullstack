import React from "react";
import { useParams, Link } from "react-router-dom";
import { useState, useEffect } from "react";
import axios from "axios";

export default function ViewSoldierType() {

    const [soldierTypes, setSoldierTypes] = useState(
        {
            nameOfType: "",
            typeRank: ""
        }
    );

    const { id } = useParams();

    useEffect(() => {
        loadSoldierTypes();
    }, []);

    const loadSoldierTypes = async () => {
        const result = await axios.get(`http://localhost:8080/api/soldier_type/${id}`);
        setSoldierTypes(result.data);
    }

    return (
        <div className='container'>
            <div className='row'>
                <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
                    <h2 className='text-center m-4'>Details Soldier Type</h2>

                    <div className="card">
                        <div className="card-header">
                            Details of soldierTypes id : {soldierTypes.id}
                            <ul className="list-group list-group-flush">
                                <li className="list-group-item">
                                    <b>Name:</b>
                                    {soldierTypes.nameOfType}
                                </li>
                                <li className="list-group-item">
                                    <b>Type rank:</b>
                                    {soldierTypes.typeRank}
                                </li>
                            </ul>
                        </div>
                    </div>
                    <Link className="btn btn-primary my-2" to={"/soldier_type"}>
                        Back
                    </Link>


                </div>
            </div>
        </div>
    )
}
