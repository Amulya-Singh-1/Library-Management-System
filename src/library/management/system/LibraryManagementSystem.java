package library.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class LibraryManagementSystem extends JFrame implements ActionListener{
    JButton b1;
    JLabel l1;
    
    public LibraryManagementSystem(){
        setSize(1366,390);
        setLayout(null);
        setLocation(300,300);
        
        l1= new JLabel();
        b1= new JButton("Enter");
        
        b1.setBackground(Color.WHITE);
        b1.setForeground(Color.BLACK);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/first.jpg"));
        Image i2= i1.getImage().getScaledInstance(1366, 390,Image.SCALE_DEFAULT );
        ImageIcon i3=new ImageIcon(i2);
        l1= new JLabel(i3);
        
        b1.setBounds(1050,250,200,60);
	l1.setBounds(0, 0, 1366, 390);
        b1.addActionListener(this);
        
        l1.add(b1);
        add(l1);
    }
    
    public void actionPerformed(ActionEvent ae){
        new Login().setVisible(true);
        this.setVisible(false);
    }

    public static void main(String[] args) {
        LibraryManagementSystem window = new LibraryManagementSystem();
        window.setVisible(true);
    }
}
