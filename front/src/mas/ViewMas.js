import React from "react";
import { useParams, Link } from "react-router-dom";
import { useState, useEffect } from "react";
import axios from "axios";

export default function ViewMas() {

    const [mas, setMas] = useState(
        {
            nameOfMas: "",
            codeOfMas: ""
        }
    );

    const { id } = useParams();

    useEffect(() => {
        loadMas();
    }, []);

    const loadMas = async () => {
        const result = await axios.get(`http://localhost:8080/api/mas/${id}`);
        setMas(result.data);
    }

    return (
        <div className='container'>
            <div className='row'>
                <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
                    <h2 className='text-center m-4'>Details Mas</h2>

                    <div className="card">
                        <div className="card-header">
                            Details of mas id : {mas.id}
                            <ul className="list-group list-group-flush">
                                <li className="list-group-item">
                                    <b>Name:</b>
                                    {mas.nameOfMas}
                                </li>
                                <li className="list-group-item">
                                    <b>Experience of using:</b>
                                    {mas.codeOfMas}
                                </li>
                            </ul>
                        </div>
                    </div>
                    <Link className="btn btn-primary my-2" to={"/mas"}>
                        Back
                    </Link>


                </div>
            </div>
        </div>
    )
}
