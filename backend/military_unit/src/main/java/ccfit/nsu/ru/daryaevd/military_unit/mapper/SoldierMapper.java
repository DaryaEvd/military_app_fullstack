package ccfit.nsu.ru.daryaevd.military_unit.mapper;

import ccfit.nsu.ru.daryaevd.military_unit.dto.SoldierDto;
import ccfit.nsu.ru.daryaevd.military_unit.entity.Soldier;

public class SoldierMapper {
    public static SoldierDto mapToSoldierDto(Soldier soldier) {
        return new SoldierDto(
                soldier.getId(),
                soldier.getFirstName(),
                soldier.getLastName(),
                soldier.getDateOfBirth(),
                soldier.getMilitaryCard(),
                soldier.getDateOfIssueMilitaryCard()
        );
    }

    public static Soldier mapToSoldier(SoldierDto soldierDto) {
        return new Soldier(
                soldierDto.getId(),
                soldierDto.getFirstName(),
                soldierDto.getLastName(),
                soldierDto.getDateOfBirth(),
                soldierDto.getMilitaryCard(),
                soldierDto.getDateOfIssueMilitaryCard()
        );
    }
}