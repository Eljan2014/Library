
package helper;

import model.Member;
import service.MemberService;

import java.util.ArrayList;

public class MemberManager {

    private final MemberService memberService;
    private final InputHelper input;

    public MemberManager(MemberService memberService,
                         InputHelper input) {
        this.memberService = memberService;
        this.input = input;
    }

    public void registerMember() {
        String name = input.readText("Uzvun adi: ");
        String email = input.readText("Email: ");
        String phone = input.readText("Telefon: ");

        if (memberService.registerMember(name, email, phone)) {
            System.out.println("Uzv ugurla qeydiyyatdan kecdi!");
        } else {
            System.out.println(
                    "Qeydiyyat ugursuzdur! Melumatlari yoxla. "
                            + "Email artiq istifade oluna biler."
            );
        }
    }

    public void updateMember() {
        int id = input.readInt("Uzvun ID-si: ");

        Member member = memberService.findById(id);

        if (member == null) {
            System.out.println("Uzv tapilmadi!");
            return;
        }

        String name = input.readText("Yeni ad: ");
        String email = input.readText("Yeni email: ");
        String phone = input.readText("Yeni telefon: ");

        if (memberService.updateMember(id, name, email, phone)) {
            System.out.println("Uzv melumatlari yenilendi!");
        } else {
            System.out.println(
                    "Yenileme ugursuzdur! Email ve melumatlari yoxla."
            );
        }
    }

    public void deleteMember() {
        int id = input.readInt("Silinecek uzvun ID-si: ");

        if (memberService.deleteMember(id)) {
            System.out.println("Uzv silindi!");
        } else {
            System.out.println("Uzv tapilmadi!");
        }
    }

    public void searchById() {
        int id = input.readInt("Uzvun ID-si: ");

        Member member = memberService.findById(id);

        if (member == null) {
            System.out.println("Uzv tapilmadi!");
        } else {
            System.out.println(member);
        }
    }

    public void showAllMembers() {
        ArrayList<Member> members = memberService.getAllMembers();

        if (members.isEmpty()) {
            System.out.println("Qeydiyyatda uzv yoxdur!");
            return;
        }

        for (Member member : members) {
            System.out.println(member);
        }
    }
}
