package dk.dtu.management.view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class ClientDestination {
	
	ContainerInfo Ctinf = new ContainerInfo();
	
	public ClientDestination(){    
		JFrame f=new JFrame("Client Destination"); 
		JButton b=new JButton("Edit");    
		b.setBounds(25,250,140, 40);
		
		JButton b2=new JButton("View status");    
		b2.setBounds(175,250,140, 40);  
		
		JLabel label = new JLabel();		
		label.setText("ID:");
		label.setBounds(100, 50, 100, 30);
		
		JLabel label2 = new JLabel();
		label2.setText("Origin:");
		label2.setBounds(80, 100, 100, 30);
		
		JLabel label3 = new JLabel();
		label3.setText("Destination:");
		label3.setBounds(50, 150, 100, 30);
		
		JLabel label4 = new JLabel();
		label4.setText("Content:");
		label4.setBounds(70, 200, 100, 30);
		
		JLabel Variable1 = new JLabel();
		Variable1.setBounds(125, 50, 130, 30);
		
		JLabel Variable2 = new JLabel();
		Variable2.setBounds(125, 100, 130, 30);
		
		JLabel Variable3 = new JLabel();
		Variable3.setBounds(125, 150, 130, 30);
		
		JLabel Variable4 = new JLabel();
		Variable4.setBounds(125, 200, 130, 30);
		
		
		f.add(label);
		f.add(label2);
		f.add(label3);
		f.add(label4);
		f.add(Variable1);
		f.add(Variable2);
		f.add(Variable3);
		f.add(Variable4);
		f.add(b);
		f.add(b2);
		f.setSize(350,350);    
		f.setLayout(null);    
		f.setVisible(true);    
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Variable1.setText(Ctinf.getID());
		Variable2.setText(Ctinf.getOrigin());
		Variable3.setText(Ctinf.getDestination());
		Variable4.setText(Ctinf.getContent());
		
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				f.dispose();
				new EditClientDestination();				
			}          
	      });
		
		b2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				f.dispose();
				new ViewStatus();				
			}          
	      });
		}
	
	
		public static void main(String[] args) {    
			new ClientDestination();    
		}    
 }

	
