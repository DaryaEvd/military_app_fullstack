package ccfit.nsu.ru.daryaevd.military_unit.mapper;

import ccfit.nsu.ru.daryaevd.military_unit.dto.SoldierTypeDto;
import ccfit.nsu.ru.daryaevd.military_unit.entity.SoldierType;

public class SoldierTypeMapper {
    public static SoldierTypeDto mapToSoldierTypeDto(SoldierType soldierType) {
        SoldierTypeDto soldierTypeDto = new SoldierTypeDto();
        soldierTypeDto.setId(soldierType.getId());
        soldierTypeDto.setNameOfType(soldierType.getNameOfType());
        soldierTypeDto.setTypeRank(soldierType.getTypeRank());

//        soldierTypeDto.setSoldierType(soldierType.getId());

        return soldierTypeDto;
    }

    public static SoldierType mapToSoldierType(SoldierTypeDto soldierTypeDto) {
        SoldierType soldierType = new SoldierType();
        soldierType.setId(soldierTypeDto.getId());
        soldierType.setNameOfType(soldierTypeDto.getNameOfType());
        soldierType.setTypeRank(soldierTypeDto.getTypeRank());

//        Soldier soldier = new Soldier();
//        soldier.setId(soldierTypeDto.getSoldierId());
//        soldierType.setSoldier(soldier);

        return soldierType;
    }
}
