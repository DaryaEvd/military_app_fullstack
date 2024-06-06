package ccfit.nsu.ru.daryaevd.military_unit.controller;

import ccfit.nsu.ru.daryaevd.military_unit.dto.RocketWeaponDto;
import ccfit.nsu.ru.daryaevd.military_unit.service.RocketWeaponService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("/api/rocket-weapons")
@CrossOrigin("http://localhost:3000")
public class RocketWeaponController {
    private RocketWeaponService rocketWeaponService;

    @PostMapping
    public ResponseEntity<RocketWeaponDto> createRocketWeapon(@RequestBody RocketWeaponDto rocketWeaponDto){
        RocketWeaponDto savedRocketWeapon = rocketWeaponService.createRocketWeapon(rocketWeaponDto);
        return new ResponseEntity<>(savedRocketWeapon, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<RocketWeaponDto> getRocketWeaponById(@PathVariable("id") Long rocketWeaponId) {
        RocketWeaponDto rocketWeaponDto = rocketWeaponService.getRocketWeaponById(rocketWeaponId);
        return ResponseEntity.ok(rocketWeaponDto);
    }

    @GetMapping
    public ResponseEntity<List<RocketWeaponDto>> getAllRocketWeapons() {
        List<RocketWeaponDto> rocketWeaponList = rocketWeaponService.getAllRocketWeapons();
        return ResponseEntity.ok(rocketWeaponList);
    }

    @PutMapping("{id}")
    public ResponseEntity<RocketWeaponDto> updateRocketWeapon(@PathVariable("id") Long rocketWeaponId,
                                                              @RequestBody RocketWeaponDto updatedRocketWeapon) {
        RocketWeaponDto rocketWeaponDto = rocketWeaponService.updateRocketWeapon(rocketWeaponId, updatedRocketWeapon);
        return ResponseEntity.ok(rocketWeaponDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteRocketWeapon(@PathVariable("id") Long rocketWeaponId) {
        rocketWeaponService.deleteRocketWeapon(rocketWeaponId);
        return ResponseEntity.ok("RocketWeapon deleted successfully");
    }
}
