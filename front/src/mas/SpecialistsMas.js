import React, { useState, useEffect } from "react";
import axios from "axios";

export default function SpecialtiesQueries() {
  const [subdivisions, setSubdivisions] = useState([]);
  const [selectedQuery, setSelectedQuery] = useState("");
  const [selectedSubdivision, setSelectedSubdivision] = useState("");
  const [results, setResults] = useState([]);

  useEffect(() => {
    loadSubdivisions();
  }, []);

  const loadSubdivisions = async () => {
    const result = await axios.get("http://localhost:8080/api/subdivision");
    setSubdivisions(result.data);
  };

  const handleQueryChange = (event) => {
    setSelectedQuery(event.target.value);
    setResults([]);
    setSelectedSubdivision("");
  };

  const handleSubdivisionChange = (event) => {
    setSelectedSubdivision(event.target.value);
  };

  const fetchResults = async () => {
    let url = "";
    if (selectedQuery === "more_than_five") {
      url = `http://localhost:8080/api/mas/specialists/more_than_five`;
    } else if (selectedQuery === "none") {
      url = `http://localhost:8080/api/mas/specialists/none`;
    } else if (selectedQuery === "more_than_five_by_subdivision" && selectedSubdivision) {
      url = `http://localhost:8080/api/mas/specialists/more_than_five/${selectedSubdivision}`;
    } else if (selectedQuery === "none_by_subdivision" && selectedSubdivision) {
      url = `http://localhost:8080/api/mas/specialists/none/${selectedSubdivision}`;
    } else {
      alert("Please select a query and a subdivision.");
      return;
    }

    const result = await axios.get(url);
    setResults(result.data);
  };

  return (
    <div className="container">
      <div className="py-4">
        <h2>Query Military Specialties</h2>

        <div className="mb-4">
          <h4>Select Query</h4>
          <select value={selectedQuery} onChange={handleQueryChange} className="form-select">
            <option value="">Select Query</option>
            <option value="more_than_five">Specialties with More Than Five Specialists</option>
            <option value="none">Specialties with No Specialists</option>
            <option value="more_than_five_by_subdivision">Specialties with More Than Five Specialists in Subdivision</option>
            <option value="none_by_subdivision">Specialties with No Specialists in Subdivision</option>
          </select>
        </div>

        {(selectedQuery === "more_than_five_by_subdivision" || selectedQuery === "none_by_subdivision") && (
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
        )}

        <button className="btn btn-primary mt-2" onClick={fetchResults}>
          Fetch Results
        </button>

        <table className="table border shadow mt-3">
          <thead>
            <tr>
              <th scope="col">#</th>
              <th scope="col">Name of Specialty</th>
              <th scope="col">Code of Specialty</th>
            </tr>
          </thead>
          <tbody>
            {results.map((specialty, index) => (
              <tr key={specialty.id}>
                <th scope="row">{index + 1}</th>
                <td>{specialty.nameOfMas}</td>
                <td>{specialty.codeOfMas}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}
