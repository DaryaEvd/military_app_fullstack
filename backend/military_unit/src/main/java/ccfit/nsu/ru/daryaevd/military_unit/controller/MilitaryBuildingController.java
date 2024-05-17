package ccfit.nsu.ru.daryaevd.military_unit.controller;

import ccfit.nsu.ru.daryaevd.military_unit.dto.MilitaryBuildingDto;
import ccfit.nsu.ru.daryaevd.military_unit.entity.MilitaryBuilding;
import ccfit.nsu.ru.daryaevd.military_unit.service.MilitaryBuildingService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/military-building")
public class MilitaryBuildingController {
    private MilitaryBuildingService militaryBuildingService;

    // add military building
    @PostMapping
    public ResponseEntity<MilitaryBuildingDto> createMilitaryBuilding(@RequestBody MilitaryBuildingDto militaryBuildingDto) {
        MilitaryBuildingDto savedMilitaryBuilding = militaryBuildingService.createMilitaryBuilding(militaryBuildingDto);
        return new ResponseEntity<>(savedMilitaryBuilding, HttpStatus.CREATED);
    }

    // get military building
    @GetMapping("{id}")
    public ResponseEntity<MilitaryBuildingDto> getMilitaryBuildingById(@PathVariable("id") Long militaryBuildingId) {
        MilitaryBuildingDto militaryBuildingDto = militaryBuildingService.getMilitaryBuildingById(militaryBuildingId);
        return ResponseEntity.ok(militaryBuildingDto);
    }

    // get all military buildings
    @GetMapping
    public ResponseEntity<List<MilitaryBuildingDto>> getAllMilitaryBuildings() {
        List<MilitaryBuildingDto> militaryBuildingDto = militaryBuildingService.getAllBuildings();
        return ResponseEntity.ok(militaryBuildingDto);
    }

    //update military building info
    @PutMapping("{id}")
    public ResponseEntity<MilitaryBuildingDto> updateSubdivision(@PathVariable("id") Long militaryBuildingId,
                                                                 @RequestBody MilitaryBuildingDto updatedMilitaryBuilding) {
        MilitaryBuildingDto militaryBuildingDto = militaryBuildingService.updateMilitaryBuilding(militaryBuildingId, updatedMilitaryBuilding);
        return ResponseEntity.ok(militaryBuildingDto);
    }

    //delete military building
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteSubdivision(@PathVariable("id") Long subdivisionId) {
        militaryBuildingService.deleteMilitaryBuilding(subdivisionId);
        return ResponseEntity.ok("Subdivision deleted successfully");
    }

    @GetMapping("/subdivision/{subdivisionType}")
    public List<MilitaryBuilding> findBySubdivisionType(@PathVariable String subdivisionType) {
        return militaryBuildingService.findBySubdivisionType(subdivisionType);
    }

    @GetMapping("/multiple-dislocated")
    public List<MilitaryBuilding> findMilitaryBuildingsWithMultipleDislocatedSubdivisions() {
        return militaryBuildingService.findMilitaryBuildingsWithMultipleDislocatedSubdivisions();
    }
}
