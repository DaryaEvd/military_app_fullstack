package ccfit.nsu.ru.daryaevd.military_unit.service;

import ccfit.nsu.ru.daryaevd.military_unit.dto.SoldierTypeDto;
import java.util.List;

public interface SoldierTypeService {
    SoldierTypeDto createSoldierType(SoldierTypeDto soldierTypeDto);
    SoldierTypeDto getSoldierTypeById(Long soldierTypeId);
    List<SoldierTypeDto> getAllSoldierTypes();
    SoldierTypeDto updateSoldierType(Long soldierTypeId, SoldierTypeDto updatedSoldierType);
    void deleteSoldierType(Long soldierTypeId);

}
