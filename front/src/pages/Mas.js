import React, { useEffect, useState } from "react";
import axios from "axios";
import { Link } from "react-router-dom";

export default function Mas() {
    const [mas, setMas] = useState([]);

    useEffect(() => {
        loadMas();
    }, []);

    const loadMas = async () => {
        const result = await axios.get("http://localhost:8080/api/mas");
        setMas(result.data);
    };

    const updateMas = async (updatedMas) => {
        setMas(mas.map(mas =>
            mas.id === updatedMas.id ? updatedMas : mas
        ));
    };

    const deleteMas = async (id) => {
        if (window.confirm("Are you sure you want to delete this item?")) {
            await axios.delete(`http://localhost:8080/api/mas/${id}`);
            loadMas();
        }
    };

    return (
        <div className='container'>
            <div className='py-4'>
                <Link className="btn btn-outline-primary mb-4" to="/addmas">
                    Add Mas Information
                </Link>

                <table className="table border shadow">
                    <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Name Of Mas</th>
                            <th scope="col">Code Of Mas</th>
                        </tr>
                    </thead>
                    <tbody>
                        {mas.map((mas, index) => (
                            <tr key={mas.id}>
                                <th scope="row">
                                    {index + 1}
                                </th>
                                <td>{mas.nameOfMas}</td>
                                <td>{mas.codeOfMas}</td>
                                <td>
                                    <Link className="btn btn-primary mx-2"
                                        to={`/viewmas/${mas.id}`}>
                                        View
                                    </Link>
                                    <Link className="btn btn-outline-primary mx-2"
                                        to={`/editmas/${mas.id}`}
                                        state={{ updateMas }}>
                                        Edit
                                    </Link>
                                    <button className="btn btn-danger mx-2"
                                        onClick={() => deleteMas(mas.id)}>
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
