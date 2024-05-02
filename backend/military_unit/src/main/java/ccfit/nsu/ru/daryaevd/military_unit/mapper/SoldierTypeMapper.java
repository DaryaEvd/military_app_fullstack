package ccfit.nsu.ru.daryaevd.military_unit.mapper;

import ccfit.nsu.ru.daryaevd.military_unit.dto.SoldierTypeDto;
import ccfit.nsu.ru.daryaevd.military_unit.entity.SoldierType;

public class SoldierTypeMapper {
  public static SoldierTypeDto mapToSoldierTypeDto(SoldierType soldierType) {
      return new SoldierTypeDto(
              soldierType.getId(),
              soldierType.getNameOfType(),
              soldierType.getTypeRank()
      );
  }

  public static SoldierType mapToSoldierType(SoldierTypeDto soldierTypeDto){
      return new SoldierType(
              soldierTypeDto.getId(),
              soldierTypeDto.getNameOfType(),
              soldierTypeDto.getTypeRank()
      );
  }

}
