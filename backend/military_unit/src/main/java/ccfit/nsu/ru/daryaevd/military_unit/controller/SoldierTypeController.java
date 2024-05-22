package ccfit.nsu.ru.daryaevd.military_unit.controller;

import ccfit.nsu.ru.daryaevd.military_unit.dto.SoldierTypeDto;
import ccfit.nsu.ru.daryaevd.military_unit.service.SoldierTypeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/soldier_type")
@CrossOrigin("http://localhost:3000")
public class SoldierTypeController {
    private SoldierTypeService soldierTypeService;

    // add military building
    @PostMapping
    public ResponseEntity<SoldierTypeDto> createSavedSoldierType(@RequestBody SoldierTypeDto soldierTypeDto){
        SoldierTypeDto savedSoldierType = soldierTypeService.createSoldierType(soldierTypeDto);
        return new ResponseEntity<>(savedSoldierType, HttpStatus.CREATED);
    }

    // get military building
    @GetMapping("{id}")
    public ResponseEntity<SoldierTypeDto> getSoldierTypeById(@PathVariable("id") Long soldierTypeId) {
        SoldierTypeDto soldierTypeDto = soldierTypeService.getSoldierTypeById(soldierTypeId);
        return ResponseEntity.ok(soldierTypeDto);
    }

    // get all military buildings
    @GetMapping
    public ResponseEntity<List<SoldierTypeDto>> getAllSoldierTypes() {
        List<SoldierTypeDto> soldierTypeDtosList = soldierTypeService.getAllSoldierTypes();
        return ResponseEntity.ok(soldierTypeDtosList);
    }

    //update military building info
    @PutMapping("{id}")
    public ResponseEntity<SoldierTypeDto> updateSubdivision(@PathVariable("id") Long soldierTypeId,
                                                                 @RequestBody SoldierTypeDto updatedSoldierType) {
        SoldierTypeDto soldierTypeDto = soldierTypeService.updateSoldierType(soldierTypeId, updatedSoldierType);
        return ResponseEntity.ok(soldierTypeDto);
    }

    //delete military building
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteSubdivision(@PathVariable("id") Long soldierTypeId) {
        soldierTypeService.deleteSoldierType(soldierTypeId);
        return ResponseEntity.ok("Soldier type deleted successfully");
    }

}
