package ccfit.nsu.ru.daryaevd.military_unit.repository;

import ccfit.nsu.ru.daryaevd.military_unit.entity.MilitaryBuilding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MilitaryBuildingRepository extends JpaRepository<MilitaryBuilding, Long> {
    List<MilitaryBuilding> findBySubdivisionId(Long subdivisionId);



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