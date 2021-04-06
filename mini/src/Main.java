import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Main implements ActionListener{
	JMenu menu1,menu2,menu3;
	JMenuItem i1,i2,i3,i4;
	JFrame f;
	public Main() {
		
		f=new JFrame("Main");
		JMenuBar mb=new JMenuBar();
		menu1=new JMenu("HOME");
		menu2=new JMenu("REGISTER");
		menu3=new JMenu("ABOUT");
		i1=new JMenuItem("MAIN PAGE");
		i2=new JMenuItem("BOOK NOW");
		i3=new JMenuItem("CONTACT US");
		i4=new JMenuItem("EXIT");
		menu1.add(i1);menu3.add(i3);menu3.add(i4);menu2.add(i2);
		mb.add(menu1);mb.add(menu2);mb.add(menu3);
		f.setJMenuBar(mb);
		f.setSize(1000, 700);
		f.setLayout(null);
		f.setVisible(true);
		i1.addActionListener(this);
		i2.addActionListener(this);
		menu2.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e)  {
		
		if(e.getSource()==menu2)
		{
			try
			 {
				new AJP();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource()==i2)
		{
			try {
				new Demo();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			f.dispose();
		}
	}
	 public static void main(String[] args) {
	        new Main();
	      
	    }

}
