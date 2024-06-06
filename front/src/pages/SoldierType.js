import React, { useEffect, useState } from "react";
import axios from "axios";

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

                            </tr>
                        ))}
                    </tbody>
                </table>
            </div>
        </div>
    );
}
