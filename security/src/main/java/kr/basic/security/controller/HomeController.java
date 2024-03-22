package kr.basic.security.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class HomeController {
    @GetMapping({"","/"})
    public String home(){
        return "index";
    }
    @GetMapping({"/loginForm"})
    public String login() {
        return "loginForm";
    }

    @GetMapping({"/joinForm"})
    public String join() {
        return "joinForm";
    }
}
