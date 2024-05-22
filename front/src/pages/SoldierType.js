import React, { useEffect, useState } from "react";
import axios from "axios";
import { Link } from "react-router-dom";

export default function SoldierType() {
    const [soldierTypes, setSoldierTypes] = useState([]);

    useEffect(() => {
        loadSoldierTypes();
    }, []);

    const loadSoldierTypes = async () => {
        const result = await axios.get("http://localhost:8080/api/soldier_type");
        setSoldierTypes(result.data);
    };

    return (
        <div className='container'>
            <div className='py-4'>

                <table className="table border shadow">
                    <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Name Of Type</th>
                            <th scope="col">Type rank</th>
                            <th scope="col">Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        {soldierTypes.map((soldierType, index) => (
                            <tr key={soldierType.id}>
                                <th scope="row">
                                    {index + 1}
                                </th>
                                <td>{soldierType.nameOfType}</td>
                                <td>{soldierType.typeRank}</td>
                                <td>
                                    <Link className="btn btn-primary mx-2"
                                        to={`/soldier_type/view/${soldierType.id}`}>
                                        View
                                    </Link>
                                </td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            </div>
        </div>
    );
}
