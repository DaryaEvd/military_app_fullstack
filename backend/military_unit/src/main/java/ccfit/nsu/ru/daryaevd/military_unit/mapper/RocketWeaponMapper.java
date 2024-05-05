package ccfit.nsu.ru.daryaevd.military_unit.mapper;

import ccfit.nsu.ru.daryaevd.military_unit.dto.RocketWeaponDto;
import ccfit.nsu.ru.daryaevd.military_unit.entity.RocketWeapon;
import ccfit.nsu.ru.daryaevd.military_unit.entity.WeaponType;

public class RocketWeaponMapper {
    public static RocketWeaponDto mapToRocketWeaponDto(RocketWeapon rocketWeapon) {
        RocketWeaponDto rocketWeaponDto = new RocketWeaponDto();
        rocketWeaponDto.setId(rocketWeapon.getId());
        rocketWeaponDto.setFlightRangeOfRocket(rocketWeapon.getFlightRangeOfRocket());
        rocketWeaponDto.setTypeOfMissileGuidance(rocketWeapon.getTypeOfMissileGuidance());
        rocketWeaponDto.setTypeOfAmmunition(rocketWeapon.getTypeOfAmmunition());
        rocketWeaponDto.setConditionOfWeapon(rocketWeapon.getConditionOfWeapon());
        rocketWeaponDto.setExperienceOfUsing(rocketWeapon.getExperienceOfUsing());
        rocketWeaponDto.setWeaponTypeId(rocketWeapon.getWeaponType().getId());

        return rocketWeaponDto;
    }

    public static RocketWeapon mapToRocketWeapon(RocketWeaponDto rocketWeaponDto) {
        RocketWeapon rocketWeapon = new RocketWeapon();
        rocketWeapon.setId(rocketWeaponDto.getId());
        rocketWeapon.setFlightRangeOfRocket(rocketWeaponDto.getFlightRangeOfRocket());
        rocketWeapon.setTypeOfMissileGuidance(rocketWeaponDto.getTypeOfMissileGuidance());
        rocketWeapon.setTypeOfAmmunition(rocketWeaponDto.getTypeOfAmmunition());
        rocketWeapon.setConditionOfWeapon(rocketWeaponDto.getConditionOfWeapon());
        rocketWeapon.setExperienceOfUsing(rocketWeaponDto.getExperienceOfUsing());

        WeaponType weaponType = new WeaponType();
        weaponType.setId(rocketWeaponDto.getWeaponTypeId());
        rocketWeapon.setWeaponType(weaponType);

        return rocketWeapon;
    }
}
