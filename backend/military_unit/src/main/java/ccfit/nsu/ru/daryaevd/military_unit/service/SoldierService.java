package ccfit.nsu.ru.daryaevd.military_unit.service;

import ccfit.nsu.ru.daryaevd.military_unit.dto.SoldierDto;
import ccfit.nsu.ru.daryaevd.military_unit.entity.Soldier;

import java.util.List;
import java.util.Optional;

public interface SoldierService {
    SoldierDto createSoldier(SoldierDto soldierDto);

    SoldierDto getSoldierById(Long soldierId);

    List<SoldierDto> getAllSoldiers();

    SoldierDto updateSoldier(Long soldierId, SoldierDto updatedSoldier);

    void deleteSoldier(Long soldierId);


    List<SoldierDto> getOfficersByRankRange();

//    List<Soldier> getOfficers(Integer rank, Integer subdivisionRank);


    List<SoldierDto> getOfficers(Integer soldierRank, Integer subdivisionRank);

    List<SoldierDto> getSergeants(Integer soldierRank, Integer subdivisionRank);


    List<SoldierDto> getSoldiersByMasId(Long masId);
    List<SoldierDto> getSoldiersByMasIdAndSubdivisionId(Long masId, Long subdivisionId);

    List<SoldierDto> getChainOfCommand(Long soldierId);

    List<SoldierDto> getHierarchyForSoldier(Long soldierId) ;


//    List<Soldier> getOfficers();

//    List<Soldier> getOfficersByTypeAndSubdivisionTypeRank(Integer minRank, Integer maxRank, Integer subdivisionTypeRank);

//    List<Soldier> findSergeants();
//
//    List<Soldier> findSergeantsByRankAndSubdivisionType(Integer lowerRank, Integer upperRank, Integer subdivisionRank);
//
//    List<Soldier> findSoldiersByMasIdAndSubdivisionName(Long masId, String subdivisionName);
}
