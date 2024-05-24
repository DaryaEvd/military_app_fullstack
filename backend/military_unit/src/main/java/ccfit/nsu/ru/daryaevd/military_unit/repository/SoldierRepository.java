package ccfit.nsu.ru.daryaevd.military_unit.repository;

import ccfit.nsu.ru.daryaevd.military_unit.entity.Soldier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SoldierRepository extends JpaRepository<Soldier, Long> {
    @Query("SELECT s FROM Soldier s WHERE s.soldierType.typeRank BETWEEN 5 AND 10")
    List<Soldier> findOfficersByRankRange();

    /* my_query 2
    Получить данные по офицерскому составу в целом и по офицерскому составу указанного звания
    всех частей военного округа, отдельной армии, дивизии, корпуса, военной части.

    Obtain data on the officer corps as a whole and on the officer corps of the specified rank
    of all units of the military district, separate army, division, corps, military unit.
     */

    /* my_query 2.1
    Get data on the officer corps as a whole
     */
//    List<Soldier> findBySoldierTypeTypeRankBetween(Integer minRank, Integer maxRank);

    /* my_query 2.2
    Получить данные по офицерскому составу указанного звания всех частей военного округа,
    отдельной армии, дивизии, корпуса, военной части.

    Obtain data on the officers of the specified rank of all units of a military
    district, separate army, division, corps, military unit.
     */
//    @Query("SELECT s FROM Soldier s " +
//            "JOIN s.subdivisions sub " +
//            "JOIN sub.typeOfSubdivision st " +
//            "WHERE s.soldierType.typeRank BETWEEN :minRank AND :maxRank " +
//            "AND st.subdivisionRank = :subdivisionTypeRank")
//    List<Soldier> findOfficersByTypeAndSubdivisionTypeRank(@Param("minRank") Integer minRank,
//                                                           @Param("maxRank") Integer maxRank,
//                                                           @Param("subdivisionTypeRank") Integer subdivisionTypeRank);

    /* my_query 3.1
    Получить данные по рядовому и сержантскому составу в целом
     */
//    List<Soldier> findBySoldierType_TypeRankBetween(Integer lowerRank, Integer upperRank);

    /* my_query 3.2
    Получить данные по рядовому и сержантскому составу с учетом указанного звания всех частей
    военного округа, отдельной армии, дивизии, корпуса, военной части.
    */
//    List<Soldier> findBySoldierType_TypeRankBetweenAndSubdivisions_TypeOfSubdivision_SubdivisionRank(
//            Integer lowerRank, Integer upperRank, Integer subdivisionRank);


    /* my_query 11
    Receive a list of soldiers of the specified mas in the specified military subdivision
     */
//    List<Soldier> findByMasIdAndSubdivisions_NameOfSubdivision(Long masId, String subdivisionName);

}
