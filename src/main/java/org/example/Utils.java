package org.example;

import java.util.concurrent.ThreadLocalRandom;

public class Utils {
    public static byte[] hexStringToByteArray(String hexString) {
        int length = hexString.length();
        byte[] byteArray = new byte[length / 2];
        for (int i = 0; i < length - 1; i += 2) {
            byteArray[i / 2] = (byte) ((Character.digit(hexString.charAt(i), 16) << 4)
                    + Character.digit(hexString.charAt(i+1), 16));
        }
        return byteArray;
    }
    public static long generate17DigitRandomNumber() {
        long random17DigitNumber = ThreadLocalRandom.current().nextLong(10000000000000000L, 100000000000000000L);
        return random17DigitNumber;
    }
}
