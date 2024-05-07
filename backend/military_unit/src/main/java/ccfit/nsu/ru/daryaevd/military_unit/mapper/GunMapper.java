package ccfit.nsu.ru.daryaevd.military_unit.mapper;

import ccfit.nsu.ru.daryaevd.military_unit.dto.GunDto;
import ccfit.nsu.ru.daryaevd.military_unit.entity.Gun;
import ccfit.nsu.ru.daryaevd.military_unit.entity.WeaponType;

public class GunMapper {
    public static GunDto mapToGunDto(Gun gun) {
        GunDto gunDto = new GunDto();
        gunDto.setId(gun.getId());
        gunDto.setNameOfGun(gun.getNameOfGun());
        gunDto.setShootingSpeed(gun.getShootingSpeed());
        gunDto.setCaliber(gun.getCaliber());
        gunDto.setMagazineCapacity(gun.getMagazineCapacity());

        gunDto.setWeaponTypeId(gun.getWeaponType().getId());
        return gunDto;
    }

    public static Gun mapToGun(GunDto gunDto) {
        Gun gun = new Gun();
        gun.setId(gunDto.getId());
        gun.setNameOfGun(gunDto.getNameOfGun());
        gun.setShootingSpeed(gunDto.getShootingSpeed());
        gun.setCaliber(gunDto.getCaliber());
        gun.setMagazineCapacity(gunDto.getMagazineCapacity());

        WeaponType weaponType = new WeaponType();
        weaponType.setId(gunDto.getWeaponTypeId());
        gun.setWeaponType(weaponType);

        return gun;
    }
}
