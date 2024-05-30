package ccfit.nsu.ru.daryaevd.military_unit.controller;

import ccfit.nsu.ru.daryaevd.military_unit.dto.MilitaryBuildingDto;
import ccfit.nsu.ru.daryaevd.military_unit.dto.SoldierDto;
import ccfit.nsu.ru.daryaevd.military_unit.dto.SubdivisionDto;
import ccfit.nsu.ru.daryaevd.military_unit.dto.SubdivisionTypeDto;
import ccfit.nsu.ru.daryaevd.military_unit.entity.MilitaryBuilding;
import ccfit.nsu.ru.daryaevd.military_unit.entity.Subdivision;
import ccfit.nsu.ru.daryaevd.military_unit.repository.SubdivisionRepository;
import ccfit.nsu.ru.daryaevd.military_unit.service.MilitaryBuildingService;
import ccfit.nsu.ru.daryaevd.military_unit.service.SoldierService;
import ccfit.nsu.ru.daryaevd.military_unit.service.SubdivisionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/subdivision")
@CrossOrigin("CrossOrigin")
public class SubdivisionController {
    private SubdivisionService subdivisionService;
    private final MilitaryBuildingService militaryBuildingService;
    private final SoldierService soldierService;
    private SubdivisionRepository subdivisionRepository;


    // add subdivision
    @PostMapping
    public ResponseEntity<SubdivisionDto> createSubdivision(@RequestBody SubdivisionDto subdivisionDto){
        SubdivisionDto savedSubdivision = subdivisionService.createSubdivision(subdivisionDto);
        return new ResponseEntity<>(savedSubdivision, HttpStatus.CREATED);
    }

    // get subdivision
    @GetMapping("{id}")
    public ResponseEntity<SubdivisionDto> getSubdivisionById(@PathVariable("id") Long subdivisionId) {
        SubdivisionDto subdivisionDto = subdivisionService.getSubdivisionById(subdivisionId);
        return ResponseEntity.ok(subdivisionDto);
    }

    // get all subdivisions
    @GetMapping
    public ResponseEntity<List<SubdivisionDto>> getAllSubdivisions() {
        List<SubdivisionDto> subdivisions = subdivisionService.getAllSubdivisions();
        return ResponseEntity.ok(subdivisions);
    }

    //update subdivision info
    @PutMapping("{id}")
    public ResponseEntity<SubdivisionDto> updateSubdivision(@PathVariable("id") Long subdivisionId,
                                                            @RequestBody SubdivisionDto updatedSubdivision) {
        SubdivisionDto subdivisionDto = subdivisionService.updateSubdivision(subdivisionId, updatedSubdivision);
        return ResponseEntity.ok(subdivisionDto);
    }

    //delete subdivision
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteSubdivision(@PathVariable("id") Long subdivisionId) {
        subdivisionService.deleteSubdivision(subdivisionId);

        return ResponseEntity.ok("Subdivision deleted successfully");
    }

    @GetMapping("/commanders")
    public ResponseEntity<List<SoldierDto>> getAllCommanders() {
        return ResponseEntity.ok(subdivisionService.getAllCommanders());
    }

    @GetMapping("/types")
    public ResponseEntity<List<SubdivisionTypeDto>> getAllSubdivisionTypes() {
        return ResponseEntity.ok(subdivisionService.getAllSubdivisionTypes());
    }

    @GetMapping("/dislocation_places")
    public List<MilitaryBuildingDto> getAllDislocationPlaces() {
        return militaryBuildingService.getAllDislocationPlaces();
    }

    @GetMapping("/dislocation_places/{subdivisionId}")
    public List<MilitaryBuildingDto> getDislocationPlacesBySubdivisionId(@PathVariable Long subdivisionId) {
        return militaryBuildingService.getDislocationPlacesBySubdivisionId(subdivisionId);
    }

    @GetMapping("/specialists/{masId}")
    public ResponseEntity<List<SoldierDto>> getSoldiersByMasId(@PathVariable Long masId) {
        List<SoldierDto> soldiers = soldierService.getSoldiersByMasId(masId);
        return ResponseEntity.ok(soldiers);
    }

    @GetMapping("/specialists/{masId}/{subdivisionId}")
    public ResponseEntity<List<SoldierDto>> getSoldiersByMasIdAndSubdivisionId(@PathVariable Long masId, @PathVariable Long subdivisionId) {
        List<SoldierDto> soldiers = soldierService.getSoldiersByMasIdAndSubdivisionId(masId, subdivisionId);
        return ResponseEntity.ok(soldiers);
    }

