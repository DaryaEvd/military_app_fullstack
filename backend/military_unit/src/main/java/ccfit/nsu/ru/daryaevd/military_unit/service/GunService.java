package ccfit.nsu.ru.daryaevd.military_unit.service;

import ccfit.nsu.ru.daryaevd.military_unit.dto.GunDto;

import java.util.List;

public interface GunService {
    GunDto createGun(GunDto gunDto);
    GunDto getGunById(Long gunId);
    List<GunDto> getAllGuns();
    GunDto updateGun(Long gunId, GunDto updatedGun);
    void deleteGun(Long gunId);
}
