package ccfit.nsu.ru.daryaevd.military_unit.repository;

import ccfit.nsu.ru.daryaevd.military_unit.dto.SubdivisionDto;
import ccfit.nsu.ru.daryaevd.military_unit.entity.Subdivision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository // todo: think
public interface SubdivisionRepository extends JpaRepository<Subdivision, Long> {
    @Query(""" 
            SELECT s.typeOfSubdivision.nameOfType AS subdivisionType, COUNT(s) AS unitCount  
            FROM Subdivision s  
            GROUP BY s.typeOfSubdivision.nameOfType  
            ORDER BY COUNT(s) DESC
            """)
    List<Object[]> findSubdivisionsWithMostMilitaryUnits();




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
