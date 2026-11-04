import helper.BorrowManager;
import helper.BorrowMenu;
import repository.BorrowRepository;
import service.BorrowService;
import helper.BookManager;
import helper.BookMenu;
import helper.InputHelper;
import helper.MemberManager;
import helper.MemberMenu;
import repository.BookRepository;
import repository.MemberRepository;
import service.BookService;
import service.MemberService;
import helper.ReportManager;
import helper.ReportMenu;
import service.ReportService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        InputHelper input = new InputHelper(scanner);


        BookRepository bookRepository = new BookRepository();
        BookService bookService = new BookService(bookRepository);
        BookManager bookManager = new BookManager(bookService, input);
        BookMenu bookMenu = new BookMenu(bookManager, input);


        MemberRepository memberRepository = new MemberRepository();
        MemberService memberService = new MemberService(memberRepository);
        MemberManager memberManager =
                new MemberManager(memberService, input);
        MemberMenu memberMenu = new MemberMenu(memberManager, input);

        BorrowRepository borrowRepository = new BorrowRepository();

        BorrowService borrowService = new BorrowService(
                bookRepository,
                memberRepository,
                borrowRepository
        );

        BorrowManager borrowManager = new BorrowManager(
                borrowService,
                input
        );

        BorrowMenu borrowMenu = new BorrowMenu(
                borrowManager,
                input
        );

        ReportService reportService = new ReportService(
                bookRepository,
                memberRepository,
                borrowRepository
        );

        ReportManager reportManager = new ReportManager(
                reportService,
                input
        );

        ReportMenu reportMenu = new ReportMenu(
                reportManager,
                input
        );


        while (true) {
            System.out.println("\n===== KITABXANA SISTEMI =====");
            System.out.println("1. Kitablarin idare edilmesi");
            System.out.println("2. Uzvlerin idare edilmesi");
            System.out.println("3. Kitab goturmek ve qaytarmaq");
            System.out.println("4. Axtaris ve hesabatlar");
            System.out.println("0. Proqramdan cixis");

            int choice = input.readInt("Seciminiz: ");

            switch (choice) {
                case 1:
                    bookMenu.showMenu();
                    break;
                case 2:
                    memberMenu.showMenu();
                    break;
                case 3:
                    borrowMenu.showMenu();
                    break;
                case 4:
                    reportMenu.showMenu();
                    break;
                case 0:
                    System.out.println("Proqram baglandi!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Yanlis secim!");
            }
        }
    }
}
