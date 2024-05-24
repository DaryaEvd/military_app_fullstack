package ccfit.nsu.ru.daryaevd.military_unit.service.implementation;

import ccfit.nsu.ru.daryaevd.military_unit.dto.CombatEquipmentDto;
import ccfit.nsu.ru.daryaevd.military_unit.entity.CombatEquipment;
import ccfit.nsu.ru.daryaevd.military_unit.exception.ResourceNotFoundException;
import ccfit.nsu.ru.daryaevd.military_unit.mapper.CombatEquipmentMapper;
import ccfit.nsu.ru.daryaevd.military_unit.repository.CombatEquipmentRepository;
import ccfit.nsu.ru.daryaevd.military_unit.service.CombatEquipmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CombatEquipmentServiceImpl implements CombatEquipmentService {

    private final CombatEquipmentRepository combatEquipmentRepository;

    @Override
    public CombatEquipmentDto createCombatEquipment(CombatEquipmentDto combatEquipmentDto) {
        CombatEquipment combatEquipment = CombatEquipmentMapper.mapToCombatEquipment(combatEquipmentDto);
        CombatEquipment savedCombatEquipment = combatEquipmentRepository.save(combatEquipment);
        return CombatEquipmentMapper.mapToCombatEquipmentDto(savedCombatEquipment);
    }

    @Override
    public CombatEquipmentDto getCombatEquipmentById(Long combatEquipmentId) {
        CombatEquipment combatEquipment = combatEquipmentRepository.findById(combatEquipmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Combat equipment not found with id: " + combatEquipmentId));
        return CombatEquipmentMapper.mapToCombatEquipmentDto(combatEquipment);
    }

    @Override
    public List<CombatEquipmentDto> getAllCombatEquipment() {
        List<CombatEquipment> combatEquipmentList = combatEquipmentRepository.findAll();
        return combatEquipmentList.stream()
                .map(CombatEquipmentMapper::mapToCombatEquipmentDto)
                .collect(Collectors.toList());
    }

    @Override
    public CombatEquipmentDto updateCombatEquipment(Long combatEquipmentId, CombatEquipmentDto updatedCombatEquipment) {
        CombatEquipment combatEquipment = combatEquipmentRepository.findById(combatEquipmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Combat equipment not found with id: " + combatEquipmentId));

        // Update fields
        combatEquipment.setNameOfEquipment(updatedCombatEquipment.getNameOfEquipment());
        combatEquipment.setConditionOfVehicle(updatedCombatEquipment.getConditionOfVehicle());
        combatEquipment.setNumberOfSeats(updatedCombatEquipment.getNumberOfSeats());
        combatEquipment.setNameOfVehicle(updatedCombatEquipment.getNameOfVehicle());

        CombatEquipment updatedCombatEquipmentObj = combatEquipmentRepository.save(combatEquipment);
        return CombatEquipmentMapper.mapToCombatEquipmentDto(updatedCombatEquipmentObj);
    }

    @Override
    public void deleteCombatEquipment(Long combatEquipmentId) {
        if (!combatEquipmentRepository.existsById(combatEquipmentId)) {
            throw new ResourceNotFoundException("Combat equipment not found with id: " + combatEquipmentId);
        }
        combatEquipmentRepository.deleteById(combatEquipmentId);
    }

//    @Override
//    public List<Object[]> getAvailabilityOfEquipment() {
//        return combatEquipmentRepository.getAvailabilityOfEquipment();
//    }
//
//    @Override
//    public List<Object[]> getAvailabilityBySubdivisionType(String subdivisionType) {
//        return combatEquipmentRepository.getAvailabilityBySubdivisionType(subdivisionType);
//    }
}
