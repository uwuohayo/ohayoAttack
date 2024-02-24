package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        /*
        File settingsFile = new File("settings.txt");
        try {
            Scanner fileReader = new Scanner(settingsFile);
            while (fileReader.hasNextLine()) {
                //proxyLines.add(fileReader.nextLine());
            }
            fileReader.close();
        } catch (FileNotFoundException e1) {
            System.out.println("File \"settings.txt\" is not found, creating...");
            try {
                settingsFile.createNewFile();
            } catch (IOException e2) {
                System.out.println("Can not create \"settings.txt\" file! Stopping...");
                System.exit(0);
            }
        }
        */

        System.out.println("█▀█ █░█ ▄▀█ █▄█ █▀█ ▄▀█ ▀█▀ ▀█▀ ▄▀█ █▀▀ █▄▀");
        System.out.println("█▄█ █▀█ █▀█ ░█░ █▄█ █▀█ ░█░ ░█░ █▀█ █▄▄ █░█");
        System.out.println("welcome to ohayoAttack v2!");
        System.out.println("大きな力には、大きな責任が伴います。");
        System.out.println("site - twitch.tv/uwuohayo");
        System.out.println("please write command - help, methods, attack, slbot");
        System.out.println("close panel - CTRL+C");
        System.out.println("Ready for input ↓");
        startProgram();
    }
    public static void startProgram() {
        String argument;
        argument = scanner.nextLine();

        switch (argument.toLowerCase()) {
            case "help":
                System.out.println("Welcome to the help menu!");
                System.out.println("help - show this message");
                System.out.println("attack - start attack");
                System.out.println("methods - list of methods");
                System.out.println("close panel - CTRL+C");
                break;
            case "methods":
                System.out.println("Welcome to the list of methods!");
                for (Method method : Methods.class.getDeclaredMethods()) {
                    System.out.println(" - " + method.getName());
                }
                break;
            case "attack":
                boolean enableProxy;
                String attackMethod;
                String targetIP;
                int targetPort;
                int attackTime;
                int attackPower;

                System.out.println("Welcome to the attack startup!");
                System.out.println("Enable socks5 proxy?: (true/false)");
                enableProxy = Boolean.parseBoolean(scanner.nextLine());
                System.out.println("Please, write method: ");
                attackMethod = scanner.nextLine();
                System.out.println("Please, write target IP: ");
                targetIP = scanner.nextLine();
                System.out.println("Please, write target Port: ");
                targetPort = scanner.nextInt();
                System.out.println("Please, write an attack time in seconds: ");
                attackTime = scanner.nextInt();
                System.out.println("Please, write attack threads: ");
                attackPower = scanner.nextInt();

                for (Method method : Methods.class.getDeclaredMethods()) {
                    if (method.getName().equals(attackMethod)) {
                        System.out.println("ohayoAttack | Start Node\nIP - " + targetIP + "\nPort - " + targetPort + "\nTime - " + attackTime + "\nMethod - " + attackMethod +  "\nPower - " + attackPower);
                        Attack.startAttack(enableProxy, targetIP, targetPort, attackTime, method, attackPower);
                        break;
                    }
                }
                break;
            case "slbot":
                System.out.println("soon...");
                //SLBot.startSCPSLBotAttack();
                break;
        }
    }
}
