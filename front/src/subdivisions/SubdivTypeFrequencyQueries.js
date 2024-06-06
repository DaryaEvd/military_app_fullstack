import React, { useState } from "react";
import axios from "axios";

export default function SubdivTypeFrequencyQueries() {
    const [leastFrequentType, setLeastFrequentType] = useState("");
    const [mostFrequentType, setMostFrequentType] = useState("");
    const [loadingLeast, setLoadingLeast] = useState(false);
    const [loadingMost, setLoadingMost] = useState(false);
    const [errorLeast, setErrorLeast] = useState("");
    const [errorMost, setErrorMost] = useState("");

    const fetchLeastFrequentType = async () => {
        setLoadingLeast(true);
        setErrorLeast("");
        try {
            const result = await axios.get("http://localhost:8080/api/subdivision/least_frequent_type");
            setLeastFrequentType(result.data);
        } catch (error) {
            setErrorLeast("Error fetching least frequent subdivision type.");
        }
        setLoadingLeast(false);
    };

    const fetchMostFrequentType = async () => {
        setLoadingMost(true);
        setErrorMost("");
        try {
            const result = await axios.get("http://localhost:8080/api/subdivision/most_frequent_type");
            setMostFrequentType(result.data);
        } catch (error) {
            setErrorMost("Error fetching most frequent subdivision type.");
        }
        setLoadingMost(false);
    };

    return (
        <div className="container">
            <div className="py-4">
                <h2>Subdivision Type Queries</h2>

                <div className="mb-4">
                    <button className="btn btn-primary" onClick={fetchLeastFrequentType} disabled={loadingLeast}>
                        {loadingLeast ? "Loading..." : "Get Least Frequent Subdivision Type"}
                    </button>
                    {errorLeast && <p className="text-danger">{errorLeast}</p>}
                    {leastFrequentType && (
                        <div>
                            <h4>Least Frequent Subdivision Type:</h4>
                            <p>{leastFrequentType}</p>
                        </div>
                    )}
                </div>

                <div className="mb-4">
                    <button className="btn btn-primary" onClick={fetchMostFrequentType} disabled={loadingMost}>
                        {loadingMost ? "Loading..." : "Get Most Frequent Subdivision Type"}
                    </button>
                    {errorMost && <p className="text-danger">{errorMost}</p>}
                    {mostFrequentType && (
                        <div>
                            <h4>Most Frequent Subdivision Type:</h4>
                            <p>{mostFrequentType}</p>
                        </div>
                    )}
                </div>
            </div>
        </div>
    );
}
