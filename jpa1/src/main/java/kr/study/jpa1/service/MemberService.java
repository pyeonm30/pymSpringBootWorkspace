package kr.study.jpa1.service;


import kr.study.jpa1.domain.Member;

import kr.study.jpa1.repository.MemberJpaRepository;
import kr.study.jpa1.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true) // 읽기전용 트렌젝셔널 -> sql 저장소 빠진거
public class MemberService {
    private final MemberJpaRepository memberRepository;

    @Transactional // 읽기 , 쓰기(삭제, 수정 )
    public Long join(Member member ){
        Member m = memberRepository.save(member);
        log.trace("savedmember ={}" ,m );
        return m.getId();
    }

}
