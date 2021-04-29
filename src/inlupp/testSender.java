package inlupp;

import javax.swing.*;
import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class testSender implements Runnable {
    JTextField textField;
    Thread sendThread = new Thread(this);
    private final int port;
    InetAddress iAddr;
    MulticastSocket socket;
    InetSocketAddress group;
    NetworkInterface netIf;
    String userName;
    public testSender(MulticastSocket socket, String name, JTextField textField, String ip, int port) {
        this.userName = name == null || name.isBlank() ? "GhostFaceKillah" : name;
        this.textField = textField;
        this.port = port;
        try {
            this.iAddr = InetAddress.getByName(ip);
            this.group = new InetSocketAddress(iAddr, port);
            this.socket = socket;
            this.netIf = NetworkInterface.getByName("eth3");
           // this.socket.joinGroup(group, netIf);

        } catch (UnknownHostException e) {
            System.out.println("No host!");
            e.printStackTrace();
        } catch (IOException e) { e.printStackTrace(); }

        this.sendThread.start();
        if (Thread.currentThread().isAlive())
            System.out.println("Sender started"); }

    @Override
    public void run() {
        textField.requestFocus();
        sendMessage("***" + this.userName  + " entered the Chat" + "***");
        this.textField.addActionListener(l -> {
            Scanner scan = new Scanner(this.textField.getText());
            StringBuilder msg = new StringBuilder();
            while (scan.hasNextLine()) {
                msg.append(scan.nextLine());
            }
            String message = this.userName + ": " + msg.toString();
            if (!msg.toString().isBlank()) {
                sendMessage(message);
                this.textField.setText("");
                }
        });
    }
    public void sendMessage(String message) {
        try {
            byte[] data = message.getBytes();
            DatagramPacket packet = new DatagramPacket(data, data.length, iAddr, port);
            this.socket.send(packet);
            System.out.println("Message sent");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

