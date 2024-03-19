package entity;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name="student_tbl")
@ToString(exclude = "major")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stuentId;
    private String name;
    private String grade;               // fetch = FetchType.LAZY 지연 로딩
    @ManyToOne(fetch = FetchType.LAZY)  // 관계 구성    FetchType.EAGER(기본값): 즉시로딩 : 연관되어있는 모든 테이블 다 가져오기
    @JoinColumn(name="majorId")// 테이블 컬럼의 fk 명
    private Major major;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id")
    private Locker locker;

    public Student(String name, String grade) {
        this.name = name;
        this.grade = grade;
    }


}
