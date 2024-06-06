package ccfit.nsu.ru.daryaevd.military_unit.repository;

import ccfit.nsu.ru.daryaevd.military_unit.entity.RocketWeapon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RocketWeaponRepository extends JpaRepository<RocketWeapon, Long> {
    List<RocketWeapon> findBySubdivisionId(Long subdivisionId);

}
