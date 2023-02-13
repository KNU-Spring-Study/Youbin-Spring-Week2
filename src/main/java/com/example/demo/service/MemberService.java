package com.example.demo.service;

import com.example.demo.dto.LoginDto;
import com.example.demo.dto.MyPageRequestDto;
import com.example.demo.dto.MyPageResponseDto;
import com.example.demo.dto.SignUpDto;
import com.example.demo.entity.Member;


/**
 * MerverService 인터페이스
 */

public interface MemberService {

    String join(SignUpDto signUpDto);
    String login(LoginDto loginDto);
    MyPageResponseDto mypage(MyPageRequestDto myPageRequestDto);
}
