package kr.study.jpa1.form;

import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@Builder  // 생성할때만 초기값 넣을 수 있음
public class StudyForm {
    private String memberId;
    private String studeyDay; // 미래시간 선택x 현재, 과거 선택
    private String startTime; // 오후 6:10
    private int studyMins; // 40
    private String contents;
//    @OneToMany(mappedBy = "member")
//    private List<Record> records;
}
