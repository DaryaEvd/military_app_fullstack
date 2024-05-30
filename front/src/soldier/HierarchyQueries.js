import React, { useState, useEffect } from "react";
import axios from "axios";

export default function HierarchyQueries() {
  const [soldierId, setSoldierId] = useState("");
  const [soldiers, setSoldiers] = useState([]);
  const [hierarchy, setHierarchy] = useState([]);
  const [loading, setLoading] = useState(false);
  const [selectedSoldierName, setSelectedSoldierName] = useState("");
  const [subdivisions, setSubdivisions] = useState([]);
  const [soldierTypes, setSoldierTypes] = useState([]);

  useEffect(() => {
    const fetchSoldiers = async () => {
      try {
        const result = await axios.get("http://localhost:8080/api/soldiers");
        setSoldiers(result.data);
      } catch (error) {
        console.error("Error fetching soldiers data:", error);
      }
    };

    const fetchSubdivisions = async () => {
      try {
        const result = await axios.get("http://localhost:8080/api/subdivision");
        setSubdivisions(result.data);
      } catch (error) {
        console.error("Error fetching subdivisions data:", error);
      }
    };

    const fetchSoldierTypes = async () => {
      try {
        const result = await axios.get("http://localhost:8080/api/soldier_type");
        setSoldierTypes(result.data);
      } catch (error) {
        console.error("Error fetching soldier types data:", error);
      }
    };

    fetchSoldiers();
    fetchSubdivisions();
    fetchSoldierTypes();
  }, []);

  const handleSoldierNameChange = (event) => {
    const selectedName = event.target.value;
    setSelectedSoldierName(selectedName);
    const selectedSoldier = soldiers.find(soldier => `${soldier.firstName} ${soldier.lastName}` === selectedName);
    setSoldierId(selectedSoldier ? selectedSoldier.id : "");
  };

  const fetchHierarchyData = async () => {
    if (!soldierId) {
      alert("Please select a soldier.");
      return;
    }

    setLoading(true);

    try {
      const result = await axios.get(`http://localhost:8080/api/soldiers/hierarchy/${soldierId}`);
      setHierarchy(result.data);
    } catch (error) {
      console.error("Error fetching hierarchy data:", error);
      alert("Failed to fetch hierarchy data.");
    }

    setLoading(false);
  };

  const getCommanderName = (commanderId) => {
    const commander = hierarchy.find(soldier => soldier.id === commanderId);
    return commander ? `${commander.firstName} ${commander.lastName}` : "N/A";
  };

  const getSubdivisionName = (subdivisionId) => {
    const subdivision = subdivisions.find(sub => sub.id === subdivisionId);
    return subdivision ? subdivision.nameOfSubdivision : "N/A";
  };

  const getSoldierTypeName = (typeId) => {
    const type = soldierTypes.find(type => type.id === typeId);
    return type ? type.typeName : "N/A";
  };

  return (
    <div className="container">
      <div className="py-4">
        <h2>Query Soldier Hierarchy</h2>

        <div className="mb-4">
          <h4>Select Soldier</h4>
          <select
            value={selectedSoldierName}
            onChange={handleSoldierNameChange}
            className="form-control"
          >
            <option value="" disabled>Select a soldier</option>
            {soldiers.map(soldier => (
              <option key={soldier.id} value={`${soldier.firstName} ${soldier.lastName}`}>
                {soldier.firstName} {soldier.lastName}
              </option>
            ))}
          </select>
        </div>

        <button className="btn btn-primary mt-2" onClick={fetchHierarchyData} disabled={loading}>
          {loading ? "Loading..." : "Fetch Hierarchy Data"}
        </button>

        {hierarchy.length > 0 && (
          <div className="mt-4">
            <h4>Hierarchy Chain</h4>
            <table className="table border shadow">
              <thead>
                <tr>
                  <th scope="col">#</th>
                  <th scope="col">First Name</th>
                  <th scope="col">Last Name</th>
                  <th scope="col">Date of Birth</th>
                  <th scope="col">Military Card</th>
                  <th scope="col">Date of Issue Military Card</th>
                  <th scope="col">Mas ID</th>
                  <th scope="col">Type of Soldier</th>
                  <th scope="col">Subdivision</th>
                  {/* <th scope="col">Commander Name</th> */}
                </tr>
              </thead>
              <tbody>
                {hierarchy.map((soldier, index) => (
                  <tr key={soldier.id}>
                    <th scope="row">{index + 1}</th>
                    <td>{soldier.firstName}</td>
                    <td>{soldier.lastName}</td>
                    <td>{new Date(soldier.dateOfBirth).toLocaleDateString()}</td>
                    <td>{soldier.militaryCard}</td>
                    <td>{new Date(soldier.dateOfIssueMilitaryCard).toLocaleDateString()}</td>
                    <td>{soldier.masId}</td>
                    <td>{getSoldierTypeName(soldier.typeOfSoldier)}</td>
                    <td>{getSubdivisionName(soldier.subdivisionId)}</td>
                    {/* <td>{getCommanderName(soldier.commanderId)}</td> */}
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
