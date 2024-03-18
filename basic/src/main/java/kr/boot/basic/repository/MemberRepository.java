package kr.boot.basic.repository;

import kr.boot.basic.domain.Member;

import java.util.List;

public interface MemberRepository {
    Member save(Member member);
    Member findById(Long id);
    Member findByName(String name);
    List<Member> findAll();
}
