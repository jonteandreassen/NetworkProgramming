package TCP_UDP.uppgift4a;

import javax.swing.*;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class mainReceiver extends JFrame {
    JPanel panel = new JPanel();
    JTextArea textArea = new JTextArea(50,20);
    public mainReceiver() throws IOException {
        this.add(panel);
        panel.add(textArea);
        this.pack();
        this.setLocation(1000,800);
        this.setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        int myPort = 55555;
        DatagramSocket socket = new DatagramSocket(myPort);
        byte[] data = new byte[256];
        while (true){
            DatagramPacket packet = new DatagramPacket(data, data.length);
            socket.receive(packet);
            String myMessage = new String(packet.getData(),0, packet.getLength());
            textArea.setText(textArea.getText() + " " + myMessage + "\n");

        }
    }
    public static void main(String[] args) throws IOException {
        mainReceiver m = new mainReceiver();
    }
}
