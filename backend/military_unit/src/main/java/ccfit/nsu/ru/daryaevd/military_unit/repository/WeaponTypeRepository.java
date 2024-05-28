package ccfit.nsu.ru.daryaevd.military_unit.repository;

import ccfit.nsu.ru.daryaevd.military_unit.entity.WeaponType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WeaponTypeRepository extends JpaRepository<WeaponType, Long> {

    @Query("SELECT w FROM WeaponType w WHERE w.subdivision.id = :subdivisionId AND (TYPE(w) = :category OR w.nameOfType = :typeName)")
    List<WeaponType> findByCategoryOrTypeNameAndSubdivision(@Param("subdivisionId") Long subdivisionId, @Param("category") Class<? extends WeaponType> category, @Param("typeName") String typeName);

    List<WeaponType> findBySubdivisionId(Long subdivisionId);


}