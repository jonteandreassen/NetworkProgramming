package inlupp;

import javax.swing.*;
import java.io.IOException;
import java.net.*;
import java.rmi.UnknownHostException;

public class testReceiver implements Runnable{
    JTextArea textArea;
    Thread receiverThread = new Thread(this);
    InetAddress iAddr;
    MulticastSocket socket;
    InetSocketAddress group;
    NetworkInterface netIf;

    public testReceiver(MulticastSocket socket, JTextArea textArea, String ip, int port) {
        this.textArea = textArea;
        try {
            this.iAddr = InetAddress.getByName(ip);
            this.socket = socket;
            this.group = new InetSocketAddress(iAddr, port);
            this.netIf = NetworkInterface.getByName("eth3");
            this.socket.joinGroup(group, netIf);
        } catch (UnknownHostException e) {
            System.out.println("Could not find host");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.receiverThread.start();
        if (Thread.currentThread().isAlive())
            System.out.println("Receiver started");
    }

    @Override
    public void run() {
        receiveMessage();
    }

    public void receiveMessage() {
        while (true) {
            byte[] data = new byte[1024];
            DatagramPacket packet = new DatagramPacket(data, data.length);
            try {
                this.socket.receive(packet);
                synchronized (this) {
                    this.textArea.append(new String(packet.getData()) + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
