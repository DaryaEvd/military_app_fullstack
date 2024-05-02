package ccfit.nsu.ru.daryaevd.military_unit.service;

import ccfit.nsu.ru.daryaevd.military_unit.dto.CommanderDto;
import ccfit.nsu.ru.daryaevd.military_unit.dto.MilitaryBuildingDto;

import java.util.List;

public interface CommanderService {
    CommanderDto createCommander(CommanderDto commanderDto);
    CommanderDto getCommanderById(Long commanderId);
    List<CommanderDto> getAllCommanders();
    CommanderDto updateCommander(Long commanderId, CommanderDto updatedCommander);
    void deleteCommander(Long commanderId);
}
