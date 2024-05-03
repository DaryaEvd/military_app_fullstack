package ccfit.nsu.ru.daryaevd.military_unit.service.implementation;

import ccfit.nsu.ru.daryaevd.military_unit.dto.ArtilleryDto;
import ccfit.nsu.ru.daryaevd.military_unit.entity.Artillery;
import ccfit.nsu.ru.daryaevd.military_unit.exception.ResourceNotFoundException;
import ccfit.nsu.ru.daryaevd.military_unit.mapper.ArtilleryMapper;
import ccfit.nsu.ru.daryaevd.military_unit.repository.ArtilleryRepository;
import ccfit.nsu.ru.daryaevd.military_unit.service.ArtilleryService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ArtilleryServiceImpl implements ArtilleryService {
    private ArtilleryRepository artilleryRepository;

    @Override
    public ArtilleryDto createArtillery(ArtilleryDto artilleryDto) {
        Artillery artillery = ArtilleryMapper.mapToArtillery(artilleryDto);
        Artillery savedArtillery = artilleryRepository.save(artillery);
        return ArtilleryMapper.mapToArtilleryDto(savedArtillery);
    }

    @Override
    public ArtilleryDto getArtilleryById(Long artilleryId) {
        Artillery artillery = artilleryRepository.findById(artilleryId)
                .orElseThrow(() -> new ResourceNotFoundException("Artillery doesn't exist with given id: " + artilleryId));
        return ArtilleryMapper.mapToArtilleryDto(artillery);
    }

    @Override
    public List<ArtilleryDto> getAllArtilleries() {
        List<Artillery> artilleries = artilleryRepository.findAll();
        return artilleries.stream().map(ArtilleryMapper::mapToArtilleryDto).collect(Collectors.toList());
    }

    @Override
    public ArtilleryDto updateArtillery(Long artilleryId, ArtilleryDto updatedArtillery) {
        Artillery artillery = artilleryRepository.findById(artilleryId)
                .orElseThrow(() -> new ResourceNotFoundException("Artillery doesn't exist with given id: " + artilleryId));

        artillery.setNameArtillery(updatedArtillery.getNameArtillery());
        artillery.setCaliber(updatedArtillery.getCaliber());
        artillery.setFiringDistance(updatedArtillery.getFiringDistance());
        artillery.setShootingSpeed(updatedArtillery.getShootingSpeed());
        artillery.setTypeOfAmmunition(updatedArtillery.getTypeOfAmmunition());
        artillery.setConditionOfWeapon(updatedArtillery.getConditionOfWeapon());
        artillery.setExperienceOfUsing(updatedArtillery.getExperienceOfUsing());

        Artillery updatedArtilleryObj = artilleryRepository.save(artillery);
        return ArtilleryMapper.mapToArtilleryDto(updatedArtilleryObj);
    }

    @Override
    public void deleteArtillery(Long artilleryId) {
        artilleryRepository.deleteById(artilleryId);
    }
}
