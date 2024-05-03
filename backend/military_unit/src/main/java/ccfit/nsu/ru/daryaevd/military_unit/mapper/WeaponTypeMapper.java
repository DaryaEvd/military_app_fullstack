package ccfit.nsu.ru.daryaevd.military_unit.mapper;

import ccfit.nsu.ru.daryaevd.military_unit.dto.WeaponTypeDto;
import ccfit.nsu.ru.daryaevd.military_unit.entity.WeaponType;

public class WeaponTypeMapper {
    public static WeaponTypeDto mapToWeaponTypeDto(WeaponType weaponType) {
        return new WeaponTypeDto(
                weaponType.getId(),
                weaponType.getNameOfType(),
                weaponType.getExperienceOfUsing(),
                weaponType.getConditionOfVehicle()
        );
    }

    public static WeaponType mapToWeaponType(WeaponTypeDto weaponTypeDto) {
        return new WeaponType(
                weaponTypeDto.getId(),
                weaponTypeDto.getNameOfType(),
                weaponTypeDto.getExperienceOfUsing(),
                weaponTypeDto.getConditionOfVehicle()
        );
    }
}

