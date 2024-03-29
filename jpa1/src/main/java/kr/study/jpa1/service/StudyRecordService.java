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
import java.util.Optional;

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
    public List<StudyRecode> getAllRecodesFindAll() {
        return recodeRepositroy.findAll();
    }

    public StudyRecode getOneRecord(Long id){
        Optional<StudyRecode> recode = recodeRepositroy.findById(id);
        return recode.isPresent()? recode.get() : null;
    }

    @Transactional
    public void updateRecord( StudyForm form , StudyRecode recode ){
        StudyRecode updateRecode = StudyRecode.modyfiyRecord(form, recode);
        recodeRepositroy.save(updateRecode);

    }

    @Transactional
    public void deleteRecord(Long id){
        recodeRepositroy.deleteById(id);
    }

    @Transactional
    public void deleteAllRecordByMember(Member member){
        List<StudyRecode> list = recodeRepositroy.searchStudyRecodeByMemberId(member.getId());
        if(list != null){
            list.forEach(recode -> {
                log.trace("delete recode={}" , recode);
                recodeRepositroy.deleteByMember(recode.getMember());
            });
        }
    }

}
