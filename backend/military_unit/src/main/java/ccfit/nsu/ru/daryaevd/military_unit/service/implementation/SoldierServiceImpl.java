package ccfit.nsu.ru.daryaevd.military_unit.service.implementation;

import ccfit.nsu.ru.daryaevd.military_unit.dto.SoldierDto;
import ccfit.nsu.ru.daryaevd.military_unit.entity.Mas;
import ccfit.nsu.ru.daryaevd.military_unit.entity.Soldier;
import ccfit.nsu.ru.daryaevd.military_unit.entity.SoldierType;
import ccfit.nsu.ru.daryaevd.military_unit.entity.Subdivision;
import ccfit.nsu.ru.daryaevd.military_unit.exception.ResourceNotFoundException;
import ccfit.nsu.ru.daryaevd.military_unit.mapper.SoldierMapper;
import ccfit.nsu.ru.daryaevd.military_unit.repository.MasRepository;
import ccfit.nsu.ru.daryaevd.military_unit.repository.SoldierRepository;
import ccfit.nsu.ru.daryaevd.military_unit.repository.SoldierTypeRepository;
import ccfit.nsu.ru.daryaevd.military_unit.repository.SubdivisionRepository;
import ccfit.nsu.ru.daryaevd.military_unit.service.SoldierService;
import ccfit.nsu.ru.daryaevd.military_unit.specification.SoldierSpecifications;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SoldierServiceImpl implements SoldierService {
    private final SoldierRepository soldierRepository;
    private final MasRepository masRepository;
    private final SoldierTypeRepository soldierTypeRepository;
    private final SubdivisionRepository subdivisionRepository;

    @Override
    public SoldierDto createSoldier(SoldierDto soldierDto) {
        Soldier soldier = new Soldier();
        soldier.setFirstName(soldierDto.getFirstName());
        soldier.setLastName(soldierDto.getLastName());
        soldier.setDateOfBirth(soldierDto.getDateOfBirth());
        soldier.setMilitaryCard(soldierDto.getMilitaryCard());
        soldier.setDateOfIssueMilitaryCard(soldierDto.getDateOfIssueMilitaryCard());

        if (soldierDto.getMasId() != null) {
            Mas mas = masRepository.findById(soldierDto.getMasId())
                    .orElseThrow(() -> new ResourceNotFoundException("Mas doesn't exist with given id: " + soldierDto.getMasId()));
            soldier.setMas(mas);
        }

        if (soldierDto.getTypeOfSoldier() != null) {
            SoldierType soldierType = soldierTypeRepository.findById(Long.valueOf(soldierDto.getTypeOfSoldier()))
                    .orElseThrow(() -> new ResourceNotFoundException("SoldierType doesn't exist with given id: " + soldierDto.getTypeOfSoldier()));
            soldier.setSoldierType(soldierType);
        }

        if (soldierDto.getSubdivisionId() != null) {
            Subdivision subdivision = subdivisionRepository.findById(Long.valueOf(soldierDto.getSubdivisionId()))
                    .orElseThrow(() -> new ResourceNotFoundException("Subdivision doesn't exist with given id: " + soldierDto.getSubdivisionId()));
            soldier.setSubdivision(subdivision);
        }

        soldier.setIsCommander(soldierDto.getIsCommander());

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

        if (updatedSoldier.getMasId() != null) {
            Mas mas = masRepository.findById(updatedSoldier.getMasId())
                    .orElseThrow(() -> new ResourceNotFoundException("Mas doesn't exist with given id: " + updatedSoldier.getMasId()));
            soldier.setMas(mas);
        }

        if (updatedSoldier.getTypeOfSoldier() != null) {
            SoldierType soldierType = soldierTypeRepository.findById(Long.valueOf(updatedSoldier.getTypeOfSoldier()))
                    .orElseThrow(() -> new ResourceNotFoundException("SoldierType doesn't exist with given id: " + updatedSoldier.getTypeOfSoldier()));
            soldier.setSoldierType(soldierType);
        }

        if (updatedSoldier.getSubdivisionId() != null) {
            Subdivision subdivision = subdivisionRepository.findById(Long.valueOf(updatedSoldier.getSubdivisionId()))
                    .orElseThrow(() -> new ResourceNotFoundException("Subdivision doesn't exist with given id: " + updatedSoldier.getSubdivisionId()));
            soldier.setSubdivision(subdivision);
        }

        soldier.setIsCommander(updatedSoldier.getIsCommander());

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
    public List<SoldierDto> getOfficersByRankRange() {
        List<Soldier> soldiers = soldierRepository.findOfficersByRankRange();
        return soldiers.stream()
                .map(SoldierMapper::mapToSoldierDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<SoldierDto> getOfficers(Integer soldierRank, Integer subdivisionRank) {
        Specification<Soldier> specification = Specification.where(SoldierSpecifications.hasRankBetween(5, 10));

        if (soldierRank != null) {
            specification = specification.and(SoldierSpecifications.hasRank(soldierRank));
        }

        if (subdivisionRank != null) {
            specification = specification.and(SoldierSpecifications.hasSubdivisionRank(subdivisionRank));
        }

        List<Soldier> soldiers = soldierRepository.findAll(specification);
        return soldiers.stream().map(SoldierMapper::mapToSoldierDto).collect(Collectors.toList());
    }

    @Override
    public List<SoldierDto> getSergeants(Integer soldierRank, Integer subdivisionRank) {
        Specification<Soldier> specification = Specification.where(SoldierSpecifications.hasRankBetween(0, 4));

        if (soldierRank != null) {
            specification = specification.and(SoldierSpecifications.hasRank(soldierRank));
        }

        if (subdivisionRank != null) {
            specification = specification.and(SoldierSpecifications.hasSubdivisionRank(subdivisionRank));
        }

        List<Soldier> soldiers = soldierRepository.findAll(specification);
        return soldiers.stream().map(SoldierMapper::mapToSoldierDto).collect(Collectors.toList());
    }

    @Override
    public List<SoldierDto> getSoldiersByMasId(Long masId) {
        List<Soldier> soldiers = soldierRepository.findSoldiersByMasId(masId);
        return soldiers.stream()
                .map(SoldierMapper::mapToSoldierDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<SoldierDto> getSoldiersByMasIdAndSubdivisionId(Long masId, Long subdivisionId) {
        List<Soldier> soldiers = soldierRepository.findSoldiersByMasIdAndSubdivisionId(masId, subdivisionId);
        return soldiers.stream()
                .map(SoldierMapper::mapToSoldierDto)
                .collect(Collectors.toList());
    }

    public List<SoldierDto> getChainOfCommand(Long soldierId) {
        Soldier soldier = soldierRepository.findById(soldierId).orElseThrow(() -> new IllegalArgumentException("Soldier not found"));

        List<SoldierDto> chainOfCommand = new ArrayList<>();

        // Find commanders recursively
        findCommanders(soldier, chainOfCommand);

        // Find the soldier itself
        chainOfCommand.add(toDto(soldier));

        // Find subordinates recursively
        findSubordinates(soldier, chainOfCommand);

        return chainOfCommand;
    }

    private void findCommanders(Soldier soldier, List<SoldierDto> chainOfCommand) {
        List<Soldier> commanders = soldierRepository.findCommanders(soldier.getSoldierType().getTypeRank(), soldier.getSubdivision().getId());
        for (Soldier commander : commanders) {
            chainOfCommand.add(toDto(commander));
            findCommanders(commander, chainOfCommand);
        }
    }

    private void findSubordinates(Soldier soldier, List<SoldierDto> chainOfCommand) {
        List<Soldier> subordinates = soldierRepository.findSubordinates(soldier.getSoldierType().getTypeRank(), soldier.getSubdivision().getId());
        for (Soldier subordinate : subordinates) {
            chainOfCommand.add(toDto(subordinate));
            findSubordinates(subordinate, chainOfCommand);
        }
    }

    private SoldierDto toDto(Soldier soldier) {
        SoldierDto dto = new SoldierDto();
        dto.setId(soldier.getId());
        dto.setFirstName(soldier.getFirstName());
        dto.setLastName(soldier.getLastName());
        dto.setDateOfBirth(soldier.getDateOfBirth());
        dto.setMilitaryCard(soldier.getMilitaryCard());
        dto.setDateOfIssueMilitaryCard(soldier.getDateOfIssueMilitaryCard());
        dto.setMasId(soldier.getMas() != null ? soldier.getMas().getId() : null);
        dto.setTypeOfSoldier(soldier.getSoldierType().getTypeRank());
        dto.setSubdivisionId(Math.toIntExact(soldier.getSubdivision().getId()));
        dto.setIsCommander(soldier.getIsCommander());
        return dto;
    }


}


//    @Override
//    public List<Soldier> getOfficers() {
//        return soldierRepository.findByIsCommanderTrue();
//    }

//    @Override
//    public List<Soldier> getOfficersByTypeAndSubdivisionTypeRank(Integer minRank, Integer maxRank, Integer subdivisionTypeRank) {
//        return soldierRepository.findOfficersByTypeAndSubdivisionTypeRank(minRank, maxRank, subdivisionTypeRank);
//    }

//    @Override
//    public List<Soldier> findSergeants() {
//        return soldierRepository.findBySoldierTypeRankBetween(3, 4);
//    }
//
//    @Override
//    public List<Soldier> findSergeantsByRankAndSubdivisionType(Integer lowerRank, Integer upperRank, Integer subdivisionRank) {
//        return soldierRepository.findSergeantsByRankAndSubdivisionType(lowerRank, upperRank, subdivisionRank);
//    }
//
//    @Override
//    public List<Soldier> findSoldiersByMasIdAndSubdivisionName(Long masId, String subdivisionName) {
//        return soldierRepository.findByMasIdAndSubdivisionName(masId, subdivisionName);
//    }




/*
public class SoldierServiceImpl implements SoldierService {
    private final SoldierRepository soldierRepository;

    @Override
    public SoldierDto createSoldier(SoldierDto soldierDto) {
        if (soldierDto.getSubdivisionIds() == null) {
            soldierDto.setSubdivisionIds(new ArrayList<>());
        }

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

    @Override
    public List<Soldier> findSergeants() {
        Integer lowerRank = 0;
        Integer upperRank = 4;
        return soldierRepository.findBySoldierType_TypeRankBetween(lowerRank, upperRank);
    }

    @Override
    public List<Soldier> findSergeantsByRankAndSubdivisionType(Integer lowerRank, Integer upperRank, Integer subdivisionRank) {
        return soldierRepository.findBySoldierType_TypeRankBetweenAndSubdivisions_TypeOfSubdivision_SubdivisionRank(
                lowerRank, upperRank, subdivisionRank);
    }

    @Override
    public List<Soldier> findSoldiersByMasIdAndSubdivisionName(Long masId, String subdivisionName) {
        return soldierRepository.findByMasIdAndSubdivisions_NameOfSubdivision(masId, subdivisionName);
    }

}
*/