package ccfit.nsu.ru.daryaevd.military_unit.mapper;

import ccfit.nsu.ru.daryaevd.military_unit.dto.SubdivisionTypeDto;
import ccfit.nsu.ru.daryaevd.military_unit.entity.SubdivisionType;

public class SubdivisionTypeMapper {
    public static SubdivisionTypeDto mapToSubdivisionTypeDto(SubdivisionType subdivisionType) {
        SubdivisionTypeDto subdivisionTypeDto = new SubdivisionTypeDto();
        subdivisionTypeDto.setId(subdivisionType.getId());
        subdivisionTypeDto.setNameOfType(subdivisionType.getNameOfType());
        subdivisionTypeDto.setSubdivisionRank(subdivisionType.getSubdivisionRank());

         return subdivisionTypeDto;
    }

    public static SubdivisionType mapToSubdivisionType(SubdivisionTypeDto subdivisionTypeDto) {
        SubdivisionType subdivisionType = new SubdivisionType();
        subdivisionType.setId(subdivisionTypeDto.getId());
        subdivisionType.setNameOfType(subdivisionTypeDto.getNameOfType());
        subdivisionType.setSubdivisionRank(subdivisionTypeDto.getSubdivisionRank());

//        Subdivision subdivision = new Subdivision();
//        subdivision.setId(subdivisionTypeDto.getSubdivisionId());
//        subdivisionType.setSubdivision(subdivision);

        return subdivisionType;
    }
}
