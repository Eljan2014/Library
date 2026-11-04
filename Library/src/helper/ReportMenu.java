
package helper;

public class ReportMenu {

    private final ReportManager reportManager;
    private final InputHelper input;

    public ReportMenu(ReportManager reportManager,
                      InputHelper input) {

        this.reportManager = reportManager;
        this.input = input;
    }

    public void showMenu() {

        while (true) {

            System.out.println("\n===== AXTARIS VE HESABATLAR =====");

            System.out.println("1. En cox goturulen kitablar");
            System.out.println("2. Hazirda uzvlerde olan kitablar");
            System.out.println("3. Gecikmis kitablarin siyahisi");
            System.out.println("4. Janra gore filtr");
            System.out.println("5. Muellife gore filtr");
            System.out.println("6. En aktiv kitabxana uzvleri");
            System.out.println("0. Geri qayit");

            int choice = input.readInt("Seciminiz: ");

            switch (choice) {

                case 1:
                    reportManager.showMostBorrowedBooks();
                    break;

                case 2:
                    reportManager.showCurrentlyBorrowedBooks();
                    break;

                case 3:
                    reportManager.showOverdueBooks();
                    break;

                case 4:
                    reportManager.filterByGenre();
                    break;

                case 5:
                    reportManager.filterByAuthor();
                    break;

                case 6:
                    reportManager.showMostActiveMembers();
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Yanlis secim!");
            }
        }
    }
}
