/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocr;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class Login {
    JFrame f=new JFrame("Login Form");
    JPanel panel=new JPanel();
    JLabel label=new JLabel();
    JButton b=new JButton();
    
    Login()
    {
        init();
    }
public void init()
{
    final JPasswordField pf = new JPasswordField();   
    pf.setBounds(125,105,100,30);   
    
    final JLabel l0=new JLabel("Authentication Required!!");
    l0.setBounds(50,10, 190,30);    
    
    final JLabel l1=new JLabel("UserName:");
    l1.setBounds(40,50, 100,30);    
    
    final JLabel l2=new JLabel("Password:");    
    l2.setBounds(40,111, 100,30);    
    
    JButton b = new JButton("Login");  
    b.setBounds(100,150, 80,30);  
    
    final JTextField t1 = new JTextField();  
    t1.setBounds(125,50, 100,30);   
     f.add(l0);
     f.add(pf); 
     f.add(l1); 
     f.add(label); 
     f.add(l2); 
     f.add(b); 
     f.add(t1);  
     f.setSize(300,300);    
     f.setLayout(null);    
     f.setVisible(true);
     b.addActionListener(new ActionListener(){

        @Override
        public void actionPerformed(ActionEvent ae) {
            String s1=t1.getText();
            char[] s2=pf.getPassword();
            if(s1.equals("sridhar") && new String(s2).equals("abc@123"))
            {
            JOptionPane.showMessageDialog(null,"Welcome! "+s1); 
            f.dispose();
                try {
                    new Ocr();
                } catch (IOException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else
            {
             JOptionPane.showMessageDialog(null, "Sorry! Please Try Again!!!"); 
            }
        }   
     });
}
    public static void main(String []args){
        new Login();
    }
   
}
