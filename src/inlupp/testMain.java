package inlupp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MulticastSocket;

public class testMain extends JFrame {
    public JPanel panel;
    public JTextArea textArea;
    public JTextField textField;
    public JButton disconnect;
    public String userName;
    public String ip = "225.225.225.225";
    public int port = 55555;
    public testReceiver receiver;
    public testSender sender;
    public MulticastSocket multicastSocket;
    //public JScrollPane scroll;
    public testMain() throws Exception {
        Font myFont = new Font("Calabri", Font.BOLD, 16);
        setTitle("Jontes Chat");
        this.userName = JOptionPane.showInputDialog(null, "Enter Username:");
        this.panel = new JPanel();
        this.textArea = new JTextArea();
        this.textField = new JTextField();
        this.disconnect = new JButton("Disconnect");

        this.panel.setLayout(new BorderLayout());
        this.panel.add(disconnect, BorderLayout.NORTH);
        this.panel.add(textArea, BorderLayout.CENTER);
        this.panel.add(textField, BorderLayout.SOUTH);

        //this.scroll = new JScrollPane(textArea);
        //scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        //textArea.add(scroll);

        textArea.setFont(myFont);
        textField.setFont(myFont);
        textArea.setBackground(Color.gray);
        disconnect.setBackground(Color.white);
        textArea.setLineWrap(true);
        textArea.setText("\t\t ___JontesChat___ \n");
        textArea.setEditable(false);
        this.add(panel);

        //instantiates classes
        multicastSocket = new MulticastSocket(port);
        receiver = new testReceiver(multicastSocket, textArea, ip, port);
        sender = new testSender(multicastSocket, userName, textField, ip, port);
        setSize(640, 300);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        disconnect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(userName + " has disconnected");
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) throws Exception { new testMain(); }
}

