package ccfit.nsu.ru.daryaevd.military_unit.mapper;

import ccfit.nsu.ru.daryaevd.military_unit.dto.GunDto;
import ccfit.nsu.ru.daryaevd.military_unit.entity.Gun;
import ccfit.nsu.ru.daryaevd.military_unit.entity.WeaponType;

import java.util.List;
import java.util.stream.Collectors;


public class GunMapper {
    public static GunDto toDto(Gun gun) {
        GunDto dto = new GunDto();
        dto.setId(gun.getId());
         dto.setExperienceOfUsing(gun.getExperienceOfUsing());
        dto.setConditionOfWeapon(gun.getConditionOfWeapon());
        dto.setSubdivisionId(gun.getSubdivision().getId());
        dto.setNameOfGun(gun.getNameOfGun());
        dto.setShootingSpeed(gun.getShootingSpeed());
        dto.setCaliber(gun.getCaliber());
        dto.setMagazineCapacity(gun.getMagazineCapacity());
        dto.setWeaponCategory("Gun");
        return dto;
   }

    public static Gun toEntity(GunDto dto) {
        Gun gun = new Gun();
        gun.setId(dto.getId());
         gun.setExperienceOfUsing(dto.getExperienceOfUsing());
        gun.setConditionOfWeapon(dto.getConditionOfWeapon());
        // Subdivision should be set separately
        gun.setNameOfGun(dto.getNameOfGun());
        gun.setShootingSpeed(dto.getShootingSpeed());
        gun.setCaliber(dto.getCaliber());
        gun.setMagazineCapacity(dto.getMagazineCapacity());
        return gun;
    }

    public static List<GunDto> toDtoList(List<Gun> guns) {
        return guns.stream().map(GunMapper::toDto).collect(Collectors.toList());
    }
}


//public class GunMapper {
//    public static GunDto mapToGunDto(Gun gun) {
//        GunDto dto = new GunDto();
//        dto.setId(gun.getId());
//        dto.setNameOfType(gun.getNameOfType());
//        dto.setExperienceOfUsing(gun.getExperienceOfUsing());
//        dto.setConditionOfWeapon(gun.getConditionOfWeapon());
//        dto.setSubdivisionId(gun.getSubdivision().getId());
//        dto.setNameOfGun(gun.getNameOfGun());
//        dto.setShootingSpeed(gun.getShootingSpeed());
//        dto.setCaliber(gun.getCaliber());
//        dto.setMagazineCapacity(gun.getMagazineCapacity());
//        return dto;
//    }
//
//    public static Gun mapToGun(GunDto dto) {
//        Gun gun = new Gun();
//        gun.setId(dto.getId());
//        gun.setNameOfType(dto.getNameOfType());
//        gun.setExperienceOfUsing(dto.getExperienceOfUsing());
//        gun.setConditionOfWeapon(dto.getConditionOfWeapon());
//        // Subdivision should be set separately
//        gun.setNameOfGun(dto.getNameOfGun());
//        gun.setShootingSpeed(dto.getShootingSpeed());
//        gun.setCaliber(dto.getCaliber());
//        gun.setMagazineCapacity(dto.getMagazineCapacity());
//        return gun;
//    }
//
//    public static List<GunDto> toDtoList(List<Gun> guns) {
//        return guns.stream().map(GunMapper::mapToGunDto).collect(Collectors.toList());
//    }
//}
