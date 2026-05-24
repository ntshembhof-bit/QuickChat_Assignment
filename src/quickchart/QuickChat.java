import java.util.Scanner;
import java.util.Random;

public class QuickChat {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Random random = new Random();

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

                // Generate Message ID
                long messageID =
                        1000000000L +
                        (long)(random.nextDouble()
                        * 9000000000L);

                String id = String.valueOf(messageID);

                System.out.println(
                        "Message ID: " + id);

                // Recipient
                System.out.print(
                        "Enter Recipient Cell Number: ");

                String cell = input.nextLine();

                System.out.println(
                        msg.checkRecipientCell(cell));

                // Message
                System.out.print(
                        "Enter Message: ");

                String text = input.nextLine();

                System.out.println(msg.checkMessageLength(text));

                // Create Hash
                String hash = msg.createMessageHash(text);

                System.out.println("Message Hash: " + hash);

                // Send Option
                System.out.println();
                System.out.println("1) Send Message");
                System.out.println("2) Disregard Message");

                int choice = input.nextInt();
                input.nextLine();

                msg.sentMessage(choice));

            } else if (menuChoice.equals("2")) {

                System.out.println("Coming Soon.");

            } else if (menuChoice.equals("3")) {

                break;

            } else {

                System.out.println("Invalid choice.");
            }
        }

        System.out.println("Thank you for using QuickChat!");
    }
}