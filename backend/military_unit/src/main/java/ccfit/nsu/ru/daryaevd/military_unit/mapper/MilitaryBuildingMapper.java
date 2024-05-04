package ccfit.nsu.ru.daryaevd.military_unit.mapper;

import ccfit.nsu.ru.daryaevd.military_unit.dto.MilitaryBuildingDto;
import ccfit.nsu.ru.daryaevd.military_unit.entity.MilitaryBuilding;
import ccfit.nsu.ru.daryaevd.military_unit.entity.Subdivision;

public class MilitaryBuildingMapper {
    public static MilitaryBuildingDto mapToMilitaryBuildingDto(MilitaryBuilding militaryBuilding) {
        return new MilitaryBuildingDto(
                militaryBuilding.getId(),
                militaryBuilding.getCanUseForDislocation(),
                militaryBuilding.getTypeOfBuilding(),
                militaryBuilding.getAreaOfBuilding(),
                militaryBuilding.getAmountOfRooms(),

                militaryBuilding.getSubdivision().getId()

        );
    }

    public static MilitaryBuilding mapToMilitaryBuilding(MilitaryBuildingDto militaryBuildingDto) {
        MilitaryBuilding militaryBuilding = new MilitaryBuilding();
        militaryBuilding.setId(militaryBuildingDto.getId());
        militaryBuilding.setCanUseForDislocation(militaryBuildingDto.getCanUseForDislocation());
        militaryBuilding.setTypeOfBuilding(militaryBuildingDto.getTypeOfBuilding());
        militaryBuilding.setAreaOfBuilding(militaryBuildingDto.getAreaOfBuilding());
        militaryBuilding.setAmountOfRooms(militaryBuildingDto.getAmountOfRooms());


        Subdivision subdivision = new Subdivision();
        subdivision.setId(militaryBuildingDto.getSubdivisionId());
        militaryBuilding.setSubdivision(subdivision);
        return militaryBuilding;
    }
}
