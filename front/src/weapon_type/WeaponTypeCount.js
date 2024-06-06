import React, { useState } from "react";
import axios from "axios";

export default function WeaponQueries() {
  const [selectedCategory, setSelectedCategory] = useState("");
  const [weaponCount, setWeaponCount] = useState("");
  const [queryType, setQueryType] = useState("");
  const [resultSubdivisions, setResultSubdivisions] = useState([]);

  const categories = ["Gun", "Artillery", "Rocket"]; // Hardcoded categories

  const handleCategoryChange = (event) => {
    setSelectedCategory(event.target.value);
  };

  const handleWeaponCountChange = (event) => {
    setWeaponCount(event.target.value);
  };

  const fetchSubdivisionsWithWeaponMoreThan = async () => {
    if (!selectedCategory || !weaponCount) {
      alert("Please select a category and enter a weapon count.");
      return;
    }

    const url = `http://localhost:8080/api/subdivision/weapon_more_than?weaponCategory=${selectedCategory}&count=${weaponCount}`;
    try {
      const result = await axios.get(url);
      setResultSubdivisions(result.data);
    } catch (error) {
      console.error("Error fetching subdivisions:", error);
    }
  };

  const fetchSubdivisionsWithoutWeapon = async () => {
    if (!selectedCategory) {
      alert("Please select a category.");
      return;
    }

    const url = `http://localhost:8080/api/subdivision/no_weapon?weaponCategory=${selectedCategory}`;
    try {
      const result = await axios.get(url);
      setResultSubdivisions(result.data);
    } catch (error) {
      console.error("Error fetching subdivisions:", error);
    }
  };

  const fetchData = async () => {
    if (queryType === "weaponMoreThan") {
      await fetchSubdivisionsWithWeaponMoreThan();
    } else if (queryType === "noWeapon") {
      await fetchSubdivisionsWithoutWeapon();
    }
  };

  return (
    <div className="container">
      <div className="py-4">
        <h2>Query Weapon Data</h2>

        <div className="mb-4">
          <h4>Select Weapon Category</h4>
          <select value={selectedCategory} onChange={handleCategoryChange} className="form-select">
            <option value="">Select Category</option>
            {categories.map((category) => (
              <option key={category} value={category}>
                {category}
              </option>
            ))}
          </select>
        </div>

        {queryType === "weaponMoreThan" && (
          <div className="mb-4">
            <h4>Enter Minimum Weapon Count</h4>
            <input
              type="number"
              value={weaponCount}
              onChange={handleWeaponCountChange}
              className="form-control"
            />
          </div>
        )}

        <div className="mb-4">
          <h4>Select Query Type</h4>
          <select value={queryType} onChange={(e) => setQueryType(e.target.value)} className="form-select">
            <option value="">Select Query Type</option>
            <option value="weaponMoreThan">Weapon Count Greater Than</option>
            <option value="noWeapon">No Weapon of Category</option>
          </select>
        </div>

        <button className="btn btn-primary mt-2" onClick={fetchData}>
          Fetch Subdivision Data
        </button>

        {resultSubdivisions.length > 0 && (
          <div className="mt-4">
            <h4>Subdivision Data</h4>
            <table className="table border shadow">
              <thead>
                <tr>
                  <th scope="col">#</th>
                  <th scope="col">Subdivision Name</th>
                </tr>
              </thead>
              <tbody>
                {resultSubdivisions.map((subdivision, index) => (
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
