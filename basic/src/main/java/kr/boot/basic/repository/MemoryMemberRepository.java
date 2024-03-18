package kr.boot.basic.repository;

import kr.boot.basic.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.List;
// DAO
@Repository
public class MemoryMemberRepository implements MemberRepository{
    @Override
    public Member save(Member member) {
        return null;
    }

    @Override
    public Member findById(Long id) {
        return null;
    }

    @Override
    public Member findByName(String name) {
        return null;
    }

    @Override
    public List<Member> findAll() {
        return null;
    }
}
