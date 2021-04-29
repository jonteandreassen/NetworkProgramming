package swing_ovningsuppgift1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.SpringLayout.*;

public class mainDemo extends JFrame implements ActionListener {
    //main panel
    JPanel labelPanel = new JPanel();
    JPanel textPanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    //Text for the text fields
    JLabel l1 = new JLabel("Meters today: ");
    JLabel l2 = new JLabel("Meters 1 year ago: ");
    JLabel l3 = new JLabel("Fuel Consumed: ");
    JLabel l4 = new JLabel();
    JLabel l5 = new JLabel();
    JLabel l6 = new JLabel();
    //TextFields
    JTextField text1 = new JTextField(20);
    JTextField text2 = new JTextField(20);
    JTextField text3 = new JTextField(20);
    //Button
    JButton b1 = new JButton("Calculate");


    public mainDemo(){
        this.setLayout(new BorderLayout());
        //LabelPanels and TextFields
        this.add(labelPanel, NORTH);
        labelPanel.setLayout(new GridLayout(3,2));
        labelPanel.add(l1);
        labelPanel.add(text1);
        labelPanel.add(l2);
        labelPanel.add(text2);
        labelPanel.add(l3);
        labelPanel.add(text3);
        //ButtonField & button
        this.add(buttonPanel, BorderLayout.CENTER);
        buttonPanel.add(b1);
        //TextField for calculation text
        this.add(textPanel, BorderLayout.SOUTH);
        textPanel.setLayout(new GridLayout(1,3));
        textPanel.add(l4); textPanel.add(l5); textPanel.add(l6);
        b1.addActionListener(this);
        pack();
        setLocation(500, 500);   // Location on window when running the program
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args) { mainDemo m = new mainDemo(); }

    @Override
    public void actionPerformed(ActionEvent e) {
        Calculator c = new Calculator(Integer.parseInt(text1.getText()), Double.parseDouble(text2.getText()), Double.parseDouble(text3.getText()));
        l4.setText("Miles diven: " + c.getMiles());
        l5.setText("Fuel: " + c.getFuel());
        l6.setText("Fuel per mile: " + c.getGas());
    }
}
