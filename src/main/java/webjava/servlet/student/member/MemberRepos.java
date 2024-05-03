package webjava.servlet.student.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRepos {
    private static final Map<Long, Member> members = new HashMap<>();
    private static long seq = 20240000L;

    public Member save(Member member) {
        member.setId(++seq);
        members.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id) {
        return members.get(id);
    }

    public List<Member> findAll() {
        return List.copyOf(members.values());
    }

    public void clear() {
        members.clear();
    }
}
