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
@Table(name = "subdivision_type")
public class SubdivisionType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_of_type", nullable = false)
    private String nameOfType;

//    @Column(name = "rank_subdiv", nullable = false)
    @Column(name = "type_rank", nullable = false
            /*, columnDefinition = "INT CHECK (rank_subdiv > 0 AND rank_subdiv < 5)"*/)
    private Integer subdivisionRank;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "subdivision_id", referencedColumnName = "id")
//    private Subdivision subdivision;
}
