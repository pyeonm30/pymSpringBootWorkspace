package kr.ex.querydsl.controller;

import kr.ex.querydsl.entity.Member;
import kr.ex.querydsl.repository.MemberJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberJpaRepository memberRepository;
    @GetMapping("/home")
    public String home(){
        return "홈이야";
    }

    @PostMapping("/member")
    public String addMember(Member member){
        memberRepository.save(member);
        return "회원생성 완료";
    }

    @GetMapping("/member/{username}")
    public String findByUsername(@PathVariable String username){
        Member findMember = memberRepository.findByUsername(username).get(0);
        return findMember == null?"해당 이름 회원없음" : findMember.toString();
    }
    @GetMapping("/member/{id}")
    public String findByUsername(@PathVariable Long id){
        Member findMember = memberRepository.findById(id).get();
        return findMember == null?"해당 번호 회원없음" : findMember.toString();
    }


}
