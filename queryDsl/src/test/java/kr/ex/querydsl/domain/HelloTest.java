package kr.ex.querydsl.domain;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest  // 통합테스트 : 스프링부트 시작처럼 root-context : db 객체 -> em
@Transactional // 트렌지션을 열어야지만 db에 값 전달 가능 transitiaonal.commit() -> rollback()
class HelloTest {
    @Autowired
    EntityManager em;

    @Test
    void firstTest(){
        Hello hello = new Hello();
        em.persist(hello);

    }


}