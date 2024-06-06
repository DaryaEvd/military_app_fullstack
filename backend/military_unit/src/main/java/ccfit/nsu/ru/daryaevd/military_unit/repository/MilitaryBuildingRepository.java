package ccfit.nsu.ru.daryaevd.military_unit.repository;

import ccfit.nsu.ru.daryaevd.military_unit.entity.MilitaryBuilding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MilitaryBuildingRepository extends JpaRepository<MilitaryBuilding, Long> {


    List<MilitaryBuilding> findBySubdivisions_Id(Long subdivisionId);

    @Query("SELECT mb FROM MilitaryBuilding mb WHERE SIZE(mb.subdivisions) >= :minSubdivisions")
    List<MilitaryBuilding> findByMinSubdivisions(int minSubdivisions);

    @Query("SELECT mb FROM MilitaryBuilding mb WHERE mb.subdivisions IS EMPTY")
    List<MilitaryBuilding> findWithNoSubdivisions();


    @Query("SELECT DISTINCT mb FROM MilitaryBuilding mb JOIN mb.subdivisions s")
    List<MilitaryBuilding> findAllDislocationPlaces();

    @Query("SELECT mb FROM MilitaryBuilding mb JOIN mb.subdivisions s WHERE s.id = :subdivisionId")
    List<MilitaryBuilding> findDislocationPlacesBySubdivisionId(Long subdivisionId);


//    @Query("SELECT mb FROM MilitaryBuilding mb JOIN mb.subdivisions s WHERE s.id = :subdivisionId AND s.isDislocated = :isDislocated")
//    List<MilitaryBuilding> findBySubdivisionIdAndDislocatedStatus(@Param("subdivisionId") Long subdivisionId, @Param("isDislocated") Boolean isDislocated);
//
//    @Query("SELECT mb FROM MilitaryBuilding mb JOIN mb.subdivisions s GROUP BY mb HAVING COUNT(s) > :minSubdivisions")
//    List<MilitaryBuilding> findBuildingsWithMultipleSubdivisions(@Param("minSubdivisions") Long minSubdivisions);
//
//    @Query("SELECT mb FROM MilitaryBuilding mb LEFT JOIN mb.subdivisions s WHERE s IS NULL OR s.isDislocated = false")
//    List<MilitaryBuilding> findBuildingsWithNoDislocatedSubdivisions();



    //    List<MilitaryBuilding> findBySubdivisionId(Long subdivisionId);

    /* my_query 7
    Receive a list of military buildings of the specified subdivision type,
        a list of military buildings where more than one subdivision is dislocated,
        where not a single subdivision is dislocated.
     */
    /* my_query 7.1
    Get a list of military buildings of the specified military subdivision
     */
//    @Query("SELECT mb FROM MilitaryBuilding mb " +
//            "JOIN mb.subdivisionList s " +
//            "JOIN s.typeOfSubdivision st " +
//            "WHERE st.nameOfType = :subdivisionType")
//    List<MilitaryBuilding> findBySubdivisionType(@Param("subdivisionType") String subdivisionType);
//
//    /* my_query 7.2
//    Obtain a list of structures where more than one military subdivision is dislocated,
//    and where military subdivision are dislocated.
//     */
//    @Query("SELECT mb FROM MilitaryBuilding mb " +
//            "JOIN mb.subdivisionList s " +
//            "WHERE s.isDislocated = true " +
//            "GROUP BY mb.id " +
//            "HAVING COUNT(s.id) > 1")
//    List<MilitaryBuilding> findMilitaryBuildingsWithMultipleDislocatedSubdivisions();


}