package quickchart;

import java.util.Scanner;
import java.util.Random;

public class QuickChat {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Message msgWorker = new Message();
        Random random = new Random();

        System.out.print("Enter username: ");
        String username = input.nextLine();
        System.out.print("Enter password: ");
        String password = input.nextLine();

        if (!username.equals("admin") || !password.equals("1234")) {
            System.out.println("Login failed. You cannot send messages.");
            return;
        }

        System.out.println("Login successful!");
        System.out.println("Welcome to QuickChat.");
        System.out.println("-----------------------");

        System.out.print("Enter the number of messages you wish to enter: ");
        int limit = input.nextInt();
        input.nextLine();

        for (int i = 0; i < limit; i++) {
            System.out.println();
            System.out.println("--- Message " + (i + 1) + " ---");

            long messageID = 1000000000L + (long)(random.nextDouble() * 9000000000L);
            String id = String.valueOf(messageID);
            System.out.println("Message ID generated: " + id);

            System.out.print("Enter Recipient Cell Number: ");
            String cell = input.nextLine();
            String cellCheck = msgWorker.checkRecipientCell(cell);
            System.out.println(cellCheck);
            if (!cellCheck.contains("successfully")) {
                i--;
                continue;
            }

            System.out.print("Enter Message text: ");
            String text = input.nextLine();
            String lengthCheck = msgWorker.checkMessageLength(text);
            System.out.println(lengthCheck);
            if (text.length() > 250) {
                i--;
                continue;
            }

            String hash = msgWorker.createMessageHash(id, i, text);

            System.out.println();
            System.out.println("What would you like to do with this message?");
            System.out.println("1) Send Message");
            System.out.println("2) Disregard Message");
            System.out.println("3) Store Message to send later");
            System.out.print("Choice: ");
            int action = input.nextInt();
            input.nextLine();

            System.out.println(msgWorker.sentMessage(action));

            if (action == 1) {
                msgWorker.incrementCount();
                System.out.println();
                System.out.println("--- Sent Message Details ---");
                System.out.println("Message ID: " + id);
                System.out.println("Message Hash: " + hash);
                System.out.println("Recipient: " + cell);
                System.out.println("Message: " + text);
            } else if (action == 3) {
                msgWorker.storeMessage(id, hash, cell, text);
            }
        }

        System.out.println();
        System.out.println("--------------------------------------------------");
        System.out.println("Total number of messages sent: " + msgWorker.returnTotalMessages());
        System.out.println("Thank you for using QuickChat!");
    }
}

