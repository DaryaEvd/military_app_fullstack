package ccfit.nsu.ru.daryaevd.military_unit.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @Column(name = "date_of_birth", nullable = false)
    private Date dateOfBirth;

    @Column(name = "military_card", nullable = false)
    private String militaryCard;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @Column(name = "date_of_issue_of_military_card", nullable = false)
    private Date dateOfIssueMilitaryCard;




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
