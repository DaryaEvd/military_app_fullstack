package ccfit.nsu.ru.daryaevd.military_unit.controller;

import ccfit.nsu.ru.daryaevd.military_unit.dto.SoldierDto;
import ccfit.nsu.ru.daryaevd.military_unit.service.SoldierService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("/api/soldiers")
public class SoldierController {
    private final SoldierService soldierService;

    @PostMapping
    public ResponseEntity<SoldierDto> createSoldier(@RequestBody SoldierDto soldierDto){
        SoldierDto savedSoldier = soldierService.createSoldier(soldierDto);
        return new ResponseEntity<>(savedSoldier, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<SoldierDto> getSoldierById(@PathVariable("id") Long soldierId) {
        SoldierDto soldierDto = soldierService.getSoldierById(soldierId);
        return ResponseEntity.ok(soldierDto);
    }

    @GetMapping
    public ResponseEntity<List<SoldierDto>> getAllSoldiers() {
        List<SoldierDto> soldierDtoList = soldierService.getAllSoldiers();
        return ResponseEntity.ok(soldierDtoList);
    }

    @PutMapping("{id}")
    public ResponseEntity<SoldierDto> updateSoldier(@PathVariable("id") Long soldierId,
                                                    @RequestBody SoldierDto updatedSoldier) {
        SoldierDto soldierDto = soldierService.updateSoldier(soldierId, updatedSoldier);
        return ResponseEntity.ok(soldierDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteSoldier(@PathVariable("id") Long soldierId) {
        soldierService.deleteSoldier(soldierId);
        return ResponseEntity.ok("Soldier deleted successfully");
    }
}