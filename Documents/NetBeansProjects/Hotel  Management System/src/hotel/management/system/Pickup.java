/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;
import java.sql.*;


public class Pickup extends JFrame implements ActionListener{
    
    Choice c1;
    JButton b1,b2;
    JTable t1;
    
    Pickup(){
        
        JLabel l1 = new JLabel("Pickup Service");
        l1.setFont(new Font("Tahoma", Font.PLAIN,20));
        l1.setForeground(Color.BLUE);
        l1.setBounds(420, 30, 200, 30);
        add(l1);
        
        JLabel l2 = new JLabel("Type of car");
        l2.setBounds(80, 70, 100,20);
        add(l2);
        
        c1 = new Choice();
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from driver");
            while(rs.next()){
                c1.add(rs.getString("model"));
            }
            
        }catch(Exception e){
            
        }
        c1.setBounds(180,70,200,25);
        add(c1);
        
        
        
        
        t1 = new JTable();
        t1.setBounds(0,130,1000,250);
        add(t1);
        
        b1 = new JButton("Submit");
        b1.setBounds(250,400,120,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Back");
        b2.setBounds(400,400,120,30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);
        
        JLabel l3 = new JLabel("Name");
        l3.setBounds(50, 100, 100,20);
        add(l3);
        
        JLabel l4 = new JLabel("Age");
        l4.setBounds(180, 100, 100,20);
        add(l4);
        
        JLabel l5 = new JLabel("Gender");
        l5.setBounds(320, 100, 100,20);
        add(l5);
        
        JLabel l6 = new JLabel("Car Company");
        l6.setBounds(450, 100, 100,20);
        add(l6);
        
        JLabel l8 = new JLabel("Brand");
        l8.setBounds(620, 100, 100,20);
        add(l8);
        
        JLabel l7 = new JLabel("Availibility");
        l7.setBounds(760, 100, 100,20);
        add(l7);
        
        JLabel l9 = new JLabel("Location");
        l9.setBounds(890, 100, 100,20);
        add(l9);
        
        getContentPane().setBackground(Color.white);
        
        
        setLayout(null);
        setBounds(200,180,1000,500);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            try{
                String str = "select * from driver where model = '"+c1.getSelectedItem()+"'";
                
                conn c = new conn();
                ResultSet rs = c.s.executeQuery(str);
                t1.setModel(DbUtils.resultSetToTableModel(rs));
                
                    
                    
                
                
            }catch(Exception e){}
            
        }else if(ae.getSource() == b2){
            new Reception().setVisible(true);
            this.setVisible(false);
            
        }
    }
    
    public static void main(String [ ] args){
        new Pickup().setVisible(true);
    }
}
