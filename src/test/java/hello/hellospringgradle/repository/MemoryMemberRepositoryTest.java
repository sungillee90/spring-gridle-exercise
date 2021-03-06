package hello.hellospringgradle.repository;

import hello.hellospringgradle.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    // to test MMRT class you need to put this @AfterEach notation
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        System.out.println("result = " + (result == member));
//        Assertions.assertEquals(result, member);
        assertThat(member).isEqualTo(result);

    }

    @Test
    public void findByName() {
        Member m1 = new Member();
        m1.setName("Sung 1");

        repository.save(m1);

        Member m2 = new Member();
        m2.setName("Sung 2");

        repository.save(m2);

        Member result = repository.findByName("Sung 1").get();

        assertThat(result).isEqualTo(m1);

    }

    @Test
    public void findAll() {
        Member m1 = new Member();
        m1.setName("Sung 1");
        repository.save(m1);

        Member m2 = new Member();
        m1.setName("Sung 2");
        repository.save(m2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);

    }

}
