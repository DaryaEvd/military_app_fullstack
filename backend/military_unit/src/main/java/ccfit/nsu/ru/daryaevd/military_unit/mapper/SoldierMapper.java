package ccfit.nsu.ru.daryaevd.military_unit.mapper;

import ccfit.nsu.ru.daryaevd.military_unit.dto.SoldierDto;
import ccfit.nsu.ru.daryaevd.military_unit.entity.Mas;
import ccfit.nsu.ru.daryaevd.military_unit.entity.Soldier;
import ccfit.nsu.ru.daryaevd.military_unit.entity.SoldierType;
import ccfit.nsu.ru.daryaevd.military_unit.entity.Subdivision;

import java.util.List;
import java.util.stream.Collectors;

public class SoldierMapper {
    public static SoldierDto mapToSoldierDto(Soldier soldier) {
        SoldierDto soldierDto = new SoldierDto();
        soldierDto.setId(soldier.getId());
        soldierDto.setFirstName(soldier.getFirstName());
        soldierDto.setLastName(soldier.getLastName());
        soldierDto.setDateOfBirth(soldier.getDateOfBirth());
        soldierDto.setMilitaryCard(soldier.getMilitaryCard());
        soldierDto.setDateOfIssueMilitaryCard(soldier.getDateOfIssueMilitaryCard());

        soldierDto.setMasId(soldier.getMas().getId());

        soldierDto.setTypeOfSoldier(soldier.getSoldierType().getId());

        List<Long> subdivisionIds = soldier.getSubdivisions().stream()
                .map(Subdivision::getId)
                .collect(Collectors.toList());
        soldierDto.setSubdivisionIds(subdivisionIds);

        return soldierDto;
    }

    public static Soldier mapToSoldier(SoldierDto soldierDto) {
        Soldier soldier = new Soldier();
        soldier.setId(soldierDto.getId());
        soldier.setFirstName(soldierDto.getFirstName());
        soldier.setLastName(soldierDto.getLastName());
        soldier.setDateOfBirth(soldierDto.getDateOfBirth());
        soldier.setMilitaryCard(soldierDto.getMilitaryCard());
        soldier.setDateOfIssueMilitaryCard(soldierDto.getDateOfIssueMilitaryCard());

        Mas mas = new Mas();
        mas.setId(soldierDto.getMasId());
        soldier.setMas(mas);

        SoldierType soldierType = new SoldierType();
        soldierType.setId(soldierDto.getTypeOfSoldier());
        soldier.setSoldierType(soldierType);

        List<Subdivision> subdivisions = soldierDto.getSubdivisionIds().stream()
                .map(id -> {
                    Subdivision subdivision = new Subdivision();
                    subdivision.setId(id);
                    return subdivision;
                })
                .toList();
        soldier.setSubdivisions(subdivisions);

        return soldier;
    }
}
