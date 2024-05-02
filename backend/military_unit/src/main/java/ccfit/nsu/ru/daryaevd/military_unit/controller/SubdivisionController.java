package ccfit.nsu.ru.daryaevd.military_unit.controller;

import ccfit.nsu.ru.daryaevd.military_unit.dto.SubdivisionDto;
import ccfit.nsu.ru.daryaevd.military_unit.service.SubdivisionService;
import lombok.AllArgsConstructor;
import org.springframework.data.web.ReactiveOffsetScrollPositionHandlerMethodArgumentResolver;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/subdivisions")
public class SubdivisionController {
    private SubdivisionService subdivisionService;

    // add subdivision
    @PostMapping
    public ResponseEntity<SubdivisionDto> createSubdivision(@RequestBody SubdivisionDto subdivisionDto){
        SubdivisionDto savedSubdivision = subdivisionService.createSubdivision(subdivisionDto);
        return new ResponseEntity<>(savedSubdivision, HttpStatus.CREATED);
    }

    // get subdivision
    @GetMapping("{id}")
    public ResponseEntity<SubdivisionDto> getSubdivisionById(@PathVariable("id") Long subdivisionId) {
        SubdivisionDto subdivisionDto = subdivisionService.getSubdivisionById(subdivisionId);
        return ResponseEntity.ok(subdivisionDto);
    }

    // get all subdivisions
    @GetMapping
    public ResponseEntity<List<SubdivisionDto>> getAllSubdivisions() {
        List<SubdivisionDto> subdivisions = subdivisionService.getAllSubdivisions();
        return ResponseEntity.ok(subdivisions);
    }

    //update subdivision info
    @PutMapping("{id}")
    public ResponseEntity<SubdivisionDto> updateSubdivision(@PathVariable("id") Long subdivisionId,
                                                            @RequestBody SubdivisionDto updatedSubdivision) {
        SubdivisionDto subdivisionDto = subdivisionService.updateSubdivision(subdivisionId, updatedSubdivision);
        return ResponseEntity.ok(subdivisionDto);
    }

    //delete subdivision
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteSubdivision(@PathVariable("id") Long subdivisionId) {
        subdivisionService.deleteSubdivision(subdivisionId);

        return ResponseEntity.ok("Subdivision deleted successfully");
    }

}
