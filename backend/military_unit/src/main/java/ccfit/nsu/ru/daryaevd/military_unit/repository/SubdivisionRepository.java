package ccfit.nsu.ru.daryaevd.military_unit.repository;

import ccfit.nsu.ru.daryaevd.military_unit.dto.SubdivisionDto;
import ccfit.nsu.ru.daryaevd.military_unit.entity.MilitaryBuilding;
import ccfit.nsu.ru.daryaevd.military_unit.entity.Subdivision;
import ccfit.nsu.ru.daryaevd.military_unit.entity.SubdivisionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository // todo: think
public interface SubdivisionRepository extends JpaRepository<Subdivision, Long> {

    @Query("SELECT s.typeOfSubdivision.nameOfType, s.nameOfSubdivision, COUNT(s) " +
            "FROM Subdivision s " +
            "GROUP BY s.typeOfSubdivision.nameOfType, s.nameOfSubdivision " +
            "ORDER BY COUNT(s) DESC")
    List<Object[]> findSubdivisionsWithMostUnits();

    @Query("SELECT s.typeOfSubdivision.nameOfType, s.nameOfSubdivision, COUNT(s) " +
            "FROM Subdivision s " +
            "GROUP BY s.typeOfSubdivision.nameOfType, s.nameOfSubdivision " +
            "ORDER BY COUNT(s)")
    List<Object[]> findSubdivisionsWithLeastUnits();


    @Query("SELECT s FROM Subdivision s LEFT JOIN FETCH s.commander")
    List<Subdivision> findAllWithCommanders();

    @Query("SELECT s FROM Subdivision s LEFT JOIN FETCH s.commander WHERE s.id = :subdivisionId")
    Subdivision findByIdWithCommander(@Param("subdivisionId") Long subdivisionId);


    @Query("SELECT s.id, s.nameOfSubdivision FROM Subdivision s WHERE s.id IN :ids")
    List<Object[]> findNamesByIds(@Param("ids") List<Long> ids);

    default Map<Long, String> getSubdivisionNames(List<Long> ids) {
        return findNamesByIds(ids).stream()
                .collect(Collectors.toMap(result -> (Long) result[0], result -> (String) result[1]));
    }


//    @Query("SELECT s.nameOfSubdivision FROM Subdivision s JOIN s.weaponTypes wt WHERE wt.weaponCategory = :weaponCategory GROUP BY s.id HAVING COUNT(wt.id) > :count")
//    List<String> findSubdivisionsWithWeaponMoreThan(@Param("weaponCategory") String weaponCategory, @Param("count") long count);
//
//    @Query("SELECT s.nameOfSubdivision FROM Subdivision s WHERE s.id NOT IN (SELECT wt.subdivision.id FROM WeaponType wt WHERE wt.weaponCategory = :weaponCategory)")
//    List<String> findSubdivisionsWithoutWeapon(@Param("weaponCategory") String weaponCategory);

    @Query("SELECT s.nameOfSubdivision FROM Subdivision s JOIN s.weaponTypes wt WHERE wt.weaponCategory = :weaponCategory GROUP BY s.id HAVING COUNT(wt.id) > :count")
    List<String> findSubdivisionsWithWeaponMoreThan(@Param("weaponCategory") String weaponCategory, @Param("count") int count);

    @Query("SELECT s.nameOfSubdivision FROM Subdivision s WHERE s.id NOT IN (SELECT wt.subdivision.id FROM WeaponType wt WHERE wt.weaponCategory = :weaponCategory)")
    List<String> findSubdivisionsWithoutWeapon(@Param("weaponCategory") String weaponCategory);


    @Query("SELECT st.nameOfType, COUNT(s.id) FROM Subdivision s JOIN s.typeOfSubdivision st GROUP BY st.nameOfType")
    List<Object[]> countSubdivisionsByType();


    @Query(value = "SELECT s.type_of_subdivision_id FROM subdivision_table s GROUP BY s.type_of_subdivision_id ORDER BY COUNT(*) DESC LIMIT 1", nativeQuery = true)
    Long findMostFrequentSubdivisionTypeId();

