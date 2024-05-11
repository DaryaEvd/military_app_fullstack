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
@Table(name = "subdivision_type")
public class SubdivisionType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_of_type", unique = true, nullable = false)
    private String nameOfType;

    @Column(name = "type_rank", /*unique = true,*/ nullable = false
            /*, columnDefinition = "INT CHECK (rank_subdiv > 0 AND rank_subdiv < 5)"*/)
    private Integer subdivisionRank;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "typeOfSubdivision", cascade = CascadeType.ALL)
    private List<Subdivision> subdivisionList;
}
