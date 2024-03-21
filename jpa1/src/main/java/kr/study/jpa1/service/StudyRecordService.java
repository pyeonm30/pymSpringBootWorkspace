package kr.study.jpa1.service;

import kr.study.jpa1.domain.Member;
import kr.study.jpa1.domain.StudyRecode;
import kr.study.jpa1.form.StudyForm;
import kr.study.jpa1.repository.StudyRecodeRepositroy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class StudyRecordService {
    private final StudyRecodeRepositroy recodeRepositroy;

    public void saveRecord(StudyForm form , Member member){
        StudyRecode recode = StudyRecode.createRecord(form,member);
        recodeRepositroy.save(recode);

    }
    public List<StudyRecode> getAllRecodes(){
        return recodeRepositroy.selectAll();
    }

}
