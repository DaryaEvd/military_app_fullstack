import './App.css';
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import Navbar from './layout/Navbar';
import Home from './pages/Home';
import { Route, BrowserRouter as Router, Routes } from 'react-router-dom';

// import SoldierType from './pages/SoldierType';

import CombatEquipment from './pages/CombatEquipment';
import AddCombatEquipment from './combat_equipments/AddCombatEquipment';
import EditCombatEquipment from './combat_equipments/EditCombatEquipment';
import ViewCombatEquipment from './combat_equipments/ViewCombatEquipment';

import Mas from './pages/Mas';
import AddMas from './mas/AddMas';
import EditMas from './mas/EditMas';
import ViewMas from './mas/ViewMas';

import Soldier from './pages/Soldier';
import AddSoldier from './soldier/AddSoldier';
import EditSoldier from './soldier/EditSoldier';
import ViewSoldier from './soldier/ViewSoldier';

import MilitaryBuilding from './pages/MilitaryBuilding';
import AddMilitaryBuilding from './military_buildings/AddMilitaryBuilding';
import EditMilitaryBuilding from './military_buildings/EditMilitaryBuilding';
import ViewMilitaryBuilding from './military_buildings/ViewMilitaryBuilding';
import WeaponType from './pages/WeaponType';


function App() {
  return (
    <div className="App">
      <Router>
        <Navbar />
        <Routes>
          <Route exact path="/" element={<Home />} />

          <Route exact path="/combat_equipment" element={<CombatEquipment />} />
          <Route exact path="/combat_equipment/add" element={<AddCombatEquipment />} />
          <Route exact path="/combat_equipment/edit/:id" element={<EditCombatEquipment />} />
          <Route exact path="/combat_equipment/view/:id" element={<ViewCombatEquipment />} />

          <Route exact path="/mas" element={<Mas />} />
          <Route exact path="/mas/add" element={<AddMas />} />
          <Route exact path="/mas/edit/:id" element={<EditMas />} />
          <Route exact path="/mas/view/:id" element={<ViewMas />} />

          {/* <Route exact path="/soldier_type" element={<SoldierType />} /> */}

          <Route exact path="/soldiers" element={<Soldier/>} />
          <Route exact path="/soldiers/add" element={<AddSoldier/>} />          
          <Route exact path="/soldiers/edit/:id" element={<EditSoldier/>} />
          <Route exact path="/soldiers/view/:id" element={<ViewSoldier/>} />

          <Route exact path="/military_building" element={<MilitaryBuilding/>} />
          <Route exact path="/military_building/add" element={<AddMilitaryBuilding/>} />
          <Route exact path="/military_building/edit/:id" element={<EditMilitaryBuilding/>} />
          <Route exact path="/military_building/view/:id" element={<ViewMilitaryBuilding/>} />

          <Route exact path="/weapon_type" element={<WeaponType/>} />
          

        </Routes>
      </Router>
    </div>
  );
}

export default App;