    @Query(value = "SELECT s.type_of_subdivision_id FROM subdivision_table s GROUP BY s.type_of_subdivision_id ORDER BY COUNT(*) ASC LIMIT 1", nativeQuery = true)
    Long findLeastFrequentSubdivisionTypeId();


//    @Query("SELECT s.id FROM Subdivision s JOIN s.weaponTypes w " +
//            "WHERE w.weaponCategory = :category " +
//            "GROUP BY s.id " +
//            "HAVING COUNT(w) > 3")
//    List<Long> findSubdivisionsWithWeaponCountGreaterThanThree(@Param("category") String category);
//
//    @Query("SELECT s.id FROM Subdivision s LEFT JOIN s.weaponTypes w " +
//            "ON w.weaponCategory = :category " +
//            "WHERE w.id IS NULL " +
//            "GROUP BY s.id")
//    List<Long> findSubdivisionsWithoutWeaponCategory(@Param("category") String category);




    /* my_query 13
    Получить данные об армии, дивизии, корпусе, в которые входит больше всего
    (меньше всего) военных частей.
    Get data about the army, division, corps, which includes the most (least) military units.
     */

//    @Query("""
//            SELECT s.typeOfSubdivision.nameOfType AS subdivisionType, COUNT(s) AS unitCount
//            FROM Subdivision s
//            GROUP BY s.typeOfSubdivision.nameOfType
//            ORDER BY COUNT(s) DESC
//            """)
//    List<Object[]> findSubdivisionsWithMostMilitaryUnits();

    /* my_query 1
    Получить перечень всех частей военного округа, указанной армии, дивизии,
            корпуса и их командиров.

    Receive a list of all units of the military district, the specified army,
        division, corps and their commanders.
     */
//    @Query("""
//            SELECT sld.firstName AS commanderFirstName, sld.lastName AS commanderLastName
//            FROM Subdivision s
//            JOIN s.soldiers sld
//            WHERE s.nameOfSubdivision = :subdivisionName
//            """)
//    List<Object[]> findCommanderBySubdivisionName(@Param("subdivisionName") String subdivisionName);


    /* my_query 8
    Receive a list of military subdivisions in which the number of the specified type
    of combat equipment is more than 5 (or there is no specified military equipment).
     */
//    @Query("SELECT s FROM Subdivision s " +
//            "LEFT JOIN s.combatEquipment ce " +
//            "WHERE ce.id IS NULL OR ce.numberOfSeats > 5")
//    List<Subdivision> findSubdivisionsWithSpecifiedCombatEquipment();


    /* my_query 5
    Receive a list of military buildings for dislocation of all military subdivisions.
     */
//    @Query(value = "SELECT DISTINCT mb FROM MilitaryBuilding mb JOIN Subdivision st ON mb.id = st.militaryBuilding.id WHERE st.isDislocated = true")
//    List<MilitaryBuilding> findMilitaryBuildingsForDislocation();


//    @Query("SELECT s.nameOfSubdivision AS subdivisionName, st.nameOfType AS subdivisionType, " +
//            "sld.firstName AS officerFirstName, sld.lastName AS officerLastName " +
//            "FROM Subdivision s " +
//            "JOIN s.soldiers sld " +
//            "JOIN s.typeOfSubdivision st " +
//            "WHERE st.subdivisionRank = :rank OR :rank IS NULL " +
//            "ORDER BY st.subdivisionRank ASC")
//    List<Object[]> findOfficersByRank(@Param("rank") Integer rank);





//    Optional<Subdivision> findWithMostMilitaryUnits(String nameOfMilitaryUnit);


//    @Query(value = "SELECT s.type_of_subdivision AS typeOfSubdivision, " +
//            "COUNT(*) AS unitCount " +
//            "FROM Subdivision s " +
//            "GROUP BY s.type_of_subdivision " +
//            "ORDER BY COUNT(*) DESC " +
//            "LIMIT 1", nativeQuery = true)
//    List<SubdivisionDto> findSubdivisionWithMostUnits();
//
//    @Query(value = "SELECT s.type_of_subdivision AS typeOfSubdivision, " +
//            "COUNT(*) AS unitCount " +
//            "FROM Subdivision s " +
//            "GROUP BY s.type_of_subdivision " +
//            "ORDER BY COUNT(*) ASC " +
//            "LIMIT 1", nativeQuery = true)
//    List<SubdivisionDto> findSubdivisionWithFewestUnits();
}
