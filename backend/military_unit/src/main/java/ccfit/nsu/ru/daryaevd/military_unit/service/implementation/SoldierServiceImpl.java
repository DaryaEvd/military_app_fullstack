package ccfit.nsu.ru.daryaevd.military_unit.service.implementation;


import ccfit.nsu.ru.daryaevd.military_unit.dto.SoldierDto;
import ccfit.nsu.ru.daryaevd.military_unit.entity.Soldier;
import ccfit.nsu.ru.daryaevd.military_unit.exception.ResourceNotFoundException;
import ccfit.nsu.ru.daryaevd.military_unit.mapper.SoldierMapper;
import ccfit.nsu.ru.daryaevd.military_unit.repository.SoldierRepository;
import ccfit.nsu.ru.daryaevd.military_unit.service.SoldierService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SoldierServiceImpl implements SoldierService {
    private final SoldierRepository soldierRepository;

    @Override
    public SoldierDto createSoldier(SoldierDto soldierDto) {
        Soldier soldier = SoldierMapper.mapToSoldier(soldierDto);
        Soldier savedSoldier = soldierRepository.save(soldier);
        return SoldierMapper.mapToSoldierDto(savedSoldier);
    }

    @Override
    public SoldierDto getSoldierById(Long soldierId) {
        Soldier soldier = soldierRepository.findById(soldierId)
                .orElseThrow(() -> new ResourceNotFoundException("Soldier doesn't exist with given id: " + soldierId));
        return SoldierMapper.mapToSoldierDto(soldier);
    }

    @Override
    public List<SoldierDto> getAllSoldiers() {
        List<Soldier> soldierList = soldierRepository.findAll();
        return soldierList.stream().map(SoldierMapper::mapToSoldierDto).collect(Collectors.toList());
    }

    @Override
    public SoldierDto updateSoldier(Long soldierId, SoldierDto updatedSoldier) {
        Soldier soldier = soldierRepository.findById(soldierId)
                .orElseThrow(() -> new ResourceNotFoundException("Soldier doesn't exist with given id: " + soldierId));

        soldier.setFirstName(updatedSoldier.getFirstName());
        soldier.setLastName(updatedSoldier.getLastName());
        soldier.setDateOfBirth(updatedSoldier.getDateOfBirth());
        soldier.setMilitaryCard(updatedSoldier.getMilitaryCard());
        soldier.setDateOfIssueMilitaryCard(updatedSoldier.getDateOfIssueMilitaryCard());

        Soldier updatedSoldierObj = soldierRepository.save(soldier);
        return SoldierMapper.mapToSoldierDto(updatedSoldierObj);
    }

    @Override
    public void deleteSoldier(Long soldierId) {
        if (!soldierRepository.existsById(soldierId)) {
            throw new ResourceNotFoundException("Soldier doesn't exist with given id: " + soldierId);
        }
        soldierRepository.deleteById(soldierId);
    }

    @Override
    public List<Soldier> getOfficers() {
        // Use the custom query method from the repository to fetch officers
        return soldierRepository.findBySoldierTypeTypeRankBetween(5, 10);
    }

    @Override
    public List<Soldier> getOfficersByTypeAndSubdivisionTypeRank(Integer minRank, Integer maxRank, Integer subdivisionTypeRank) {
        return soldierRepository.findOfficersByTypeAndSubdivisionTypeRank(minRank, maxRank, subdivisionTypeRank);
    }

}