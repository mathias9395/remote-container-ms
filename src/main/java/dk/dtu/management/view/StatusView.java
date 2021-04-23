package dk.dtu.management.view;

import javax.swing.JFrame;
import javax.swing.JTextField;

import dk.dtu.management.controller.ContainerController;

import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import javax.swing.JOptionPane;


public class StatusView extends JFrame{
	
	private ContainerController controller;
	private JLabel temp;
	private JLabel humidity;
	private JLabel pressure;

	public StatusView(ContainerController controller) {
		this.controller = controller;
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
			//labelData
			temp = new JLabel(gettempField());
			humidity = new JLabel(gethumidityField());
			pressure = new JLabel(getpressureField());
			
			//buttons
			JButton btnGotoEdit = new JButton("Back");
			btnGotoEdit.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					controller.gotoBack(); //Close this and go to ClientDestinationView.java
				}
			});
			
			setLayout(new FlowLayout());
			add(tempLabel);
			add(temp);
			add(humidityLabel);
			add(humidity);
			add(pressureLabel);
			add(pressure);
			
			pack();
			setLocationRelativeTo(null);
		}
	}

	public String gettempField() {
		return temp.getText();
	}
	
	public String gethumidityField() {
		return humidity.getText();
	}
	
	public String getpressureField() {
		return pressure.getText();
	}
	
	public void showError() {
		JOptionPane.showMessageDialog(this, "ayo the pizza here", "how", JOptionPane.ERROR_MESSAGE);
	}
	
}