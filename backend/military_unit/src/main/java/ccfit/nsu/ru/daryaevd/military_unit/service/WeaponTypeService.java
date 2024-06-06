package ccfit.nsu.ru.daryaevd.military_unit.service;

import ccfit.nsu.ru.daryaevd.military_unit.dto.WeaponTypeDto;
import ccfit.nsu.ru.daryaevd.military_unit.entity.*;

import java.util.List;

public interface WeaponTypeService {
    WeaponTypeDto createWeaponType(WeaponTypeDto weaponTypeDto);

    WeaponTypeDto getWeaponTypeById(Long weaponTypeId);

//    List<WeaponTypeDto> getAllWeaponTypes();

    WeaponTypeDto updateWeaponType(Long weaponTypeId, WeaponTypeDto updatedWeaponType);

//    void deleteWeaponType(Long weaponTypeId);

    List<WeaponTypeDto> getAllWeaponTypes();
    List<WeaponTypeDto> getWeaponTypesByCategory(String category);
    List<WeaponTypeDto> getWeaponTypesByCategoryAndSubdivision(String category, Long subdivisionId);

//    List<Subdivision> getSubdivisionsWithWeaponCountGreaterThanThree(String category);
//    List<Subdivision> getSubdivisionsWithoutWeaponCategory(String category);


    List<Subdivision> getSubdivisionsWithWeaponCountGreaterThan(String category, Long count);


}