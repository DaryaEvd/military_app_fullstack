package ccfit.nsu.ru.daryaevd.military_unit.mapper;

import ccfit.nsu.ru.daryaevd.military_unit.dto.CombatEquipmentDto;
import ccfit.nsu.ru.daryaevd.military_unit.entity.CombatEquipment;
import ccfit.nsu.ru.daryaevd.military_unit.entity.Subdivision;

public class CombatEquipmentMapper {
    public static CombatEquipmentDto mapToCombatEquipmentDto(CombatEquipment combatEquipment) {
        CombatEquipmentDto combatEquipmentDto = new CombatEquipmentDto();
        combatEquipmentDto.setId(combatEquipment.getId());
        combatEquipmentDto.setNameOfEquipment(combatEquipment.getNameOfEquipment());
        combatEquipmentDto.setExperienceOfUsing(combatEquipment.getExperienceOfUsing());
        combatEquipmentDto.setConditionOfVehicle(combatEquipment.getConditionOfVehicle());
        combatEquipmentDto.setNumberOfSeats(combatEquipment.getNumberOfSeats());
        combatEquipmentDto.setNameOfVehicle(combatEquipment.getNameOfVehicle());

        combatEquipmentDto.setSubdivisionId(combatEquipment.getId());

        return combatEquipmentDto;
    }

    public static CombatEquipment mapToCombatEquipment(CombatEquipmentDto combatEquipmentDto) {
        CombatEquipment combatEquipment = new CombatEquipment();
        combatEquipment.setId(combatEquipmentDto.getId());
        combatEquipment.setNameOfEquipment(combatEquipmentDto.getNameOfEquipment());
        combatEquipment.setExperienceOfUsing(combatEquipmentDto.getExperienceOfUsing());
        combatEquipment.setConditionOfVehicle(combatEquipmentDto.getConditionOfVehicle());
        combatEquipment.setNumberOfSeats(combatEquipmentDto.getNumberOfSeats());
        combatEquipment.setNameOfVehicle(combatEquipmentDto.getNameOfVehicle());

//        Subdivision subdivision = new Subdivision();
//        subdivision.setId(combatEquipmentDto.getSubdivisionId());
//        combatEquipment.setSubdivision(subdivision);

        return combatEquipment;
    }
}
