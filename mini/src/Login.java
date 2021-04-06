import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login {
	Boolean res=false;
  
	Login()
    {
    	
    	String pass="1234"; 
         JFrame f=new JFrame("Admin Login");
         JLabel l=new JLabel("Admin Enter Your Passsword to Add Bus Details");
         JPasswordField t=new JPasswordField(15);
         JButton b=new JButton("LOGIN");
         f.setForeground(Color.darkGray);
         f.setLayout(null);
         f.setSize(600,500);
         f.setVisible(true);
         f.setLayout(null);
         f.add(l); f.add(t);f.add(b);
         l.setBounds(100,40,500,25);
         t.setBounds(170,150,300,30);
         b.setBounds(260,250,100,50);
         t.setToolTipText("Admin password");
         
         l.setFont(new Font("serif",Font.BOLD,20));
         
        
         b.addActionListener(new ActionListener() {
 		 public void actionPerformed(ActionEvent e)
 		{
 			String word =new String(t.getPassword());   
 	         
 	         if(pass.equals(word))
 	         {
 	        	 res=true;
 	         }
 			if(res)
			 {
 				JOptionPane.showMessageDialog(null,"LOGIN SUCCESSFULL");
 				try {
					new Dummy();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
 				f.dispose();
 				
 				
			 }
 			else
 			{
 				
 				t.setText(null);
 				JOptionPane.showMessageDialog(null,"LOGIN FAILED-INVALID PASSWORD");
 				
 			}
 		}});
         
         b.addMouseListener(new java.awt.event.MouseAdapter() {
		    	public void mouseEntered(java.awt.event.MouseEvent evt) {
		    		b.setBackground(Color.GREEN);
		    	}
		    	public void mouseExited(java.awt.event.MouseEvent evt) {
		    		b.setBackground(Color.CYAN);
		    	}
		    });
         f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 			
    }
         
	
		public static void main(String[] args) {
        new Login();
      
    }

   
    
}
