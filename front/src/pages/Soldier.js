import React, { useEffect, useState } from "react";
import axios from "axios";
import { Link } from "react-router-dom";

export default function Soldier() {
    const [soldiers, setSoldiers] = useState([]);

    useEffect(() => {
        loadSoldiers();
    }, []);

    const loadSoldiers = async () => {
        const result = await axios.get("http://localhost:8080/api/soldiers");
        setSoldiers(result.data);
    };

    // const deleteCombatEquipments = async (id) => {
    //     if (window.confirm("Are you sure you want to delete this item?")) {
    //         await axios.delete(`http://localhost:8080/api/soldiers/${id}`);
    //         setSoldiers();
    //     }
    // };

    return (
        <div className='container'>
            <div className='py-4'>
                <Link className="btn btn-outline-primary mb-4" to="/soldiers/add">
                    Add Soldier Info
                </Link>

                <table className="table border shadow">
                    <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">First Name</th>
                            <th scope="col">Last Name</th>
                            <th scope="col">Date of birth</th>
                            <th scope="col">Military Card</th>
                            <th scope="col">Date Of Issue Military Card</th>

                            <th scope="col">Mas</th>
                            <th scope="col">Type Of Soldier</th>

                            <th scope="col">Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        {soldiers.map((soldiers, index) => (
                            <tr key={soldiers.id}>
                                <th scope="row">
                                    {index + 1}
                                </th>
                                <td>{soldiers.firstName}</td>
                                <td>{soldiers.lastName}</td>
                                <td>{soldiers.dateOfBirth}</td>
                                <td>{soldiers.militaryCard}</td>
                                <td>{soldiers.dateOfIssueMilitaryCard}</td>
                                <td>{soldiers.masId}</td>
                                <td>{soldiers.typeOfSoldier}</td>
                                
                                <td>
                                    <Link className="btn btn-primary mx-2"
                                        to={`/soldiers/view/${soldiers.id}`}>
                                        View
                                    </Link>
                                    <Link className="btn btn-outline-primary mx-2"
                                        to={`/soldiers/edit/${soldiers.id}`}>
                                        Edit
                                    </Link>
                                    <button className="btn btn-danger mx-2"
                                        // onClick={() => deleteCombatEquipments(soldiers.id)}
                                        >
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
