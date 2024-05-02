package ccfit.nsu.ru.daryaevd.military_unit.mapper;

import ccfit.nsu.ru.daryaevd.military_unit.dto.SubdivisionDto;
import ccfit.nsu.ru.daryaevd.military_unit.entity.Subdivision;

public class SubdivisionMapper {
    public static SubdivisionDto mapToSubdivisionDto(Subdivision subdivision) {
        return new SubdivisionDto(
                subdivision.getId(),
                subdivision.getNameOfSubdivision(),
                subdivision.getNumberOfSubdivision(),
                subdivision.getIsDislocated(),
                subdivision.getCommander(),
                subdivision.getTypeOfSubdivision()
        );
    }

    public static Subdivision mapToSubdivision(SubdivisionDto subdivisionDto) {
        return new Subdivision(
                subdivisionDto.getId(),
                subdivisionDto.getNameOfSubdivision(),
                subdivisionDto.getNumberOfSubdivision(),
                subdivisionDto.getIsDislocated(),
                subdivisionDto.getCommander(),
                subdivisionDto.getTypeOfSubdivision()
        );
    }
}
