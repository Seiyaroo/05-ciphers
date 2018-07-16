import ciphers.Cipher;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean isRunning = true;
        System.out.println("Select your Operation:");
        System.out.println("1: encode");
        System.out.println("2: decode");
        System.out.println("3: quit");

        while (isRunning) {
            Scanner input = new Scanner(System.in);
            int selection = input.nextInt();

            if (selection == 1) {
                System.out.println("You chose encode.");
                Cipher.presentOptions();
                int cipherSelection = input.nextInt();

                Cipher.encode(cipherSelection);
            } else if (selection == 2) {
                System.out.println("You chose decode.");
                Cipher.presentOptions();
                int cipherSelection = input.nextInt();

                Cipher.decode(cipherSelection);
            } else if (selection == 3) {
                isRunning = false;
            } else {
                System.out.println("I didn't understand your selection.");
            }
        }
    }

}