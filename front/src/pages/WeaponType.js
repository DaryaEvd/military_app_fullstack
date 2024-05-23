import React, { useEffect, useState } from "react";
import axios from "axios";
import { Link } from "react-router-dom";

export default function WeaponType() {
    const [weaponTypes, setWeaponTypes] = useState([]);

    useEffect(() => {
        loadWeaponTypes();
    }, []);

    const loadWeaponTypes = async () => {
        const result = await axios.get("http://localhost:8080/api/weapon_type");
        setWeaponTypes(result.data);
    };

    const deleteWeaponType = async (id) => {
        if (window.confirm("Are you sure you want to delete this item?")) {
            await axios.delete(`http://localhost:8080/api/weapon_type/${id}`);
            loadWeaponTypes();
        }
    };

    return (
        <div className='container'>
            <div className='py-4'>
                <Link className="btn btn-outline-primary mb-4" to="/weapon_type/add">
                    Add Weapon Type
                </Link>

                <table className="table border shadow">
                    <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Name Of Type</th>
                            <th scope="col">Experience Of Using</th>
                            <th scope="col">Condition Of Vehicle</th>
                            <th scope="col">Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        {weaponTypes.map((weaponType, index) => (
                            <tr key={weaponType.id}>
                                <th scope="row">{index + 1}</th>
                                <td>{weaponType.nameOfType}</td>
                                <td>{weaponType.experienceOfUsing}</td>
                                <td>{weaponType.conditionOfVehicle}</td>
                                <td>
                                    <Link className="btn btn-primary mx-2" to={`/weapon_type/view/${weaponType.id}`}>
                                        View
                                    </Link>
                                    <Link className="btn btn-outline-primary mx-2" to={`/weapon_type/edit/${weaponType.id}`}>
                                        Edit
                                    </Link>
                                    <button className="btn btn-danger mx-2" onClick={() => deleteWeaponType(weaponType.id)}>
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
