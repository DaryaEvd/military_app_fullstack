package ccfit.nsu.ru.daryaevd.military_unit.service;

import ccfit.nsu.ru.daryaevd.military_unit.dto.SoldierDto;
import ccfit.nsu.ru.daryaevd.military_unit.dto.SubdivisionDto;
import ccfit.nsu.ru.daryaevd.military_unit.dto.SubdivisionTypeDto;
import ccfit.nsu.ru.daryaevd.military_unit.dto.SubdivisionWithCommanderDto;
import ccfit.nsu.ru.daryaevd.military_unit.entity.MilitaryBuilding;
import ccfit.nsu.ru.daryaevd.military_unit.entity.Subdivision;
import ccfit.nsu.ru.daryaevd.military_unit.entity.SubdivisionType;

import java.util.List;
import java.util.Map;

public interface SubdivisionService {
    SubdivisionDto createSubdivision(SubdivisionDto subdivisionDto);

    SubdivisionDto getSubdivisionById(Long subdivisionId);

    List<SubdivisionDto> getAllSubdivisions();

    SubdivisionDto updateSubdivision(Long subdivisionId, SubdivisionDto updatedSubdivision);

    void deleteSubdivision(Long subdivisionId);

    List<SoldierDto> getAllCommanders();

    List<SubdivisionTypeDto> getAllSubdivisionTypes();

    List<Object[]> findSubdivisionsWithMostUnits();
    List<Object[]> findSubdivisionsWithLeastUnits();


//    List<Subdivision> getAllSubdivisionsWithCommanders();
    Subdivision getSubdivisionWithCommander(Long subdivisionId);

    List<SubdivisionWithCommanderDto> getAllSubdivisionsWithCommanders();

    Map<Long, String> getSubdivisionNames(List<Long> subdivisionIds) ;

//
//    List<String> getSubdivisionsWithWeaponMoreThan(String weaponCategory, long count);
//    List<String> getSubdivisionsWithoutWeapon(String weaponCategory);

    List<String> getSubdivisionsWithWeaponMoreThan(String weaponCategory, int count);
    List<String> getSubdivisionsWithoutWeapon(String weaponCategory);

    List<SubdivisionTypeDto> countSubdivisionsByType();

    String getMostFrequentSubdivisionTypeName();
    String getLeastFrequentSubdivisionTypeName();

//    List<Long> getSubdivisionsWithWeaponCountGreaterThanThree(String category);
//    List<Long> getSubdivisionsWithoutWeaponCategory(String category);

//    List<Object[]> findSubdivisionsWithMostMilitaryUnits();

//    List<Object[]> findCommanderBySubdivisionName(String subdivisionName);
//
//    List<Subdivision> findSubdivisionsWithSpecifiedCombatEquipment();
//
//    List<MilitaryBuilding> getMilitaryBuildingsForDislocation();


//    List<Object[]> findOfficersByRank(Integer rank);


//    List<SubdivisionDto> findSubdivisionWithMostUnits();
//    List<SubdivisionDto> findSubdivisionWithFewestUnits();

}
