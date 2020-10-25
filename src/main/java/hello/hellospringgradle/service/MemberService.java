package hello.hellospringgradle.service;

import hello.hellospringgradle.domain.Member;
import hello.hellospringgradle.repository.MemberRepository;
import hello.hellospringgradle.repository.MemoryMemberRepository;

public class MemberService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    // Register
    public Long join(Member member) {
        memberRepository.save(member);
        return member.getId();
    }
}
