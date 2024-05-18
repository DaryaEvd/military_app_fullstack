import './App.css';
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import Navbar from './layout/Navbar';
import Home from './pages/Home';
import { Route, BrowserRouter as Router, Routes } from 'react-router-dom';
import AddCombatEquipment from './combat_equipments/AddCombatEquipment';

function App() {
  return (
    <div className="App">
      <Router>
        <Navbar />

        <Routes>
          <Route exact path="/" element={<Home />} />
          <Route exact path="/addcombatequipment" element={<AddCombatEquipment/>} />
        </Routes>

       </Router>
    </div>
  );
}

export default App;
