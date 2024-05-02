package ccfit.nsu.ru.daryaevd.military_unit.service.implementation;

import ccfit.nsu.ru.daryaevd.military_unit.dto.SoldierTypeDto;
 import ccfit.nsu.ru.daryaevd.military_unit.entity.SoldierType;
import ccfit.nsu.ru.daryaevd.military_unit.exception.ResourceNotFoundException;
 import ccfit.nsu.ru.daryaevd.military_unit.mapper.SoldierTypeMapper;
import ccfit.nsu.ru.daryaevd.military_unit.repository.SoldierTypeRepository;
import ccfit.nsu.ru.daryaevd.military_unit.service.SoldierTypeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SoldierTypeServiceImpl implements SoldierTypeService {
    private SoldierTypeRepository soldierTypeRepository;
    @Override
    public SoldierTypeDto createSoldierType(SoldierTypeDto soldierTypeDto) {
        SoldierType soldierType = SoldierTypeMapper.mapToSoldierType(soldierTypeDto);
        SoldierType savedSoldierType = soldierTypeRepository.save(soldierType);
        return SoldierTypeMapper.mapToSoldierTypeDto(savedSoldierType);
    }

    @Override
    public SoldierTypeDto getSoldierTypeById(Long soldierTypeId) {
        SoldierType soldierType = soldierTypeRepository.findById(soldierTypeId)
                .orElseThrow(() -> new ResourceNotFoundException("Soldier type doesn't exist with given id: " + soldierTypeId));
        return SoldierTypeMapper.mapToSoldierTypeDto(soldierType);
    }

    @Override
    public List<SoldierTypeDto> getAllSoldierTypes() {
        List<SoldierType> soldierTypes = soldierTypeRepository.findAll();
        return soldierTypes.stream().map((soldierType -> SoldierTypeMapper.mapToSoldierTypeDto(soldierType)))
                .collect(Collectors.toList());
    }

    @Override
    public SoldierTypeDto updateSoldierType(Long soldierTypeId, SoldierTypeDto updatedSoldierType) {
        SoldierType soldierType = soldierTypeRepository.findById(soldierTypeId)
                .orElseThrow(() -> new ResourceNotFoundException("Soldier type doesn't exist with given id: " + soldierTypeId));

        soldierType.setNameOfType(updatedSoldierType.getNameOfType());
        soldierType.setTypeRank(updatedSoldierType.getTypeRank());

        SoldierType updatedSoldierTypeObj = soldierTypeRepository.save(soldierType);
        return SoldierTypeMapper.mapToSoldierTypeDto(updatedSoldierTypeObj);
    }

    @Override
    public void deleteSoldierType(Long soldierTypeId) {
        SoldierType soldierType = soldierTypeRepository.findById(soldierTypeId)
                .orElseThrow(() -> new ResourceNotFoundException("Soldier type doesn't exist with given id: " + soldierTypeId));
        soldierTypeRepository.deleteById(soldierTypeId);
    }
}
