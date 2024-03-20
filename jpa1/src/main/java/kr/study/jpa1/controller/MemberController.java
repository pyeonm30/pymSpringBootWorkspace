package kr.study.jpa1.controller;

import kr.study.jpa1.domain.Member;
import kr.study.jpa1.form.MemberForm;
import kr.study.jpa1.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService service;

    @GetMapping
    public String joinForm(){
        return "member/joinForm";
    }
    @PostMapping
    public String joinMember(@ModelAttribute MemberForm form ){
        //System.out.println("memberForm = " + memberForm);
        log.trace("memberForm ={}" , form);
        Member member = Member.builder()
                .password(form.getPw())
                .loginId(form.getId())
                .name(form.getName())
                .build();
        log.trace("member ={}" , member);

        service.join(member);


        return "redirect:/";
    }
}
