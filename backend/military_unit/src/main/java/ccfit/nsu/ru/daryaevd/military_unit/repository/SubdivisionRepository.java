package ccfit.nsu.ru.daryaevd.military_unit.repository;

import ccfit.nsu.ru.daryaevd.military_unit.entity.Subdivision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // todo: think
public interface SubdivisionRepository extends JpaRepository<Subdivision, Long> {
    /* my_query 13
    Получить данные об армии, дивизии, корпусе, в которые входит больше всего
    (меньше всего) военных частей.
    Get data about the army, division, corps, which includes the most (least) military units.
     */

    @Query(""" 
            SELECT s.typeOfSubdivision.nameOfType AS subdivisionType, COUNT(s) AS unitCount
            FROM Subdivision s
            GROUP BY s.typeOfSubdivision.nameOfType
            ORDER BY COUNT(s) DESC
            """)
    List<Object[]> findSubdivisionsWithMostMilitaryUnits();

    /* my_query 1
    Получить перечень всех частей военного округа, указанной армии, дивизии,
            корпуса и их командиров.

    Receive a list of all units of the military district, the specified army,
        division, corps and their commanders.
     */
    @Query("""
            SELECT sld.firstName AS commanderFirstName, sld.lastName AS commanderLastName
            FROM Subdivision s
            JOIN s.soldiers sld
            WHERE s.nameOfSubdivision = :subdivisionName
            """)
    List<Object[]> findCommanderBySubdivisionName(@Param("subdivisionName") String subdivisionName);





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
