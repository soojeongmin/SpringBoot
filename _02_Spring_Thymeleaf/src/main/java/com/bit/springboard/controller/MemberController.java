package com.bit.springboard.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/member")
public class MemberController {
    // @Controller를 사용해서 Controller bean 객첼르 생성했을 떄는 String 값을 리턴했을 때 ViewResolver가 동작했지만
    // @RestController에서 String 값을 리턴하면 ViewResolver가 동작하지 않고 String 값을 그대로 리턴한다.
    // @RestController에서 화면을 리턴하기 위해서는 ModelAndView 객체를 리턴해야 한다.
    @GetMapping("/join")
    public ModelAndView joinView() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("name", "bitcamp");
        mav.setViewName("member/join");
        return mav;
    }

    @GetMapping("/login")
    public ModelAndView loginView() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("member/login");
        return mav;
    }
}
