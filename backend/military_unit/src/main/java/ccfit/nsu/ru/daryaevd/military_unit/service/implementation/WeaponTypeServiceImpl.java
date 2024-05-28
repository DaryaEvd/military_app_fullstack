package ccfit.nsu.ru.daryaevd.military_unit.service.implementation;

import ccfit.nsu.ru.daryaevd.military_unit.dto.WeaponTypeDto;
import ccfit.nsu.ru.daryaevd.military_unit.entity.Artillery;
import ccfit.nsu.ru.daryaevd.military_unit.entity.Gun;
import ccfit.nsu.ru.daryaevd.military_unit.entity.WeaponType;
import ccfit.nsu.ru.daryaevd.military_unit.entity.RocketWeapon;
import ccfit.nsu.ru.daryaevd.military_unit.exception.ResourceNotFoundException;
import ccfit.nsu.ru.daryaevd.military_unit.mapper.WeaponTypeMapper;
import ccfit.nsu.ru.daryaevd.military_unit.repository.ArtilleryRepository;
import ccfit.nsu.ru.daryaevd.military_unit.repository.GunRepository;
import ccfit.nsu.ru.daryaevd.military_unit.repository.RocketWeaponRepository;
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
        WeaponType weaponType = WeaponTypeMapper.toEntity(weaponTypeDto);
        WeaponType savedWeaponType = weaponTypeRepository.save(weaponType);
        return WeaponTypeMapper.toDto(savedWeaponType);
    }

    @Override
    public WeaponTypeDto getWeaponTypeById(Long weaponTypeId) {
        WeaponType weaponType = weaponTypeRepository.findById(weaponTypeId)
                .orElseThrow(() -> new ResourceNotFoundException("Weapon type doesn't exist with given id: " + weaponTypeId));
        return WeaponTypeMapper.toDto(weaponType);
    }

    @Override
    public List<WeaponTypeDto> getAllWeaponTypes() {
        List<WeaponType> weaponTypes = weaponTypeRepository.findAll();
        return weaponTypes.stream().map(WeaponTypeMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public WeaponTypeDto updateWeaponType(Long weaponTypeId, WeaponTypeDto updatedWeaponType) {
        WeaponType weaponType = weaponTypeRepository.findById(weaponTypeId)
                .orElseThrow(() -> new ResourceNotFoundException("Weapon type doesn't exist with given id: " + weaponTypeId));

        weaponType.setNameOfType(updatedWeaponType.getNameOfType());
        weaponType.setExperienceOfUsing(updatedWeaponType.getExperienceOfUsing());
//        weaponType.setConditionOfVehicle(updatedWeaponType.getConditionOfVehicle());

        WeaponType updatedWeaponTypeObj = weaponTypeRepository.save(weaponType);
        return WeaponTypeMapper.toDto(updatedWeaponTypeObj);
    }

    @Override
    public void deleteWeaponType(Long weaponTypeId) {
        weaponTypeRepository.deleteById(weaponTypeId);
    }


    private GunRepository gunRepository;

    private ArtilleryRepository artilleryRepository;

    private RocketWeaponRepository rocketWeaponRepository;

    @Override
    public List<WeaponType> getWeaponsBySubdivision(Long subdivisionId) {
        return weaponTypeRepository.findBySubdivisionId(subdivisionId);
    }

    @Override
    public List<Gun> getGunsBySubdivision(Long subdivisionId) {
        return gunRepository.findBySubdivisionId(subdivisionId);
    }

    @Override
    public List<Artillery> getArtilleryBySubdivision(Long subdivisionId) {
        return artilleryRepository.findBySubdivisionId(subdivisionId);
    }

    @Override
    public List<RocketWeapon> getRocketWeaponsBySubdivision(Long subdivisionId) {
        return rocketWeaponRepository.findBySubdivisionId(subdivisionId);
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
