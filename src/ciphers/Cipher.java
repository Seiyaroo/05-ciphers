package ciphers;

import java.util.Scanner;

public class Cipher {
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public static void presentOptions () {
        System.out.println("Select your cipher type -");
        System.out.println("1: Plaintext");
        System.out.println("2: ROT13");
        System.out.println("3: Keyword");
        System.out.println("4: Caesar-Shift");
    }

    public static String encode (int type) {
        String encodedString = "";
        String payload = "";
        Scanner input = new Scanner(System.in);
        System.out.println("Encoder");

        if (type == 1) {
            System.out.println("You chose plaintext - Type your message below");
            payload = input.nextLine();
            encodedString = payload;

        } else if (type == 2) {
            System.out.println("You chose ROT13 - Type your message below");
            payload = input.nextLine();
            encodedString = ROT13Cipher.encodeRot(payload);

        } else if (type == 3) {
            System.out.println("You chose Keyword - Type your message below");
            payload = input.nextLine();


        } else if (type == 4) {
            System.out.println("You chose Caesar-Shift - How much would you like to shift?");
            int shiftyBoi = input.nextInt();
            System.out.println("You set the shift amount to: " + shiftyBoi);
            System.out.println("Input your message below");
            payload = input.next();

            encodedString = CaesarShiftCipher.encrypt(payload, shiftyBoi);
        }
        System.out.println("Your message: " + encodedString);
        return encodedString;
    }

    public static String decode(int type) {
        String decodedString = "";
        String payload = "";
        Scanner input = new Scanner(System.in);
        System.out.println("Decoder");

        if (type == 1) {
            System.out.println("You chose plaintext - Type your message below");
            payload = input.nextLine();
        } else if (type == 2) {
            System.out.println("You chose ROT13 - Type your message below");
            payload = input.nextLine();
            decodedString = ROT13Cipher.encodeRot(payload);

        } else if (type == 3) {
            System.out.println("You chose Keyword - Type your message below");
            payload = input.nextLine();
        } else if (type == 4) {
            System.out.println("You chose Caesar-Shift - How far is your cipher shifted?");
            int shiftyBoi = input.nextInt();
            System.out.println("You set the shift amount to: " + shiftyBoi);
            System.out.println("Input your message below");
            payload = input.next();

            decodedString = CaesarShiftCipher.decrypt(payload, shiftyBoi);
        }
        System.out.println("Your message: " + decodedString);
        return decodedString;
    }

    protected static String replaceCharacters(String payload, String source, String target) {

        String thingy = " ";

        // Build the for loop here to compare the input message to the different alphabets based on chosen cipher
        // If a => n etc...

        for (int i = 0; i < payload.length(); i++) {
            System.out.println("In the for loop");
            System.out.println(payload.charAt(i));
            System.out.println(target.charAt(i));
            thingy += target.charAt(i);

        }

        return thingy;
    }

}