package marsal.Attendence.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "attendance")
public class AtendenceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade =CascadeType.ALL)
    @JoinColumn(name = "student_id", nullable = false)
    private StudentsEntity student;


    @Column(name = "date")
    private LocalDate date;

    @Column(name = "status")
    private String status; // Values can be "Present", "Absent", "Late"



}
