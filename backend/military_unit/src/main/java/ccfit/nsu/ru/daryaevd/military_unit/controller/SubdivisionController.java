package ccfit.nsu.ru.daryaevd.military_unit.controller;

import ccfit.nsu.ru.daryaevd.military_unit.dto.MilitaryBuildingDto;
import ccfit.nsu.ru.daryaevd.military_unit.dto.SoldierDto;
import ccfit.nsu.ru.daryaevd.military_unit.dto.SubdivisionDto;
import ccfit.nsu.ru.daryaevd.military_unit.dto.SubdivisionTypeDto;
import ccfit.nsu.ru.daryaevd.military_unit.entity.MilitaryBuilding;
import ccfit.nsu.ru.daryaevd.military_unit.entity.Subdivision;
import ccfit.nsu.ru.daryaevd.military_unit.service.MilitaryBuildingService;
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
