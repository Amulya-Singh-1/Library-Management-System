package library.management.system;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
public class Loading extends JFrame implements Runnable{
    private JPanel contentPanel;
    private JProgressBar progressBar;
    Connection con;
    int s;
    Thread th;
    
    public static void main(String[] args){
        new Loading().setVisible(true);
    }
    
    public void setUploading(){
        th.start();
    }
    
    public void run(){
        try{
            for(int i=0; i<200; i++){
                s=s+1;
                int m=progressBar.getMaximum();
                int v=progressBar.getValue();
                if(v<m){
                    progressBar.setValue(progressBar.getValue()+1);
                }else{
                    i=201;
                    setVisible(false);
                    new Home().setVisible(true);
                }
                Thread.sleep(50);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public Loading(){
        super("Loading");
        th= new Thread((Runnable) this);
        setBounds(600, 300, 600, 400);
        contentPanel = new JPanel();
        setContentPane(contentPanel);
        contentPanel.setLayout(null);
        
        JLabel lblLibraryManagement = new JLabel("Virtual Library");
        lblLibraryManagement.setForeground(Color.lightGray);
        lblLibraryManagement.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
        lblLibraryManagement.setBounds(130, 46, 500, 35);
        contentPanel.add(lblLibraryManagement);
        
        progressBar= new JProgressBar();
        progressBar.setFont(new Font("Tahoma", Font.BOLD, 12));
        progressBar.setStringPainted(true);
        progressBar.setBounds(130, 135, 300, 25);
        contentPanel.add(progressBar);
        
        JLabel lbl2=new JLabel("Please wait");
        lbl2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
        lbl2.setForeground(new Color(160, 82, 45));
        lbl2.setBounds(200, 165, 150, 20);
        contentPanel.add(lbl2);
        
        JPanel panel = new JPanel();
        panel.setBackground(Color.white);
        panel.setBounds(0, 0, 590, 390);
        contentPanel.add(panel);
        
        setUploading();
    }
}
