package ccfit.nsu.ru.daryaevd.military_unit.controller;

import ccfit.nsu.ru.daryaevd.military_unit.dto.CombatEquipmentDto;
import ccfit.nsu.ru.daryaevd.military_unit.service.CombatEquipmentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("/api/combat_equipment")
@CrossOrigin("http://localhost:3000")
public class CombatEquipmentController {
    private CombatEquipmentService combatEquipmentService;

    // add combat equipment
    @PostMapping
    public ResponseEntity<CombatEquipmentDto> createCombatEquipment(@RequestBody CombatEquipmentDto combatEquipmentDto){
        CombatEquipmentDto savedCombatEquipment = combatEquipmentService.createCombatEquipment(combatEquipmentDto);
        return new ResponseEntity<>(savedCombatEquipment, HttpStatus.CREATED);
    }

    // get combat equipment
    @GetMapping("{id}")
    public ResponseEntity<CombatEquipmentDto> getCombatEquipmentById(@PathVariable("id") Long combatEquipmentId) {
        CombatEquipmentDto combatEquipmentDto = combatEquipmentService.getCombatEquipmentById(combatEquipmentId);
        return ResponseEntity.ok(combatEquipmentDto);
    }

    // get all combat equipment
//    @GetMapping
//    public ResponseEntity<List<CombatEquipmentDto>> getAllCombatEquipment() {
//        List<CombatEquipmentDto> combatEquipmentList = combatEquipmentService.getAllCombatEquipment();
//        return ResponseEntity.ok(combatEquipmentList);
//    }

    // update combat equipment info
    @PutMapping("{id}")
    public ResponseEntity<CombatEquipmentDto> updateCombatEquipment(@PathVariable("id") Long combatEquipmentId,
                                                                    @RequestBody CombatEquipmentDto updatedCombatEquipment) {
        CombatEquipmentDto combatEquipmentDto = combatEquipmentService.updateCombatEquipment(combatEquipmentId, updatedCombatEquipment);
        return ResponseEntity.ok(combatEquipmentDto);
    }

    // delete combat equipment
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCombatEquipment(@PathVariable("id") Long combatEquipmentId) {
        combatEquipmentService.deleteCombatEquipment(combatEquipmentId);
        return ResponseEntity.ok("Combat equipment deleted successfully");
    }

    @GetMapping
    public ResponseEntity<List<CombatEquipmentDto>> getAllCombatEquipments() {
        List<CombatEquipmentDto> combatEquipments = combatEquipmentService.getAllCombatEquipments();
        return ResponseEntity.ok(combatEquipments);
    }

    @GetMapping("/subdivision/{subdivisionId}")
    public ResponseEntity<List<CombatEquipmentDto>> getCombatEquipmentsBySubdivisionId(@PathVariable Long subdivisionId) {
        List<CombatEquipmentDto> combatEquipments = combatEquipmentService.getCombatEquipmentsBySubdivisionId(subdivisionId);
        return ResponseEntity.ok(combatEquipments);
    }


    @GetMapping("/subdivisions/more_than_five/{equipmentId}")
    public ResponseEntity<List<Long>> getSubdivisionsWithMoreThanFiveEquipment(@PathVariable Long equipmentId) {
        List<Long> subdivisions = combatEquipmentService.getSubdivisionsWithMoreThanFiveEquipment(equipmentId);
        return ResponseEntity.ok(subdivisions);
    }

    @GetMapping("/subdivisions/no_equipment/{equipmentId}")
    public ResponseEntity<List<Long>> getSubdivisionsWithNoEquipment(@PathVariable Long equipmentId) {
        List<Long> subdivisions = combatEquipmentService.getSubdivisionsWithNoEquipment(equipmentId);
        return ResponseEntity.ok(subdivisions);
    }


//    @GetMapping("/availability")
//    public List<Object[]> getAvailabilityOfEquipment() {
//        return combatEquipmentService.getAvailabilityOfEquipment();
//    }
//
//    @GetMapping("/availability/{subdivisionType}")
//    public List<Object[]> getAvailabilityBySubdivisionType(@PathVariable String subdivisionType) {
//        return combatEquipmentService.getAvailabilityBySubdivisionType(subdivisionType);
//    }
}
