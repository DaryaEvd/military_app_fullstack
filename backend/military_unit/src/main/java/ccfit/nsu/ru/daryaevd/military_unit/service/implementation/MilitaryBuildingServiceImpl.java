package ccfit.nsu.ru.daryaevd.military_unit.service.implementation;

import ccfit.nsu.ru.daryaevd.military_unit.dto.MilitaryBuildingDto;
import ccfit.nsu.ru.daryaevd.military_unit.entity.MilitaryBuilding;
import ccfit.nsu.ru.daryaevd.military_unit.exception.ResourceNotFoundException;
import ccfit.nsu.ru.daryaevd.military_unit.mapper.MilitaryBuildingMapper;
import ccfit.nsu.ru.daryaevd.military_unit.repository.MilitaryBuildingRepository;
import ccfit.nsu.ru.daryaevd.military_unit.service.MilitaryBuildingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class MilitaryBuildingServiceImpl implements MilitaryBuildingService {
    private MilitaryBuildingRepository militaryBuildingRepository;
    @Override
    public MilitaryBuildingDto createMilitaryBuilding(MilitaryBuildingDto militaryBuildingDto) {
        MilitaryBuilding militaryBuilding = MilitaryBuildingMapper.mapToMilitaryBuilding(militaryBuildingDto);
        MilitaryBuilding savedMilitaryBuilding = militaryBuildingRepository.save(militaryBuilding);
        return MilitaryBuildingMapper.mapToMilitaryBuildingDto(savedMilitaryBuilding);
    }

    @Override
    public MilitaryBuildingDto getMilitaryBuildingById(Long militaryBuildingId) {
        MilitaryBuilding militaryBuilding = militaryBuildingRepository.findById(militaryBuildingId)
                .orElseThrow(() -> new ResourceNotFoundException("Military building doesn't exist with given id: " + militaryBuildingId));
        return MilitaryBuildingMapper.mapToMilitaryBuildingDto(militaryBuilding);
    }

    @Override
    public List<MilitaryBuildingDto> getAllBuildings() {
        List<MilitaryBuilding> militaryBuildings = militaryBuildingRepository.findAll();
        return militaryBuildings.stream().map((militaryBuilding -> MilitaryBuildingMapper.mapToMilitaryBuildingDto(militaryBuilding)))
                .collect(Collectors.toList());
    }

    @Override
    public MilitaryBuildingDto updateMilitaryBuilding(Long militaryBuildingId, MilitaryBuildingDto updatedMilitaryBuilding) {
        MilitaryBuilding militaryBuilding = militaryBuildingRepository.findById(militaryBuildingId)
                .orElseThrow(() -> new ResourceNotFoundException("Military building doesn't exist with given id: " + militaryBuildingId));

        militaryBuilding.setCanUseForDislocation(updatedMilitaryBuilding.getCanUseForDislocation());
        militaryBuilding.setTypeOfBuilding(updatedMilitaryBuilding.getTypeOfBuilding());
        militaryBuilding.setAreaOfBuilding(updatedMilitaryBuilding.getAreaOfBuilding());
        militaryBuilding.setAmountOfRooms(updatedMilitaryBuilding.getAmountOfRooms());

        MilitaryBuilding updatedMilitaryBuildingObj = militaryBuildingRepository.save(militaryBuilding);
        return MilitaryBuildingMapper.mapToMilitaryBuildingDto(updatedMilitaryBuildingObj);
    }

    @Override
    public void deleteMilitaryBuilding(Long militaryBuildingId) {
        MilitaryBuilding militaryBuilding = militaryBuildingRepository.findById(militaryBuildingId)
                .orElseThrow(() -> new ResourceNotFoundException("Military building doesn't exist with given id: " + militaryBuildingId));
        militaryBuildingRepository.deleteById(militaryBuildingId);
    }
}
