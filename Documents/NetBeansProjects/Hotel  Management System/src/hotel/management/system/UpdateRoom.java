package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;



public class UpdateRoom extends JFrame implements ActionListener{
    Choice c1;
    JTextField t1,t2,t3;
    JButton b1,b2,b3;
    
    UpdateRoom(){
        
        JLabel l1 = new JLabel("Update Room Status");
        l1.setFont(new Font("Tahoma", Font.PLAIN,20));
        l1.setForeground(Color.blue);
        l1.setBounds(30, 20, 250, 30);
        add(l1);
        
        JLabel l2 = new JLabel("GUEST ID");
        l2.setBounds(30, 80, 120, 20);
        add(l2);
        c1 = new Choice();
        try{
            conn c =  new conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while(rs.next()){
                c1.add(rs.getString("number"));
                
            }
            
        }catch(Exception e){}
        
        c1.setBounds(200,80,150,25);
        add(c1);
        
        
        JLabel l3 = new JLabel("Room Number");
        l3.setBounds(30, 120, 120, 20);
        add(l3);
        
        t1 = new JTextField();
        t1.setBounds(200,120,150,25);
        add(t1);
        
        JLabel l4 = new JLabel("Availibilty");
        l4.setBounds(30, 160, 120, 20);
        add(l4);
        
        t2 = new JTextField();
        t2.setBounds(200,160,150,25);
        add(t2);
        
        JLabel l5 = new JLabel("Clean Status");
        l5.setBounds(30, 200, 120, 20);
        add(l5);
        
        t3 = new JTextField();
        t3.setBounds(200,200,150,25);
        add(t3);
        
        
        b1 = new JButton("Check");
        b1.setBounds(135,300,120,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Update");
        b2.setBounds(40,350,120,30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);
        
        b3 = new JButton("Back");
        b3.setBounds(220,350,120,30);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.addActionListener(this);
        add(b3);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/Icons/20.jpg"));
        
        Image i2 = i1.getImage().getScaledInstance(600, 150,Image.SCALE_DEFAULT);
        ImageIcon  i3 = new ImageIcon(i2);
        JLabel l6 = new JLabel(i1);
        l6.setBounds(370,8,490,390);
        add(l6);
        
        getContentPane().setBackground(Color.white);
        
        
        setLayout(null);
        setBounds(340, 170, 890, 450);
        setVisible(true);
        
        
    }
    public static void main(String[] args){
        new UpdateRoom().setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            String room = null;
            String s1 = c1.getSelectedItem();
	    conn c = new conn();
            try{
                ResultSet rs = c.s.executeQuery("select * from customer where number = '"+s1+"'");
                
                while(rs.next()){
                    t1.setText(rs.getString("room"));
                    room = rs.getString("room");
                    
                    
                }
                ResultSet rs2 = c.s.executeQuery("select * from room where room_number = '"+room+"'");
                while(rs2.next()){
                    t2.setText(rs2.getString("available"));
                    t3.setText(rs2.getString("status"));
                    
                }
            }catch(Exception e){}
                                
            
        }else if(ae.getSource() == b2){
            try{
                conn c = new conn();
                String room = t1.getText();
                String available = t2.getText();
                String status = t3.getText();
                
                String str = "update room set available  = '"+available+"' , status = '"+status+"' where room_number = '"+room+"'";
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "Room Updated Successfully!");
                new Reception().setVisible(true);
                this.setVisible(false);
                
                
            }catch(Exception e){}
            
        }else if(ae.getSource() == b3){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }
    
}
