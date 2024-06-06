import React, { useState, useEffect } from "react";
import axios from "axios";

export default function SubdivisionsWithCommanders() {
  const [subdivisionsWithCommanders, setSubdivisionsWithCommanders] = useState([]);
  const [loading, setLoading] = useState(false);

  useEffect(() => {
    const fetchSubdivisionsWithCommanders = async () => {
      setLoading(true);
      try {
        const result = await axios.get("http://localhost:8080/api/subdivision/with_commanders");
        setSubdivisionsWithCommanders(result.data);
      } catch (error) {
        console.error("Error fetching subdivisions with commanders data:", error);
      }
      setLoading(false);
    };

    fetchSubdivisionsWithCommanders();
  }, []);

  return (
    <div className="container">
      <div className="py-4">
        <h2>All Subdivisions and Their Commanders</h2>

        {loading ? (
          <p>Loading...</p>
        ) : (
          <table className="table border shadow">
            <thead>
              <tr>
                <th scope="col">#</th>
                <th scope="col">Subdivision Name</th>
                <th scope="col">Commander First Name</th>
                <th scope="col">Commander Last Name</th>
              </tr>
            </thead>
            <tbody>
              {subdivisionsWithCommanders.map((subdivision, index) => (
                <tr key={subdivision.subdivisionId}>
                  <th scope="row">{index + 1}</th>
                  <td>{subdivision.subdivisionName}</td>
                  <td>{subdivision.commanderFirstName}</td>
                  <td>{subdivision.commanderLastName}</td>
                </tr>
              ))}
            </tbody>
          </table>
        )}
      </div>
    </div>
  );
}
