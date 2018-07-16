package ciphers;

public class ROT13Cipher extends Cipher {

    public static String encodeRot (String payload) {
        char c;
        String rotString = "";

        for (int i = 0; i < payload.length(); i++) {
            c = payload.charAt(i);

            if (c >= 'a' && c <= 'm') c += 13;
            else if (c >= 'n' && c <= 'z') c -= 13;
            rotString += c;
        }
        return rotString;
    }
}