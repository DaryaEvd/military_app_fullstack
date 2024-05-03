package ccfit.nsu.ru.daryaevd.military_unit.mapper;

import ccfit.nsu.ru.daryaevd.military_unit.dto.SubdivisionTypeDto;
import ccfit.nsu.ru.daryaevd.military_unit.entity.SubdivisionType;

public class SubdivisionTypeMapper {
    public static SubdivisionTypeDto mapToSubdivisionTypeDto(SubdivisionType subdivisionType) {
        return new SubdivisionTypeDto(
                subdivisionType.getId(),
                subdivisionType.getNameOfType(),
                subdivisionType.getSubdivisionRank()
        );
    }

    public static SubdivisionType mapToSubdivisionType(SubdivisionTypeDto subdivisionTypeDto) {
        return new SubdivisionType(
                subdivisionTypeDto.getId(),
                subdivisionTypeDto.getNameOfType(),
                subdivisionTypeDto.getSubdivisionRank()
        );
    }
}
