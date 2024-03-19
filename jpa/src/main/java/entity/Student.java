package entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name="student_tbl")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stuentId;
    private String name;
    private String grade;
    private Long majorId;

    public Student(String name, String grade) {
        this.name = name;
        this.grade = grade;
    }
}
