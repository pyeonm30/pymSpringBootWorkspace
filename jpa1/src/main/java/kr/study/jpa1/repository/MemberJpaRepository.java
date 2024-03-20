package kr.study.jpa1.repository;

import kr.study.jpa1.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
public class MemberJpaRepository implements MemberRepository{
    @Override
    public Member save(Member member) {
        return null;
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
