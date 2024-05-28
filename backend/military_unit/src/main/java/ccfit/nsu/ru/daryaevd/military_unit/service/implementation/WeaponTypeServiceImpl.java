package ccfit.nsu.ru.daryaevd.military_unit.service.implementation;

import ccfit.nsu.ru.daryaevd.military_unit.dto.WeaponTypeDto;
import ccfit.nsu.ru.daryaevd.military_unit.entity.*;
import ccfit.nsu.ru.daryaevd.military_unit.exception.ResourceNotFoundException;
import ccfit.nsu.ru.daryaevd.military_unit.mapper.WeaponTypeMapper;
import ccfit.nsu.ru.daryaevd.military_unit.repository.*;
import ccfit.nsu.ru.daryaevd.military_unit.service.WeaponTypeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class WeaponTypeServiceImpl implements WeaponTypeService {
    private   WeaponTypeRepository weaponTypeRepository;
    private   SubdivisionRepository subdivisionRepository;

    private  WeaponTypeMapper weaponTypeMapper;

    @Override
    public WeaponTypeDto createWeaponType(WeaponTypeDto weaponTypeDto) {
        WeaponType weaponType = weaponTypeMapper.toEntity(weaponTypeDto);
        // Убедитесь, что подразделение установлено правильно
        Subdivision subdivision = subdivisionRepository.findById(weaponTypeDto.getSubdivisionId()).orElseThrow(() -> new RuntimeException("Subdivision not found"));
        weaponType.setSubdivision(subdivision);
        WeaponType savedWeaponType = weaponTypeRepository.save(weaponType);
        return weaponTypeMapper.toDto(savedWeaponType);
    }

    @Override
    public WeaponTypeDto getWeaponTypeById(Long weaponTypeId) {
        WeaponType weaponType = weaponTypeRepository.findById(weaponTypeId).orElseThrow(() -> new RuntimeException("Weapon type not found"));
        return weaponTypeMapper.toDto(weaponType);
    }

    @Override
    public List<WeaponTypeDto> getAllWeaponTypes() {
        List<WeaponType> entities = weaponTypeRepository.findAll();
        return entities.stream()
                .map(weaponTypeMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<WeaponTypeDto> getWeaponTypesByCategory(String category) {
        List<WeaponType> entities = weaponTypeRepository.findByWeaponCategory(category);
        return entities.stream()
                .map(weaponTypeMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<WeaponTypeDto> getWeaponTypesByCategoryAndSubdivision(String category, Long subdivisionId) {
        List<WeaponType> entities = weaponTypeRepository.findByWeaponCategoryAndSubdivisionId(category, subdivisionId);
        return entities.stream()
                .map(weaponTypeMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public WeaponTypeDto updateWeaponType(Long weaponTypeId, WeaponTypeDto weaponTypeDto) {
        WeaponType weaponType = weaponTypeRepository.findById(weaponTypeId).orElseThrow(() -> new RuntimeException("Weapon type not found"));

        weaponType.setExperienceOfUsing(weaponTypeDto.getExperienceOfUsing());
        weaponType.setConditionOfWeapon(weaponTypeDto.getConditionOfWeapon());

        switch (weaponTypeDto.getWeaponCategory()) {
            case "Gun":
                if (weaponType instanceof Gun) {
                    Gun gun = (Gun) weaponType;
                    gun.setNameOfGun(weaponTypeDto.getNameOfGun());
                    gun.setShootingSpeed(weaponTypeDto.getShootingSpeed());
                    gun.setCaliber(weaponTypeDto.getCaliber());
                    gun.setMagazineCapacity(weaponTypeDto.getMagazineCapacity());
                }
                break;
            case "Artillery":
                if (weaponType instanceof Artillery) {
                    Artillery artillery = (Artillery) weaponType;
                    artillery.setNameArtillery(weaponTypeDto.getNameArtillery());
                    artillery.setFiringDistance(weaponTypeDto.getFiringDistance());
                    artillery.setTypeOfAmmunition(weaponTypeDto.getTypeOfAmmunition());
                }
                break;
            case "Rocket":
                if (weaponType instanceof RocketWeapon) {
                    RocketWeapon rocketWeapon = (RocketWeapon) weaponType;
                    rocketWeapon.setFlightRangeOfRocket(weaponTypeDto.getFlightRangeOfRocket());
                    rocketWeapon.setTypeOfMissileGuidance(weaponTypeDto.getTypeOfMissileGuidance());
                }
                break;
        }

        Subdivision subdivision = subdivisionRepository.findById(weaponTypeDto.getSubdivisionId()).orElseThrow(() -> new RuntimeException("Subdivision not found"));
        weaponType.setSubdivision(subdivision);

        WeaponType updatedWeaponType = weaponTypeRepository.save(weaponType);
        return weaponTypeMapper.toDto(updatedWeaponType);
    }



//    public List<WeaponTypeDto> getWeaponsByCategoryOrTypeName(Long subdivisionId, String category, String typeName) {
//        Class<? extends WeaponType> categoryClass = getCategoryClass(category);
//        List<WeaponType> weaponTypes = weaponTypeRepository.findByCategoryOrTypeNameAndSubdivision(subdivisionId, categoryClass, typeName);
//        return weaponTypes.stream().map(WeaponTypeMapper::toDto).collect(Collectors.toList());
//    }
//
//    private Class<? extends WeaponType> getCategoryClass(String category) {
//        switch (category.toLowerCase()) {
//            case "rocket":
//                return RocketWeapon.class;
//            case "artillery":
//                return Artillery.class;
//            case "gun":
//                return Gun.class;
//            default:
//                throw new IllegalArgumentException("Unknown category: " + category);
//        }
//    }
}
