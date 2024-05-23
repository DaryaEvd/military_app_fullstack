package ccfit.nsu.ru.daryaevd.military_unit.service;

import ccfit.nsu.ru.daryaevd.military_unit.dto.SubdivisionDto;
import ccfit.nsu.ru.daryaevd.military_unit.entity.MilitaryBuilding;
import ccfit.nsu.ru.daryaevd.military_unit.entity.Subdivision;

import java.util.List;

public interface SubdivisionService {
    SubdivisionDto createSubdivision(SubdivisionDto subdivisionDto);

    SubdivisionDto getSubdivisionById(Long subdivisionId);

    List<SubdivisionDto> getAllSubdivisions();

    SubdivisionDto updateSubdivision(Long subdivisionId, SubdivisionDto updatedEmployee);

    void deleteSubdivision(Long subdivisionId);

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
