package ccfit.nsu.ru.daryaevd.military_unit.service;

import ccfit.nsu.ru.daryaevd.military_unit.dto.MilitaryBuildingDto;
import ccfit.nsu.ru.daryaevd.military_unit.entity.MilitaryBuilding;

import java.util.List;

public interface MilitaryBuildingService {
    List<MilitaryBuildingDto> getAllMilitaryBuildings();
    MilitaryBuildingDto getMilitaryBuildingById(Long id);
    MilitaryBuildingDto createMilitaryBuilding(MilitaryBuildingDto dto);
    MilitaryBuildingDto updateMilitaryBuilding(Long id, MilitaryBuildingDto dto);
    void deleteMilitaryBuilding(Long id);

//    List<MilitaryBuildingDto> getMilitaryBuildingsBySubdivision(Long subdivisionId, Boolean isDislocated);
//    List<MilitaryBuildingDto> getBuildingsWithDislocatedSubdivisions(Boolean isDislocated, int minSubdivisions);

    List<MilitaryBuildingDto> getBuildingsBySubdivisionId(Long subdivisionId);
    List<MilitaryBuildingDto> getBuildingsWithMinSubdivisions(int minSubdivisions);
    List<MilitaryBuildingDto> getBuildingsWithNoSubdivisions();


//    MilitaryBuildingDto createMilitaryBuilding(MilitaryBuildingDto militaryBuildingDto);
//
//    MilitaryBuildingDto getMilitaryBuildingById(Long militaryBuildingId);
//
//    List<MilitaryBuildingDto> getAllBuildings();
//
//    MilitaryBuildingDto updateMilitaryBuilding(Long militaryBuildingId, MilitaryBuildingDto updatedMilitaryBuilding);
//
//    void deleteMilitaryBuilding(Long militaryBuildingId);
//
//    List<MilitaryBuilding> getAllMilitaryBuildings();



//    List<MilitaryBuilding> findBySubdivisionType(String subdivisionType);
//
//    List<MilitaryBuilding> findMilitaryBuildingsWithMultipleDislocatedSubdivisions();

}
