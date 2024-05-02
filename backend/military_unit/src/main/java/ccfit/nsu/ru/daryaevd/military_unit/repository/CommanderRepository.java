package ccfit.nsu.ru.daryaevd.military_unit.repository;

import ccfit.nsu.ru.daryaevd.military_unit.entity.Commander;
import ccfit.nsu.ru.daryaevd.military_unit.entity.MilitaryBuilding;
import org.springframework.data.jpa.repository.JpaRepository;

// todo: подумац, тут только long или вместо это го чеот
public interface CommanderRepository extends JpaRepository<Commander, Long> {
}