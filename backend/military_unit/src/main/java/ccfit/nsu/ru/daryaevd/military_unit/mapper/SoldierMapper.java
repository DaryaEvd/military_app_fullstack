package ccfit.nsu.ru.daryaevd.military_unit.mapper;

import ccfit.nsu.ru.daryaevd.military_unit.dto.SoldierDto;
import ccfit.nsu.ru.daryaevd.military_unit.entity.Mas;
import ccfit.nsu.ru.daryaevd.military_unit.entity.Soldier;

public class SoldierMapper {
    public static SoldierDto mapToSoldierDto(Soldier soldier) {
        return new SoldierDto(
                soldier.getId(),
                soldier.getFirstName(),
                soldier.getLastName(),
                soldier.getDateOfBirth(),
                soldier.getMilitaryCard(),
                soldier.getDateOfIssueMilitaryCard(),

                soldier.getMas().getId() // get id связанного mas
        );
    }


    public static Soldier mapToSoldier(SoldierDto soldierDto) {
        Soldier soldier = new Soldier();
        soldier.setId(soldierDto.getId());
        soldier.setFirstName(soldierDto.getFirstName());
        soldier.setLastName(soldierDto.getLastName());
        soldier.setDateOfBirth(soldierDto.getDateOfBirth());
        soldier.setMilitaryCard(soldierDto.getMilitaryCard());
        soldier.setDateOfIssueMilitaryCard(soldierDto.getDateOfIssueMilitaryCard());

        // to connect with mas
        Mas mas = new Mas();
        mas.setId(soldierDto.getMasId());
        soldier.setMas(mas);
        return soldier;

    }
}
