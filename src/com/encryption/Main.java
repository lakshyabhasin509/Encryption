package com.encryption;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Main {
    public static void main(String[] args) {
        System.out.println("this is testing");
        JFrame frame = new JFrame();    //create a new frame
        createFrame(frame);
    createButton(frame);


    }



    static  void operate(int key){
JFileChooser fileChooser =new JFileChooser();
fileChooser.showOpenDialog(null);
        File file =fileChooser.getSelectedFile();
        try {
            FileInputStream fis=new FileInputStream(file);
            byte[] data=new byte[fis.available()];
            System.out.println(data.length);
            fis.read(data);
          for(int i=0;i<data.length;i++){
              data[i]=(byte)(data[i]^key);
          }
            FileOutputStream fileOutputStream=new FileOutputStream(file);

          fileOutputStream.write(data);
          fileOutputStream.close();
          fis.close();
          JOptionPane.showMessageDialog(null,"encrypted");
        }catch (Exception e){
            e.printStackTrace();
        }


    }
    static  void createButton(JFrame frame){
        Font f = new Font("roboto", Font.BOLD, 20);
    frame.setLayout(new FlowLayout());

        JButton button = new JButton("Open image");
        button.setFont(f);
        button.setBounds(100,100,100,50);
        frame.add(button);

        //        creating text field
        JTextField textField = new JTextField(10);
        textField.setFont(f);

frame.add(textField);
//ActionListner
        button.addActionListener(e->{
            System.out.println();
        String text=textField.getText();
        int integertext=Integer.parseInt(text);
        operate(integertext);
        });

    }
  static void createFrame(JFrame frame){

        frame.setTitle("Encryption"); //set the title of the frame
        frame.setSize(500,500); //set the size of the frame
        frame.setLocationRelativeTo(null); //set the location of the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //set the default close operation of the frame
        frame.setVisible(true); //set the frame to visible
    }

}
