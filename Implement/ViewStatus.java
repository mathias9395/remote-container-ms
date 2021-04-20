package dk.dtu.management.view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


class ViewStatus {
	
	ContainerInfo Ctinf = new ContainerInfo();
	
	ViewStatus(){    
		JFrame f=new JFrame("Container Status"); 
		JButton b=new JButton("Back");    
		b.setBounds(25,250,140, 40);
		
		JLabel label = new JLabel();		
		label.setText("Temperature:");
		label.setBounds(100, 50, 100, 30);
		
		JLabel label2 = new JLabel();
		label2.setText("Humidity:");
		label2.setBounds(80, 100, 100, 30);
		
		JLabel label3 = new JLabel();
		label3.setText("Pressure:");
		label3.setBounds(50, 150, 100, 30);
		
		JLabel Variable1 = new JLabel();
		Variable1.setBounds(125, 50, 130, 30);
		
		JLabel Variable2 = new JLabel();
		Variable2.setBounds(125, 100, 130, 30);
		
		JLabel Variable3 = new JLabel();
		Variable3.setBounds(125, 150, 130, 30);
		
		
		f.add(label);
		f.add(label2);
		f.add(label3);
		f.add(Variable1);
		f.add(Variable2);
		f.add(Variable3);
		f.add(b);
		f.setSize(350,350);    
		f.setLayout(null);    
		f.setVisible(true);    
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Variable1.setText(Ctinf.getTemperature());
		Variable2.setText(Ctinf.getHumidity());
		Variable3.setText(Ctinf.getPressure());
		
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				f.dispose();
				new ClientDestination();  				
			}          
	      });
		}
	
	
		public static void main(String[] args) {    
			new ViewStatus();    
		}    
 }

	
