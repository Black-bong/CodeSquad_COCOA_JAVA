package moneybook.repository;

import moneybook.domain.Member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRepository {

    private static final MemberRepository instance = new MemberRepository();
    private static final Map<Long, Member> members = new HashMap<>();
    private static long sequence = 0L;

    public Member save(Member member) {
        member.setId(++sequence);
        members.put(sequence, member);
        return member;
    }

    public boolean memberIsValid() {
        return sequence == 0L;
    }

    public static MemberRepository getInstance() {
        return instance;
    }

    public boolean isSameMember(String n, String p) {
        for (Member value : findAllMember()) {
            if (value.isSameUserName(n)) {
                return value.isSamePassword(p);
            }
        }
        return false;
    }

    public List<Member> findAllMember() {
        return new ArrayList<>(members.values());
    }

    public void clearMembers() {
        members.clear();
    }
}
