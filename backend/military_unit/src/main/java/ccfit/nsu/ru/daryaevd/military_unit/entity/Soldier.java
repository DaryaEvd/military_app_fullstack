package ccfit.nsu.ru.daryaevd.military_unit.entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
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

    @Column(name = "date_of_birth", nullable = false)
    private Date dateOfBirth;

    @Column(name = "military_card", nullable = false)
    private String militaryCard;

    @Column(name = "date_of_issue_of_military_card", nullable = false)
    private Date dateOfIssueMilitaryCard;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mas_id", referencedColumnName = "id")
    private Mas masId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "soldier_type_id", referencedColumnName = "id")
    private SoldierType soldierType;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "subdivision_id", referencedColumnName = "id")
//    private Subdivision subdivision;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "subdivision_id", referencedColumnName = "id", nullable = false)
    private Subdivision subdivision;


    @Column(name = "is_commander", nullable = false)
    private Boolean isCommander;
}
