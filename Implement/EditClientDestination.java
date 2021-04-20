package dk.dtu.management.view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


class EditClientDestination {
	
	ContainerInfo Ctinf = new ContainerInfo(); //This is fucked lol
	
	EditClientDestination(){    
		JFrame f=new JFrame("Client Destination"); 
		JButton b=new JButton("Submit");    
		b.setBounds(100,250,140, 40); 
		
		JLabel label = new JLabel();		
		label.setText("ID:");
		label.setBounds(100, 15, 100, 100);
		
		JLabel label2 = new JLabel();
		label2.setText("Origin:");
		label2.setBounds(80, 65, 100, 100);
		
		JLabel label3 = new JLabel();
		label3.setText("Destination:");
		label3.setBounds(50, 115, 100, 100);
		
		JLabel label4 = new JLabel();
		label4.setText("Content:");
		label4.setBounds(70, 165, 100, 100);
		
		JTextField textfield1= new JTextField();
		textfield1.setBounds(125, 50, 130, 30);
		
		JTextField textfield2= new JTextField();
		textfield2.setBounds(125, 100, 130, 30);
		
		JTextField textfield3= new JTextField();
		textfield3.setBounds(125, 150, 130, 30);
		
		JTextField textfield4= new JTextField();
		textfield4.setBounds(125, 200, 130, 30);
		
		
		f.add(textfield1);
		f.add(textfield2);
		f.add(textfield3);
		f.add(textfield4);
		f.add(label);
		f.add(label2);
		f.add(label3);
		f.add(label4);
		f.add(b);
		f.setSize(350,350);    
		f.setLayout(null);    
		f.setVisible(true);    
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
		
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Ctinf.setID(String.valueOf(textfield1.getText()));
				Ctinf.setOrigin(textfield2.getText());
				Ctinf.setDestination(textfield3.getText());
				Ctinf.setContent(textfield4.getText());
				f.dispose();
				new ClientDestination();			
			}          
	      });
		}         
	
	
		public static void main(String[] args) {    
		    new EditClientDestination ();    
		}    
 }

	
