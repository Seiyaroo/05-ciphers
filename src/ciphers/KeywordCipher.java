package ciphers;

public class KeywordCipher extends Cipher {
    public static String encrypt (String payload, final String keyword) {
        String encrypted = "";

        for (int i = 0, j = 0; i < payload.length(); i++) {
            char input = payload.charAt(i);

            if(input < 'a' || input > 'z' || input == ' ') {
                continue;
            }

            encrypted += (char) ((input + keyword.charAt(j) - 2 * 'a') % 26 + 'a');
            j = j++ % keyword.length();
        }
        return encrypted;
    }

    public static String decrypt (String payload, final String keyword) {
        String decrypted = "";

        for (int i = 0, j = 0; i < payload.length(); i++) {
            char input = payload.charAt(i);

            if (input < 'a' || input > 'z' || input == ' ') {
                continue;
            }

            decrypted += (char) ((input - keyword.charAt(j) + 26) % 26 + 'a');
            j = j++ % keyword.length();
        }
        return decrypted;
    }
}