package kr.study.jpa1.repository;

import jakarta.persistence.EntityManager;
import kr.study.jpa1.domain.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
@RequiredArgsConstructor
public class MemberJpaRepository implements MemberRepository{

    private final EntityManager em;

//    @Autowired   --> @RequiredArgsConstructor 동일하다
//    public MemberJpaRepository(EntityManager em){
//        this.em = em;
//    }

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public List<Member> findAll() {
        return null;
    }

    @Override
    public Member findById(Long id) {
        return null;
    }

    @Override
    public Member findByLoginId(String loginId) {
        return null;
    }

    @Override
    public Member deleteById(Long id) {
        return null;
    }
}
