package ccfit.nsu.ru.daryaevd.military_unit.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @Column(name = "name_of_type", nullable = false)
    private String nameOfType;

//    @Column(name = "type_rank", nullable = false)
    @Column(name = "type_rank", nullable = false /*, columnDefinition = "INT CHECK (type_rank >= 0 AND type_rank < 11)"*/)
    private Integer typeRank;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "soldier_id", referencedColumnName = "id")
    private Soldier soldier;
}
