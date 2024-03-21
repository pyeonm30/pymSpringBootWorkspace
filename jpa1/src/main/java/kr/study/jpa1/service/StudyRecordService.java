package kr.study.jpa1.service;

import kr.study.jpa1.domain.Member;
import kr.study.jpa1.domain.StudyRecode;
import kr.study.jpa1.form.StudyForm;
import kr.study.jpa1.repository.StudyRecodeRepositroy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StudyRecordService {
    private final StudyRecodeRepositroy recodeRepositroy;

    @Transactional
    public void saveRecord(StudyForm form , Member member){
        StudyRecode recode = StudyRecode.createRecord(form,member);
        recodeRepositroy.save(recode);

    }
    public List<StudyRecode> getAllRecodes() {
        return recodeRepositroy.selectAll();
    }

    public StudyRecode getOneRecord(Long id){
        return recodeRepositroy.findById(id).get();
    }

    @Transactional
    public void updateRecord( StudyForm form , StudyRecode recode ){
        StudyRecode updateRecode = StudyRecode.modyfiyRecord(form, recode);
        recodeRepositroy.save(updateRecode);

    }

}
