package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;




public class AddRooms extends JFrame implements ActionListener{
    JTextField t1,t2;
    JComboBox c1,c2,c3;
    JButton b1,b2;
    
    AddRooms(){
        
        
        JLabel l1 = new JLabel("Add Rooms");
        l1.setFont(new Font("Tahoma", Font.BOLD,18));
        l1.setBounds(150,20,100,20);
        add(l1);
        
        JLabel room = new JLabel("Room Number");
        room.setFont(new Font("Tahoma", Font.BOLD,18));
        room.setBounds(60,80,130,30);
        add(room);
        
        t1 = new JTextField();
        t1.setBounds(200,80,150,30);
        add(t1);
        
        JLabel available = new JLabel("Available");
        available.setFont(new Font("Tahoma", Font.BOLD,18));
        available.setBounds(60,130,130,30);
        add(available);
        
        c1 = new JComboBox(new String[] { "Available", "Occupied" });
        c1.setBackground(Color.WHITE);
	c1.setBounds(200, 130, 150, 30);
	add(c1);
        
        JLabel status = new JLabel("Cleaning Status");
        status.setFont(new Font("Tahoma", Font.BOLD,18));
        status.setBounds(57,180,300,40);
        add(status);
        
        c2 = new JComboBox(new String[] { "Clean", "Dirty" });
        c2.setBackground(Color.WHITE);
	c2.setBounds(200, 180, 150, 30);
	add(c2);
        
        JLabel price = new JLabel("Price");
        price.setFont(new Font("Tahoma", Font.BOLD,18));
        price.setBounds(60,230,130,30);
        add(price);
        
        t2 = new JTextField();
        t2.setBounds(200,230,150,30);
        add(t2);
        
        JLabel type = new JLabel("Bed Type");
        type.setFont(new Font("Tahoma", Font.BOLD,18));
        type.setBounds(60,280,130,30);
        add(type);
        
        c3 = new JComboBox(new String[] { "Single Bed", "Double Bed" });
        c3.setBackground(Color.WHITE);
	c3.setBounds(200, 280, 150, 30);
	add(c3);
        
        b1 = new JButton("Add Room");
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(60,350,120,30);
        add(b1);
        
        b2 = new JButton("Back");
        b2.addActionListener(this);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(230,350,120,30);
        add(b2);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/Icons/twelve.jpg"));
        JLabel l5 = new JLabel(i1);
        l5.setBounds(400,40,450,350);
        add(l5);
        
        getContentPane().setBackground(Color.WHITE);
        
        setBounds(250,150,900,500);
        setLayout(null);
        setVisible(true);
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            String room = t1.getText();
            String  available = (String)c1.getSelectedItem();
            String status = (String)c2.getSelectedItem();
            String price = t2.getText();
            String type = (String)c3.getSelectedItem();
            
            
            conn c = new conn();
            try{
                String str = "insert into room values( '"+room+"', '"+available+"', '"+status+"','"+price+"', '"+type+"')";
                c.s.executeUpdate(str);
		JOptionPane.showMessageDialog(null, "Room Successfully Added");
                this.setVisible(false);
            }catch(Exception e){}
            
            
           
        }else if(ae.getSource() == b2){
            this.setVisible(false);
        }
    }
    public static void main(String [] args){
       new AddRooms().setVisible(true); 
    }
    
    
}
