package ccfit.nsu.ru.daryaevd.military_unit.service.implementation;

import ccfit.nsu.ru.daryaevd.military_unit.dto.RocketWeaponDto;
import ccfit.nsu.ru.daryaevd.military_unit.entity.RocketWeapon;
import ccfit.nsu.ru.daryaevd.military_unit.exception.ResourceNotFoundException;
import ccfit.nsu.ru.daryaevd.military_unit.mapper.RocketWeaponMapper;
import ccfit.nsu.ru.daryaevd.military_unit.mapper.WeaponTypeMapper;
import ccfit.nsu.ru.daryaevd.military_unit.repository.RocketWeaponRepository;
import ccfit.nsu.ru.daryaevd.military_unit.service.RocketWeaponService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RocketWeaponServiceImpl implements RocketWeaponService {
    private RocketWeaponRepository rocketWeaponRepository;

    @Override
    public RocketWeaponDto createRocketWeapon(RocketWeaponDto rocketWeaponDto) {
        RocketWeapon rocketWeapon = RocketWeaponMapper.toEntity(rocketWeaponDto);
        RocketWeapon savedRocketWeapon = rocketWeaponRepository.save(rocketWeapon);
        return RocketWeaponMapper.toDto(savedRocketWeapon);
    }

    @Override
    public RocketWeaponDto getRocketWeaponById(Long rocketWeaponId) {
        RocketWeapon rocketWeapon = rocketWeaponRepository.findById(rocketWeaponId)
                .orElseThrow(() -> new ResourceNotFoundException("RocketWeapon doesn't exist with given id: " + rocketWeaponId));
        return RocketWeaponMapper.toDto(rocketWeapon);
    }

    @Override
    public List<RocketWeaponDto> getAllRocketWeapons() {
        List<RocketWeapon> rocketWeapons = rocketWeaponRepository.findAll();
        return rocketWeapons.stream().map(RocketWeaponMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public RocketWeaponDto updateRocketWeapon(Long rocketWeaponId, RocketWeaponDto updatedRocketWeapon) {
        RocketWeapon rocketWeapon = rocketWeaponRepository.findById(rocketWeaponId)
                .orElseThrow(() -> new ResourceNotFoundException("RocketWeapon doesn't exist with given id: " + rocketWeaponId));

        rocketWeapon.setFlightRangeOfRocket(updatedRocketWeapon.getFlightRangeOfRocket());
        rocketWeapon.setTypeOfMissileGuidance(updatedRocketWeapon.getTypeOfMissileGuidance());
        rocketWeapon.setTypeOfAmmunition(updatedRocketWeapon.getTypeOfAmmunition());
        rocketWeapon.setConditionOfWeapon(updatedRocketWeapon.getConditionOfWeapon());
        rocketWeapon.setExperienceOfUsing(updatedRocketWeapon.getExperienceOfUsing());

        RocketWeapon updatedRocketWeaponObj = rocketWeaponRepository.save(rocketWeapon);
        return RocketWeaponMapper.toDto(updatedRocketWeaponObj);
    }

    @Override
    public void deleteRocketWeapon(Long rocketWeaponId) {
        rocketWeaponRepository.deleteById(rocketWeaponId);
    }

//    public RocketWeaponDto createRocketWeapon(RocketWeaponDto rocketWeaponDto) {
//        RocketWeapon rocketWeapon = WeaponTypeMapper.toEntity(rocketWeaponDto);
//        RocketWeapon savedRocketWeapon = rocketWeaponRepository.save(rocketWeapon);
//        return WeaponTypeMapper.toDto(savedRocketWeapon);
//    }

//    public RocketWeaponDto getRocketWeaponById(Long id) {
//        RocketWeapon rocketWeapon = rocketWeaponRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("RocketWeapon not found"));
//        return WeaponTypeMapper.ma(rocketWeapon);
//    }

}
