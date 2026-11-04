
package helper;

public class BorrowMenu {

    private final BorrowManager borrowManager;
    private final InputHelper input;

    public BorrowMenu(BorrowManager borrowManager,
                      InputHelper input) {
        this.borrowManager = borrowManager;
        this.input = input;
    }

    public void showMenu() {

        while (true) {

            System.out.println("\n===== KITAB GOTURME VE QAYTARMA =====");
            System.out.println("1. Kitab gotur");
            System.out.println("2. Kitab qaytar");
            System.out.println("3. Hazirda goturulen kitablar");
            System.out.println("4. Gecikmis kitablar");
            System.out.println("5. Butun goturme qeydləri");
            System.out.println("0. Geri qayit");

            int choice = input.readInt("Seciminiz: ");

            switch (choice) {

                case 1:
                    borrowManager.borrowBook();
                    break;

                case 2:
                    borrowManager.returnBook();
                    break;

                case 3:
                    borrowManager.showActiveRecords();
                    break;

                case 4:
                    borrowManager.showOverdueRecords();
                    break;

                case 5:
                    borrowManager.showAllRecords();
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Yanlis secim!");
            }
        }
    }
}
