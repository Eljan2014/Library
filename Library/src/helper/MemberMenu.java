
package helper;

public class MemberMenu {

    private final MemberManager memberManager;
    private final InputHelper input;

    public MemberMenu(MemberManager memberManager,
                      InputHelper input) {
        this.memberManager = memberManager;
        this.input = input;
    }

    public void showMenu() {
        while (true) {
            System.out.println("\n===== UZVLERIN IDARE EDILMESI =====");
            System.out.println("1. Yeni uzv qeydiyyati");
            System.out.println("2. Uzv melumatlarini yenile");
            System.out.println("3. Uzv sil");
            System.out.println("4. ID ile uzv axtar");
            System.out.println("5. Butun uzvleri goster");
            System.out.println("0. Geri qayit");

            int choice = input.readInt("Seciminiz: ");

            switch (choice) {
                case 1:
                    memberManager.registerMember();
                    break;
                case 2:
                    memberManager.updateMember();
                    break;
                case 3:
                    memberManager.deleteMember();
                    break;
                case 4:
                    memberManager.searchById();
                    break;
                case 5:
                    memberManager.showAllMembers();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Yanlis secim!");
            }
        }
    }
}
