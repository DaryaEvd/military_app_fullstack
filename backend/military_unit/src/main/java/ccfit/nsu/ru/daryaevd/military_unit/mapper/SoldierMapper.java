package ccfit.nsu.ru.daryaevd.military_unit.mapper;

import ccfit.nsu.ru.daryaevd.military_unit.dto.SoldierDto;
import ccfit.nsu.ru.daryaevd.military_unit.entity.Mas;
import ccfit.nsu.ru.daryaevd.military_unit.entity.Soldier;
import ccfit.nsu.ru.daryaevd.military_unit.entity.SoldierType;
import ccfit.nsu.ru.daryaevd.military_unit.entity.Subdivision;
import ccfit.nsu.ru.daryaevd.military_unit.exception.ResourceNotFoundException;
import ccfit.nsu.ru.daryaevd.military_unit.repository.MasRepository;
import ccfit.nsu.ru.daryaevd.military_unit.repository.SoldierTypeRepository;
import ccfit.nsu.ru.daryaevd.military_unit.repository.SubdivisionRepository;


public class SoldierMapper {

    public static SoldierDto mapToSoldierDto(Soldier soldier) {
        SoldierDto soldierDto = new SoldierDto();
        soldierDto.setId(soldier.getId());
        soldierDto.setFirstName(soldier.getFirstName());
        soldierDto.setLastName(soldier.getLastName());
        soldierDto.setDateOfBirth(soldier.getDateOfBirth());
        soldierDto.setMilitaryCard(soldier.getMilitaryCard());
        soldierDto.setDateOfIssueMilitaryCard(soldier.getDateOfIssueMilitaryCard());
        soldierDto.setMasId(soldier.getMas() != null ? soldier.getMas().getId() : null);
        soldierDto.setTypeOfSoldier(soldier.getSoldierType() != null ? soldier.getSoldierType().getTypeRank() : null);
//        soldierDto.setSubdivisionId(soldier.getSubdivision() != null ? soldier.getSubdivision().getTypeOfSubdivision() : null); // Исправлено здесь

        soldierDto.setSubdivisionId(soldier.getSubdivision().getTypeOfSubdivision() != null ?
                    soldier.getSubdivision().getTypeOfSubdivision().getSubdivisionRank() : null);

        soldierDto.setIsCommander(soldier.getIsCommander());

        soldierDto.setCommanderId(soldier.getCommanderId() != null ?
                soldier.getCommanderId() : null);

        return soldierDto;
    }


//    public static Soldier mapToSoldier(SoldierDto soldierDto, MasRepository masRepository, SoldierTypeRepository soldierTypeRepository, SubdivisionRepository subdivisionRepository) {
//        Soldier soldier = new Soldier();
//        soldier.setId(soldierDto.getId());
//        soldier.setFirstName(soldierDto.getFirstName());
//        soldier.setLastName(soldierDto.getLastName());
//        soldier.setDateOfBirth(soldierDto.getDateOfBirth());
//        soldier.setMilitaryCard(soldierDto.getMilitaryCard());
//        soldier.setDateOfIssueMilitaryCard(soldierDto.getDateOfIssueMilitaryCard());
//
//        if (soldierDto.getMasId() != null) {
//            Mas mas = masRepository.findById(soldierDto.getMasId())
//                    .orElseThrow(() -> new ResourceNotFoundException("Mas doesn't exist with given id: " + soldierDto.getMasId()));
//            soldier.setMasId(mas);
//        }
//
//        if (soldierDto.getTypeOfSoldier() != null) {
//            SoldierType soldierType = soldierTypeRepository.findById(soldierDto.getTypeOfSoldier())
//                    .orElseThrow(() -> new ResourceNotFoundException("SoldierType doesn't exist with given id: " + soldierDto.getTypeOfSoldier()));
//            soldier.setSoldierType(soldierType);
//        }
//
//        if (soldierDto.getSubdivisionId() != null) {
//            Subdivision subdivision = subdivisionRepository.findById(soldierDto.getSubdivisionId())
//                    .orElseThrow(() -> new ResourceNotFoundException("Subdivision doesn't exist with given id: " + soldierDto.getSubdivisionId()));
//            soldier.setSubdivision(subdivision);
//        }
//
//        soldier.setIsCommander(soldierDto.getIsCommander());
//        return soldier;
//    }
}
