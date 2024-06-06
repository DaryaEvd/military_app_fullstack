import React, { useState, useEffect } from "react";
import axios from "axios";

export default function WeaponQueries() {
  const [selectedCategory, setSelectedCategory] = useState("");
  const [subdivisionId, setSubdivisionId] = useState("");
  const [weaponTypes, setWeaponTypes] = useState([]);
  const [queryType, setQueryType] = useState("");
  const [subdivisions, setSubdivisions] = useState([]);

  useEffect(() => {
    const fetchSubdivisions = async () => {
      const result = await axios.get("http://localhost:8080/api/subdivision");
      setSubdivisions(result.data);
    };

    fetchSubdivisions();
  }, []);

  const getSubdivisionNames = (subdivisionIds) => {
    if (!subdivisionIds) return "Unknown"; // Проверка на undefined или null
    return subdivisionIds.map(id => {
      const subdivision = subdivisions.find(sub => sub.id === id);
      return subdivision ? subdivision.nameOfSubdivision : "Unknown";
    }).join(", ");
  };

  const categories = ["Gun", "Artillery", "Rocket"]; // Hardcoded categories

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
            <h4>Select Subdivision</h4>
            <select value={subdivisionId} onChange={handleSubdivisionChange} className="form-control">
              <option value="" disabled>Select a subdivision</option>
              {subdivisions.map((subdivision) => (
                <option key={subdivision.id} value={subdivision.id}>
                  {subdivision.nameOfSubdivision}
                </option>
              ))}
            </select>
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
                  <th scope="col">Subdivision Name</th>
                  {selectedCategory === "Gun" && (
                    <>
                      <th scope="col">Name of Gun</th>
                      <th scope="col">Shooting Speed</th>
                      <th scope="col">Caliber</th>
                      <th scope="col">Magazine Capacity</th>
                    </>
                  )}
                  {selectedCategory === "Artillery" && (
                    <>
                      <th scope="col">Name of Artillery</th>
                      <th scope="col">Firing Distance</th>
                      <th scope="col">Type of Ammunition</th>
                    </>
                  )}
                  {selectedCategory === "Rocket" && (
                    <>
                      <th scope="col">Flight Range of Rocket</th>
                      <th scope="col">Type of Missile Guidance</th>
                    </>
                  )}
                </tr>
              </thead>
              <tbody>
                {weaponTypes.map((weapon, index) => (
                  <tr key={index}>
                    <th scope="row">{index + 1}</th>
                    <td>{weapon.weaponCategory}</td>
                    <td>{weapon.experienceOfUsing}</td>
                    <td>{weapon.conditionOfWeapon}</td>
                    <td>{getSubdivisionNames([weapon.subdivisionId])}</td>
                    {selectedCategory === "Gun" && (
                      <>
                        <td>{weapon.nameOfGun}</td>
                        <td>{weapon.shootingSpeed}</td>
                        <td>{weapon.caliber}</td>
                        <td>{weapon.magazineCapacity}</td>
                      </>
                    )}
                    {selectedCategory === "Artillery" && (
                      <>
                        <td>{weapon.nameArtillery}</td>
                        <td>{weapon.firingDistance}</td>
                        <td>{weapon.typeOfAmmunition}</td>
                      </>
                    )}
                    {selectedCategory === "Rocket" && (
                      <>
                        <td>{weapon.flightRangeOfRocket}</td>
                        <td>{weapon.typeOfMissileGuidance}</td>
                      </>
                    )}
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
