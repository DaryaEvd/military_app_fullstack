package ccfit.nsu.ru.daryaevd.military_unit.mapper;

import ccfit.nsu.ru.daryaevd.military_unit.dto.MilitaryBuildingDto;
import ccfit.nsu.ru.daryaevd.military_unit.entity.MilitaryBuilding;

public class MilitaryBuildingMapper {
    public static MilitaryBuildingDto mapToMilitaryBuildingDto(MilitaryBuilding militaryBuilding) {
        return new MilitaryBuildingDto(
                militaryBuilding.getId(),
                militaryBuilding.getCanUseForDislocation(),
                militaryBuilding.getTypeOfBuilding(),
                militaryBuilding.getAreaOfBuilding(),
                militaryBuilding.getAmountOfRooms()
        );
    }

    public static MilitaryBuilding mapToMilitaryBuilding(MilitaryBuildingDto militaryBuildingDto) {
        return new MilitaryBuilding(
                militaryBuildingDto.getId(),
                militaryBuildingDto.getCanUseForDislocation(),
                militaryBuildingDto.getTypeOfBuilding(),
                militaryBuildingDto.getAreaOfBuilding(),
                militaryBuildingDto.getAmountOfRooms()
        );
    }
}
