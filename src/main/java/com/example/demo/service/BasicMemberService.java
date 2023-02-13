package com.example.demo.service;

import com.example.demo.dto.LoginDto;
import com.example.demo.dto.SignUpDto;
import com.example.demo.entity.Member;
import com.example.demo.repository.MemberRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service // 서비스를 지정하는 어노테이션. 캡슐화없이 모델 내 단독 인터페이스로써 제공되는 동작을 의미
public class BasicMemberService  implements MemberService{

    private final MemberRepository memberRepository;

    private final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    public BasicMemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }
    @Override
    public String join(SignUpDto signUpDto){
        Member member = new Member(signUpDto.getUsername(), signUpDto.getPassword(), signUpDto.getName());
        if(isNotDuplicateUsername(member.getUsername())){
            memberRepository.save(member);
            return "회원가입 성공";
        }
        return "회원가입 실패 - username 중복";
    }

    private boolean isNotDuplicateUsername(String username){ // username 중복 확인
        Member findMember = memberRepository.findByUsername(username);
        if(findMember == null){ // username 같은 멤버가 없으면 true 반환
            return true;
        }
        return false; // username 같은 멤버가 있으면 false 반환
    }

    @Override
    public String login(LoginDto loginDto){
        Member findMember = memberRepository.findByUsername(loginDto.getUsername());
        if(findMember != null){ // username을 가진 member가 있다면
            log.info("해당 아이디 존재");
            if(loginDto.getPassword().equals(findMember.getPassword())){ // findmember의 password와 비교
                return "로그인 성공";
            }
        }
        return "로그인 실패";
    }
}
