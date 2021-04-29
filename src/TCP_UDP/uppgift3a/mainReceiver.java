package TCP_UDP.uppgift3a;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class mainReceiver {
    public static void main(String[] args) throws IOException {
        int minPort = 55555;
        DatagramSocket socket = new DatagramSocket(minPort);
        byte[] data = new byte[256];
        while (true) {
            DatagramPacket packet = new DatagramPacket(data, data.length);
            socket.receive(packet);
            String myMessage = new String(packet.getData(), 0, packet.getLength());
            System.out.println(myMessage);

        }
    }
}
