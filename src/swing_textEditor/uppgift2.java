package swing_textEditor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static javax.swing.SpringLayout.*;

public class uppgift2 extends JFrame implements ActionListener {
    JPanel p = new JPanel();
    JPanel headerPanel = new JPanel();
    JLabel fileName = new JLabel("Filename: ");
    JTextField textField = new JTextField(10);
    JButton open = new JButton("Open");
    JButton save = new JButton("Save");
    JButton print = new JButton("Print");
    JButton close = new JButton("Close");
    JButton deleteFiles = new JButton("Delete Files");
    JTextArea textArea = new JTextArea(20,100);
   // Path myPath = Paths.get("src/swing_textEditor/");

    public uppgift2(){
        this.setLayout(new BorderLayout());
        this.add(headerPanel, NORTH);
        headerPanel.setBackground(Color.lightGray);
        headerPanel.setLayout(new FlowLayout());
        //Textfield labels + field
        headerPanel.add(fileName); headerPanel.add(textField);
        //Buttons
        headerPanel.add(open); headerPanel.add(save); headerPanel.add(print); headerPanel.add(close); headerPanel.add(deleteFiles);
        this.add(p, BorderLayout.CENTER);
        p.setLayout(new BorderLayout());
        p.add(textArea);

        //Listeners
        save.addActionListener(this); open.addActionListener(this);
        print.addActionListener(this); close.addActionListener(this);
        deleteFiles.addActionListener(this);
        pack();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        }
        @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == save){
                    File myFile = new File("src/swing_textEditor/"
                    + textField.getText());
                    saveFile(myFile);
                }
                else if(e.getSource() == open){
                    String path = "src/swing_textEditor/" + textField.getText();
                    readFile(path);
                }
                else if(e.getSource() == print){
                    try {
                        textArea.print();
                    } catch (PrinterException printerException) {
                        printerException.printStackTrace();
                    }

                }
                else if(e.getSource() == close){
                    System.exit(0);
                }

                else if(e.getSource() == deleteFiles){
                    Path deletePath = Paths.get("src/swing_textEditor/" + textField.getText());
                    try {
                        Files.delete(deletePath);
                        System.out.println("File Deleted!");
                    } catch (IOException ioException) {
                        ioException.printStackTrace(); }
                }
            }
    private void readFile(String fileName) {
        try{
            FileReader fileReader = new FileReader(fileName);
            textArea.read(fileReader, null);
        }catch (IOException error){error.printStackTrace();}
    }
    private void saveFile(File filePath){
        try{
            if(filePath.createNewFile()){
                System.out.println("File Saved");
                FileWriter w = new FileWriter(filePath);
                textArea.write(w);
            }else{
                System.out.println("File Already exists");
            }
        }catch (IOException e){e.printStackTrace();}
    }

    public static void main(String[] args) { uppgift2 u = new uppgift2(); }
        }
