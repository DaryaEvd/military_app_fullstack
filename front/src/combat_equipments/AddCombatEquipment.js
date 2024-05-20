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
                </div>
            </div>
        </div>
    )
}
