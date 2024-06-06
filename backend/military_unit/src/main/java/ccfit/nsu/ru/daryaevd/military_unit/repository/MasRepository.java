package ccfit.nsu.ru.daryaevd.military_unit.repository;

import ccfit.nsu.ru.daryaevd.military_unit.entity.Mas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MasRepository extends JpaRepository<Mas, Long> {

    @Query("SELECT m FROM Mas m LEFT JOIN m.soldiers s GROUP BY m.id HAVING COUNT(s) > 5")
    List<Mas> findMasWithMoreThanFiveSpecialists();

    @Query("SELECT m FROM Mas m LEFT JOIN m.soldiers s GROUP BY m.id HAVING COUNT(s) = 0")
    List<Mas> findMasWithNoSpecialists();

    @Query("SELECT m FROM Mas m LEFT JOIN m.soldiers s WHERE s.subdivision.id = :subdivisionId GROUP BY m.id HAVING COUNT(s) > 5")
    List<Mas> findMasWithMoreThanFiveSpecialistsBySubdivision(@Param("subdivisionId") Long subdivisionId);

    @Query("SELECT m FROM Mas m LEFT JOIN m.soldiers s WHERE s.subdivision.id = :subdivisionId GROUP BY m.id HAVING COUNT(s) = 0")
    List<Mas> findMasWithNoSpecialistsBySubdivision(@Param("subdivisionId") Long subdivisionId);



    /* my_query 10
    Obtain a list of military specialties for which there are more than five
    specialists in a particular subdivision (there are no specialists).
     */
//    @Query("SELECT m.nameOfMas " +
//            "FROM Mas m " +
//            "LEFT JOIN m.soldiers s " +
//            "LEFT JOIN s.subdivisions st " +
//            "GROUP BY m.nameOfMas " +
//            "HAVING COUNT(s.id) > 5 OR COUNT(s.id) = 0")
//    List<String> findMasWithMoreThanFiveSoldiersOrNone();

}
