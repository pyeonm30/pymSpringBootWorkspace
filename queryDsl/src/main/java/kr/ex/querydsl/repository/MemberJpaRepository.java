package kr.ex.querydsl.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import kr.ex.querydsl.entity.Member;
import kr.ex.querydsl.entity.QMember;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static kr.ex.querydsl.entity.QMember.member;

@Repository
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberJpaRepository {
    private final EntityManager em; // 순수 jpa 쿼리 작성시필요하다
    private final JPAQueryFactory queryFactory; // queryDSL
//    public MemberJpaRepository(EntityManager em) {
//        this.em = em;
//        // this.queryFactory= jpaQueryFactory;
//        this.queryFactory =  new JPAQueryFactory(em);
//    }

    @Transactional
    public void save(Member member){
        em.persist(member);
    }

    public Optional<Member> findById(Long id){
        Member findMember = em.find(Member.class, id);
        return Optional.ofNullable(findMember);
    }

    public List<Member> findAll(){
        return em.createQuery("select m from Member m", Member.class).getResultList();
    }

    public List<Member> findByUsername(String username){
        return em.createQuery("select m from Member m where m.username=:username", Member.class)
                .setParameter("username", username)
                .getResultList();
    }

    ///------------- QueryDSL 사용

    public List<Member> findAll_QueryDsl(){
        // QMemer.member -> alt+enter -> static 변수로 만들 수 있음
        return queryFactory
                .selectFrom(member)
                .fetch();
    }

    public List<Member> findByUsername_QueryDsl(String username){
        return queryFactory
                .selectFrom(member)
                .where(member.username.eq(username))
                .fetch();
    }




}
