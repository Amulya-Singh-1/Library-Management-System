package library.management.system;

import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener{
    private JPanel panel;
    private JTextField tf;
    private JPasswordField pf;
    private JButton b1 , b2 , b3;
    
    public Login(){
        setLayout(null);
        setBackground(Color.WHITE);
        setBounds(500, 250, 600, 400);
        
        panel= new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.lightGray);
        setContentPane(panel);
        
        JLabel l1= new JLabel("User");
        l1.setBounds(124, 89 , 95 ,24);
        l1.setForeground(Color.ORANGE);
        panel.add(l1);
        JLabel l2=new JLabel("Pswd");
        l2.setBounds(124,124 ,95, 24);
        l2.setForeground(Color.orange);
        panel.add(l2);
        
        tf= new JTextField();
        tf.setBounds(210, 93, 157 , 20);
        panel.add(tf);
        pf=new JPasswordField();
        pf.setBounds(210, 128 , 157, 20);
        panel.add(pf);
        
        b1=new JButton("Login");
        b1.addActionListener(this);
        b1.setForeground(Color.CYAN);
        b1.setBackground(Color.GRAY);
        b1.setBounds(149 , 181 , 113 , 39);
        panel.add(b1);
        
        b2=new JButton("SignUp");
        b2.addActionListener(this);
        b2.setForeground(Color.black);
        b2.setBackground(Color.red);
        b2.setBounds(289 , 181 , 113 , 39);
        panel.add(b2);
        
        b3=new JButton("Forgot Password");
        b3.addActionListener(this);
        b3.setForeground(Color.BLACK);
        b3.setBackground(Color.red);
        b3.setBounds(199 , 231 , 150 , 39);
        panel.add(b3);
        
        JLabel l3=new JLabel("Login Problems");
        l3.setForeground(Color.red);
        l3.setBounds(100,231 ,95, 24);
        panel.add(l3);
        
        JPanel panel2=new JPanel();
        panel2.setBackground(Color.darkGray);
        panel2.setBounds(80, 40 , 434 ,263);
        panel.add(panel2);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            Boolean status=false;
            try{
                conn con= new conn();
                String sql="select * from account where User=? and Pswd=?";
                PreparedStatement pst= con.c.prepareStatement(sql);
                
                pst.setString(1, tf.getText());
                pst.setString(2, pf.getText());
                
                ResultSet rs=pst.executeQuery();
                if(rs.next()){
                    this.setVisible(false);
                    new Loading().setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid Login!");
                }
            }catch(Exception e2){
                e2.printStackTrace();
            }
        }
        if(ae.getSource()== b2){
            setVisible(false);
            new Signup().setVisible(true);
        }
        if(ae.getSource()== b3){
            setVisible(false);
            new Forgot().setVisible(true);
        }
    }
    
    public static void main(String[] args){
        new Login().setVisible(true);
    }
    
}
