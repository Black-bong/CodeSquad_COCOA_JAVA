package test.moneybookrepositorytest;

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
        Member member1 = new Member("blackBong1", "1");
        memberRepository.save(member1);
        Member member2 = new Member("blackBong2", "12");
        memberRepository.save(member2);
        Member member3 = new Member("blackBong3", "123");
        memberRepository.save(member3);

        Assertions.assertSame(memberRepository.isSameMember("blackBong1", "1"), true);
        Assertions.assertSame(memberRepository.isSameMember("blackBong2", "12"), true);
        Assertions.assertSame(memberRepository.isSameMember("blackBong3", "123"), true);
        Assertions.assertSame(memberRepository.isSameMember("black", "123"), false);
        Assertions.assertSame(memberRepository.isSameMember("blackBong3", "1"), false);
    }

    @Test
    @DisplayName("멤버 삭제 확인")
    void removeMember() {

    }
}