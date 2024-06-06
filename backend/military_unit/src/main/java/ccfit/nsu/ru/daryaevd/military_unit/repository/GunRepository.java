package ccfit.nsu.ru.daryaevd.military_unit.repository;

import ccfit.nsu.ru.daryaevd.military_unit.entity.Gun;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GunRepository extends JpaRepository<Gun, Long> {
    List<Gun> findBySubdivisionId(Long subdivisionId);

}