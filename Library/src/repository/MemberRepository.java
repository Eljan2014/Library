
package repository;

import model.Member;
import java.util.ArrayList;

public class MemberRepository {

    private final ArrayList<Member> members = new ArrayList<>();
    private int nextId = 1;

    public int generateId() {
        return nextId++;
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public Member findById(int id) {
        for (Member member : members) {
            if (member.getId() == id) {
                return member;
            }
        }
        return null;
    }

    public Member findByEmail(String email) {
        for (Member member : members) {
            if (member.getEmail().equalsIgnoreCase(email)) {
                return member;
            }
        }
        return null;
    }

    public boolean deleteMember(int id) {
        Member member = findById(id);

        if (member == null) {
            return false;
        }

        members.remove(member);
        return true;
    }

    public ArrayList<Member> getAllMembers() {
        return new ArrayList<>(members);
    }
}
