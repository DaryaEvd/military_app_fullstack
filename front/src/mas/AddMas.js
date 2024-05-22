import axios from 'axios';
import React, { useState } from 'react'
import { useNavigate, Link } from 'react-router-dom';

export default function AddMas() {

    let navigate = useNavigate()

    const [mas, setMas] = useState(
        {
            nameOfMas: "",
            codeOfMas: ""
        }
    );

    const { nameOfMas, codeOfMas } = mas;

    const onInputChange = (e) => {
        setMas({ ...mas, [e.target.name]: e.target.value })
    }

    const onSubmit = async (e) => {
        e.preventDefault();
        await axios.post("http://localhost:8080/api/mas", mas)
        navigate("/")
    };

    return (
        <div className='container'>
            <div className='row'>
                <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
                    <h2 className='text-center m-4'>Register Mas</h2>

                    <form onSubmit={(e) => onSubmit(e)}>
                        <div className='mb-3'>
                            <label htmlFor='Name' className='form-label'>Name</label>
                            <input
                                type="text"
                                className='form-control'
                                placeholder='Enter name of mas'
                                name="nameOfMas"
                                value={nameOfMas}
                                onChange={onInputChange}
                            />
                        </div>
                        <div className='mb-3'>
                            <label htmlFor='CodeOfMas' className='form-label'>Code of mas</label>
                            <input
                                type="text"
                                className='form-control'
                                placeholder='Enter code of mas'
                                name="codeOfMas"
                                value={codeOfMas}
                                onChange={onInputChange}
                            />
                        </div>

                        <button type="submit" className="btn btn-outline-primary">
                            Submit
                        </button>

                        <Link className="btn btn-outline-danger mx-2" to="/">
                            Cancel
                        </Link>

                    </form>
                </div>
            </div>
        </div>
    )
}
