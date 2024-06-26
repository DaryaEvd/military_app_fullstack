package ccfit.nsu.ru.daryaevd.military_unit.service.implementation;

import ccfit.nsu.ru.daryaevd.military_unit.dto.SoldierDto;
import ccfit.nsu.ru.daryaevd.military_unit.dto.SubdivisionDto;
import ccfit.nsu.ru.daryaevd.military_unit.dto.SubdivisionTypeDto;
import ccfit.nsu.ru.daryaevd.military_unit.dto.SubdivisionWithCommanderDto;
import ccfit.nsu.ru.daryaevd.military_unit.entity.MilitaryBuilding;
import ccfit.nsu.ru.daryaevd.military_unit.entity.Soldier;
import ccfit.nsu.ru.daryaevd.military_unit.entity.Subdivision;
import ccfit.nsu.ru.daryaevd.military_unit.entity.SubdivisionType;
import ccfit.nsu.ru.daryaevd.military_unit.exception.ResourceNotFoundException;
import ccfit.nsu.ru.daryaevd.military_unit.mapper.SubdivisionMapper;
import ccfit.nsu.ru.daryaevd.military_unit.repository.SoldierRepository;
import ccfit.nsu.ru.daryaevd.military_unit.repository.SubdivisionRepository;
import ccfit.nsu.ru.daryaevd.military_unit.repository.SubdivisionTypeRepository;
import ccfit.nsu.ru.daryaevd.military_unit.service.SoldierService;
import ccfit.nsu.ru.daryaevd.military_unit.service.SubdivisionService;
import ccfit.nsu.ru.daryaevd.military_unit.service.SubdivisionTypeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SubdivisionServiceImpl implements SubdivisionService {

    private final SubdivisionRepository subdivisionRepository;
    private final SoldierService soldierService;
    private final SubdivisionTypeService subdivisionTypeService;


    private SubdivisionTypeRepository subdivisionTypeRepository;
    private SoldierRepository soldierRepository;

    @Override
    public SubdivisionDto createSubdivision(SubdivisionDto subdivisionDto) {
        SubdivisionType subdivisionType = subdivisionTypeRepository.findById(Long.valueOf(subdivisionDto.getTypeOfSubdivision()))
                .orElseThrow(() -> new ResourceNotFoundException("SubdivisionType not found with id " + subdivisionDto.getTypeOfSubdivision()));

        Soldier commander = soldierRepository.findById(subdivisionDto.getCommanderId())
                .orElseThrow(() -> new ResourceNotFoundException("Soldier not found with id " + subdivisionDto.getCommanderId()));

        Subdivision subdivision = new Subdivision();
        subdivision.setNameOfSubdivision(subdivisionDto.getNameOfSubdivision());
        subdivision.setNumberOfSubdivision(subdivisionDto.getNumberOfSubdivision());
        subdivision.setIsDislocated(subdivisionDto.getIsDislocated());
        subdivision.setTypeOfSubdivision(subdivisionType);
        subdivision.setCommander(commander);

        Subdivision savedSubdivision = subdivisionRepository.save(subdivision);
        return SubdivisionMapper.mapToSubdivisionDto(savedSubdivision);
    }

    @Override
    public SubdivisionDto getSubdivisionById(Long subdivisionId) {
        Subdivision subdivision = subdivisionRepository.findById(subdivisionId)
                .orElseThrow(() -> new ResourceNotFoundException("Subdivision doesn't exist with given id: " + subdivisionId));
        return SubdivisionMapper.mapToSubdivisionDto(subdivision);
    }

    @Override
    public List<SubdivisionDto> getAllSubdivisions() {
        List<Subdivision> subdivisions = subdivisionRepository.findAll();
        return subdivisions.stream()
                .map(SubdivisionMapper::mapToSubdivisionDto)
                .collect(Collectors.toList());
    }

    @Override
    public SubdivisionDto updateSubdivision(Long subdivisionId, SubdivisionDto updatedSubdivision) {
        Subdivision subdivision = subdivisionRepository.findById(subdivisionId)
                .orElseThrow(() -> new ResourceNotFoundException("Subdivision doesn't exist with given id: " + subdivisionId));

        subdivision.setNameOfSubdivision(updatedSubdivision.getNameOfSubdivision());
        subdivision.setNumberOfSubdivision(updatedSubdivision.getNumberOfSubdivision());
        subdivision.setIsDislocated(updatedSubdivision.getIsDislocated());

        if (updatedSubdivision.getCommanderId() != null) {
            Soldier commander = soldierRepository.findById(updatedSubdivision.getCommanderId())
                    .orElseThrow(() -> new ResourceNotFoundException("Soldier not found with id " + updatedSubdivision.getCommanderId()));
            subdivision.setCommander(commander);
        }

        SubdivisionType subdivisionType = subdivisionTypeRepository.findById(Long.valueOf(updatedSubdivision.getTypeOfSubdivision()))
                .orElseThrow(() -> new ResourceNotFoundException("SubdivisionType not found with id " + updatedSubdivision.getTypeOfSubdivision()));
        subdivision.setTypeOfSubdivision(subdivisionType);

        Subdivision updatedSubdivisionObj = subdivisionRepository.save(subdivision);
        return SubdivisionMapper.mapToSubdivisionDto(updatedSubdivisionObj);
    }

    @Override
    public void deleteSubdivision(Long subdivisionId) {
        Subdivision subdivision = subdivisionRepository.findById(subdivisionId)
                .orElseThrow(() -> new ResourceNotFoundException("Subdivision doesn't exist with given id: " + subdivisionId));
        subdivisionRepository.delete(subdivision);
    }

    @Override
    public List<SoldierDto> getAllCommanders() {
        // Return a list of all available commanders
        return soldierService.getAllSoldiers();
    }

    @Override
    public List<SubdivisionTypeDto> getAllSubdivisionTypes() {
        // Return a list of all available subdivision types
        return subdivisionTypeService.getAllSubdivisionTypes();
    }

    @Override
    public List<Object[]> findSubdivisionsWithMostUnits() {
        return subdivisionRepository.findSubdivisionsWithMostUnits();
    }

    @Override
    public List<Object[]> findSubdivisionsWithLeastUnits() {
        return subdivisionRepository.findSubdivisionsWithLeastUnits();
    }

//    @Override
//    public List<Subdivision> getAllSubdivisionsWithCommanders() {
//        return subdivisionRepository.findAllWithCommanders();
//    }

    @Override
    public Subdivision getSubdivisionWithCommander(Long subdivisionId) {
        return subdivisionRepository.findByIdWithCommander(subdivisionId);
    }

    public Map<Long, String> getSubdivisionNames(List<Long> subdivisionIds) {
        return subdivisionRepository.getSubdivisionNames(subdivisionIds);
    }

    public List<String> getSubdivisionsWithWeaponMoreThan(String weaponCategory, int count) {
        return subdivisionRepository.findSubdivisionsWithWeaponMoreThan(weaponCategory, count);
    }

    public List<String> getSubdivisionsWithoutWeapon(String weaponCategory) {
        return subdivisionRepository.findSubdivisionsWithoutWeapon(weaponCategory);
    }

    public List<SubdivisionTypeDto> countSubdivisionsByType() {
        List<Object[]> results = subdivisionRepository.countSubdivisionsByType();
        List<SubdivisionTypeDto> dtos = new ArrayList<>();
        for (Object[] result : results) {
            String nameOfType = (String) result[0];
            Integer count = (Integer) result[1];
            SubdivisionTypeDto dto = new SubdivisionTypeDto();
            dto.setNameOfType(nameOfType);
            dto.setCount(count);
            dtos.add(dto);
        }
        return dtos;
    }

    public List<SubdivisionWithCommanderDto> getAllSubdivisionsWithCommanders() {
        List<Subdivision> subdivisions = subdivisionRepository.findAll();
        return subdivisions.stream()
                .map(SubdivisionMapper::toSubdivisionWithCommanderDto)
                .collect(Collectors.toList());
    }


    public String getMostFrequentSubdivisionTypeName() {
        Long typeId = subdivisionRepository.findMostFrequentSubdivisionTypeId();
        return subdivisionTypeRepository.findById(typeId).map(type -> type.getNameOfType()).orElse(null);
    }

    public String getLeastFrequentSubdivisionTypeName() {
        Long typeId = subdivisionRepository.findLeastFrequentSubdivisionTypeId();
        return subdivisionTypeRepository.findById(typeId).map(type -> type.getNameOfType()).orElse(null);
    }

//    @Override
//    public List<Long> getSubdivisionsWithWeaponCountGreaterThanThree(String category) {
//        return subdivisionRepository.findSubdivisionsWithWeaponCountGreaterThanThree(category);
//    }
//
//    @Override
//    public List<Long> getSubdivisionsWithoutWeaponCategory(String category) {
//        return subdivisionRepository.findSubdivisionsWithoutWeaponCategory(category);
//    }

//    @Override
//    public List<Object[]> findSubdivisionsWithMostMilitaryUnits() {
//        return subdivisionRepository.findSubdivisionsWithMostMilitaryUnits();
//    }

//    @Override
//    public List<Object[]> findCommanderBySubdivisionName(String subdivisionName) {
//        return subdivisionRepository.findCommanderBySubdivisionName(subdivisionName);
//    }
//
//    @Override
//    public List<Subdivision> findSubdivisionsWithSpecifiedCombatEquipment() {
//        return subdivisionRepository.findSubdivisionsWithSpecifiedCombatEquipment();
//    }
//
//    @Override
//    public List<MilitaryBuilding> getMilitaryBuildingsForDislocation() {
//        return subdivisionRepository.findMilitaryBuildingsForDislocation();
//    }


//    public List<Object[]> findOfficersByRank(Integer rank) {
//        return subdivisionRepository.findOfficersByRank(rank);
//    }

}
