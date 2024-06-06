package ccfit.nsu.ru.daryaevd.military_unit.service;

import ccfit.nsu.ru.daryaevd.military_unit.dto.ArtilleryDto;
import ccfit.nsu.ru.daryaevd.military_unit.entity.Artillery;

import java.util.List;

public interface ArtilleryService {
    ArtilleryDto createArtillery(ArtilleryDto artilleryDto);
    ArtilleryDto getArtilleryById(Long artilleryId);
    List<ArtilleryDto> getAllArtilleries();
    ArtilleryDto updateArtillery(Long artilleryId, ArtilleryDto updatedArtillery);
    void deleteArtillery(Long artilleryId);

//    List<Artillery> getArtilleryBySubdivision(Long subdivisionId);

}

