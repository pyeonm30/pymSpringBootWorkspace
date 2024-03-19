package kr.boot.basic.repository;

import kr.boot.basic.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SpringMemberRepository extends JpaRepository<Member, Long> {
}
