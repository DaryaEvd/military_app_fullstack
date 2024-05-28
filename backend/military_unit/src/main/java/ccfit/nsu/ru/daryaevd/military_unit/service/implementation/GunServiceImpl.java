package ccfit.nsu.ru.daryaevd.military_unit.service.implementation;

import ccfit.nsu.ru.daryaevd.military_unit.dto.GunDto;
import ccfit.nsu.ru.daryaevd.military_unit.entity.Gun;
import ccfit.nsu.ru.daryaevd.military_unit.exception.ResourceNotFoundException;
import ccfit.nsu.ru.daryaevd.military_unit.mapper.GunMapper;
import ccfit.nsu.ru.daryaevd.military_unit.repository.GunRepository;
import ccfit.nsu.ru.daryaevd.military_unit.service.GunService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GunServiceImpl implements GunService {
    private GunRepository gunRepository;

    @Override
    public GunDto createGun(GunDto gunDto) {
        Gun gun = GunMapper.toEntity(gunDto);
        Gun savedGun = gunRepository.save(gun);
        return GunMapper.toDto(savedGun);
    }

    @Override
    public GunDto getGunById(Long gunId) {
        Gun gun = gunRepository.findById(gunId)
                .orElseThrow(() -> new ResourceNotFoundException("Gun doesn't exist with given id: " + gunId));
        return GunMapper.toDto(gun);
    }

    @Override
    public List<GunDto> getAllGuns() {
        List<Gun> guns = gunRepository.findAll();
        return guns.stream().map(GunMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public GunDto updateGun(Long gunId, GunDto updatedGun) {
        Gun gun = gunRepository.findById(gunId)
                .orElseThrow(() -> new ResourceNotFoundException("Gun doesn't exist with given id: " + gunId));

        gun.setNameOfGun(updatedGun.getNameOfGun());
        gun.setShootingSpeed(updatedGun.getShootingSpeed());
        gun.setCaliber(updatedGun.getCaliber());
        gun.setMagazineCapacity(updatedGun.getMagazineCapacity());

        Gun updatedGunObj = gunRepository.save(gun);
        return GunMapper.toDto(updatedGunObj);
    }

    @Override
    public void deleteGun(Long gunId) {
        gunRepository.deleteById(gunId);
    }
}
