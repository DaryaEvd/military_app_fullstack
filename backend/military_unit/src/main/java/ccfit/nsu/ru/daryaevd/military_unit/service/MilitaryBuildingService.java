package ccfit.nsu.ru.daryaevd.military_unit.service;

import ccfit.nsu.ru.daryaevd.military_unit.dto.MilitaryBuildingDto;
import java.util.List;

public interface MilitaryBuildingService {
    MilitaryBuildingDto createMilitaryBuilding(MilitaryBuildingDto militaryBuildingDto);
    MilitaryBuildingDto getMilitaryBuildingById(Long militaryBuildingId);
    List<MilitaryBuildingDto> getAllBuildings();
    MilitaryBuildingDto updateMilitaryBuilding(Long militaryBuildingId, MilitaryBuildingDto updatedMilitaryBuilding);
    void deleteMilitaryBuilding(Long militaryBuildingId);
}
