package ccfit.nsu.ru.daryaevd.military_unit.repository;

import ccfit.nsu.ru.daryaevd.military_unit.entity.Mas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MasRepository extends JpaRepository<Mas, Long> {
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
