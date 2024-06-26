package ccfit.nsu.ru.daryaevd.military_unit.controller;

import ccfit.nsu.ru.daryaevd.military_unit.dto.SoldierDto;
import ccfit.nsu.ru.daryaevd.military_unit.entity.Soldier;
import ccfit.nsu.ru.daryaevd.military_unit.mapper.SoldierMapper;
import ccfit.nsu.ru.daryaevd.military_unit.service.SoldierService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping("/officers")
    public ResponseEntity<List<SoldierDto>> getOfficers(
            @RequestParam(value = "soldier_rank", required = false) Integer soldierRank,
            @RequestParam(value = "subdivision_rank", required = false) Integer subdivisionRank) {
        List<SoldierDto> officers = soldierService.getOfficers(soldierRank, subdivisionRank);
        return ResponseEntity.ok(officers);
    }

    @GetMapping("/sergeants")
    public ResponseEntity<List<SoldierDto>> getSergeants(
            @RequestParam(value = "soldier_rank", required = false) Integer soldierRank,
            @RequestParam(value = "subdivision_rank", required = false) Integer subdivisionRank) {
        List<SoldierDto> sergeants = soldierService.getSergeants(soldierRank, subdivisionRank);
        return ResponseEntity.ok(sergeants);
    }

    @GetMapping("/{soldierId}/chain-of-command")
    public ResponseEntity<List<SoldierDto>> getChainOfCommand(@PathVariable Long soldierId) {
        List<SoldierDto> chainOfCommand = soldierService.getChainOfCommand(soldierId);
        return ResponseEntity.ok(chainOfCommand);
    }


    @GetMapping("/hierarchy/{soldierId}")
    public ResponseEntity<List<SoldierDto>> getHierarchyForSoldier(@PathVariable Long soldierId) {
        List<SoldierDto> hierarchy = soldierService.getHierarchyForSoldier(soldierId);
        return ResponseEntity.ok(hierarchy);
    }

    @GetMapping("/subordinates/{id}")
    public ResponseEntity<List<SoldierDto>> getSubordinates(@PathVariable Long id) {
        List<SoldierDto> subordinates = soldierService.getSubordinates(id);
        return ResponseEntity.ok(subordinates);
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
