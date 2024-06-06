package ccfit.nsu.ru.daryaevd.military_unit.specification;

import ccfit.nsu.ru.daryaevd.military_unit.entity.Soldier;
import ccfit.nsu.ru.daryaevd.military_unit.entity.Subdivision;
import ccfit.nsu.ru.daryaevd.military_unit.entity.SubdivisionType;
import jakarta.persistence.criteria.Join;
import org.springframework.data.jpa.domain.Specification;

public class SoldierSpecifications {
    public static Specification<Soldier> hasRankBetween(Integer minRank, Integer maxRank) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.between(root.get("soldierType").get("typeRank"), minRank, maxRank);
    }

    public static Specification<Soldier> hasRank(Integer rank) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("soldierType").get("typeRank"), rank);
    }

    public static Specification<Soldier> hasSubdivisionRank(Integer subdivisionRank) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("subdivision").get("typeOfSubdivision").get("subdivisionRank"), subdivisionRank);
    }
}
