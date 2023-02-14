package com.example.demo.service;

import com.example.demo.dto.LoginDto;
import com.example.demo.dto.MyPageResponseDto;
import com.example.demo.dto.SignUpDto;
import com.example.demo.entity.Member;
import com.example.demo.repository.MemberRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service // 서비스를 지정하는 어노테이션. 캡슐화없이 모델 내 단독 인터페이스로써 제공되는 동작을 의미
public class BasicMemberService  implements MemberService{

    private final MemberRepository memberRepository;

    private final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    public BasicMemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    /**
     * 회원 가입
     */
    @Override
    public String join(SignUpDto signUpDto){
        Member member = new Member(signUpDto.getUsername(), signUpDto.getPassword(), signUpDto.getName(), signUpDto.getPhoneNumber());
        if(isNotDuplicateUsername(member.getUsername())){
            memberRepository.save(member);
            return "회원가입 성공";
        }
        return "회원가입 실패 - username 중복";
    }


    /**
     * 로그인
     */
    @Override
    public String login(LoginDto loginDto){
       if(isPasswordCorrect(loginDto.getUsername(), loginDto.getPassword())){
           return "로그인 성공";
       }
       return "로그인 실패";
    }


    /**
     * 마이페이지 (회원정보조회)
     */
    @Override
    public MyPageResponseDto mypage(@RequestParam String username){

            if(!isNotDuplicateUsername(username)){ // 중복 확인을 통해 해당 username이 존재하는지 확인
                MyPageResponseDto myPageResponseDto = new MyPageResponseDto();
                Member findMember = memberRepository.findByUsername(username);
                myPageResponseDto.setUsername(findMember.getUsername());
                myPageResponseDto.setName(findMember.getName());
                myPageResponseDto.setPhoneNumber(findMember.getPhoneNumber());

                return myPageResponseDto;
            }
            return null;
    }

    private boolean isNotDuplicateUsername(String username){ // username 중복 확인
        Member findMember = memberRepository.findByUsername(username);
        if(findMember == null){ // username 같은 멤버가 없으면 true 반환
            return true;
        }
        return false; // username 같은 멤버가 있으면 false 반환
    }

    public boolean isPasswordCorrect(String username, String password){ // username과 password 일치하는지 확인
        Member findMember = memberRepository.findByUsername(username);
        if(findMember != null){
            if(password.equals(findMember.getPassword())){
                return true;
            }
        }
        return false;
    }
}
