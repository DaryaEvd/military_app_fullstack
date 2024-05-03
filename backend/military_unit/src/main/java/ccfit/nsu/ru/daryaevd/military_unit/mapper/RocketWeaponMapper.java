package ccfit.nsu.ru.daryaevd.military_unit.mapper;

import ccfit.nsu.ru.daryaevd.military_unit.dto.RocketWeaponDto;
import ccfit.nsu.ru.daryaevd.military_unit.entity.RocketWeapon;

public class RocketWeaponMapper {
    public static RocketWeaponDto mapToRocketWeaponDto(RocketWeapon rocketWeapon) {
        return new RocketWeaponDto(
                rocketWeapon.getId(),
                rocketWeapon.getFlightRangeOfRocket(),
                rocketWeapon.getTypeOfMissileGuidance(),
                rocketWeapon.getTypeOfAmmunition(),
                rocketWeapon.getConditionOfWeapon(),
                rocketWeapon.getExperienceOfUsing()
        );
    }

    public static RocketWeapon mapToRocketWeapon(RocketWeaponDto rocketWeaponDto) {
        return new RocketWeapon(
                rocketWeaponDto.getId(),
                rocketWeaponDto.getFlightRangeOfRocket(),
                rocketWeaponDto.getTypeOfMissileGuidance(),
                rocketWeaponDto.getTypeOfAmmunition(),
                rocketWeaponDto.getConditionOfWeapon(),
                rocketWeaponDto.getExperienceOfUsing()
        );
    }
}
