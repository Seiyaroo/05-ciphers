package ciphers;

public class CaesarShiftCipher extends Cipher {

    public static String encrypt (String payload, int shift) {
        char[] arr = payload.toCharArray();
        int ascii;

        for (int i = 0; i < arr.length; i++) {
            ascii = (int) arr[i];
            ascii = ascii + shift;

            if (ascii > 122) {
                ascii = 32 + (122 % ascii);
            }

            arr[i] = (char) ascii;
        }
        return String.valueOf(arr);
    }

    public static String decrypt (String payload, int shift) {
        char[] arr = payload.toCharArray();
        int ascii;

        for (int i = 0; i < arr.length; i++) {
            ascii = (int) arr[i];
            ascii = ascii - shift;

            if (ascii > 122) {
                ascii = 32 + (122 % ascii);
            }

            arr[i] = (char) ascii;
        }
        return String.valueOf(arr);
    }
}