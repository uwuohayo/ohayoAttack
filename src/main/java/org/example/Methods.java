package org.example;

import java.nio.charset.StandardCharsets;
import java.util.Random;

public class Methods {

    static Random rnd = new Random();

    public static byte[] VSE() {
        String strVal1 = "ffffffff54536f7572636520456e67696e6520517565727900";
        return Utils.hexStringToByteArray(strVal1);
    }

    public static byte[] PLRC() {
        String inputString = String.valueOf(Utils.generate17DigitRandomNumber());

        byte[] byteArray = inputString.getBytes(StandardCharsets.UTF_8);
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : byteArray) {
            stringBuilder.append(String.format("%02x", b));
        }
        String rawString = stringBuilder.toString();

        String[] strValues = {
                "050d00000012185e552131dc08000000001002001e617f0000010000000000000000000d04020101ba72c7240a00edc59e5e6ac3ef75ee831800"+rawString+"40737465616dc80fd3650000000000030052558b00308188024200f95e7ec9fd2c9dccd38b15e43068b729b7d91843d2c6124f5d3f3891312d41c05dc556a84d8b7f8c3f4c8be80c6d5991678dba8e1b7413e7b4386a1e111f6756e7024201539400728e9bff85c29aab878ce58be61510d8888b83d33e0f212a206297d9964e6b43c47b72becf607503e3ec5ca68eaa4cd392d4714bd9d680bfdafe4e605024",
                "050d000000904bd3542131dc08000000001002001e617f0000010000000000000000000d04020101000000001800"+rawString+"40737465616dc80fd3650000000000030052558b00308188024200f95e7ec9fd2c9dccd38b15e43068b729b7d91843d2c6124f5d3f3891312d41c05dc556a84d8b7f8c3f4c8be80c6d5991678dba8e1b7413e7b4386a1e111f6756e7024201539400728e9bff85c29aab878ce58be61510d8888b83d33e0f212a206297d9964e6b43c47b72becf607503e3ec5ca68eaa4cd392d4714bd9d680bfdafe4e605024"
        };
        return Utils.hexStringToByteArray(strValues[rnd.nextInt(strValues.length)]);
    }

    public static byte[] SEC() {
        String inputString = String.valueOf(Utils.generate17DigitRandomNumber());

        byte[] byteArray = inputString.getBytes(StandardCharsets.UTF_8);
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : byteArray) {
            stringBuilder.append(String.format("%02x", b));
        }
        String rawString = stringBuilder.toString();

        String strVal1 = "050d00000037dbcc7afc3adc08000000001002001e615778cc800000000000000000000d040201012db1bcdf0a00ad0d1c7839bb48f087921800"+rawString+"40737465616d2599e3650000000000030052558b003081880242019ea1065c7e7e7e6d57d41f0287646ff53ce1755bf9fbf39930dfcf13f5964b01deff8a0a6f643549643158e4ce5be8be05af9930b30c15acd4003650f8e15d970002420122461135fd8c7b9ebee9e22ba15733e3ba6a073119ae7969a8b3fcd50d721ccffb129ee3cfbbb8f8df6398473297ee12d1da485603d1eb0d254ea6cea72d491f54";
        return Utils.hexStringToByteArray(strVal1);
    }

    public static byte[] REQ() {
        String inputString = String.valueOf(Utils.generate17DigitRandomNumber());

        byte[] byteArray = inputString.getBytes(StandardCharsets.UTF_8);
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : byteArray) {
            stringBuilder.append(String.format("%02x", b));
        }
        String rawString = stringBuilder.toString();

        String strVal1 = "050d00000049a5887afc3adc08000000001002001e615778cc800000000000000000000d04020101000000001800"+rawString+"40737465616d2599e3650000000000030052558b003081880242019ea1065c7e7e7e6d57d41f0287646ff53ce1755bf9fbf39930dfcf13f5964b01deff8a0a6f643549643158e4ce5be8be05af9930b30c15acd4003650f8e15d970002420122461135fd8c7b9ebee9e22ba15733e3ba6a073119ae7969a8b3fcd50d721ccffb129ee3cfbbb8f8df6398473297ee12d1da485603d1eb0d254ea6cea72d491f54";
        return Utils.hexStringToByteArray(strVal1);
    }
}
