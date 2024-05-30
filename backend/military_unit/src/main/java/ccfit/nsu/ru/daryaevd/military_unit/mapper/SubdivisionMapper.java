package ccfit.nsu.ru.daryaevd.military_unit.mapper;

import ccfit.nsu.ru.daryaevd.military_unit.dto.SubdivisionDto;
import ccfit.nsu.ru.daryaevd.military_unit.entity.*;

import java.util.List;
import java.util.stream.Collectors;

public class SubdivisionMapper {
    public static SubdivisionDto mapToSubdivisionDto(Subdivision subdivision) {
        SubdivisionDto subdivisionDto = new SubdivisionDto();

        subdivisionDto.setId(subdivision.getId());
        subdivisionDto.setNameOfSubdivision(subdivision.getNameOfSubdivision());
        subdivisionDto.setNumberOfSubdivision(subdivision.getNumberOfSubdivision());
        subdivisionDto.setIsDislocated(subdivision.getIsDislocated());
//        subdivisionDto.setTypeOfSubdivision(Math.toIntExact(subdivision.getTypeOfSubdivision().getId()));
        subdivisionDto.setTypeOfSubdivision(subdivision.getTypeOfSubdivision().getId());
        

        if (subdivision.getCommander() != null) {
            subdivisionDto.setCommanderId(subdivision.getCommander().getId());
        }

        return subdivisionDto;
    }

//        SubdivisionDto subdivisionDto = new SubdivisionDto();
//
//        subdivisionDto.setId(subdivision.getId());
//        subdivisionDto.setNameOfSubdivision(subdivision.getNameOfSubdivision());
//        subdivisionDto.setNumberOfSubdivision(subdivision.getNumberOfSubdivision());
//        subdivisionDto.setIsDislocated(subdivision.getIsDislocated());
//        subdivisionDto.setTypeOfSubdivision(subdivision.getTypeOfSubdivision().getId());
//
//        subdivisionDto.setCommanderId(subdivision.getCommander().getId());
//
////        subdivisionDto.setMilitaryBuildingId(subdivision.getMilitaryBuilding().getId());
////        subdivisionDto.setCombatEquipmentId(subdivision.getCombatEquipment().getId());
////        subdivisionDto.setWeaponTypeId(subdivision.getWeaponType().getId());
////
////        List<Long> soldierIds = subdivision.getSoldiers().stream()
////                .map(Soldier::getId)
////                .collect(Collectors.toList());
////        subdivisionDto.setSoldierIds(soldierIds);
//        return subdivisionDto;
//    }

    public static Subdivision mapToSubdivision(SubdivisionDto subdivisionDto) {

        Subdivision subdivision = new Subdivision();
        subdivision.setId(subdivisionDto.getId());
        subdivision.setNameOfSubdivision(subdivisionDto.getNameOfSubdivision());
        subdivision.setNumberOfSubdivision(subdivisionDto.getNumberOfSubdivision());
        subdivision.setIsDislocated(subdivisionDto.getIsDislocated());

        SubdivisionType subdivisionType = new SubdivisionType();
        subdivisionType.setId(Long.valueOf(subdivisionDto.getTypeOfSubdivision()));
        subdivision.setTypeOfSubdivision(subdivisionType);

        Soldier soldier = new Soldier();
        if (subdivisionDto.getCommanderId() != null) {
            soldier.setId(subdivisionDto.getCommanderId());
        }
        subdivision.setCommander(soldier);

        return subdivision;


//        Subdivision subdivision = new Subdivision();
//        subdivision.setId(subdivisionDto.getId());
//        subdivision.setNameOfSubdivision(subdivisionDto.getNameOfSubdivision());
//        subdivision.setNumberOfSubdivision(subdivisionDto.getNumberOfSubdivision());
//        subdivision.setIsDislocated(subdivisionDto.getIsDislocated());
//
//        SubdivisionType subdivisionType = new SubdivisionType();
//        subdivisionType.setId(subdivisionDto.getTypeOfSubdivision());
//        subdivision.setTypeOfSubdivision(subdivisionType);
//
//        Soldier soldier = new Soldier();
//        soldier.setId(subdivisionDto.getCommanderId());
//        subdivision.setCommander(soldier);
//
////        MilitaryBuilding militaryBuilding = new MilitaryBuilding();
////        militaryBuilding.setId(subdivisionDto.getMilitaryBuildingId());
////        subdivision.setMilitaryBuilding(militaryBuilding);
////
////        CombatEquipment combatEquipment = new CombatEquipment();
////        combatEquipment.setId(subdivisionDto.getCombatEquipmentId());
////        subdivision.setCombatEquipment(combatEquipment);
////
////        WeaponType weaponType = new WeaponType();
////        weaponType.setId(subdivisionDto.getWeaponTypeId());
////        subdivision.setWeaponType(weaponType);
////
////        List<Soldier> soldiers = subdivisionDto.getSoldierIds().stream()
////                .map(id -> {
////                    Soldier soldier = new Soldier();
////                    soldier.setId(id);
////                    return soldier;
////                })
////                .toList();
////        subdivision.setSoldiers(soldiers);
//
//        return subdivision;
    }
}
