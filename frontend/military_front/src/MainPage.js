import React from 'react';
import Sidebar from './Sidebar';
import './MainPage.css'; // You can add styles here

function MainPage() {
  return (
    <div className="MainPage">
      <Sidebar />
      <div className="content">
        <h2>Welcome to the Main Page</h2>
        {/* Add your main page content here */}
      </div>
    </div>
  );
}

export default MainPage;
