package ccfit.nsu.ru.daryaevd.military_unit.service.implementation;

import ccfit.nsu.ru.daryaevd.military_unit.dto.WeaponTypeDto;
import ccfit.nsu.ru.daryaevd.military_unit.entity.WeaponType;
import ccfit.nsu.ru.daryaevd.military_unit.exception.ResourceNotFoundException;
import ccfit.nsu.ru.daryaevd.military_unit.mapper.WeaponTypeMapper;
import ccfit.nsu.ru.daryaevd.military_unit.repository.WeaponTypeRepository;
import ccfit.nsu.ru.daryaevd.military_unit.service.WeaponTypeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class WeaponTypeServiceImpl implements WeaponTypeService {
    private WeaponTypeRepository weaponTypeRepository;

    @Override
    public WeaponTypeDto createWeaponType(WeaponTypeDto weaponTypeDto) {
        WeaponType weaponType = WeaponTypeMapper.mapToWeaponType(weaponTypeDto);
        WeaponType savedWeaponType = weaponTypeRepository.save(weaponType);
        return WeaponTypeMapper.mapToWeaponTypeDto(savedWeaponType);
    }

    @Override
    public WeaponTypeDto getWeaponTypeById(Long weaponTypeId) {
        WeaponType weaponType = weaponTypeRepository.findById(weaponTypeId)
                .orElseThrow(() -> new ResourceNotFoundException("Weapon type doesn't exist with given id: " + weaponTypeId));
        return WeaponTypeMapper.mapToWeaponTypeDto(weaponType);
    }

    @Override
    public List<WeaponTypeDto> getAllWeaponTypes() {
        List<WeaponType> weaponTypes = weaponTypeRepository.findAll();
        return weaponTypes.stream().map(WeaponTypeMapper::mapToWeaponTypeDto).collect(Collectors.toList());
    }

    @Override
    public WeaponTypeDto updateWeaponType(Long weaponTypeId, WeaponTypeDto updatedWeaponType) {
        WeaponType weaponType = weaponTypeRepository.findById(weaponTypeId)
                .orElseThrow(() -> new ResourceNotFoundException("Weapon type doesn't exist with given id: " + weaponTypeId));

        weaponType.setNameOfType(updatedWeaponType.getNameOfType());
        weaponType.setExperienceOfUsing(updatedWeaponType.getExperienceOfUsing());
        weaponType.setConditionOfVehicle(updatedWeaponType.getConditionOfVehicle());

        WeaponType updatedWeaponTypeObj = weaponTypeRepository.save(weaponType);
        return WeaponTypeMapper.mapToWeaponTypeDto(updatedWeaponTypeObj);
    }

    @Override
    public void deleteWeaponType(Long weaponTypeId) {
        weaponTypeRepository.deleteById(weaponTypeId);
    }
}
