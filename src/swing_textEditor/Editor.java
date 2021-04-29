package swing_textEditor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Editor extends JFrame implements ActionListener {
    JPanel mainPanel = new JPanel();
    JPanel buttomPanel = new JPanel();
    JTextArea txt1 = new JTextArea(10,60);
    JButton button1 = new JButton("Double text");
    JButton button2 = new JButton("Clear text");
    public Editor(){
        txt1.setFont(new Font("Monospaced", Font.BOLD,14));
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(txt1, BorderLayout.CENTER);
        buttomPanel.add(button1);
        buttomPanel.add(button2);
        mainPanel.add(buttomPanel, BorderLayout.SOUTH);
        button1.addActionListener(this);
        button2.addActionListener(this);
        add(mainPanel);
        pack();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);



    }
    public static void main(String[] args) { Editor e = new Editor(); }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button2){
            txt1.setText("");
        }else if (e.getSource() == button1){
            String newText = txt1.getText() + txt1.getText();
            txt1.setText(newText);
        }
        txt1.setLineWrap(true);
    }
}
