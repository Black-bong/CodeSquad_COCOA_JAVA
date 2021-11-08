package moneybook.test;

import moneybook.domain.Member;
import moneybook.repository.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MemberRepositoryTest {

    @BeforeEach
    void clear() {
        MemberRepository memberRepository = new MemberRepository();
        memberRepository.clearMembers();
    }

    @Test
    @DisplayName("멤버 저장 확인")
    void saveMember() {
        MemberRepository memberRepository = new MemberRepository();
        Member member = new Member("blackBong", "1234");

        memberRepository.save(member);

        Assertions.assertEquals(member.getId(), 1L);
        Assertions.assertEquals(member.getUsername(), "blackBong");
    }

    @Test
    @DisplayName("멤버 삭제 확인")
    void removeMember() {

    }
}