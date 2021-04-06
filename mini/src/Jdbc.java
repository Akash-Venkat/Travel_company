import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import java.awt.event.*;
public class Jdbc {
	JFrame f;  String a;
	//String id;
	String bs1,id1,da1,hra1,all1,sal1;
	public Jdbc() throws ClassNotFoundException {
		 f=new JFrame();  
		    
			JLabel bs,id,da,hra,all,sal;		    
			JTextField t1=new JTextField(8);
			JTextField t2=new JTextField(7);
			JTextField t3=new JTextField(5);
			JTextField t4=new JTextField(5);
			JTextField t5=new JTextField(5);
			JTextField t6=new JTextField(5);
			JButton b0=new JButton("CALCULATE");
			JButton b1=new JButton("INSERT");
			JButton b2=new JButton("CANCEL");
			JButton y1=new JButton("REFRESH");
			JSeparator s=new JSeparator();
			//JRadioButton r1=new JRadioButton("AC");
			//JRadioButton r2=new JRadioButton("NON-AC");
			//ButtonGroup bg= new ButtonGroup();
			//bg.add(r1);
			//bg.add(r2);
			id=new JLabel("ENTER EMPLOYEE ID");
			bs=new JLabel("ENTER BASIC SALARY");
			da=new JLabel("ENTER % OF DA");
			hra=new JLabel("ENTER % OF HRA");
			all=new JLabel("ENTER ALLOWANCE");
			sal=new JLabel("NET SALARY");
		    JPanel p1=new JPanel();  
		    JPanel p2=new JPanel();
		    p1.add(id);
		    p1.add(bs);
		    p1.add(da);
		    p1.add(hra);
		    p1.add(all);
		    p1.add(sal);
		    p1.add(b1);
		    p1.add(b2);
		    p1.add(b0);
		    p1.add(t1);
		    p1.add(t2);
		    p1.add(t3);
		    //p1.add(r1);
		    //p1.add(r2);
		    p1.add(t4);
		    p1.add(t5);
		    p1.add(s);
		    p1.add(t6);
		   
			//head.setBounds(400,30,300,100);
			id.setBounds(200,100,200,100);
			t1.setBounds(500,150,200,30);
			bs.setBounds(200,200,200,100);
			t2.setBounds(500,250,200,30);
			da.setBounds(200,300,200,100);
			t3.setBounds(500,350,200,30);
			hra.setBounds(200,400,200,100);
			all.setBounds(200,500,200,50);
			//r2.setBounds(600,480,80,50);
			sal.setBounds(200, 600, 200, 100);
			t4.setBounds(500,450,200,30);
			t5.setBounds(500,530,200,30);
			t6.setBounds(500,650,200,30);
			b0.setBounds(150,700,200,50);
			b1.setBounds(350,700,200,50);
			b2.setBounds(550,700,200,50);
		   
		    JTabbedPane tp=new JTabbedPane(); 
		    
		    tp.setBounds(10,10,1000,1000);  
		    tp.add("ADD DATA",p1);  
		    tp.add("DELETE DATA",p2);  
		    
		    p1.setBackground(Color.darkGray);
		    p2.setBackground(Color.darkGray);
		    id.setForeground(Color.WHITE);
		    bs.setForeground(Color.WHITE);
		    da.setForeground(Color.WHITE);
		    hra.setForeground(Color.WHITE);
		    all.setForeground(Color.WHITE);
		    sal.setForeground(Color.cyan);
		    //head.setFont(new Font("serif",Font.BOLD,20));		
			
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
		    b0.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					float bs2,da2,hra2,all2,net2;
					// TODO Auto-generated method stub
					bs1=t2.getText();
					da1=t3.getText();
					hra1=t4.getText();
					all1=t5.getText();
					bs2=Float.parseFloat(bs1);
					da2=Float.parseFloat(da1);
					hra2=Float.parseFloat(hra1);
					all2=Float.parseFloat(all1);
					net2=bs2+((((da2/100)*bs2)+((hra2/100)*bs2)+all2)-3500);
					sal1=Float.toString(net2);
					t6.setText(sal1);
					
				}
		    	
		    });
		    b1.addActionListener(new ActionListener() {
				 public void actionPerformed(ActionEvent e)
				{
					//id1=t1.getText(); 
					try
					{System.out.println("hello");
						id1=t1.getText();
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost/test?serverTimezone=UTC","root","");
						java.sql.Statement stmt=con.createStatement();
						((java.sql.Statement) stmt).executeUpdate("insert into emp values('"+id1+"','"+bs1+"','"+da1+"','"+hra1+"','"+all1+"','"+sal1+"')");
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
		    String query1="SELECT id FROM emp";
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
					           
					        	 a=rs.getString("id");
					        	 
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
		           
		        	 a=rs.getString("id");
		        	 
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
					((java.sql.Statement) stmt).executeUpdate("delete from emp where id='"+city2+"'");
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
						 
				String query5="delete FROM emp";
			    
				try
				{
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost/test?serverTimezone=UTC","root","");
					java.sql.Statement stmt=con.createStatement();
					((java.sql.Statement) stmt).executeUpdate("delete from emp");
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
        new Jdbc();
      
    }

}
