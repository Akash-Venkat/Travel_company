import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import static java.time.Clock.system;
import static javafx.beans.binding.Bindings.select;
import javax.swing.*;  
public class Final {  
JFrame f;  String a;
Final()throws ClassNotFoundException{  
    f=new JFrame();  
    JLabel dis,time,amt,con,head;
	JTextField t1=new JTextField(15);
	JTextField t2=new JTextField("Rs",5);
	JTextField t3=new JTextField(6);
	JButton b1=new JButton("INSERT");
	JButton b2=new JButton("CANCEL");
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
	b1.setBounds(400,600,100,50);
	b2.setBounds(600,600,100,50);   
    JTabbedPane tp=new JTabbedPane();     
    tp.setBounds(10,10,1000,700);  
    tp.add("ADD BUSES",p1);  
    tp.add("DELETE BUSES",p2); 	
    f.add(tp);  
    f.setSize(1000,700);  
    f.setLayout(null);  p1.setLayout(null);
    f.setVisible(true); 
    p1.setLayout(null);p2.setLayout(null);	
	JLabel z1=new JLabel("REMOVE THE BUSES");
	JComboBox z2=new JComboBox();
	JButton bb1,bb2,bb3;
	bb1=new JButton("DELETE");
	bb2=new JButton("DELETE ALL");
	bb3=new JButton("CLOSE");
	p2.add(z1);
	p2.add(z2);
	p2.add(bb1);p2.add(bb2);p2.add(bb3);
	z1.setBounds(400,30,200,80);
	z2.setBounds(100,150,300,60);
	bb1.setBounds(100,250,80,30);
	bb2.setBounds(200,250,80,30);
	bb3.setBounds(300,250,80,30);    
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
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost/test?serverTimezone=UTC","root","");
				java.sql.Statement stmt=con.createStatement();
				String g=t1.getText();
                                   String g1=t2.getText();
				System.out.println(g);
				((java.sql.Statement) stmt).executeUpdate("insert into input values('"+district+"','"+time+"','"+price+"','"+ac+"')");
				JOptionPane.showMessageDialog(null,"INSERTED SUCCESSFULLY");
				t1.setText(null);
				t2.setText(null);
				t3.setText(null);
				((Connection) stmt).close();
				con.close();
			}
			catch(SQLException ex)
			{
				System.out.println(ex);
			
			}
			
		}
	 });
	 b2.addActionListener(new ActionListener() {
		 public void actionPerformed(ActionEvent e)
		{
			 f.dispose();
		}
	 });
    
    String query1="SELECT city FROM input";
    
    
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
bb1.addActionListener(new ActionListener() {
	 public void actionPerformed(ActionEvent e)
	{
		 String city2=(String) z2.getSelectedItem();
		 
		
		try
		{
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/test?serverTimezone=UTC","root","");
			java.sql.Statement stmt=con.createStatement();
			((java.sql.Statement) stmt).executeUpdate("delete from input where city='"+city2+"'");
			JOptionPane.showMessageDialog(null,"INSERTED SUCCESSFULLY");

			((Connection) stmt).close();
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
			JOptionPane.showMessageDialog(null,"DELETED SUCCESSFULLY");
			
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
public static void main(String[] args)     throws ClassNotFoundException{
 {  
                            Final tutorial = new Final();  
}

    } }

       