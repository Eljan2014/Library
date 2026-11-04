
package helper;

import java.util.Scanner;

public class InputHelper {

    private Scanner scanner;

    public InputHelper(Scanner scanner) {
        this.scanner = scanner;
    }

    public int readInt(String message) {
        while (true) {
            System.out.print(message);

            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Duzgun reqem daxil et!");
            }
        }
    }

    public String readText(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }
}
