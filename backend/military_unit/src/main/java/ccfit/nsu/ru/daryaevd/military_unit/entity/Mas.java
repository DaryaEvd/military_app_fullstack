package ccfit.nsu.ru.daryaevd.military_unit.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data // todo: maybe delete?
@Entity
@Table(name = "mas_type")
public class Mas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_of_mas", nullable = false)
    private String nameOfMas;

    @Column(name = "code_of_mas", nullable = false)
    private String codeOfMas;


    /*
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Rating> ratings;
     */
//    @OneToMany(mappedBy = "mas", cascade = CascadeType.ALL,
//            fetch = FetchType.EAGER)
//    @JoinColumn(name = "mas_id", referencedColumnName = "id")
//    private List<Soldier> soldiers = new ArrayList<>();


    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "mas")
    private List<Soldier> soldiers;
}
