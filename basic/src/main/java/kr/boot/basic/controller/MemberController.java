package kr.boot.basic.controller;

import kr.boot.basic.domain.Member;
import kr.boot.basic.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MemberController {
    @Autowired
    MemberService memberService;
    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = null;
        model.addAttribute("members", members);
        return "members/memberList";
    }

}
