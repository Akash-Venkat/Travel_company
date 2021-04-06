import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;

public class Register {
	JFrame f;
	public Register() throws ClassNotFoundException {
		f=new JFrame(); 
		f.setSize(700,700);
		f.setLayout(null);
		f.setVisible(true);
		JLabel name,mob,dis,no,head;
		JTextField t1=new JTextField();
		JTextField t2=new JTextField();
		JTextField t3=new JTextField(1);
		JButton b1=new JButton("BOOK");
		JComboBox z1=new JComboBox();
		head=new JLabel("GRAB UR TICKETS NOW (YOU CANT ABLE TO CANCEL TICKETS)");
		name=new JLabel("NAME");
		mob=new JLabel("PH.NO");
		dis=new JLabel("DESTINATION");
		no	=new JLabel("NO.OF SEATS");
		final JPopupMenu pm=new JPopupMenu("main");
	    JMenuItem m1=new JMenuItem("Main Menu");pm.add(m1);
	    f.add(pm);

		f.add(name);
		f.add(mob);
		f.add(dis);
		f.add(no);
		f.add(head);
		f.add(t1);
		f.add(t2);
		f.add(t3);
		f.add(z1);
		f.add(b1);
		
		head.setBounds(230,40,500,25);
		name.setBounds(100,160,200,80);
		t1.setBounds(300,180,200,30);
		mob.setBounds(100,230,200,80);
		t2.setBounds(300,250,200,30);
		dis.setBounds(100,290,200,80);
		z1.setBounds(300,310,200,30);
		no.setBounds(100,350,200,80);
		t3.setBounds(300,380,200,30);
		b1.setBounds(300,500,80,40);
		
		
		head.setForeground(Color.DARK_GRAY);
	    head.setFont(new Font("serif",Font.BOLD,20));
		name.setForeground(Color.DARK_GRAY);
		mob.setForeground(Color.DARK_GRAY);
		dis.setForeground(Color.DARK_GRAY);
		no.setForeground(Color.DARK_GRAY);
		f.setBackground(Color.DARK_GRAY);
		
		String query1="SELECT city FROM input";
		try {
		        java.sql.PreparedStatement ps = DriverManager.getConnection("jdbc:mysql://localhost/test?serverTimezone=UTC","root","").prepareStatement(query1);
		        ResultSet rs = ps.executeQuery();
		        while(rs.next())
		        {
		           
		        	String a=rs.getString("city");
		        	 
		        	 z1.addItem(a);
		        	
		        }
		}
		catch (SQLException ex) {
	     	
	     	System.out.println(ex);
	     }
		
		b1.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e)
			{
				String name=t1.getText();
				String pno=t2.getText();
				//int pno1=Integer.parseInt(t2.getText());
				//String seat=t3.getText();
				int seat1=Integer.parseInt(t3.getText());
				String city1=(String) z1.getSelectedItem();
				int amt=0;
				int count,rem=0;
				try
				{
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost/test?serverTimezone=UTC","root","");
					java.sql.Statement stmt=con.createStatement();
					((java.sql.Statement) stmt).executeUpdate("insert into booking1 values('"+name+"','"+pno+"','"+city1+"','"+seat1+"')");
					f.dispose();
					 stmt.close();
					con.close();
					java.sql.PreparedStatement ps = DriverManager.getConnection("jdbc:mysql://localhost/test?serverTimezone=UTC","root","").prepareStatement("SELECT * FROM input where city='"+city1+"'");
			         ResultSet rs = ps.executeQuery();
			         while(rs.next())
			         {
			        count=rs.getInt(5);amt=rs.getInt(3);
			        amt=amt*seat1;
			        rem=count-seat1;
			         }
			        
			        
				}
				catch(SQLException ex)
				{
					System.out.println(ex);
				
				}	
				try
				{
					Connection con1=DriverManager.getConnection("jdbc:mysql://localhost/test?serverTimezone=UTC","root","");
					java.sql.Statement stmt1=con1.createStatement();
					((java.sql.Statement) stmt1).executeUpdate("UPDATE input SET seats='"+rem+"' WHERE city='"+city1+"'");
				}
				catch (SQLException ex) {
			     	
			     	System.out.println(ex);
			     }
				

				 JOptionPane.showMessageDialog(null,"THE TOTAL COST IS "+amt+"\nTO CONFORM BOOKING PRESS OK");
			}
		 });
f.addMouseListener(new MouseAdapter() {
			
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				pm.show(f,e.getX(),e.getY());
				
			}
		});
		m1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//f.dispose();
				try {
					new AJP();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
	}

	public static void main(String[] args) throws ClassNotFoundException{
		// TODO Auto-generated method stub
		new Register();
	}

}
