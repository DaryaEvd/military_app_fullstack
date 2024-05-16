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

        @Column(name = "date_of_birth", nullable = false)
        private Date dateOfBirth;

        @Column(name = "military_card", nullable = false)
        private String militaryCard;

        // todo: this doesn't allow normal data like 01.01.1991. fix it
        @Column(name = "date_of_issue_of_military_card", nullable = false)
        private Date dateOfIssueMilitaryCard;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "mas_id", referencedColumnName = "id")
        private Mas mas;

        @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
        @JoinTable(name = "commander_table",
                joinColumns = @JoinColumn(name = "soldier_id"),
                inverseJoinColumns = @JoinColumn(name = "subdivision_id"))
        private List<Subdivision> subdivisions;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "soldier_type", /*referencedColumnName = "id",*/ nullable = false)
        private SoldierType soldierType;
    }
