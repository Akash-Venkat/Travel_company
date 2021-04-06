import java.awt.BorderLayout;  
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;  
import javax.swing.JComboBox;  
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextArea;  
import javax.swing.JToolBar;  
  
public class Sample implements ActionListener
{ 
	JTextArea t1;
	static JMenuBar mb; 
	static JMenu x;  
    static JMenuItem contact, tourism;
    static JButton b1,b2,b3;
	Sample(){
		JFrame myframe = new JFrame("About us");  
        myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // create a menubar 
        mb = new JMenuBar(); 
  
        // create a menu 
        x = new JMenu("Menu"); 
  
        // create menuitems 
        contact = new JMenuItem("contact"); 
        tourism = new JMenuItem("tourism"); 
          
        // add menu items to menu 
        x.add(contact); 
        x.add(tourism); 
          
        // add menu to menu bar 
        mb.add(x); myframe.add(mb, BorderLayout.PAGE_START);
  
        JToolBar toolbar = new JToolBar();  
        toolbar.setRollover(false);  
         b1 = new JButton("CONTACT");
         b2 = new JButton("TOURISM");
         b3 = new JButton("GRAB TICKETS");
        toolbar.add(b1);  
        toolbar.addSeparator();  
        toolbar.add(b2); 
        toolbar.addSeparator();  
        toolbar.add(b3);
        mb.setBounds(50, 50, 50, 80);
	     
        Container contentPane = myframe.getContentPane();  
        contentPane.add(toolbar, BorderLayout.PAGE_END);  
         //t1 = new JTextArea();  
        JScrollPane mypane = new JScrollPane(t1);  
        contentPane.add(mypane, BorderLayout.EAST);  
        myframe.setSize(1100, 800);
        //t1.setBounds(100, 100, 200, 200);
        myframe.setVisible(true); 
        
        contact.addActionListener(this);
        tourism.addActionListener(this);
        
         t1 = new JTextArea(30, 200);  
        JScrollPane scrollablet1 = new JScrollPane(t1);  
        t1.setText("\t\t\t\tCome with us Travels\n\n\nThe powerful inclination of American voyagers to travel more nowadays is something that\n"
        		+ "keeps us inspired to satisfy your vacation necessities. Our vision to give you a consistent\n"
        		+ "occasion encounter makes us one of the main visit administrators in the regularly\n extending travel industry."
        		+ "\n\n");
  
        scrollablet1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollablet1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
        myframe.add(scrollablet1);
        
        b1.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e)
			{
				 b1.setEnabled(false);
				 b2.setEnabled(true);
				 tourism.setEnabled(true);
				 contact.setEnabled(false);
				t1.setText("\t\t\t\tContact\n\n\nEMAIL:comewithus@gmail.com\n\nPH.NO:2282268");
			}
		});
        b2.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e)
			{
				 b2.setEnabled(false);
				 b1.setEnabled(true);
				 tourism.setEnabled(false);
				 contact.setEnabled(true);
				t1.setText("\t\t\t\tTOURISM WE OFFER\n\n\n*INDUSTRIAL VISIT\n*INPLANT TRAING\n*SCHOOL TOURS\n*COLLEGE TOURS\n*SUMMER VACATION");
			}
		});
        
      
        
	}
    public static void main(final String args[]) {  
        new Sample();
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==tourism)
		{
			
			t1.setText("\t\t\t\tTOURISM WE OFFER\n\n\n*INDUSTRIAL VISIT\n*INPLANT TRAING\n*SCHOOL TOURS\n*COLLEGE TOURS\n*SUMMER VACATION");
			System.out.print("hello");
			b2.setEnabled(false);
			b1.setEnabled(true);
			tourism.setEnabled(false);
			contact.setEnabled(true);
		}
		else
		if(e.getSource()==contact)
		{
			t1.setText("\t\t\t\tContact\n\n\nEMAIL:comewithus@gmail.com\n\nPH.NO:2282268");
			b1.setEnabled(false);
			b2.setEnabled(true);
			contact.setEnabled(false);
			tourism.setEnabled(true);
		}
		
	}  
}  
