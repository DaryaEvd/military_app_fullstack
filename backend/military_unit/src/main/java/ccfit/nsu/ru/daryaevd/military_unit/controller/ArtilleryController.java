package ccfit.nsu.ru.daryaevd.military_unit.controller;

import ccfit.nsu.ru.daryaevd.military_unit.dto.ArtilleryDto;
import ccfit.nsu.ru.daryaevd.military_unit.service.ArtilleryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/artilleries")
public class ArtilleryController {
    private ArtilleryService artilleryService;

    @PostMapping
    public ResponseEntity<ArtilleryDto> createArtillery(@RequestBody ArtilleryDto artilleryDto){
        ArtilleryDto savedArtillery = artilleryService.createArtillery(artilleryDto);
        return new ResponseEntity<>(savedArtillery, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<ArtilleryDto> getArtilleryById(@PathVariable("id") Long artilleryId) {
        ArtilleryDto artilleryDto = artilleryService.getArtilleryById(artilleryId);
        return ResponseEntity.ok(artilleryDto);
    }

    @GetMapping
    public ResponseEntity<List<ArtilleryDto>> getAllArtilleries() {
        List<ArtilleryDto> artilleryList = artilleryService.getAllArtilleries();
        return ResponseEntity.ok(artilleryList);
    }

    @PutMapping("{id}")
    public ResponseEntity<ArtilleryDto> updateArtillery(@PathVariable("id") Long artilleryId,
                                                        @RequestBody ArtilleryDto updatedArtillery) {
        ArtilleryDto artilleryDto = artilleryService.updateArtillery(artilleryId, updatedArtillery);
        return ResponseEntity.ok(artilleryDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteArtillery(@PathVariable("id") Long artilleryId) {
        artilleryService.deleteArtillery(artilleryId);
        return ResponseEntity.ok("Artillery deleted successfully");
    }
}
