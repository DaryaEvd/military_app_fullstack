package ccfit.nsu.ru.daryaevd.military_unit.service;

import ccfit.nsu.ru.daryaevd.military_unit.dto.RocketWeaponDto;

import java.util.List;

public interface RocketWeaponService {
    RocketWeaponDto createRocketWeapon(RocketWeaponDto rocketWeaponDto);
    RocketWeaponDto getRocketWeaponById(Long rocketWeaponId);
    List<RocketWeaponDto> getAllRocketWeapons();
    RocketWeaponDto updateRocketWeapon(Long rocketWeaponId, RocketWeaponDto updatedRocketWeapon);
    void deleteRocketWeapon(Long rocketWeaponId);
}