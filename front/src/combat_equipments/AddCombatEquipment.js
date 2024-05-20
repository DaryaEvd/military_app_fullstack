import React from 'react'

export default function AddCombatEquipment() {
    return (
        <div className='container'>
            <div className='row'>
                <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
                    <h2 className='text-center m-4'>Register Combat Equipment</h2>
                    <div className='mb-3'>
                        <label htmlFor='Name' className='form-label'>
                            Name
                        </label>
                        <input
                            type={"text"}
                            className='form-control'
                            placeholder='Enter name of combat equipment'
                            name="name"
                        />
                    </div>

                    <div className='mb-3'>
                        <label htmlFor='Name' className='form-label'>
                            Name
                        </label>
                        <input
                            type={"text"}
                            className='form-control'
                            placeholder='Enter name of combat equipment'
                            name="name"
                        />
                    </div>

                    <div className='mb-3'>
                        <label htmlFor='Name' className='form-label'>
                            Experience of using
                        </label>
                        <input
                            type={"text"}
                            className='form-control'
                            placeholder='Enter experience of using of combat equipment'
                            name="name"
                        />
                    </div>

                    <div className='mb-3'>
                        <label htmlFor='Name' className='form-label'>
                            Condition of vehicle
                        </label>
                        <input
                            type={"text"}
                            className='form-control'
                            placeholder='Enter condition of vehicle'
                            name="name"
                        />
                    </div>

                    <div className='mb-3'>
                        <label htmlFor='Name' className='form-label'>
                            Number of seats
                        </label>
                        <input
                            type={"text"}
                            className='form-control'
                            placeholder='Enter number of seats'
                            name="name"
                        />
                    </div>

                    <div className='mb-3'>
                        <label htmlFor='Name' className='form-label'>
                            Name of vehicle
                        </label>
                        <input
                            type={"text"}
                            className='form-control'
                            placeholder='Enter name of vehicle'
                            name="name"
                        />
                    </div>

                    <button type="submit" className="btn btn-outline-primary">
                        Submit
                    </button>

                    <button type="submit" className="btn btn-outline-danger mx-2">
                        Cancel
                    </button>

                </div>
            </div>
        </div>
    )
}
