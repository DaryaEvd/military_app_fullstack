import React, { useState, useEffect } from "react";
import axios from "axios";

export default function CombatEquipmentInSubdiv() {
  const [subdivisions, setSubdivisions] = useState([]);
  const [selectedSubdivision, setSelectedSubdivision] = useState("");
  const [combatEquipments, setCombatEquipments] = useState([]);

  useEffect(() => {
    loadSubdivisions();
  }, []);

  const loadSubdivisions = async () => {
    const result = await axios.get("http://localhost:8080/api/subdivision");
    setSubdivisions(result.data);
  };

  const handleSubdivisionChange = (event) => {
    setSelectedSubdivision(event.target.value);
    setCombatEquipments([]);
  };

  const fetchCombatEquipments = async () => {
    if (!selectedSubdivision) {
      alert("Please select a subdivision.");
      return;
    }

    const result = await axios.get(`http://localhost:8080/api/combat_equipment/subdivision/${selectedSubdivision}`);
    setCombatEquipments(result.data);
  };

  return (
    <div className="container">
      <div className="py-4">
        <h2>Query Combat Equipment by Subdivision</h2>

        <div className="mb-4">
          <h4>Select Subdivision</h4>
          <select value={selectedSubdivision} onChange={handleSubdivisionChange} className="form-select">
            <option value="">Select Subdivision</option>
            {subdivisions.map((subdivision) => (
              <option key={subdivision.id} value={subdivision.id}>
                {subdivision.nameOfSubdivision}
              </option>
            ))}
          </select>
        </div>

        <button className="btn btn-primary mt-2" onClick={fetchCombatEquipments}>
          Fetch Combat Equipments
        </button>

        {combatEquipments.length > 0 && (
          <table className="table border shadow mt-3">
            <thead>
              <tr>
                <th scope="col">#</th>
                <th scope="col">Name of Equipment</th>
                <th scope="col">Experience of Using</th>
                <th scope="col">Condition of Vehicle</th>
                <th scope="col">Number of Seats</th>
                <th scope="col">Name of Vehicle</th>
              </tr>
            </thead>
            <tbody>
              {combatEquipments.map((equipment, index) => (
                <tr key={equipment.id}>
                  <th scope="row">{index + 1}</th>
                  <td>{equipment.nameOfEquipment}</td>
                  <td>{equipment.experienceOfUsing}</td>
                  <td>{equipment.conditionOfVehicle}</td>
                  <td>{equipment.numberOfSeats}</td>
                  <td>{equipment.nameOfVehicle}</td>
                </tr>
              ))}
            </tbody>
          </table>
        )}
      </div>
    </div>
  );
}
