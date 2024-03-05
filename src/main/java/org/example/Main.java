package org.example;

import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("█▀█ █░█ ▄▀█ █▄█ █▀█ ▄▀█ ▀█▀ ▀█▀ ▄▀█ █▀▀ █▄▀");
        System.out.println("█▄█ █▀█ █▀█ ░█░ █▄█ █▀█ ░█░ ░█░ █▀█ █▄▄ █░█");
        System.out.println();
        System.out.println("welcome to ohayoAttack v3!");
        System.out.println("大きな力には、大きな責任が伴います。");
        System.out.println();
        System.out.println("site - twitch.tv/uwuohayo");
        System.out.println();
        System.out.println("please write command - help, methods, attack, slbot");
        System.out.println("close panel - CTRL+C");
        System.out.println();
        System.out.println("Ready for input ↓");
        while (true) {
            startProgram();
        }
    }
    public static void startProgram() {
        String argument;
        argument = scanner.nextLine().toLowerCase();

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