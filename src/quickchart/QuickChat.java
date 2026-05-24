package quickchart;

import java.util.Scanner;
import java.util.Random;

public class QuickChat {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Random random = new Random();

        int totalMessages = 0;

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

                String cellCheck =
                        msg.checkRecipientCell(cell);

                System.out.println(cellCheck);

                if (!cellCheck.contains("successfully")) {

                    continue;
                }

                System.out.print(
                        "Enter Message: ");

                String text = input.nextLine();

                String lengthCheck =
                        msg.checkMessageLength(text);

                System.out.println(lengthCheck);

                if (text.length() > 250) {

                    continue;
                }

                String hash =
                        msg.createMessageHash(text);

                System.out.println();
                System.out.println(
                        "What would you like to do?");

                System.out.println("1) Send Message");
                System.out.println("2) Disregard Message");
                System.out.println("3) Store Message");

                System.out.print("Choice: ");

                int action = input.nextInt();
                input.nextLine();

                System.out.println(
                        msg.sentMessage(action));

                if (action == 1) {

                    totalMessages++;

                    System.out.println();
                    System.out.println(
                            "--- Sent Message Details ---");

                    System.out.println(
                            "Message ID: " + id);

                    System.out.println(
                            "Message Hash: " + hash);

                    System.out.println(
                            "Recipient: " + cell);

                    System.out.println(
                            "Message: " + text);
                }

            } else if (menuChoice.equals("2")) {

                System.out.println("Coming Soon.");

            } else if (menuChoice.equals("3")) {

                break;

            } else {

                System.out.println("Invalid choice.");
            }
        }

        System.out.println();
        System.out.println("Total number of messages sent: " + totalMessages);

        System.out.println("Thank you for using QuickChat!");
    }
}