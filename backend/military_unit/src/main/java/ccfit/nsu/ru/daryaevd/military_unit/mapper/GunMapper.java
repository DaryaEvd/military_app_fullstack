package ccfit.nsu.ru.daryaevd.military_unit.mapper;

import ccfit.nsu.ru.daryaevd.military_unit.dto.GunDto;
import ccfit.nsu.ru.daryaevd.military_unit.entity.Gun;

public class GunMapper {
    public static GunDto mapToGunDto(Gun gun) {
        GunDto gunDto = new GunDto();
        gunDto.setId(gun.getId());
        gunDto.setNameOfGun(gun.getNameOfGun());
        gunDto.setShootingSpeed(gun.getShootingSpeed());
        gunDto.setCaliber(gun.getCaliber());
        gunDto.setMagazineCapacity(gun.getMagazineCapacity());

//        gunDto.setSubdivisionId(gun.getSubdivision().getId());
        return gunDto;
    }

    public static Gun mapToGun(GunDto gunDto) {
        Gun gun = new Gun();
        gun.setId(gunDto.getId());
        gun.setNameOfGun(gunDto.getNameOfGun());
        gun.setShootingSpeed(gunDto.getShootingSpeed());
        gun.setCaliber(gunDto.getCaliber());
        gun.setMagazineCapacity(gunDto.getMagazineCapacity());


//        Subdivision subdivision = new Subdivision();
//        subdivision.setId(GunDto.getSubdivisionId());
//        gun.setSubdivision(subdivision);

        return gun;
    }
}
