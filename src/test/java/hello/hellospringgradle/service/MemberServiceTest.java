package hello.hellospringgradle.service;

import hello.hellospringgradle.domain.Member;
import hello.hellospringgradle.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService = new MemberService();
    MemoryMemberRepository memberRepository = new MemoryMemberRepository();

    @AfterEach
    public void afterEAch() {
        memberRepository.clearStore();
    }

    @Test
    void join() {
        //given
        Member member = new Member();
        member.setName("hello");

        //when
        Long savedId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(savedId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void duplicateException() {
        //given
        Member m1 = new Member();
        m1.setName("spring");

        Member m2 = new Member();
        m2.setName("spring");

        //when
        memberService.join(m1);

        try {
            memberService.join(m2);
            fail();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
        //then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}