    @GetMapping("/most-units")
    public ResponseEntity<List<Object[]>> getSubdivisionsWithMostUnits() {
        List<Object[]> result = subdivisionService.findSubdivisionsWithMostUnits();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/least-units")
    public ResponseEntity<List<Object[]>> getSubdivisionsWithLeastUnits() {
        List<Object[]> result = subdivisionService.findSubdivisionsWithLeastUnits();
        return ResponseEntity.ok(result);
    }


    @GetMapping("/with-commanders")
    public ResponseEntity<List<Subdivision>> getAllSubdivisionsWithCommanders() {
        List<Subdivision> subdivisions = subdivisionService.getAllSubdivisionsWithCommanders();
        return ResponseEntity.ok(subdivisions);
    }

    @GetMapping("/{subdivisionId}/with-commander")
    public ResponseEntity<Subdivision> getSubdivisionWithCommander(@PathVariable Long subdivisionId) {
        Subdivision subdivision = subdivisionService.getSubdivisionWithCommander(subdivisionId);
        return ResponseEntity.ok(subdivision);
    }

    @GetMapping("/weapon_more_than")
    public List<String> getSubdivisionsWithWeaponMoreThan(@RequestParam String weaponCategory, @RequestParam int count) {
        return subdivisionService.getSubdivisionsWithWeaponMoreThan(weaponCategory, count);
    }

    @GetMapping("/no_weapon")
    public List<String> getSubdivisionsWithoutWeapon(@RequestParam String weaponCategory) {
        return subdivisionService.getSubdivisionsWithoutWeapon(weaponCategory);
    }

//    @GetMapping("/weapons/count-greater-than-three")
//    public ResponseEntity<List<Long>> getSubdivisionsWithWeaponCountGreaterThanThree(
//            @RequestParam String category) {
//         List<Long> subdivisionIds = subdivisionRepository.findSubdivisionsWithWeaponCountGreaterThanThree(category);
//        return ResponseEntity.ok(subdivisionIds);
//    }
//
//    @GetMapping("/weapons/without-category")
//    public ResponseEntity<List<Long>> getSubdivisionsWithoutWeaponCategory(
//            @RequestParam String category) {
//        List<Long> subdivisionIds = subdivisionRepository.findSubdivisionsWithoutWeaponCategory(category);
//        return ResponseEntity.ok(subdivisionIds);
//    }

//    @GetMapping("/most_military_units")
//    public ResponseEntity<List<Object[]>> getSubdivisionsWithMostMilitaryUnits() {
//        List<Object[]> result = subdivisionService.findSubdivisionsWithMostMilitaryUnits();
//        return new ResponseEntity<>(result, HttpStatus.OK);
//    }

//    @GetMapping("/specified-subdivision")
//    public ResponseEntity<Object[]> getCommanderBySubdivisionName(@RequestParam(value = "subdivisionName") String subdivisionName) {
//        List<Object[]> result = subdivisionService.findCommanderBySubdivisionName(subdivisionName);
//        if (result.isEmpty()) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(result.get(0)); // Assuming there is only one commander per subdivision
//    }

//    @GetMapping("/combat-equipment")
//    public List<Subdivision> findSubdivisionsWithSpecifiedCombatEquipment() {
//        return subdivisionService.findSubdivisionsWithSpecifiedCombatEquipment();
//    }

//    @GetMapping("/military-buildings/dislocation")
//    public List<MilitaryBuilding> getMilitaryBuildingsForDislocation() {
//        return subdivisionService.getMilitaryBuildingsForDislocation();
//    }


//    @GetMapping("/officers")
//    public ResponseEntity<List<Object[]>> getOfficersByRank(@RequestParam(value = "rank", required = false) Integer rank) {
//        List<Object[]> officers = subdivisionService.findOfficersByRank(rank);
//        if (officers.isEmpty()) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(officers);
//    }


//    @GetMapping("/most-units")
//    public ResponseEntity<List<SubdivisionDto>> getSubdivisionWithMostUnits() {
//        List<SubdivisionDto> subdivisions = subdivisionService.findSubdivisionWithMostUnits();
//        return ResponseEntity.ok(subdivisions);
//    }
//
//    @GetMapping("/fewest-units")
//    public ResponseEntity<List<SubdivisionDto>> getSubdivisionWithFewestUnits() {
//        List<SubdivisionDto> subdivisions = subdivisionService.findSubdivisionWithFewestUnits();
//        return ResponseEntity.ok(subdivisions);
//    }

}
