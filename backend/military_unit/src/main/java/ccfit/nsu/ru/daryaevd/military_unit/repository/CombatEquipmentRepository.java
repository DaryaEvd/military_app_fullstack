package ccfit.nsu.ru.daryaevd.military_unit.repository;

import ccfit.nsu.ru.daryaevd.military_unit.entity.CombatEquipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CombatEquipmentRepository extends JpaRepository<CombatEquipment, Long> {
    List<CombatEquipment> findBySubdivisionId(Long subdivisionId);

//    @Query("SELECT ce.subdivision.id FROM CombatEquipment ce WHERE ce.nameOfEquipment = :nameOfEquipment GROUP BY ce.subdivision.id HAVING COUNT(ce.id) > 5")
//    List<Long> findSubdivisionsWithMoreThanFiveEquipment(@Param("nameOfEquipment") String nameOfEquipment);
//
//    @Query("SELECT s.id FROM Subdivision s WHERE s.id NOT IN (SELECT ce.subdivision.id FROM CombatEquipment ce WHERE ce.nameOfEquipment = :nameOfEquipment)")
//    List<Long> findSubdivisionsWithNoEquipment(@Param("nameOfEquipment") String nameOfEquipment);


    @Query("SELECT ce.subdivision.nameOfSubdivision FROM CombatEquipment ce WHERE ce.nameOfEquipment = :nameOfEquipment GROUP BY ce.subdivision.nameOfSubdivision HAVING COUNT(ce.id) > 5")
    List<String> findSubdivisionsWithMoreThanFiveEquipment(@Param("nameOfEquipment") String nameOfEquipment);

    @Query("SELECT s.nameOfSubdivision FROM Subdivision s WHERE s.id NOT IN (SELECT ce.subdivision.id FROM CombatEquipment ce WHERE ce.nameOfEquipment = :nameOfEquipment)")
    List<String> findSubdivisionsWithNoEquipment(@Param("nameOfEquipment") String nameOfEquipment);



//
//    @Query("SELECT ce.subdivision.id FROM CombatEquipment ce WHERE ce.id = :equipmentId GROUP BY ce.subdivision.id HAVING COUNT(ce) > 5")
//    List<Long> findSubdivisionsWithMoreThanFiveEquipment(@Param("equipmentId") Long equipmentId);
//
//    @Query("SELECT s.id FROM Subdivision s WHERE s.id NOT IN (SELECT DISTINCT ce.subdivision.id FROM CombatEquipment ce WHERE ce.id = :equipmentId)")
//    List<Long> findSubdivisionsWithNoEquipment(@Param("equipmentId") Long equipmentId);


    /* my_query 6.1
        Obtain data on the availability of military equipment in general
     */
//    @Query("SELECT ce.nameOfEquipment, COUNT(s) " +
//            "FROM CombatEquipment ce " +
//            "LEFT JOIN ce.subdivisionList s " +
//            "GROUP BY ce.nameOfEquipment")
//    List<Object[]> getAvailabilityOfEquipment();
    
    /* my_query 6.2
    Obtain data on the availability of military equipment taking into account the specified
        type in specified subdivision part
    */
//    @Query("SELECT ce.nameOfEquipment, COUNT(s.id) " +
//            "FROM CombatEquipment ce " +
//            "LEFT JOIN ce.subdivisionList s " +
//            "LEFT JOIN s.typeOfSubdivision st " +
//            "WHERE st.nameOfType = :subdivisionType " +
//            "GROUP BY ce.nameOfEquipment")
//    List<Object[]> getAvailabilityBySubdivisionType(@Param("subdivisionType") String subdivisionType);
}
