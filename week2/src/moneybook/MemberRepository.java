package moneybook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRepository {

    private static Map<Long , Member> members = new HashMap<>();
    private static long sequence = 0L;

    public Member save(Member member) {
        member.setId(++sequence);
        members.put(sequence, member);
        return member;
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
