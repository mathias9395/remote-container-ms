package dk.dtu.management.view;



import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class AddStatus {
	

	public AddStatus (){    
		JFrame f=new JFrame("Add status"); 
					//submit button
		JButton b=new JButton("Submit");    
		b.setBounds(95,200,140, 40);    
					//enter name label
		
		JLabel label = new JLabel();		
		label.setText("Enter Temp:");
		label.setBounds(25, 15, 100, 100);
					//empty label which will show event after button clicked
		
		JLabel label2 = new JLabel();
		label2.setText("Enter Humidity:");
		label2.setBounds(10, 65, 100, 100);
		
		JLabel label3 = new JLabel();
		label3.setText("Enter Pressure:");
		label3.setBounds(5, 115, 100, 100);
		
		JLabel input = new JLabel();
		input.setBounds(10, 210, 200, 100);
					//textfield to enter name
		
		JTextField textfield= new JTextField();
		textfield.setBounds(100, 50, 130, 30);
					//add to frame
		
		JTextField textfield2= new JTextField();
		textfield2.setBounds(100, 100, 130, 30);
		
		JTextField textfield3= new JTextField();
		textfield3.setBounds(100, 150, 130, 30);
		
		f.add(input);
		f.add(textfield);
		f.add(textfield2);
		f.add(textfield3);
		f.add(label);
		f.add(label2);
		f.add(label3);
		f.add(b);    
		f.setSize(300,350);    
		f.setLayout(null);    
		f.setVisible(true);    
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
		f.setResizable(false);
		
							//action listener
		b.addActionListener(new ActionListener() {
	        
			@Override
			public void actionPerformed(ActionEvent arg0) {
				input.setText("Your status has been added.");				
			}          
	      });
		}         
	
	
		public static void main(String[] args) {    
		    new AddStatus ();    
		}    
 }

	
