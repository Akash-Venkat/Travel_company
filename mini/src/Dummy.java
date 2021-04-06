import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.*;
import java.awt.event.*;
public class Dummy {
	JFrame f;  String a;
	public Dummy() throws ClassNotFoundException {
		 f=new JFrame();  
		    JLabel dis,time,amt,con,head,no;		    
			JTextField t1=new JTextField(15);
			JTextField t2=new JTextField("Rs",5);
			JTextField t3=new JTextField(6);
			JTextField t4=new JTextField(3);
			JButton b1=new JButton("INSERT");
			JButton b2=new JButton("CANCEL");
			JButton y1=new JButton("REFRESH");
			JRadioButton r1=new JRadioButton("AC");
			JRadioButton r2=new JRadioButton("NON-AC");
			ButtonGroup bg= new ButtonGroup();
			bg.add(r1);
			bg.add(r2);
			dis=new JLabel("Enter the district");
			head=new JLabel("ENTER THE BUS SCHEDULE");
			time=new JLabel("Enter arrival time");
			amt=new JLabel("Enter cost per head");
			con=new JLabel("Available Bus is in AC/NON-AC");
			no=new JLabel("NO.of seats available");
		    JPanel p1=new JPanel();  
		    JPanel p2=new JPanel();
		    p1.add(head);
		    p1.add(dis);
		    p1.add(time);
		    p1.add(amt);
		    p1.add(con);
		    p1.add(b1);
		    p1.add(b2);
		    p1.add(t1);
		    p1.add(t2);
		    p1.add(t3);
		    p1.add(r1);
		    p1.add(r2);
		    p1.add(no);
		    p1.add(t4);
		   
			head.setBounds(400,30,300,100);
			dis.setBounds(200,150,100,100);
			t1.setBounds(500,190,200,30);
			time.setBounds(200,250,100,100);
			t3.setBounds(500,290,200,30);
			t3.setToolTipText("hrs:min am/pm");
			amt.setBounds(200,350,150,100);
			t2.setBounds(500,390,200,30);
			con.setBounds(200,450,200,100);
			r1.setBounds(500,480,80,50);
			r2.setBounds(600,480,80,50);
			no.setBounds(200, 550, 150, 100);
			t4.setBounds(500,580,200,30);
			b1.setBounds(350,680,100,50);
			b2.setBounds(550,680,100,50);
		   
		    JTabbedPane tp=new JTabbedPane(); 
		    
		    tp.setBounds(10,10,1000,1000);  
		    tp.add("ADD BUSES",p1);  
		    tp.add("DELETE BUSES",p2);  
		    
		    p1.setBackground(Color.darkGray);
		    p2.setBackground(Color.darkGray);
		    dis.setForeground(Color.WHITE);
		    time.setForeground(Color.WHITE);
		    amt.setForeground(Color.WHITE);
		    con.setForeground(Color.WHITE);
		    no.setForeground(Color.WHITE);
		    head.setForeground(Color.cyan);
		    head.setFont(new Font("serif",Font.BOLD,20));		
			
		    f.add(tp);  
		    f.setSize(1000,850);  
		    f.setLayout(null);  p1.setLayout(null);
		    f.setVisible(true); 
		    p1.setLayout(null);p2.setLayout(null);	    
	   		
			
			JLabel z1=new JLabel("REMOVE THE BUSES");
			z1.setForeground(Color.WHITE);
			z1.setFont(new Font("serif",Font.BOLD,20));
			JComboBox z2=new JComboBox();
			JButton bb1,bb2,bb3;
			bb1=new JButton("DELETE");
			bb2=new JButton("DELETE ALL");
			bb3=new JButton("CLOSE");
			p2.add(z1);
			p2.add(z2);
			p2.add(bb1);p2.add(bb2);p2.add(bb3);p2.add(y1);
			z1.setBounds(400,30,220,80);
			z2.setBounds(100,270,300,60);
			bb1.setBounds(500,280,80,30);
			bb2.setBounds(600,280,120,30);
			bb3.setBounds(740,280,80,30);
			y1.setBounds(840,280,100,30);	
	    
		    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  		    
		    b1.addActionListener(new ActionListener() {
				 public void actionPerformed(ActionEvent e)
				{
					 
					try
					{System.out.println("hello");
					String ac="NON-AC";
					if(r1.isSelected())
					{
						ac="AC";
					}
					String district=t1.getText();
					 String time=t3.getText();
					 String price=t2.getText();
					 String seat=t4.getText();
					 int seat1=Integer.parseInt(seat);
					 int price1=Integer.parseInt(price);
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost/test?serverTimezone=UTC","root","");
						java.sql.Statement stmt=con.createStatement();
						String g=t1.getText();
		                String g1=t2.getText();
						System.out.println(g);
						((java.sql.Statement) stmt).executeUpdate("insert into input values('"+district+"','"+time+"','"+price1+"','"+ac+"','"+seat1+"')");
						JOptionPane.showMessageDialog(null,"INSERTED SUCCESSFULLY");
						t1.setText(null);
						t2.setText(null);
						t3.setText(null);
						t4.setText(null);
						stmt.close();
						con.close();
					}
					catch(SQLException ex)
					{
						System.out.println(ex);
					
					}
					
				}
			 });
		    String query1="SELECT city FROM input";
			 b2.addActionListener(new ActionListener() {
				 public void actionPerformed(ActionEvent e)
				{
					 f.dispose();
				}
			 });
			 
			 y1.addActionListener(new ActionListener() {
				 public void actionPerformed(ActionEvent e)
				{
					 try {
						 	z2.removeAllItems();
					        java.sql.PreparedStatement ps = DriverManager.getConnection("jdbc:mysql://localhost/test?serverTimezone=UTC","root","").prepareStatement(query1);
					        ResultSet rs = ps.executeQuery();
					        while(rs.next())
					        {
					           
					        	 a=rs.getString("city");
					        	 
					        	 z2.addItem(a);
					        	
					        }
				}
					 catch(SQLException ex)
						{
							System.out.println(ex);
						
						}
			 }});
		    
		    try {
		        java.sql.PreparedStatement ps = DriverManager.getConnection("jdbc:mysql://localhost/test?serverTimezone=UTC","root","").prepareStatement(query1);
		        ResultSet rs = ps.executeQuery();
		        while(rs.next())
		        {
		           
		        	 a=rs.getString("city");
		        	 
		        	 z2.addItem(a);
		        	
		        }
		       
		   
		    } catch (SQLException ex) {
		    	
		    	System.out.println(ex);
		    }
		    
		    b1.addMouseListener(new java.awt.event.MouseAdapter() {
		    	public void mouseEntered(java.awt.event.MouseEvent evt) {
		    		b1.setBackground(Color.GREEN);
		    	}
		    	public void mouseExited(java.awt.event.MouseEvent evt) {
		    		b1.setBackground(Color.CYAN);
		    	}
		    });
		    
		    b2.addMouseListener(new java.awt.event.MouseAdapter() {
		    	public void mouseEntered(java.awt.event.MouseEvent evt) {
		    		b2.setBackground(Color.red);
		    	}
		    	public void mouseExited(java.awt.event.MouseEvent evt) {
		    		b2.setBackground(Color.CYAN);
		    	}
		    });




		bb1.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e)
			{
				 String city2=(String) z2.getSelectedItem();
				 
				
				try
				{
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost/test?serverTimezone=UTC","root","");
					java.sql.Statement stmt=con.createStatement();
					((java.sql.Statement) stmt).executeUpdate("delete from input where city='"+city2+"'");
					JOptionPane.showMessageDialog(null,"DELETED SUCCESSFULLY");

					stmt.close();
					con.close();
				}
				catch(SQLException ex)
				{
					System.out.println(ex);
				
				}
		      
		     
			}
		});
		bb2.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e)
			{
						 
				String query5="delete FROM input";
			    
				try
				{
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost/test?serverTimezone=UTC","root","");
					java.sql.Statement stmt=con.createStatement();
					((java.sql.Statement) stmt).executeUpdate("delete from input");
					JOptionPane.showMessageDialog(null,"DELETED ALL INPUTS SUCCESSFULLY");
					
					((Connection) stmt).close();
					con.close();
				}
				catch(SQLException ex)
				{
					System.out.println(ex);
				
				}
		   
			}
		});
		bb3.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e)
			{
				f.dispose();
			}
		});
		
	
	}
	public static void main(String[] args) throws ClassNotFoundException {
        new Dummy();
      
    }

}
