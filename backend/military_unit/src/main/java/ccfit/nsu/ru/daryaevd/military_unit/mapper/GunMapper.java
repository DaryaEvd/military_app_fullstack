package ccfit.nsu.ru.daryaevd.military_unit.mapper;

import ccfit.nsu.ru.daryaevd.military_unit.dto.GunDto;
import ccfit.nsu.ru.daryaevd.military_unit.entity.Gun;

public class GunMapper {
    public static GunDto mapToGunDto(Gun gun) {
        return new GunDto(
                gun.getId(),
                gun.getNameOfGun(),
                gun.getShootingSpeed(),
                gun.getCaliber(),
                gun.getMagazineCapacity()
        );
    }

    public static Gun mapToGun(GunDto gunDto) {
        return new Gun(
                gunDto.getId(),
                gunDto.getNameOfGun(),
                gunDto.getShootingSpeed(),
                gunDto.getCaliber(),
                gunDto.getMagazineCapacity()
        );
    }
}
