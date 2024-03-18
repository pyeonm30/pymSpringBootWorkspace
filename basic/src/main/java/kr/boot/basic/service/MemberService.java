package kr.boot.basic.service;

import kr.boot.basic.domain.Member;
import kr.boot.basic.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private final MemberRepository memberRepository;
    public MemberService(MemberRepository repository){
        this.memberRepository = repository;
    }

//    회원가입
    public void join(Member member){
        if(!validateDuplicateMember(member)) {
            memberRepository.save(member);
        }else{
            System.out.println(" 이미 존재하는 회원 입니다 ");
        }
    }

    // 아이디 중복검사
    private boolean validateDuplicateMember(Member member){
//       if(memberRepository.findById(member.getId()) != null){
//           throw new IllegalArgumentException("이미 존재하는 회원입니다");
//       }
//        memberRepository.findById(member.getId())
//                .ifPresent( m -> {throw new IllegalArgumentException("이미 존재하는 회원입니다");});
        return memberRepository.findById(member.getId()).isPresent();
    }

}
