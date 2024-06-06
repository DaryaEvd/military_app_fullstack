import React, { useState, useEffect } from "react";
import axios from "axios";

export default function FindCombatEquipment() {
  const [equipments, setEquipments] = useState([]);
  const [selectedEquipment, setSelectedEquipment] = useState("");
  const [subdivisions, setSubdivisions] = useState([]);
  const [queryType, setQueryType] = useState("");

  useEffect(() => {
    loadEquipments();
  }, []);

  const loadEquipments = async () => {
    const result = await axios.get("http://localhost:8080/api/combat_equipment");
    setEquipments(result.data);
  };

  const handleEquipmentChange = (event) => {
    setSelectedEquipment(event.target.value);
    setSubdivisions([]);
  };

  const fetchSubdivisions = async () => {
    if (!selectedEquipment) {
      alert("Please select a type of combat equipment.");
      return;
    }

    let url = "";
    if (queryType === "more_than_five") {
      url = `http://localhost:8080/api/combat_equipment/subdivisions/more_than_five/${selectedEquipment}`;
    } else if (queryType === "no_equipment") {
      url = `http://localhost:8080/api/combat_equipment/subdivisions/no_equipment/${selectedEquipment}`;
    }

    const result = await axios.get(url);
    setSubdivisions(result.data);
  };

  return (
    <div className="container">
      <div className="py-4">
        <h2>Query Subdivisions by Combat Equipment</h2>

        <div className="mb-4">
          <h4>Select Combat Equipment</h4>
          <select value={selectedEquipment} onChange={handleEquipmentChange} className="form-select">
            <option value="">Select Equipment</option>
            {equipments.map((equipment) => (
              <option key={equipment.nameOfEquipment} value={equipment.nameOfEquipment}>
                {equipment.nameOfEquipment}
              </option>
            ))}
          </select>
        </div>

        <div className="mb-4">
          <h4>Select Query Type</h4>
          <select value={queryType} onChange={(e) => setQueryType(e.target.value)} className="form-select">
            <option value="">Select Query Type</option>
            <option value="more_than_five">Subdivisions with more than 5 units</option>
            <option value="no_equipment">Subdivisions with no units</option>
          </select>
        </div>

        <button className="btn btn-primary mt-2" onClick={fetchSubdivisions}>
          Fetch Subdivisions
        </button>

        {subdivisions.length > 0 && (
          <div className="mt-4">
            <h4>Subdivisions</h4>
            <table className="table border shadow">
              <thead>
                <tr>
                  <th scope="col">#</th>
                  <th scope="col">Name</th>
                </tr>
              </thead>
              <tbody>
                {subdivisions.map((subdivision, index) => (
                  <tr key={index}>
                    <th scope="row">{index + 1}</th>
                    <td>{subdivision}</td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        )}
      </div>
    </div>
  );
}
