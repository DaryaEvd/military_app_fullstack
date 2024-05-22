import './App.css';
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import Navbar from './layout/Navbar';
import Home from './pages/Home';
import { Route, BrowserRouter as Router, Routes } from 'react-router-dom';

import CombatEquipment from './pages/CombatEquipment';
import Mas
 from './pages/Mas';
import AddCombatEquipment from './combat_equipments/AddCombatEquipment';
import EditCombatEquipment from './combat_equipments/EditCombatEquipment';
import ViewCombatEquipment from './combat_equipments/ViewCombatEquipment';

import AddMas from './mas/AddMas';
import EditMas from './mas/EditMas';
import ViewMas from './mas/ViewMas';

function App() {
  return (
    <div className="App">
      <Router>
        <Navbar />
        <Routes>
          <Route exact path="/" element={<Home />} />

          <Route exact path="/combat_equipment" element={<CombatEquipment />} />
          <Route exact path="/addcombatequipment" element={<AddCombatEquipment />} />
          <Route exact path="/editcombatequipment/:id" element={<EditCombatEquipment />} />
          <Route exact path="/viewcombatequipment/:id" element={<ViewCombatEquipment />} />

          <Route exact path="/mas" element={<Mas />} />
          <Route exact path="/addmas" element={<AddMas />} />
          <Route exact path="/editmas/:id" element={<EditMas />} />
          <Route exact path="/viewmas/:id" element={<ViewMas />} />


        </Routes>
      </Router>
    </div>
  );
}

export default App;
