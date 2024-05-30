package ccfit.nsu.ru.daryaevd.military_unit.controller;

import ccfit.nsu.ru.daryaevd.military_unit.dto.WeaponTypeDto;
import ccfit.nsu.ru.daryaevd.military_unit.entity.*;
import ccfit.nsu.ru.daryaevd.military_unit.mapper.WeaponTypeMapper;
import ccfit.nsu.ru.daryaevd.military_unit.service.SubdivisionService;
import ccfit.nsu.ru.daryaevd.military_unit.service.WeaponTypeService;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/api/weapons")
@CrossOrigin("http://localhost:3000")
public class WeaponTypeController {
    private WeaponTypeService weaponTypeService;
    private SubdivisionService subdivisionService;


    @PostMapping
    public ResponseEntity<WeaponTypeDto> createWeaponType(@RequestBody WeaponTypeDto weaponTypeDto) {
        WeaponTypeDto savedWeaponType = weaponTypeService.createWeaponType(weaponTypeDto);
        return new ResponseEntity<>(savedWeaponType, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<WeaponTypeDto> getWeaponTypeById(@PathVariable("id") Long weaponTypeId) {
        WeaponTypeDto weaponTypeDto = weaponTypeService.getWeaponTypeById(weaponTypeId);
        return ResponseEntity.ok(weaponTypeDto);
    }

//    @GetMapping
//    public ResponseEntity<List<WeaponTypeDto>> getAllWeaponTypes() {
//        List<WeaponTypeDto> weaponTypeList = weaponTypeService.getAllWeaponTypes();
//        return ResponseEntity.ok(weaponTypeList);
//    }

    @PutMapping("{id}")
    public ResponseEntity<WeaponTypeDto> updateWeaponType(@PathVariable("id") Long weaponTypeId,
                                                          @RequestBody WeaponTypeDto updatedWeaponType) {
        WeaponTypeDto weaponTypeDto = weaponTypeService.updateWeaponType(weaponTypeId, updatedWeaponType);
        return ResponseEntity.ok(weaponTypeDto);
    }

//    @DeleteMapping("{id}")
//    public ResponseEntity<String> deleteWeaponType(@PathVariable("id") Long weaponTypeId) {
//        weaponTypeService.deleteWeaponType(weaponTypeId);
//        return ResponseEntity.ok("Weapon type deleted successfully");
//    }

    // todo: delete mb???
//    @PostMapping("/subdivisions/names")
//    public ResponseEntity<Map<Long, String>> getSubdivisionNames(@RequestBody List<Long> subdivisionIds) {
//        Map<Long, String> subdivisionNames = subdivisionService.getSubdivisionNames(subdivisionIds);
//        return ResponseEntity.ok(subdivisionNames);
//    }

    /////////////////////////////////////
    @GetMapping
    public ResponseEntity<List<WeaponTypeDto>> getAllWeaponTypes() {
        List<WeaponTypeDto> weaponTypes = weaponTypeService.getAllWeaponTypes();
        return ResponseEntity.ok(weaponTypes);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<WeaponTypeDto>> getWeaponTypesByCategory(@PathVariable String category) {
        List<WeaponTypeDto> weaponTypes = weaponTypeService.getWeaponTypesByCategory(category);
        return ResponseEntity.ok(weaponTypes);
    }

    @GetMapping("/category/{category}/subdivision/{subdivisionId}")
    public ResponseEntity<List<WeaponTypeDto>> getWeaponTypesByCategoryAndSubdivision(
            @PathVariable String category, @PathVariable Long subdivisionId) {
        List<WeaponTypeDto> weaponTypes = weaponTypeService.getWeaponTypesByCategoryAndSubdivision(category, subdivisionId);
        return ResponseEntity.ok(weaponTypes);
    }


    @GetMapping("/subdivisions-with-weapon-count")
    public ResponseEntity<List<Subdivision>> getSubdivisionsWithWeaponCountGreaterThan(
            @RequestParam String category,
            @RequestParam Long count) {
        List<Subdivision> subdivisions = weaponTypeService.getSubdivisionsWithWeaponCountGreaterThan(category, count);
        return ResponseEntity.ok(subdivisions);
    }


//    @GetMapping("/subdivisions-with-weapon-count-greater-than-three")
//    public ResponseEntity<List<Subdivision>> getSubdivisionsWithWeaponCountGreaterThanThree(
//            @RequestParam String category) {
//        List<Subdivision> subdivisions = weaponTypeService.getSubdivisionsWithWeaponCountGreaterThanThree(category);
//        return ResponseEntity.ok(subdivisions);
//    }
//
//    @GetMapping("/subdivisions-without-weapon-category")
//    public ResponseEntity<List<Subdivision>> getSubdivisionsWithoutWeaponCategory(
//            @RequestParam String category) {
//        List<Subdivision> subdivisions = weaponTypeService.getSubdivisionsWithoutWeaponCategory(category);
//        return ResponseEntity.ok(subdivisions);
//    }


//    @GetMapping("/category/{category}")
//    public ResponseEntity<List<WeaponTypeDto>> getWeaponsByCategory(@PathVariable String category) {
//        List<WeaponTypeDto> weapons = weaponTypeService.getWeaponsByCategory(category);
//        return ResponseEntity.ok(weapons);
//    }
//
//    @GetMapping("/category/{category}/subdivision/{subdivisionId}")
//    public ResponseEntity<List<WeaponTypeDto>> getWeaponsByCategoryAndSubdivision(@PathVariable String category, @PathVariable Long subdivisionId) {
//        List<WeaponTypeDto> weapons = weaponTypeService.getWeaponsByCategoryAndSubdivision(category, subdivisionId);
//        return ResponseEntity.ok(weapons);
//    }


//    @GetMapping("/subdivision/{subdivisionId}/guns")
//    public List<Gun> getGunsBySubdivision(@PathVariable Long subdivisionId) {
//        return weaponTypeService.getGunsBySubdivision(subdivisionId);
//    }
//
//    @GetMapping("/subdivision/{subdivisionId}/artillery")
//    public List<Artillery> getArtilleryBySubdivision(@PathVariable Long subdivisionId) {
//        return weaponTypeService.getArtilleryBySubdivision(subdivisionId);
//    }
//
//    @GetMapping("/subdivision/{subdivisionId}/rocket_weapons")
//    public List<RocketWeapon> getRocketWeaponsBySubdivision(@PathVariable Long subdivisionId) {
//        return weaponTypeService.getRocketWeaponsBySubdivision(subdivisionId);
//    }
}

