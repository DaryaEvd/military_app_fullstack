package ccfit.nsu.ru.daryaevd.military_unit.controller;

import ccfit.nsu.ru.daryaevd.military_unit.dto.WeaponTypeDto;
import ccfit.nsu.ru.daryaevd.military_unit.entity.Artillery;
import ccfit.nsu.ru.daryaevd.military_unit.entity.Gun;
import ccfit.nsu.ru.daryaevd.military_unit.entity.RocketWeapon;
import ccfit.nsu.ru.daryaevd.military_unit.entity.WeaponType;
import ccfit.nsu.ru.daryaevd.military_unit.service.WeaponTypeService;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/weapons")
@CrossOrigin("http://localhost:3000")
public class WeaponTypeController {
    private WeaponTypeService weaponTypeService;

    @PostMapping
    public ResponseEntity<WeaponTypeDto> createWeaponType(@RequestBody WeaponTypeDto weaponTypeDto){
        WeaponTypeDto savedWeaponType = weaponTypeService.createWeaponType(weaponTypeDto);
        return new ResponseEntity<>(savedWeaponType, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<WeaponTypeDto> getWeaponTypeById(@PathVariable("id") Long weaponTypeId) {
        WeaponTypeDto weaponTypeDto = weaponTypeService.getWeaponTypeById(weaponTypeId);
        return ResponseEntity.ok(weaponTypeDto);
    }

    @GetMapping
    public ResponseEntity<List<WeaponTypeDto>> getAllWeaponTypes() {
        List<WeaponTypeDto> weaponTypeList = weaponTypeService.getAllWeaponTypes();
        return ResponseEntity.ok(weaponTypeList);
    }

    @PutMapping("{id}")
    public ResponseEntity<WeaponTypeDto> updateWeaponType(@PathVariable("id") Long weaponTypeId,
                                                          @RequestBody WeaponTypeDto updatedWeaponType) {
        WeaponTypeDto weaponTypeDto = weaponTypeService.updateWeaponType(weaponTypeId, updatedWeaponType);
        return ResponseEntity.ok(weaponTypeDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteWeaponType(@PathVariable("id") Long weaponTypeId) {
        weaponTypeService.deleteWeaponType(weaponTypeId);
        return ResponseEntity.ok("Weapon type deleted successfully");
    }


    @GetMapping("/subdivision/{subdivisionId}/guns")
    public List<Gun> getGunsBySubdivision(@PathVariable Long subdivisionId) {
        return weaponTypeService.getGunsBySubdivision(subdivisionId);
    }

    @GetMapping("/subdivision/{subdivisionId}/artillery")
    public List<Artillery> getArtilleryBySubdivision(@PathVariable Long subdivisionId) {
        return weaponTypeService.getArtilleryBySubdivision(subdivisionId);
    }

    @GetMapping("/subdivision/{subdivisionId}/rocket-weapons")
    public List<RocketWeapon> getRocketWeaponsBySubdivision(@PathVariable Long subdivisionId) {
        return weaponTypeService.getRocketWeaponsBySubdivision(subdivisionId);
    }
}

