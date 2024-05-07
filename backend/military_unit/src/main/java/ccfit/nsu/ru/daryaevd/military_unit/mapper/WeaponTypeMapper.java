package ccfit.nsu.ru.daryaevd.military_unit.mapper;

import ccfit.nsu.ru.daryaevd.military_unit.dto.WeaponTypeDto;
import ccfit.nsu.ru.daryaevd.military_unit.entity.Subdivision;
import ccfit.nsu.ru.daryaevd.military_unit.entity.WeaponType;

public class WeaponTypeMapper {
    public static WeaponTypeDto mapToWeaponTypeDto(WeaponType weaponType) {
        WeaponTypeDto weaponTypeDto = new WeaponTypeDto();
        weaponTypeDto.setId(weaponType.getId());
        weaponTypeDto.setNameOfType(weaponType.getNameOfType());
        weaponTypeDto.setExperienceOfUsing(weaponType.getExperienceOfUsing());
        weaponTypeDto.setConditionOfVehicle(weaponType.getConditionOfVehicle());

        weaponTypeDto.setSubdivisionId(weaponType.getId());
        return weaponTypeDto;
    }

    public static WeaponType mapToWeaponType(WeaponTypeDto weaponTypeDto) {
        WeaponType weaponType = new WeaponType();
        weaponType.setId(weaponTypeDto.getId());
        weaponType.setNameOfType(weaponTypeDto.getNameOfType());
        weaponType.setExperienceOfUsing(weaponTypeDto.getExperienceOfUsing());
        weaponType.setConditionOfVehicle(weaponTypeDto.getConditionOfVehicle());

        Subdivision subdivision = new Subdivision();
        subdivision.setId(weaponTypeDto.getId());
        weaponType.setSubdivision(subdivision);
        return weaponType;
    }
}

