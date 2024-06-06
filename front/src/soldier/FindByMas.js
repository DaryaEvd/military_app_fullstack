import React, { useState, useEffect } from "react";
import axios from "axios";

export default function FindByMas() {
  const [specialties, setSpecialties] = useState([]);
  const [subdivisions, setSubdivisions] = useState([]);
  const [selectedSpecialty, setSelectedSpecialty] = useState("");
  const [selectedSubdivision, setSelectedSubdivision] = useState("");
  const [results, setResults] = useState([]);

  useEffect(() => {
    loadSpecialties();
    loadSubdivisions();
  }, []);

  const loadSpecialties = async () => {
    const result = await axios.get("http://localhost:8080/api/mas");
    setSpecialties(result.data);
  };

  const loadSubdivisions = async () => {
    const result = await axios.get("http://localhost:8080/api/subdivision");
    setSubdivisions(result.data);
  };

  const handleSpecialtyChange = (event) => {
    setSelectedSpecialty(event.target.value);
    setResults([]);
  };

  const handleSubdivisionChange = (event) => {
    setSelectedSubdivision(event.target.value);
  };

  const fetchResults = async () => {
    if (!selectedSpecialty) {
      alert("Please select a specialty.");
      return;
    }

    let url = `http://localhost:8080/api/subdivision/specialists/${selectedSpecialty}`;
    if (selectedSubdivision) {
      url += `/${selectedSubdivision}`;
    }

    const result = await axios.get(url);
    setResults(result.data);
  };

  return (
    <div className="container">
      <div className="py-4">
        <h2>Query Soldiers by Specialty</h2>

        <div className="mb-4">
          <h4>Select Specialty</h4>
          <select value={selectedSpecialty} onChange={handleSpecialtyChange} className="form-select">
            <option value="">Select Specialty</option>
            {specialties.map((specialty) => (
              <option key={specialty.id} value={specialty.id}>
                {specialty.nameOfMas}
              </option>
            ))}
          </select>
        </div>

        <div className="mb-4">
          <h4>Select Subdivision (optional)</h4>
          <select value={selectedSubdivision} onChange={handleSubdivisionChange} className="form-select">
            <option value="">Select Subdivision</option>
            {subdivisions.map((subdivision) => (
              <option key={subdivision.id} value={subdivision.id}>
                {subdivision.nameOfSubdivision}
              </option>
            ))}
          </select>
        </div>

        <button className="btn btn-primary mt-2" onClick={fetchResults}>
          Fetch Results
        </button>

        <table className="table border shadow mt-3">
          <thead>
            <tr>
              <th scope="col">#</th>
              <th scope="col">First Name</th>
              <th scope="col">Last Name</th>
              <th scope="col">Date of Birth</th>
              <th scope="col">Military Card</th>
              <th scope="col">Date of Issue</th>
            </tr>
          </thead>
          <tbody>
            {results.map((soldier, index) => (
              <tr key={soldier.id}>
                <th scope="row">{index + 1}</th>
                <td>{soldier.firstName}</td>
                <td>{soldier.lastName}</td>
                <td>{new Date(soldier.dateOfBirth).toLocaleDateString()}</td>
                <td>{soldier.militaryCard}</td>
                <td>{new Date(soldier.dateOfIssueMilitaryCard).toLocaleDateString()}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}
