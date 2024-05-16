package ccfit.nsu.ru.daryaevd.military_unit.repository;

import ccfit.nsu.ru.daryaevd.military_unit.entity.CombatEquipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CombatEquipmentRepository extends JpaRepository<CombatEquipment, Long> {

    /* my_query 6.1
        Obtain data on the availability of military equipment in general
     */
    @Query("SELECT ce.nameOfEquipment, COUNT(s) " +
            "FROM CombatEquipment ce " +
            "LEFT JOIN ce.subdivisionList s " +
            "GROUP BY ce.nameOfEquipment")
    List<Object[]> getAvailabilityOfEquipment();
    
    /* my_query 6.2
    Obtain data on the availability of military equipment taking into account the specified
        type in specified subdivision part
    */
    @Query("SELECT ce.nameOfEquipment, COUNT(s.id) " +
            "FROM CombatEquipment ce " +
            "LEFT JOIN ce.subdivisionList s " +
            "LEFT JOIN s.typeOfSubdivision st " +
            "WHERE st.nameOfType = :subdivisionType " +
            "GROUP BY ce.nameOfEquipment")
    List<Object[]> getAvailabilityBySubdivisionType(@Param("subdivisionType") String subdivisionType);

}
