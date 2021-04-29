package TCP_UDP.uppgift4a;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.*;

public class mainSender extends JFrame implements ActionListener {
    JPanel panel = new JPanel();
    JTextField text = new JTextField(10);
    JButton button = new JButton("Send Data");

    String city = "";
    String temp = "";
    String datatoSend = "";
    InetAddress toAdress = InetAddress.getLocalHost();
    int toPort = 55555;
    DatagramSocket socket = new DatagramSocket();

    public mainSender() throws UnknownHostException, SocketException {
        String paneText = JOptionPane.showInputDialog(null,"Enter City");
        city = paneText;
        JLabel label = new JLabel(city);
        if(city == null || city.length() == 0){
            System.exit(0);
        }
        this.add(panel);
        panel.add(label);
        panel.add(text);
        panel.add(button);
        button.addActionListener(this);
        text.addActionListener(this);
        this.pack();
        this.setLocation(1000,500);
        this.setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        temp = text.getText();
        datatoSend = city + ", " + temp;
        byte[] data = datatoSend.getBytes();
        DatagramPacket packet = new DatagramPacket(data, data.length, toAdress, toPort);
        try{
            socket.send(packet);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        text.setText("");
    }
    public static void main(String[] args) throws UnknownHostException, SocketException {
        mainSender m = new mainSender();
    }
}
