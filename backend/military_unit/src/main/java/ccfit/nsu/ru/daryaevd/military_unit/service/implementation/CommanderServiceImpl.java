package ccfit.nsu.ru.daryaevd.military_unit.service.implementation;

import ccfit.nsu.ru.daryaevd.military_unit.dto.CommanderDto;
import ccfit.nsu.ru.daryaevd.military_unit.entity.Commander;
import ccfit.nsu.ru.daryaevd.military_unit.exception.ResourceNotFoundException;
import ccfit.nsu.ru.daryaevd.military_unit.mapper.CommanderMapper;
import ccfit.nsu.ru.daryaevd.military_unit.repository.CommanderRepository;
import ccfit.nsu.ru.daryaevd.military_unit.service.CommanderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CommanderServiceImpl implements CommanderService {
    private final CommanderRepository commanderRepository;

    @Override
    public CommanderDto createCommander(CommanderDto commanderDto) {
        Commander commander = CommanderMapper.mapToCommander(commanderDto);
        Commander savedCommander = commanderRepository.save(commander);
        return CommanderMapper.mapToCommanderDto(savedCommander);
    }

    @Override
    public CommanderDto getCommanderById(Long commanderId) {
        Commander commander = commanderRepository.findById(commanderId)
                .orElseThrow(() -> new ResourceNotFoundException("Commander doesn't exist with given id: " + commanderId));
        return CommanderMapper.mapToCommanderDto(commander);
    }

    @Override
    public List<CommanderDto> getAllCommanders() {
        List<Commander> commanders = commanderRepository.findAll();
        return commanders.stream()
                .map(CommanderMapper::mapToCommanderDto)
                .collect(Collectors.toList());
    }

    @Override
    public CommanderDto updateCommander(Long commanderId, CommanderDto updatedCommander) {
        Commander commander = commanderRepository.findById(commanderId)
                .orElseThrow(() -> new ResourceNotFoundException("Commander doesn't exist with given id: " + commanderId));

        commander.setIdOfficer(updatedCommander.getIdOfficer());
        commander.setIdSubdivision(updatedCommander.getIdSubdivision());

        Commander updatedCommanderObj = commanderRepository.save(commander);
        return CommanderMapper.mapToCommanderDto(updatedCommanderObj);
    }

    @Override
    public void deleteCommander(Long commanderId) {
        commanderRepository.findById(commanderId)
                .orElseThrow(() -> new ResourceNotFoundException("Commander doesn't exist with given id: " + commanderId));
        commanderRepository.deleteById(commanderId);
    }
}
