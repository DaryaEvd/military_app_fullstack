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
@CrossOrigin("http://localhost:3000")
public class SoldierController {
    private SoldierService soldierService;

    @PostMapping
    public ResponseEntity<SoldierDto> createSoldier(@RequestBody SoldierDto soldierDto) {
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
        List<SoldierDto> soldiers = soldierService.getAllSoldiers();
        return ResponseEntity.ok(soldiers);
    }

    @PutMapping("{id}")
    public ResponseEntity<SoldierDto> updateSoldier(@PathVariable("id") Long soldierId,
                                                    @RequestBody SoldierDto soldierDto) {
        SoldierDto updatedSoldier = soldierService.updateSoldier(soldierId, soldierDto);
        return ResponseEntity.ok(updatedSoldier);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteSoldier(@PathVariable("id") Long soldierId) {
        soldierService.deleteSoldier(soldierId);
        return ResponseEntity.ok("Soldier deleted successfully");
    }


    @GetMapping("/all_officcers")
    public List<SoldierDto> getOfficersByRankRange() {
        return soldierService.getOfficersByRankRange();
    }


//    @GetMapping("/all_officcers")
//    public List<Soldier> getAllOfficers() {
//        // Call the method from the service to fetch officers and return the result
//        return soldierService.getOfficers();
//    }

//    @GetMapping("/{minRank}/{maxRank}/{subdivisionTypeRank}")
//    public ResponseEntity<List<Soldier>> getOfficersByTypeAndSubdivisionTypeRank(@PathVariable Integer minRank,
//                                                                                 @PathVariable Integer maxRank,
//                                                                                 @PathVariable Integer subdivisionTypeRank) {
//        List<Soldier> officers = soldierService.getOfficersByTypeAndSubdivisionTypeRank(minRank, maxRank, subdivisionTypeRank);
//        return ResponseEntity.ok(officers);
//    }

//    @GetMapping("/all_sergeants")
//    public List<Soldier> getAllSergeants() {
//        return soldierService.findSergeants();
//    }
//
//    @GetMapping("/{lowerRank}/{upperRank}/{subdivisionRank}")
//    public List<Soldier> getSergeantsByRankAndSubdivisionType(
//            @PathVariable Integer lowerRank, @PathVariable Integer upperRank, @PathVariable Integer subdivisionRank) {
//        return soldierService.findSergeantsByRankAndSubdivisionType(lowerRank, upperRank, subdivisionRank);
//    }
//
//    @GetMapping("/mas/{masId}/subdivision/{subdivisionName}")
//    public List<Soldier> findSoldiersByMasIdAndSubdivisionName(
//            @PathVariable Long masId,
//            @PathVariable String subdivisionName) {
//        return soldierService.findSoldiersByMasIdAndSubdivisionName(masId, subdivisionName);
//    }
}