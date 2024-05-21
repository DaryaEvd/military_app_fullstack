import './App.css';
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import Navbar from './layout/Navbar';
import Home from './pages/Home';
import { Route, BrowserRouter as Router, Routes } from 'react-router-dom';
import AddCombatEquipment from './combat_equipments/AddCombatEquipment';
import EditCombatEquipment from './combat_equipments/EditCombatEquipment';

function App() {
  return (
    <div className="App">
      <Router>
        <Navbar />

        <Routes>
          <Route exact path="/" element={<Home />} />
          <Route exact path="/addcombatequipment" element={<AddCombatEquipment/>} />
          <Route exact path="/editcombatequipment/:id" element={<EditCombatEquipment/>} />
        </Routes>

       </Router>
    </div>
  );
}

export default App;
