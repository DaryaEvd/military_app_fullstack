package ccfit.nsu.ru.daryaevd.military_unit.mapper;

import ccfit.nsu.ru.daryaevd.military_unit.dto.ArtilleryDto;
import ccfit.nsu.ru.daryaevd.military_unit.dto.GunDto;
import ccfit.nsu.ru.daryaevd.military_unit.dto.RocketWeaponDto;
import ccfit.nsu.ru.daryaevd.military_unit.dto.WeaponTypeDto;
import ccfit.nsu.ru.daryaevd.military_unit.entity.*;
import ccfit.nsu.ru.daryaevd.military_unit.exception.ResourceNotFoundException;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import java.util.List;
import java.util.stream.Collectors;


public class WeaponTypeMapper {

    public static WeaponTypeDto toDto(WeaponType weaponType) {
        WeaponTypeDto dto = new WeaponTypeDto();
        dto.setId(weaponType.getId());
        dto.setNameOfType(weaponType.getNameOfType());
        dto.setExperienceOfUsing(weaponType.getExperienceOfUsing());
        dto.setConditionOfWeapon(weaponType.getConditionOfWeapon());
        dto.setSubdivisionId(weaponType.getSubdivision().getId());

        if (weaponType instanceof Gun) {
            dto.setType("GUN");
        } else if (weaponType instanceof Artillery) {
            dto.setType("ARTILLERY");
        } else if (weaponType instanceof RocketWeapon) {
            dto.setType("ROCKET");
        }
        return dto;
    }

    public static WeaponType toEntity(WeaponTypeDto dto) {
        WeaponType weaponType;
        switch (dto.getType()) {
            case "GUN":
                weaponType = new Gun();
                ((Gun) weaponType).setNameOfGun(((GunDto) dto).getNameOfGun());
                ((Gun) weaponType).setShootingSpeed(((GunDto) dto).getShootingSpeed());
                ((Gun) weaponType).setCaliber(((GunDto) dto).getCaliber());
                ((Gun) weaponType).setMagazineCapacity(((GunDto) dto).getMagazineCapacity());
                break;
            case "ARTILLERY":
                weaponType = new Artillery();
                ((Artillery) weaponType).setNameArtillery(((ArtilleryDto) dto).getNameArtillery());
                ((Artillery) weaponType).setCaliber(((ArtilleryDto) dto).getCaliber());
                ((Artillery) weaponType).setFiringDistance(((ArtilleryDto) dto).getFiringDistance());
                ((Artillery) weaponType).setShootingSpeed(((ArtilleryDto) dto).getShootingSpeed());
                ((Artillery) weaponType).setTypeOfAmmunition(((ArtilleryDto) dto).getTypeOfAmmunition());
                break;
            case "ROCKET":
                weaponType = new RocketWeapon();
                ((RocketWeapon) weaponType).setFlightRangeOfRocket(((RocketWeaponDto) dto).getFlightRangeOfRocket());
                ((RocketWeapon) weaponType).setTypeOfMissileGuidance(((RocketWeaponDto) dto).getTypeOfMissileGuidance());
                ((RocketWeapon) weaponType).setTypeOfAmmunition(((RocketWeaponDto) dto).getTypeOfAmmunition());
                break;
            default:
                throw new IllegalArgumentException("Unknown weapon type: " + dto.getType());
        }

        weaponType.setId(dto.getId());
        weaponType.setNameOfType(dto.getNameOfType());
        weaponType.setExperienceOfUsing(dto.getExperienceOfUsing());
        weaponType.setConditionOfWeapon(dto.getConditionOfWeapon());
        // Subdivision should be set separately
        return weaponType;
    }
}


//
//public class WeaponTypeMapper {
//    public static WeaponTypeDto toDto(WeaponType weaponType) {
//        WeaponTypeDto dto = new WeaponTypeDto();
//        dto.setId(weaponType.getId());
//        dto.setNameOfType(weaponType.getNameOfType());
//        dto.setExperienceOfUsing(weaponType.getExperienceOfUsing());
//        dto.setConditionOfWeapon(weaponType.getConditionOfWeapon());
//        dto.setSubdivisionId(weaponType.getSubdivision().getId());
//        return dto;
//    }
//
//    public static WeaponType toEntity(WeaponTypeDto dto) {
//        WeaponType weaponType = new WeaponType();
//        weaponType.setId(dto.getId());
//        weaponType.setNameOfType(dto.getNameOfType());
//        weaponType.setExperienceOfUsing(dto.getExperienceOfUsing());
//        weaponType.setConditionOfWeapon(dto.getConditionOfWeapon());
//        // Subdivision should be set separately
//        return weaponType;
//    }
//
//    public static List<WeaponTypeDto> toDtoList(List<WeaponType> weaponTypes) {
//        return weaponTypes.stream().map(WeaponTypeMapper::toDto).collect(Collectors.toList());
//    }
//}
