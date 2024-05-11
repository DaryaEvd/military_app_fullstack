package ccfit.nsu.ru.daryaevd.military_unit.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "mas_type")
public class Mas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_of_mas", unique = true, nullable = false)
    private String nameOfMas;

    @Column(name = "code_of_mas", unique = true, nullable = false)
    private String codeOfMas;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "mas")
    private List<Soldier> soldiers;
}
