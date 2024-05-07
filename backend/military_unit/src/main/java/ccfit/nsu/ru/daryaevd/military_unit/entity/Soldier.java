package ccfit.nsu.ru.daryaevd.military_unit.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString(exclude = "soldiers") // todo: think
@EqualsAndHashCode
@Entity
@Table(name = "soldier_table")
public class Soldier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    /// todo: think
//    @OneToMany(mappedBy = "subdivision")
//    private List<Commander> commanders;
    ///


    @ManyToMany(mappedBy = "soldiers")
    private List<Subdivision> subdivisions;



    //    @JsonDeserialize(using = LocalDateDeserializer.class)
//    @JsonSerialize(using = LocalDateSerializer.class)
    @Column(name = "date_of_birth", nullable = false)
    private Date dateOfBirth;

    @Column(name = "military_card", nullable = false)
    private String militaryCard;

    // todo: this doesn't allow normal data like 01.01.1991. fix it
//    @JsonDeserialize(using = LocalDateDeserializer.class)
//    @JsonSerialize(using = LocalDateSerializer.class)
    @Column(name = "date_of_issue_of_military_card", nullable = false)
    private Date dateOfIssueMilitaryCard;

//    @Column(name = "mas_id")
//    private Long masId;
//    @ManyToOne
//    @JoinColumn(name = "mas_id")
//    private Mas mas;

    /*
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "productId")
    private Product product;
     */

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mas_id", referencedColumnName = "id")
    private Mas mas;

    @Column(name = "soldier_id")
    Long soldierId;

    @Column(name = "subdivision_id")
    Long subdivisionId;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "subdivision_soldier",
              joinColumns = @JoinColumn(name = "subdivision_id"),
    inverseJoinColumns = @JoinColumn(name = "soldier_id"))
    private Set<Soldier> soldiers = new LinkedHashSet<>();

    /* TODO: think about it later
    soldier_type_id INT NOT NULL,
	FOREIGN KEY (soldier_type_id) REFERENCES soldier_type (id),

	subdivision INT NOT NULL,
	FOREIGN KEY (subdivision) REFERENCES subdivision_table (id),

	mas INT NOT NULL,
	FOREIGN KEY (mas) REFERENCES mas_table (id),

	commander INT NOT NULL,
	FOREIGN KEY (commander) REFERENCES commander_table(id),
     */
}
