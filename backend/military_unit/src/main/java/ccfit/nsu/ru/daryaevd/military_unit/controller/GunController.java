package ccfit.nsu.ru.daryaevd.military_unit.controller;

import ccfit.nsu.ru.daryaevd.military_unit.dto.GunDto;
import ccfit.nsu.ru.daryaevd.military_unit.service.GunService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/guns")
@CrossOrigin("http://localhost:3000")
public class GunController {
    private GunService gunService;

    @PostMapping
    public ResponseEntity<GunDto> createGun(@RequestBody GunDto gunDto){
        GunDto savedGun = gunService.createGun(gunDto);
        return new ResponseEntity<>(savedGun, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<GunDto> getGunById(@PathVariable("id") Long gunId) {
        GunDto gunDto = gunService.getGunById(gunId);
        return ResponseEntity.ok(gunDto);
    }

    @GetMapping
    public ResponseEntity<List<GunDto>> getAllGuns() {
        List<GunDto> gunList = gunService.getAllGuns();
        return ResponseEntity.ok(gunList);
    }

    @PutMapping("{id}")
    public ResponseEntity<GunDto> updateGun(@PathVariable("id") Long gunId,
                                            @RequestBody GunDto updatedGun) {
        GunDto gunDto = gunService.updateGun(gunId, updatedGun);
        return ResponseEntity.ok(gunDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteGun(@PathVariable("id") Long gunId) {
        gunService.deleteGun(gunId);
        return ResponseEntity.ok("Gun deleted successfully");
    }
}

