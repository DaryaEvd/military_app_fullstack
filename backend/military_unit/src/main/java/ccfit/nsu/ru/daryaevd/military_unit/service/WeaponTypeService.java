package ccfit.nsu.ru.daryaevd.military_unit.service;

import ccfit.nsu.ru.daryaevd.military_unit.dto.WeaponTypeDto;
import ccfit.nsu.ru.daryaevd.military_unit.entity.Artillery;
import ccfit.nsu.ru.daryaevd.military_unit.entity.Gun;
import ccfit.nsu.ru.daryaevd.military_unit.entity.RocketWeapon;
import ccfit.nsu.ru.daryaevd.military_unit.entity.WeaponType;

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

}