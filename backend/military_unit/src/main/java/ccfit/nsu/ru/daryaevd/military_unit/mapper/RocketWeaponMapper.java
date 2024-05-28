package ccfit.nsu.ru.daryaevd.military_unit.mapper;

import ccfit.nsu.ru.daryaevd.military_unit.dto.RocketWeaponDto;
import ccfit.nsu.ru.daryaevd.military_unit.entity.RocketWeapon;
import ccfit.nsu.ru.daryaevd.military_unit.entity.WeaponType;

import java.util.List;
import java.util.stream.Collectors;

public class RocketWeaponMapper {
    public static RocketWeaponDto toDto(RocketWeapon rocketWeapon) {
        RocketWeaponDto dto = new RocketWeaponDto();
        dto.setId(rocketWeapon.getId());
        dto.setNameOfType(rocketWeapon.getNameOfType());
        dto.setExperienceOfUsing(rocketWeapon.getExperienceOfUsing());
        dto.setConditionOfWeapon(rocketWeapon.getConditionOfWeapon());
        dto.setSubdivisionId(rocketWeapon.getSubdivision().getId());
        dto.setFlightRangeOfRocket(rocketWeapon.getFlightRangeOfRocket());
        dto.setTypeOfMissileGuidance(rocketWeapon.getTypeOfMissileGuidance());
        dto.setTypeOfAmmunition(rocketWeapon.getTypeOfAmmunition());
        dto.setType("ROCKET");
        return dto;
    }

    public static RocketWeapon toEntity(RocketWeaponDto dto) {
        RocketWeapon rocketWeapon = new RocketWeapon();
        rocketWeapon.setId(dto.getId());
        rocketWeapon.setNameOfType(dto.getNameOfType());
        rocketWeapon.setExperienceOfUsing(dto.getExperienceOfUsing());
        rocketWeapon.setConditionOfWeapon(dto.getConditionOfWeapon());
        // Subdivision should be set separately
        rocketWeapon.setFlightRangeOfRocket(dto.getFlightRangeOfRocket());
        rocketWeapon.setTypeOfMissileGuidance(dto.getTypeOfMissileGuidance());
        rocketWeapon.setTypeOfAmmunition(dto.getTypeOfAmmunition());
        return rocketWeapon;
    }

    public static List<RocketWeaponDto> toDtoList(List<RocketWeapon> rocketWeapons) {
        return rocketWeapons.stream().map(RocketWeaponMapper::toDto).collect(Collectors.toList());
    }
}


//public class RocketWeaponMapper {
//    public static RocketWeaponDto mapToRocketWeaponDto(RocketWeapon rocketWeapon) {
//        RocketWeaponDto dto = new RocketWeaponDto();
//        dto.setId(rocketWeapon.getId());
//        dto.setNameOfType(rocketWeapon.getNameOfType());
//        dto.setExperienceOfUsing(rocketWeapon.getExperienceOfUsing());
//        dto.setConditionOfWeapon(rocketWeapon.getConditionOfWeapon());
//        dto.setSubdivisionId(rocketWeapon.getSubdivision().getId());
//        dto.setFlightRangeOfRocket(rocketWeapon.getFlightRangeOfRocket());
//        dto.setTypeOfMissileGuidance(rocketWeapon.getTypeOfMissileGuidance());
//        dto.setTypeOfAmmunition(rocketWeapon.getTypeOfAmmunition());
//        return dto;
//    }
//
//    public static RocketWeapon mapToRocketWeapon(RocketWeaponDto dto) {
//        RocketWeapon rocketWeapon = new RocketWeapon();
//        rocketWeapon.setId(dto.getId());
//        rocketWeapon.setNameOfType(dto.getNameOfType());
//        rocketWeapon.setExperienceOfUsing(dto.getExperienceOfUsing());
//        rocketWeapon.setConditionOfWeapon(dto.getConditionOfWeapon());
//        // Subdivision should be set separately
//        rocketWeapon.setFlightRangeOfRocket(dto.getFlightRangeOfRocket());
//        rocketWeapon.setTypeOfMissileGuidance(dto.getTypeOfMissileGuidance());
//        rocketWeapon.setTypeOfAmmunition(dto.getTypeOfAmmunition());
//        return rocketWeapon;
//    }
//
//    public static List<RocketWeaponDto> mapToRocketWeaponDto(List<RocketWeapon> rocketWeapons) {
//        return rocketWeapons.stream().map(RocketWeaponMapper::mapToRocketWeaponDto).collect(Collectors.toList());
//    }
//}
