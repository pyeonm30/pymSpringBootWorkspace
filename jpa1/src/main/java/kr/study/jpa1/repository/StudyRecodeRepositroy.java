package kr.study.jpa1.repository;

import kr.study.jpa1.domain.Member;
import kr.study.jpa1.domain.StudyRecode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudyRecodeRepositroy extends JpaRepository<StudyRecode, Long> {
    @Query(value="select m.member_id, r.study_id, r.contents, r.start_time, r.study_day, r.study_mins from member m , study_recode r where m.member_id = r.member_id", nativeQuery = true)
    List<StudyRecode> selectAll();

    @Query(value="select * from study_recode where member_id =:memberId", nativeQuery = true)
    List<StudyRecode> searchStudyRecodeByMemberId(@Param(value="memberId") Long memberId);

    //delete study_recode where member_id = memberId;
    void deleteByMember(Member member);


}
