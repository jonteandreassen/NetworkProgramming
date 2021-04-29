package Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.SpringLayout.*;

public class JFrameDemo extends JFrame implements ActionListener{
    JFrame f = new JFrame("The Frame");
    JPanel panel = new JPanel();
    JPanel panel1 = new JPanel();
    JLabel label = new JLabel("Hej");
    JLabel label1 = new JLabel("Or not?");
    JButton button = new JButton("Stop");
    JButton button1 = new JButton("it!");
    JFrameDemo(){
        setSize(1000, 500);
        setLocation(1000, 500);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //panel.setLayout(new BorderLayout());
        //panel.setLayout(new GridLayout(2,2));
        //panel.setLayout(new FlowLayout());
        button.addActionListener(this);
        add(panel);
        //panel.setLayout(new BorderLayout());
        panel.add(new JButton("Jonte"),EAST);
        panel.add(label);
        panel.add(button);
        panel.add(panel1);
        panel1.setLayout(new BorderLayout());
        panel1.add(label1);
        panel1.add(button1);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button1){
            label1.setText("ny text");
        }
        if(label.getText().equalsIgnoreCase("Stop")){
            label.setText("Jonte");
        }else{
            label.setText("Ny TEXT i Lablen");
        }
        JTextField t = new JTextField("Text: ");
        panel.add(t);
        //String txt = t.getText();
    }

    public static void main(String[] args) { JFrameDemo j = new JFrameDemo(); }
}
