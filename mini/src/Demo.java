import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Set;
import java.sql.*;
import static java.time.Clock.system;
import static javafx.beans.binding.Bindings.select;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;  
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import javax.swing.*;

public class Demo implements ActionListener
{  
	JFrame f; String city,a;
	JMenu menu1,menu2,menu3;
	JMenuItem i1,i2,i3,i10,fm;
	Demo()throws ClassNotFoundException
	{  
		f=new JFrame();  
		DefaultTableModel model=new DefaultTableModel();
		JTable jtbl=new JTable(model);
		model.addColumn("CITY");
		model.addColumn("TIMING");
		model.addColumn("PRICE");
		model.addColumn("AC/NON-AC");		
		JMenuBar mb=new JMenuBar();
		menu1=new JMenu("HOME");
		menu2=new JMenu("REGISTER");
		menu3=new JMenu("ABOUT");
		i1=new JMenuItem("our service");
		fm=new JMenuItem("MAIN PAGE");
		i2=new JMenuItem("BOOK NOW",KeyEvent.VK_B);
		i2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,InputEvent.CTRL_MASK));
		i3=new JMenuItem("EXIT");
		i10=new JMenuItem("CONTACT US");
		menu1.add(i1);menu2.add(i2);menu3.add(i10);menu3.add(i3);menu1.add(fm);
		mb.add(menu1);mb.add(menu2);mb.add(menu3);
		f.setJMenuBar(mb);
		f.setSize(1000, 700);
		f.setLayout(null);
		f.setVisible(true);
		i1.addActionListener(this);
		i2.addActionListener(this);
		i3.addActionListener(this);
		
		JPanel p1=new JPanel();  
		JPanel p2=new JPanel();  
		JTabbedPane tp=new JTabbedPane(); 
		tp.setBounds(10,10,1000,700);  
		tp.add("FIND BUS",p1);  
		tp.add("BUS SCHEDULE",p2);  
		f.add(tp);  
		f.setSize(1000,800);  
		f.setLayout(null);  
		f.setVisible(true);
		
		JLabel head,search,cost,time,ac,no;
		JTextField t2,t3,t4,t5;
		JComboBox t1=new JComboBox();
		t2=new JTextField(20);
		t3=new JTextField(20);
		t4=new JTextField(20);
		t5=new JTextField(3);
		head=new JLabel("SEARCH FOR YOUR BUS");
		search=new JLabel("Enter The District You Want To Travel");
		time=new JLabel("TIME");
	    cost=new JLabel("FARE FOR SINGLE TICKET");
		head=new JLabel("SEARCH FOR YOUR BUS");
		ac=new JLabel("AC/NON-AC");
		no=new JLabel("NO.of seats available");
		JButton b3=new JButton("FIND");
		JButton b4=new JButton("EXIT");
		JButton b5=new JButton("CLEAR");
		
		p1.add(head);
		p1.add(search);
		p1.add(cost);
		p1.add(time);
		p1.add(ac);
		p1.add(t1);
		p1.add(t2);
		p1.add(t3);
		p1.add(t4);
		p1.add(b4);
		p1.add(b3);
		p1.add(b5);
		p1.add(no);
		p1.add(t5);
		p1.setLayout(null);
		p1.setVisible(true);
		p1.setBackground(Color.darkGray);
	    p2.setBackground(Color.darkGray);
	    head.setForeground(Color.WHITE);
	    search.setForeground(Color.WHITE);
	    cost.setForeground(Color.WHITE);
	    time.setForeground(Color.WHITE);
	    no.setForeground(Color.WHITE);
	    ac.setForeground(Color.WHITE);
	    head.setFont(new Font("serif",Font.BOLD,20));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		head.setBounds(380,30,260,80);
		search.setBounds(100,150,300,80);
		t1.setBounds(400,180,200,30);
		b3.setBounds(700,180,80,30);
		time.setBounds(100,250,200,80);
		t2.setBounds(400,280,200,30);
		cost.setBounds(100,350,200,80);
		t3.setBounds(400,380,200,30);
		ac.setBounds(100,450,200,80);
		t4.setBounds(400,480,200,30);
		no.setBounds(100,550,200,80);
		t5.setBounds(400,580,200,30);
		b5.setBounds(700,300,80,30);
		b4.setBounds(700,420,80,30);		
		String query1="SELECT city FROM input";   
	       
        try {
            java.sql.PreparedStatement ps = DriverManager.getConnection("jdbc:mysql://localhost/test?serverTimezone=UTC","root","").prepareStatement(query1);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
               
            	 a=rs.getString("city");
            	 t1.addItem(a);
            	
            }
           
       
        } catch (SQLException ex) {
        	
        	System.out.println(ex);
        }       
	
	b3.addActionListener(new ActionListener() {
 		 public void actionPerformed(ActionEvent e)
 		{
 			 String city1=(String) t1.getSelectedItem();
 			 
 			String query="SELECT * FROM input WHERE city=?";
 		    
 	       
 	        try {
 	            java.sql.PreparedStatement ps = DriverManager.getConnection("jdbc:mysql://localhost/test?serverTimezone=UTC","root","").prepareStatement(query);
 	            ps.setString(1,city1);
 	            ResultSet rs = ps.executeQuery();
 	            while(rs.next())
 	            {
 	               
 	            	String a=rs.getString(1);
 	            	System.out.print(a);
 	                t2.setText(rs.getString(2));
 	                t3.setText(rs.getString(3));
 	                t4.setText(rs.getString(4));
 	                t5.setText(rs.getString(5));
 	               
 	            }
 	       
 	        } catch (SQLException ex) {
 	        	
 	        	System.out.println(ex);
 	        }
 		}
	 });
	b4.addActionListener(new ActionListener() {
 		 public void actionPerformed(ActionEvent e)
 		{
 			 f.dispose();
 			 try {
				new AJP();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
 		}
	 });
	b5.addActionListener(new ActionListener() {
 		 public void actionPerformed(ActionEvent e)
 		{
 			// t1.setText(null);
 			t2.setText(null);
 			t3.setText(null);
 			t4.setText(null);
 		}
	 });
    
    
	String query0="SELECT * FROM input";
	model.addRow(new Object[] {"CITY","TIME","FARE","AC/NON-AC"});  
     
     try {
         java.sql.PreparedStatement ps = DriverManager.getConnection("jdbc:mysql://localhost/test?serverTimezone=UTC","root","").prepareStatement(query0);
         ResultSet rs = ps.executeQuery();
         while(rs.next())
         {
            
        	 model.addRow(new Object[] {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)});
            
         }
    
     } catch (SQLException ex) {
     	
     	System.out.println(ex);
     }
     p2.add(jtbl);
     //f.add(new JScrollPane(p2));
     
   
 

	}
public static void main(String[] args) throws ClassNotFoundException {
	new Demo();
}



@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(e.getSource()==i1)
	{
		f.dispose();
		new Sample();
		
	}
	if(e.getSource()==fm)
	{
		f.dispose();
		try {
			new AJP();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	if(e.getSource()==i3)
	{
		f.dispose();
	}
	if(e.getSource()==i2)
	{
		f.dispose();
		try {
			new Register();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		};
	}
	
}

}

   

       


