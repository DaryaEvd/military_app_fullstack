package ccfit.nsu.ru.daryaevd.military_unit.mapper;

import ccfit.nsu.ru.daryaevd.military_unit.dto.MilitaryBuildingDto;
import ccfit.nsu.ru.daryaevd.military_unit.entity.MilitaryBuilding;
import ccfit.nsu.ru.daryaevd.military_unit.entity.Subdivision;
import ccfit.nsu.ru.daryaevd.military_unit.entity.WeaponType;

import java.util.List;
import java.util.stream.Collectors;

public class MilitaryBuildingMapper {
    public static MilitaryBuildingDto mapToMilitaryBuildingDto(MilitaryBuilding militaryBuilding) {

        MilitaryBuildingDto militaryBuildingDto = new MilitaryBuildingDto();
        militaryBuildingDto.setId(militaryBuilding.getId());
        militaryBuildingDto.setCanUseForDislocation(militaryBuilding.getCanUseForDislocation());
        militaryBuildingDto.setTypeOfBuilding(militaryBuilding.getTypeOfBuilding());
        militaryBuildingDto.setAreaOfBuilding(militaryBuilding.getAreaOfBuilding());
        militaryBuildingDto.setAmountOfRooms(militaryBuilding.getAmountOfRooms());

        militaryBuildingDto.setSubdivisionIds(militaryBuilding.getSubdivisions().stream()
                .map(Subdivision::getId)
                .collect(Collectors.toList()));

        return militaryBuildingDto;
    }


    public static MilitaryBuilding mapToMilitaryBuilding(MilitaryBuildingDto dto, List<Subdivision> subdivisions) {
        MilitaryBuilding militaryBuilding = new MilitaryBuilding();
        militaryBuilding.setCanUseForDislocation(dto.getCanUseForDislocation());
        militaryBuilding.setTypeOfBuilding(dto.getTypeOfBuilding());
        militaryBuilding.setAreaOfBuilding(dto.getAreaOfBuilding());
        militaryBuilding.setAmountOfRooms(dto.getAmountOfRooms());
        militaryBuilding.setSubdivisions(subdivisions);
        return militaryBuilding;
    }


//    public static MilitaryBuilding mapToMilitaryBuilding(MilitaryBuildingDto militaryBuildingDto) {
//        MilitaryBuilding militaryBuilding = new MilitaryBuilding();
//        militaryBuilding.setId(militaryBuildingDto.getId());
//        militaryBuilding.setCanUseForDislocation(militaryBuildingDto.getCanUseForDislocation());
//        militaryBuilding.setTypeOfBuilding(militaryBuildingDto.getTypeOfBuilding());
//        militaryBuilding.setAreaOfBuilding(militaryBuildingDto.getAreaOfBuilding());
//        militaryBuilding.setAmountOfRooms(militaryBuildingDto.getAmountOfRooms());
//
//
//        Subdivision subdivision = new Subdivision();
//        subdivision.setId(militaryBuildingDto.getSubdivisionId());
//        militaryBuilding.setSubdivision(subdivision);
//
//        return militaryBuilding;
//    }
}
