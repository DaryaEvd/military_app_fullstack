package ccfit.nsu.ru.daryaevd.military_unit.service;

import ccfit.nsu.ru.daryaevd.military_unit.dto.SoldierDto;

import java.util.List;

public interface SoldierService {
    SoldierDto createSoldier(SoldierDto soldierDto);

    SoldierDto getSoldierById(Long soldierId);

    List<SoldierDto> getAllSoldiers();

    SoldierDto updateSoldier(Long soldierId, SoldierDto updatedSoldier);

    void deleteSoldier(Long soldierId);


    List<SoldierDto> getOfficersByRankRange();


//    List<Soldier> getOfficers();

//    List<Soldier> getOfficersByTypeAndSubdivisionTypeRank(Integer minRank, Integer maxRank, Integer subdivisionTypeRank);

//    List<Soldier> findSergeants();
//
//    List<Soldier> findSergeantsByRankAndSubdivisionType(Integer lowerRank, Integer upperRank, Integer subdivisionRank);
//
//    List<Soldier> findSoldiersByMasIdAndSubdivisionName(Long masId, String subdivisionName);
}
