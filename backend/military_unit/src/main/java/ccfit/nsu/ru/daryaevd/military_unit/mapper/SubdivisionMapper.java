package ccfit.nsu.ru.daryaevd.military_unit.mapper;

import ccfit.nsu.ru.daryaevd.military_unit.dto.SubdivisionDto;
import ccfit.nsu.ru.daryaevd.military_unit.entity.Subdivision;

public class SubdivisionMapper {
    public static SubdivisionDto mapToSubdivisionDto(Subdivision subdivision) {
        SubdivisionDto subdivisionDto = new SubdivisionDto();
        subdivisionDto.setId(subdivision.getId());
        subdivisionDto.setNameOfSubdivision(subdivision.getNameOfSubdivision());
        subdivisionDto.setNumberOfSubdivision(subdivision.getNumberOfSubdivision());
        subdivisionDto.setIsDislocated(subdivision.getIsDislocated());
        subdivisionDto.setCommander(subdivision.getCommander());
        subdivisionDto.setTypeOfSubdivision(subdivision.getTypeOfSubdivision());

        return subdivisionDto;
    }

    public static Subdivision mapToSubdivision(SubdivisionDto subdivisionDto) {
        Subdivision subdivision = new Subdivision();
        subdivision.setId(subdivisionDto.getId());
        subdivision.setNameOfSubdivision(subdivisionDto.getNameOfSubdivision());
        subdivision.setNumberOfSubdivision(subdivisionDto.getNumberOfSubdivision());
        subdivision.setIsDislocated(subdivisionDto.getIsDislocated());
        subdivision.setCommander(subdivisionDto.getCommander());
        subdivisionDto.setTypeOfSubdivision(subdivisionDto.getTypeOfSubdivision());

        return subdivision;
    }
}