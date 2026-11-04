
package helper;

public class BookMenu {

    private BookManager bookManager;
    private InputHelper input;

    public BookMenu(BookManager bookManager, InputHelper input) {
        this.bookManager = bookManager;
        this.input = input;
    }

    public void showMenu() {
        while (true) {
            System.out.println("\n===== KITABXANA SISTEMI =====");
            System.out.println("1. Kitab elave et");
            System.out.println("2. Kitab sil");
            System.out.println("3. Kitab melumatlarini yenile");
            System.out.println("4. ID ile kitab axtar");
            System.out.println("5. Ada gore kitab axtar");
            System.out.println("6. Muellife gore kitab axtar");
            System.out.println("7. Janra gore kitab axtar");
            System.out.println("8. Butun kitablari goster");
            System.out.println("0. Cixis");

            int choice = input.readInt("Seciminiz: ");

            switch (choice) {
                case 1:
                    bookManager.addBook();
                    break;
                case 2:
                    bookManager.deleteBook();
                    break;
                case 3:
                    bookManager.updateBook();
                    break;
                case 4:
                    bookManager.searchById();
                    break;
                case 5:
                    bookManager.searchByTitle();
                    break;
                case 6:
                    bookManager.searchByAuthor();
                    break;
                case 7:
                    bookManager.searchByGenre();
                    break;
                case 8:
                    bookManager.showAllBooks();
                    break;
                case 0:
                    System.out.println("Kitab menyusunden cixilir...");
                    return;
                default:
                    System.out.println("Yanlis secim! Yeniden cehd edin.");
            }
        }
    }
}
