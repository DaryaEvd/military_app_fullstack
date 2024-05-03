package ccfit.nsu.ru.daryaevd.military_unit.service;

import ccfit.nsu.ru.daryaevd.military_unit.dto.WeaponTypeDto;

import java.util.List;

public interface WeaponTypeService {
    WeaponTypeDto createWeaponType(WeaponTypeDto weaponTypeDto);
    WeaponTypeDto getWeaponTypeById(Long weaponTypeId);
    List<WeaponTypeDto> getAllWeaponTypes();
    WeaponTypeDto updateWeaponType(Long weaponTypeId, WeaponTypeDto updatedWeaponType);
    void deleteWeaponType(Long weaponTypeId);
}