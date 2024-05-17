import React from 'react';
import { Link } from 'react-router-dom';
import './Sidebar.css'; // You can add styles here

function Sidebar() {
  return (
    <div className="Sidebar">
      <ul>
        <li><Link to="/main">Main Page</Link></li>
        <li><Link to="/soldiers">Soldiers</Link></li>
        <li><Link to="/subdivisions">Subdivisions</Link></li>
        <li><Link to="/military-buildings">Military Buildings</Link></li>
        <li><Link to="/combat-equipment">Combat Equipment</Link></li>
        <li><Link to="/weapon">Weapon</Link></li>
        <li><Link to="/specialities">Specialities</Link></li>
      </ul>
    </div>
  );
}

export default Sidebar;
