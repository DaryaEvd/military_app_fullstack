package ccfit.nsu.ru.daryaevd.military_unit.repository;

import ccfit.nsu.ru.daryaevd.military_unit.entity.Soldier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SoldierRepository extends JpaRepository<Soldier, Long> {

}
