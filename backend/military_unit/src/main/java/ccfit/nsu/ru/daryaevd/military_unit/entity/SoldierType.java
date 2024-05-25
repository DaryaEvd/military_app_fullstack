package ccfit.nsu.ru.daryaevd.military_unit.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "soldier_type")
public class SoldierType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_of_type", unique = true, nullable = false)
    private String nameOfType;

    @Column(name = "type_rank", unique = true, nullable = false)
    private Integer typeRank;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "soldierType", cascade = CascadeType.ALL)
    private List<Soldier> soldierList;
}
