package ccfit.nsu.ru.daryaevd.military_unit.service;

import ccfit.nsu.ru.daryaevd.military_unit.dto.CombatEquipmentDto;

import java.util.List;

public interface CombatEquipmentService {
    CombatEquipmentDto createCombatEquipment(CombatEquipmentDto combatEquipmentDto);

    CombatEquipmentDto getCombatEquipmentById(Long combatEquipmentId);

    List<CombatEquipmentDto> getAllCombatEquipment();

    CombatEquipmentDto updateCombatEquipment(Long combatEquipmentId, CombatEquipmentDto updatedCombatEquipment);

    void deleteCombatEquipment(Long combatEquipmentId);

    List<CombatEquipmentDto> getAllCombatEquipments();
    List<CombatEquipmentDto> getCombatEquipmentsBySubdivisionId(Long subdivisionId);

    List<String> getSubdivisionsWithMoreThanFiveEquipment(String nameOfEquipment);
    List<String> getSubdivisionsWithNoEquipment(String nameOfEquipment);

//    List<Long> getSubdivisionsWithMoreThanFiveEquipment(Long equipmentId);
//    List<Long> getSubdivisionsWithNoEquipment(Long equipmentId);


//    List<Long> getSubdivisionsWithMoreThanFiveEquipment(String equipmentName);
//    List<Long> getSubdivisionsWithNoEquipment(String equipmentName);


//    List<Object[]> getAvailabilityOfEquipment();
//    List<Object[]> getAvailabilityBySubdivisionType(String subdivisionType);

}
