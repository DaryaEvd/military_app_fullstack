package ccfit.nsu.ru.daryaevd.military_unit.repository;

import ccfit.nsu.ru.daryaevd.military_unit.entity.Artillery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArtilleryRepository extends JpaRepository<Artillery, Long> {
    List<Artillery> findBySubdivisionId(Long subdivisionId);

}
