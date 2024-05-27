package ccfit.nsu.ru.daryaevd.military_unit.controller;

import ccfit.nsu.ru.daryaevd.military_unit.dto.MasDto;
import ccfit.nsu.ru.daryaevd.military_unit.service.MasService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("/api/mas")
@CrossOrigin("http://localhost:3000")
public class MasController {
    private final MasService masService;

    @PostMapping
    public ResponseEntity<MasDto> createMas(@RequestBody MasDto masDto){
        MasDto savedMas = masService.createMas(masDto);
        return new ResponseEntity<>(savedMas, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<MasDto> getMasById(@PathVariable("id") Long masId) {
        MasDto masDto = masService.getMasById(masId);
        return ResponseEntity.ok(masDto);
    }

    @GetMapping
    public ResponseEntity<List<MasDto>> getAllMas() {
        List<MasDto> masDtoList = masService.getAllMas();
        return ResponseEntity.ok(masDtoList);
    }

    @PutMapping("{id}")
    public ResponseEntity<MasDto> updateMas(@PathVariable("id") Long masId,
                                            @RequestBody MasDto updatedMas) {
        MasDto masDto = masService.updateMas(masId, updatedMas);
        return ResponseEntity.ok(masDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteMas(@PathVariable("id") Long masId) {
        masService.deleteMas(masId);
        return ResponseEntity.ok("MAS type deleted successfully");
    }

    @GetMapping("/specialists/more_than_five")
    public ResponseEntity<List<MasDto>> getSpecialistsWithMoreThanFive() {
        List<MasDto> masDtoList = masService.getSpecialistsWithMoreThanFive();
        return ResponseEntity.ok(masDtoList);
    }

    @GetMapping("/specialists/none")
    public ResponseEntity<List<MasDto>> getSpecialistsWithNone() {
        List<MasDto> masDtoList = masService.getSpecialistsWithNone();
        return ResponseEntity.ok(masDtoList);
    }

    @GetMapping("/specialists/more_than_five/{subdivisionId}")
    public ResponseEntity<List<MasDto>> getSpecialistsWithMoreThanFiveBySubdivision(@PathVariable Long subdivisionId) {
        List<MasDto> masDtoList = masService.getSpecialistsWithMoreThanFiveBySubdivision(subdivisionId);
        return ResponseEntity.ok(masDtoList);
    }

    @GetMapping("/specialists/none/{subdivisionId}")
    public ResponseEntity<List<MasDto>> getSpecialistsWithNoneBySubdivision(@PathVariable Long subdivisionId) {
        List<MasDto> masDtoList = masService.getSpecialistsWithNoneBySubdivision(subdivisionId);
        return ResponseEntity.ok(masDtoList);
    }

//    @GetMapping("/soldier-count")
//    public List<String> findMasWithMoreThanFiveSoldiersOrNone() {
//        return masService.findMasWithMoreThanFiveSoldiersOrNone();
//    }
}
