package ccfit.nsu.ru.daryaevd.military_unit.repository;

import ccfit.nsu.ru.daryaevd.military_unit.entity.Soldier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SoldierRepository extends JpaRepository<Soldier, Long> {
    /* query 2
    Получить данные по офицерскому составу в целом и по офицерскому составу указанного звания
    всех частей военного округа, отдельной армии, дивизии, корпуса, военной части.

    Obtain data on the officer corps as a whole and on the officer corps of the specified rank
    of all units of the military district, separate army, division, corps, military unit.
     */

    /* query 2.1
    Get data on the officer corps as a whole
     */
    List<Soldier> findBySoldierTypeTypeRankBetween(Integer minRank, Integer maxRank);

}
