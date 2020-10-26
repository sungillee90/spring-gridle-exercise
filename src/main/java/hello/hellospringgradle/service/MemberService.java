package hello.hellospringgradle.service;

import hello.hellospringgradle.domain.Member;
import hello.hellospringgradle.repository.MemberRepository;
import hello.hellospringgradle.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    // Register
    public Long join(Member member) {

        // if there is DUPLICATE, it cannot happen
        // try cmd + opt + v
        validateDuplicateMember(member);
//        Optional<Member> result = memberRepository.findByName(member.getName());
//        result.ifPresent(m -> {
//            throw new IllegalThreadStateException("Username is already exist. Do you remember?");
//        });

        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("User already exist");
                });
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
