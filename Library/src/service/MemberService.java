
package service;

import model.Member;
import repository.MemberRepository;

import java.util.ArrayList;

public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public boolean registerMember(
            String name, String email, String phone) {

        if (!isValid(name, email, phone)) {
            return false;
        }

        if (memberRepository.findByEmail(email.trim()) != null) {
            return false;
        }

        int id = memberRepository.generateId();

        Member member = new Member(
                id, name.trim(), email.trim(), phone.trim()
        );

        memberRepository.addMember(member);
        return true;
    }

    public boolean updateMember(
            int id, String name, String email, String phone) {

        Member member = memberRepository.findById(id);

        if (member == null || !isValid(name, email, phone)) {
            return false;
        }

        String cleanEmail = email.trim();
        Member existing = memberRepository.findByEmail(cleanEmail);

        if (existing != null && existing.getId() != id) {
            return false;
        }

        member.setName(name.trim());
        member.setEmail(cleanEmail);
        member.setPhone(phone.trim());

        return true;
    }

    private boolean isValid(
            String name, String email, String phone) {

        return name != null && !name.trim().isEmpty()
                && email != null
                && email.trim().matches("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$")
                && phone != null && !phone.trim().isEmpty();
    }

    public boolean deleteMember(int id) {
        return memberRepository.deleteMember(id);
    }

    public Member findById(int id) {
        return memberRepository.findById(id);
    }

    public ArrayList<Member> getAllMembers() {
        return memberRepository.getAllMembers();
    }
}
