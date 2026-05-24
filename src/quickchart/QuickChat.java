import java.util.Scanner;

public class QuickChat {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to QuickChat.");
        System.out.println("-----------------------");

        while (true) {

            System.out.println();
            System.out.println("MENU:");
            System.out.println("1) Send Messages");
            System.out.println("2) Show recently sent messages");
            System.out.println("3) Quit");
            System.out.print("Select an option: ");

            String menuChoice = input.nextLine();

            if (menuChoice.equals("1")) {

                Message msg = new Message(1);

                System.out.print(
                        "Enter Recipient Cell Number: ");

                String cell = input.nextLine();

                System.out.println(
                        msg.checkRecipientCell(cell));

                System.out.print("Enter Message: ");

                String text = input.nextLine();

                System.out.println(
                        msg.checkMessageLength(text));

            } else if (menuChoice.equals("2")) {

                System.out.println("Coming Soon.");

            } else if (menuChoice.equals("3")) {

                break;

            } else {

                System.out.println("Invalid choice.");
            }
        }

        System.out.println(
                "Thank you for using QuickChat!");
    }
}