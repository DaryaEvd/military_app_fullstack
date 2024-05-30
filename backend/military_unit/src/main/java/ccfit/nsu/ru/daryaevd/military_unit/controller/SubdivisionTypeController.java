package ccfit.nsu.ru.daryaevd.military_unit.controller;

import ccfit.nsu.ru.daryaevd.military_unit.dto.SubdivisionTypeDto;
import ccfit.nsu.ru.daryaevd.military_unit.service.SubdivisionTypeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/subdivision_types")
@CrossOrigin("http://localhost:3000")
public class SubdivisionTypeController {
    private final SubdivisionTypeService subdivisionTypeService;

    @PostMapping
    public ResponseEntity<SubdivisionTypeDto> createSubdivisionType(@RequestBody SubdivisionTypeDto subdivisionTypeDto){
        SubdivisionTypeDto savedSubdivisionType = subdivisionTypeService.createSubdivisionType(subdivisionTypeDto);
        return new ResponseEntity<>(savedSubdivisionType, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<SubdivisionTypeDto> getSubdivisionTypeById(@PathVariable("id") Long subdivisionTypeId) {
        SubdivisionTypeDto subdivisionTypeDto = subdivisionTypeService.getSubdivisionTypeById(subdivisionTypeId);
        return ResponseEntity.ok(subdivisionTypeDto);
    }

    @GetMapping
    public ResponseEntity<List<SubdivisionTypeDto>> getAllSubdivisionTypes() {
        List<SubdivisionTypeDto> subdivisionTypes = subdivisionTypeService.getAllSubdivisionTypes();
        return ResponseEntity.ok(subdivisionTypes);
    }

    @PutMapping("{id}")
    public ResponseEntity<SubdivisionTypeDto> updateSubdivisionType(@PathVariable("id") Long subdivisionTypeId,
                                                                    @RequestBody SubdivisionTypeDto updatedSubdivisionType) {
        SubdivisionTypeDto subdivisionTypeDto = subdivisionTypeService.updateSubdivisionType(subdivisionTypeId, updatedSubdivisionType);
        return ResponseEntity.ok(subdivisionTypeDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteSubdivisionType(@PathVariable("id") Long subdivisionTypeId) {
        subdivisionTypeService.deleteSubdivisionType(subdivisionTypeId);
        return ResponseEntity.ok("Subdivision Type deleted successfully");
    }
}