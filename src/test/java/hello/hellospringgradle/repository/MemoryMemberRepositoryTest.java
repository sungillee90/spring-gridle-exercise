package hello.hellospringgradle.repository;

import hello.hellospringgradle.domain.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class MemoryMemberRepositoryTest {
    MemberRepository repository = new MemoryMemberRepository();

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();

        System.out.println("result = " + (result == member));

        Assertions.assertEquals(result, member);
    }

    @Test
    public void findByName() {
        Member m1 = new Member();
        m1.setName("Sung");
    }

}
