package dk.dtu.management.view;

import javax.swing.JFrame;
import javax.swing.JTextField;

import dk.dtu.management.controller.ClientViewStatusController;


import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import javax.swing.JOptionPane;


public class StatusView extends JFrame{
	
	private ClientViewStatusController controller;
	private JLabel tempField;
	private JLabel humidityField;
	private JLabel pressureField;

	public StatusView( ClientViewStatusController controller) {
		this.controller =controller;
		initGUI();
	}
	
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Client Destination");
		setPreferredSize(new Dimension(350,350));
		
		//labels
		JLabel tempLabel = new JLabel("Temperature:");
		JLabel humidityLabel= new JLabel("Humidity:");
		JLabel pressureLabel = new JLabel("Pressure:");
		
		{
			
			 
			
			JTextField txtTemp = new JTextField(10);
			txtTemp.setText(String.valueOf(controller.getTemperature()));
			JTextField txtHumidity = new JTextField(10);
			txtHumidity.setText(String.valueOf(controller.getHumidity()));
			JTextField txtPressure = new JTextField(10);
			txtPressure.setText(String.valueOf(controller.getPressure()));
			
	
			
			//buttons
			JButton btnCancel = new JButton("Cancel");
			btnCancel.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					controller.returnDashboard(); //Close this and go to ClientDestinationView.java
				}
			});
			
			setLayout(new FlowLayout());
			add(tempLabel);
			add(tempField);
			add(humidityLabel);
			add(humidityField);
			add(pressureLabel);
			add(pressureField);
			
			pack();
			setLocationRelativeTo(null);
		}
	}
}
	