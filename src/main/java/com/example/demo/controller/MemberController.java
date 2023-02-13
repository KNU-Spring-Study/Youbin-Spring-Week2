package com.example.demo.controller;

import com.example.demo.dto.LoginDto;
import com.example.demo.dto.SignUpDto;
import com.example.demo.entity.Member;
import com.example.demo.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    /**
     * 회원 가입
     */
    @PostMapping("users/join")
    @ResponseBody
    public String userJoin(@RequestBody SignUpDto signUpDto){
        // Controller에서 직접 Member 객체를 사용하여 데이터를 받거나 전송하는 것은 좋지 않다. 간단히 하기 위해 Member 객체 사용 -> 그럼 어케하는게 좋은지?
        return memberService.join(signUpDto);
    }

    /**
     * 로그인
     */
    @PostMapping("users/login")
    @ResponseBody
    public String userLogin(@RequestBody LoginDto loginDto){
        return memberService.login(loginDto);
    }

}
