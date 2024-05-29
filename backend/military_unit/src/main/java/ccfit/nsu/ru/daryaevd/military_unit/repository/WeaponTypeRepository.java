package ccfit.nsu.ru.daryaevd.military_unit.repository;

import ccfit.nsu.ru.daryaevd.military_unit.entity.Subdivision;
import ccfit.nsu.ru.daryaevd.military_unit.entity.WeaponType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WeaponTypeRepository extends JpaRepository<WeaponType, Long> {

    List<WeaponType> findByWeaponCategory(String weaponCategory);

    List<WeaponType> findByWeaponCategoryAndSubdivisionId(String weaponCategory, Long subdivisionId);


    @Query("SELECT w.subdivision FROM WeaponType w WHERE w.weaponCategory = :category GROUP BY w.subdivision HAVING COUNT(w) > :count")
    List<Subdivision> findSubdivisionsWithWeaponCountGreaterThan(@Param("category") String category, @Param("count") Long count);



//    @Query("SELECT w.subdivision FROM WeaponType w WHERE w.weaponCategory = :category GROUP BY w.subdivision HAVING COUNT(w) > 3")
//    List<Subdivision> findSubdivisionsWithWeaponCountGreaterThanThree(@Param("category") String category);
//
//    @Query("SELECT s FROM Subdivision s WHERE s NOT IN (SELECT w.subdivision FROM WeaponType w WHERE w.weaponCategory = :category)")
//    List<Subdivision> findSubdivisionsWithoutWeaponCategory(@Param("category") String category);



//    @Query("SELECT w FROM WeaponType w WHERE w.dtype = :dtype")
//    List<WeaponType> findWeaponsByCategory(@Param("dtype") String dtype);
//
//    @Query("SELECT w FROM WeaponType w WHERE w.dtype = :dtype AND w.subdivision.id = :subdivisionId")
//    List<WeaponType> findWeaponsByCategoryAndSubdivision(@Param("dtype") String dtype, @Param("subdivisionId") Long subdivisionId);
//
//    @Query("SELECT w FROM WeaponType w")
//    List<WeaponType> findAllWeapons();

//    @Query("SELECT w FROM WeaponType w WHERE w.subdivision.id = :subdivisionId AND (TYPE(w) = :category OR w.nameOfType = :typeName)")
//    List<WeaponType> findByCategoryOrTypeNameAndSubdivision(@Param("subdivisionId") Long subdivisionId, @Param("category") Class<? extends WeaponType> category, @Param("typeName") String typeName);
//
//    List<WeaponType> findBySubdivisionId(Long subdivisionId);


}