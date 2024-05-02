package ccfit.nsu.ru.daryaevd.military_unit.mapper;

import ccfit.nsu.ru.daryaevd.military_unit.dto.CommanderDto;
import ccfit.nsu.ru.daryaevd.military_unit.entity.Commander;

public class CommanderMapper {
    public static CommanderDto mapToCommanderDto(Commander commander) {
        return new CommanderDto(
                commander.getId(),
                commander.getIdOfficer(),
                commander.getIdSubdivision()
        );
    }

    public static Commander mapToCommander(CommanderDto commanderDto) {
        return new Commander(
                commanderDto.getId(),
                commanderDto.getIdOfficer(),
                commanderDto.getIdSubdivision()
        );
    }
}
