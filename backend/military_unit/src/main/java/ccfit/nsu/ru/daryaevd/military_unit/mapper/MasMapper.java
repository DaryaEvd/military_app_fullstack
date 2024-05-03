package ccfit.nsu.ru.daryaevd.military_unit.mapper;

import ccfit.nsu.ru.daryaevd.military_unit.dto.MasDto;
import ccfit.nsu.ru.daryaevd.military_unit.entity.Mas;

public class MasMapper {
    public static MasDto mapToMasDto(Mas mas) {
        return new MasDto(
                mas.getId(),
                mas.getNameOfMas(),
                mas.getCodeOfMas()
        );
    }

    public static Mas mapToMas(MasDto masDto) {
        return new Mas(
                masDto.getId(),
                masDto.getNameOfMas(),
                masDto.getCodeOfMas()
        );
    }
}