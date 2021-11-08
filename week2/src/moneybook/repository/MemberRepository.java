package moneybook.repository;

import moneybook.domain.Member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRepository {

    private static final MemberRepository instance = new MemberRepository();
    private static Map<Long , Member> members = new HashMap<>();
    private static long sequence = 0L;
    private static boolean flag = false;

    public Member save(Member member) {
        member.setId(++sequence);
        members.put(sequence, member);
        flag = true;
        return member;
    }

    public boolean isFlag() {
        return flag;
    }

    public static MemberRepository getInstance() {
        return instance;
    }

    public Member findByIdMember(Long id) {
        return members.get(id);
    }

    public List<Member> findAllMember() {
        return new ArrayList<>(members.values());
    }

    public void clearMembers() {
        members.clear();
    }
}
