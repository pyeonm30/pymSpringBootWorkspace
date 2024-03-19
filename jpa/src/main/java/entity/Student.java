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
    @ManyToOne  // 관계 구성
    @JoinColumn(name="majorId")// 테이블 컬럼의 fk 명
    private Major major;

    public Student(String name, String grade) {
        this.name = name;
        this.grade = grade;
    }
}
