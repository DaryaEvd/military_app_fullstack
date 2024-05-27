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
@RequestMapping("/api/military_building")
@CrossOrigin("http://localhost:3000")
public class MilitaryBuildingController {
    private MilitaryBuildingService militaryBuildingService;

    @GetMapping
    public List<MilitaryBuildingDto> getAllMilitaryBuildings() {
        return militaryBuildingService.getAllMilitaryBuildings();
    }

    @GetMapping("/{id}")
    public MilitaryBuildingDto getMilitaryBuildingById(@PathVariable Long id) {
        return militaryBuildingService.getMilitaryBuildingById(id);
    }

    @PostMapping
    public MilitaryBuildingDto createMilitaryBuilding(@RequestBody MilitaryBuildingDto dto) {
        return militaryBuildingService.createMilitaryBuilding(dto);
    }

    @PutMapping("/{id}")
    public MilitaryBuildingDto updateMilitaryBuilding(@PathVariable Long id, @RequestBody MilitaryBuildingDto dto) {
        return militaryBuildingService.updateMilitaryBuilding(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteMilitaryBuilding(@PathVariable Long id) {
        militaryBuildingService.deleteMilitaryBuilding(id);
    }

    @GetMapping("/subdivision/{subdivisionId}")
    public List<MilitaryBuildingDto> getMilitaryBuildingsBySubdivision(@PathVariable Long subdivisionId) {
        return militaryBuildingService.getBuildingsBySubdivisionId(subdivisionId);
    }

    @GetMapping("/subdivision")
    public List<MilitaryBuildingDto> getMilitaryBuildingsByDislocation(
            @RequestParam boolean is_dislocated,
            @RequestParam(required = false, defaultValue = "0") int min_amount_subdivisions) {
        if (is_dislocated) {
            return militaryBuildingService.getBuildingsWithMinSubdivisions(min_amount_subdivisions);
        } else {
            return militaryBuildingService.getBuildingsWithNoSubdivisions();
        }
    }




    ////////////////////////////////////////////////////////

//    // add military building
//    @PostMapping
//    public ResponseEntity<MilitaryBuildingDto> createMilitaryBuilding(@RequestBody MilitaryBuildingDto militaryBuildingDto) {
//        MilitaryBuildingDto savedMilitaryBuilding = militaryBuildingService.createMilitaryBuilding(militaryBuildingDto);
//        return new ResponseEntity<>(savedMilitaryBuilding, HttpStatus.CREATED);
//    }
//
//    // get military building
//    @GetMapping("{id}")
//    public ResponseEntity<MilitaryBuildingDto> getMilitaryBuildingById(@PathVariable("id") Long militaryBuildingId) {
//        MilitaryBuildingDto militaryBuildingDto = militaryBuildingService.getMilitaryBuildingById(militaryBuildingId);
//        return ResponseEntity.ok(militaryBuildingDto);
//    }
//
//    // get all military buildings
//    @GetMapping
//    public ResponseEntity<List<MilitaryBuildingDto>> getAllMilitaryBuildings() {
//        List<MilitaryBuildingDto> militaryBuildingDto = militaryBuildingService.getAllBuildings();
//        return ResponseEntity.ok(militaryBuildingDto);
//    }
//
//    //update military building info
//    @PutMapping("{id}")
//    public ResponseEntity<MilitaryBuildingDto> updateMilitaryBuilding(@PathVariable("id") Long militaryBuildingId,
//                                                                 @RequestBody MilitaryBuildingDto updatedMilitaryBuilding) {
//        MilitaryBuildingDto militaryBuildingDto = militaryBuildingService.updateMilitaryBuilding(militaryBuildingId, updatedMilitaryBuilding);
//        return ResponseEntity.ok(militaryBuildingDto);
//    }
//
//    //delete military building
//    @DeleteMapping("{id}")
//    public ResponseEntity<String> deleteMilitaryBuilding(@PathVariable("id") Long militaryBuildingId) {
//        militaryBuildingService.deleteMilitaryBuilding(militaryBuildingId);
//        return ResponseEntity.ok("Subdivision deleted successfully");
//    }


//    @GetMapping("/subdivision/{subdivisionType}")
//    public List<MilitaryBuilding> findBySubdivisionType(@PathVariable String subdivisionType) {
//        return militaryBuildingService.findBySubdivisionType(subdivisionType);
//    }
//
//    @GetMapping("/multiple-dislocated")
//    public List<MilitaryBuilding> findMilitaryBuildingsWithMultipleDislocatedSubdivisions() {
//        return militaryBuildingService.findMilitaryBuildingsWithMultipleDislocatedSubdivisions();
//    }
}
