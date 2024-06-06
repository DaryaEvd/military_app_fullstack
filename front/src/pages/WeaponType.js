import React, { useEffect, useState } from "react";
import axios from "axios";
import { Link } from "react-router-dom";

export default function WeaponType() {
    const [weaponTypes, setWeaponTypes] = useState([]);

    useEffect(() => {
        loadWeaponTypes();
    }, []);

    const loadWeaponTypes = async () => {
        const result = await axios.get("http://localhost:8080/api/weapons");
        setWeaponTypes(result.data);
    };

    

    return (
        <div className='container'>
            <div className='py-4'>
                {/* <Link className="btn btn-outline-primary mb-4" to="/weapons/add">
                    Add Weapon Type
                </Link> */}

                 <Link className="btn btn-outline-primary mb-4" to="/weapon_type/categories">
                    Query
                </Link>
                <Link className="btn btn-outline-primary mb-4" to="/weapon_type/amount">
                    Query Count
                </Link>

                <table className="table border shadow">
                    <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Weapon Category</th>
                            <th scope="col">Experience Of Using</th>
                            <th scope="col">Condition Of Weapon</th>
                            {/* <th scope="col">Actions</th> */}
                        </tr>
                    </thead>
                    <tbody>
                        {weaponTypes.map((weaponType, index) => (
                            <tr key={weaponType.id}>
                                <th scope="row">{index + 1}</th>
                                <td>{weaponType.weaponCategory}</td>
                                <td>{weaponType.experienceOfUsing}</td>
                                <td>{weaponType.conditionOfWeapon}</td>
                                
                                {/* <td>
                                    <Link className="btn btn-primary mx-2" to={`/weapon_type/view/${weaponType.id}`}>
                                        View
                                    </Link>
                                    <Link className="btn btn-outline-primary mx-2" to={`/weapon_type/edit/${weaponType.id}`}>
                                        Edit
                                    </Link>
                                    <button className="btn btn-danger mx-2" onClick={() => deleteWeaponType(weaponType.id)}>
                                        Delete
                                    </button>
                                </td> */}
                            
                            </tr>
                        ))}
                    </tbody>
                </table>
            </div>
        </div>
    );
}