package ccfit.nsu.ru.daryaevd.military_unit.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @Column(name = "subdivision_rank", nullable = false)
    private Integer subdivisionRank;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "typeOfSubdivision", cascade = CascadeType.ALL)
    private List<Subdivision> subdivisionList;
}
