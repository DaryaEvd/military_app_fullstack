package ccfit.nsu.ru.daryaevd.military_unit.mapper;

import ccfit.nsu.ru.daryaevd.military_unit.dto.SubdivisionDto;
import ccfit.nsu.ru.daryaevd.military_unit.entity.Subdivision;
import ccfit.nsu.ru.daryaevd.military_unit.entity.Soldier;
import ccfit.nsu.ru.daryaevd.military_unit.entity.SubdivisionType;

import java.util.List;
import java.util.stream.Collectors;

public class SubdivisionMapper {
    public static SubdivisionDto mapToSubdivisionDto(Subdivision subdivision) {
            SubdivisionDto subdivisionDto = new SubdivisionDto();
            subdivisionDto.setId(subdivision.getId());
            subdivisionDto.setNameOfSubdivision(subdivision.getNameOfSubdivision());
            subdivisionDto.setNumberOfSubdivision(subdivision.getNumberOfSubdivision());
            subdivisionDto.setIsDislocated(subdivision.getIsDislocated());

            // Map typeOfSubdivision to its ID
            subdivisionDto.setTypeOfSubdivision(subdivision.getTypeOfSubdivision().getId());

            // Set the list of soldier IDs
            List<Long> soldierIds = subdivision.getSoldiers().stream()
                    .map(Soldier::getId)
                    .collect(Collectors.toList());
            subdivisionDto.setSoldierIds(soldierIds);

            return subdivisionDto;
        }


    public static Subdivision mapToSubdivision(SubdivisionDto subdivisionDto) {
        Subdivision subdivision = new Subdivision();
        subdivision.setId(subdivisionDto.getId());
        subdivision.setNameOfSubdivision(subdivisionDto.getNameOfSubdivision());
        subdivision.setNumberOfSubdivision(subdivisionDto.getNumberOfSubdivision());
        subdivision.setIsDislocated(subdivisionDto.getIsDislocated());

        // You need to set the typeOfSubdivision using the provided ID
        SubdivisionType subdivisionType = new SubdivisionType();
        subdivisionType.setId(subdivisionDto.getTypeOfSubdivision());
        subdivision.setTypeOfSubdivision(subdivisionType);

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
