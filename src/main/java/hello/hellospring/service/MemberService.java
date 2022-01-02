package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService { //회원 서비스

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    /*
    * 회원가입
    * */
    public Long join (Member member) {
        //같은 이름이 있는 중복 회원은 안된다.
        Optional<Member> result = memberRepository.findByName(member.getName());
        //memberRepository.findByName(member.getName()); 를 선택하고
        //ctrl+alt+v 하면 나옴!
        result.ifPresent(member1 -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
        //result가 값이 있으면...
        memberRepository.save(member);
        return member.getId();
    }

    /*
    * 전체 회원 조회
    * */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
