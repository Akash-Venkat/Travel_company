import javax.swing.tree.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import java.util.*;
public class AJP {

    AJP()throws ClassNotFoundException 
    {
    	
        JFrame f=new JFrame("AAA-Travels");        
        JTree tree;
        JLabel l=new JLabel(new ImageIcon("C:\\Users\\gj\\Pictures\\Screenshots\\Screenshot (59).png"));
        JLabel l1=new JLabel(new ImageIcon("C:\\Users\\gj\\Desktop\\Desktop\\DBMS project picture\\aback.jfif"));        
        DefaultMutableTreeNode root,child1,child2;
        root=new DefaultMutableTreeNode("LOGIN");
        child1=new DefaultMutableTreeNode("ADMIN");
        child2=new DefaultMutableTreeNode("CUSTOMER");
        root.add(child1);
        root.add(child2);
        tree=new JTree(root);
        tree.setSize(150,700);
        f.setLayout(null);f.setVisible(true);
        f.add(tree);
        f.setSize(1280,800);
        f.add(l);f.add(l1);l.setBounds(150,0,1000,700);
        final JPopupMenu pm=new JPopupMenu("main");
	    JMenuItem m1=new JMenuItem("ADMIN");pm.add(m1);
	    JMenuItem m2=new JMenuItem("CUSTOMER");pm.add(m2);
        tree.setForeground(Color.DARK_GRAY);
        JTextArea textArea = new JTextArea(20, 20);  
        JScrollPane scrollableTextArea = new JScrollPane(textArea);  
        scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
        scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
        f.getContentPane().add(scrollableTextArea);  
        
        tree.addTreeSelectionListener(new TreeSelectionListener(){
            public void valueChanged(TreeSelectionEvent tse){
               TreePath tp=tree.getSelectionPath();
                if(tp!=null)
                {
                    Object filePathToAdd=tp.getLastPathComponent();
                     System.out.println(filePathToAdd);
                    if(filePathToAdd.equals(child1))
                    {
                        
                        System.out.println("hello admin");
                        f.dispose();
                        new Login();
                        
                    }
                    else
                    {
                        if(filePathToAdd.equals(child2))
                        {f.dispose();
                        	try {
								new Demo();
							} catch (ClassNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
                            System.out.println("hello customer");
                        }
                    }
                }
            }

           
        });
        
        
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

   
   
    public static void main(String[] args) throws ClassNotFoundException {
        new AJP();
      
    }
    
}
