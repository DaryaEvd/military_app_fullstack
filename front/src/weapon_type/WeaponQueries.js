import React, { useState, useEffect } from "react";
import axios from "axios";

export default function WeaponQueries() {
  const [categories, setCategories] = useState([]);
  const [selectedCategory, setSelectedCategory] = useState("");
  const [subdivisionId, setSubdivisionId] = useState("");
  const [weaponTypes, setWeaponTypes] = useState([]);
  const [queryType, setQueryType] = useState("");

  useEffect(() => {
    loadCategories();
  }, []);

  const loadCategories = async () => {
    const result = await axios.get("http://localhost:8080/api/weapons");
    setCategories(result.data);
  };

  const handleCategoryChange = (event) => {
    setSelectedCategory(event.target.value);
    setWeaponTypes([]);
  };

  const handleSubdivisionChange = (event) => {
    setSubdivisionId(event.target.value);
    setWeaponTypes([]);
  };

  const fetchWeaponData = async () => {
    if (!selectedCategory) {
      alert("Please select a weapon category.");
      return;
    }

    let url = "";
    if (queryType === "general") {
      url = `http://localhost:8080/api/weapons/category/${selectedCategory}`;
    } else if (queryType === "subdivision") {
      if (!subdivisionId) {
        alert("Please select a subdivision.");
        return;
      }
      url = `http://localhost:8080/api/weapons/category/${selectedCategory}/subdivision/${subdivisionId}`;
    }

    const result = await axios.get(url);
    setWeaponTypes(result.data);
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

        {queryType === "subdivision" && (
          <div className="mb-4">
            <h4>Enter Subdivision ID</h4>
            <input type="number" value={subdivisionId} onChange={handleSubdivisionChange} className="form-control" />
          </div>
        )}

        <div className="mb-4">
          <h4>Select Query Type</h4>
          <select value={queryType} onChange={(e) => setQueryType(e.target.value)} className="form-select">
            <option value="">Select Query Type</option>
            <option value="general">General</option>
            <option value="subdivision">By Subdivision</option>
          </select>
        </div>

        <button className="btn btn-primary mt-2" onClick={fetchWeaponData}>
          Fetch Weapon Data
        </button>

        {weaponTypes.length > 0 && (
          <div className="mt-4">
            <h4>Weapon Data</h4>
            <table className="table border shadow">
              <thead>
                <tr>
                  <th scope="col">#</th>
                  <th scope="col">Category</th>
                  <th scope="col">Experience of Using</th>
                  <th scope="col">Condition of Weapon</th>
                  <th scope="col">Subdivision ID</th>
                </tr>
              </thead>
              <tbody>
                {weaponTypes.map((weapon, index) => (
                  <tr key={index}>
                    <th scope="row">{index + 1}</th>
                    <td>{weapon.weaponCategory}</td>
                    <td>{weapon.experienceOfUsing}</td>
                    <td>{weapon.conditionOfWeapon}</td>
                    <td>{weapon.subdivisionId}</td>
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
