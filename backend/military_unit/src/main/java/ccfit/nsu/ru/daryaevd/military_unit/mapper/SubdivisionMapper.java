package ccfit.nsu.ru.daryaevd.military_unit.mapper;

import ccfit.nsu.ru.daryaevd.military_unit.dto.SubdivisionDto;
import ccfit.nsu.ru.daryaevd.military_unit.entity.Subdivision;
import ccfit.nsu.ru.daryaevd.military_unit.entity.Soldier;

import java.util.List;
import java.util.stream.Collectors;

public class SubdivisionMapper {
    public static SubdivisionDto mapToSubdivisionDto(Subdivision subdivision) {
        SubdivisionDto subdivisionDto = new SubdivisionDto();
        subdivisionDto.setId(subdivision.getId());
        subdivisionDto.setNameOfSubdivision(subdivision.getNameOfSubdivision());
        subdivisionDto.setNumberOfSubdivision(subdivision.getNumberOfSubdivision());
        subdivisionDto.setIsDislocated(subdivision.getIsDislocated());
        subdivisionDto.setCommander(subdivision.getCommander());
        subdivisionDto.setTypeOfSubdivision(subdivision.getTypeOfSubdivision());


        // Set the list of soldier IDs
        List<Long> soldierIds = subdivision.getSoldiers().stream()
                .map(Soldier::getId)
                .collect(Collectors.toList());
        subdivisionDto.setSoldierIds(soldierIds);
        ///

        return subdivisionDto;
    }

    public static Subdivision mapToSubdivision(SubdivisionDto subdivisionDto) {
        Subdivision subdivision = new Subdivision();
        subdivision.setId(subdivisionDto.getId());
        subdivision.setNameOfSubdivision(subdivisionDto.getNameOfSubdivision());
        subdivision.setNumberOfSubdivision(subdivisionDto.getNumberOfSubdivision());
        subdivision.setIsDislocated(subdivisionDto.getIsDislocated());
        subdivision.setCommander(subdivisionDto.getCommander());
        subdivision.setTypeOfSubdivision(subdivisionDto.getTypeOfSubdivision());

        // Set the list of soldiers
        List<Soldier> soldiers = subdivisionDto.getSoldierIds().stream()
                .map(id -> {
                    Soldier soldier = new Soldier();
                    soldier.setId(id);
                    return soldier;
                })
                .toList();
        subdivision.setSoldiers(soldiers);

        return subdivision;
    }
}