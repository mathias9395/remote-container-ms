package dk.dtu.management.view;

import javax.swing.JFrame;
import javax.swing.JTextField;

import dk.dtu.management.controller.AddStatusController;

import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JOptionPane;
@SuppressWarnings("serial")
public class AddStatusView extends JFrame{
	private AddStatusController controller;
	private JFormattedTextField tempField;
	private JFormattedTextField humidityField;
	private JFormattedTextField pressureField;
	private JTextField locationField;

	
	
	public AddStatusView(AddStatusController controller) {
		this.controller = controller;
		initGUI();
	}
	
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Add Status");
		setPreferredSize(new Dimension(350, 200));
		
		
		
		
		// labels
		JLabel tempLabel = new JLabel("Temperature:*");
		JLabel humidityLabel= new JLabel("Humidity:*");
		JLabel pressureLabel = new JLabel("Pressure:*");
		JLabel locationLabel = new JLabel("Location:");
		
		// fields
		NumberFormat format = NumberFormat.getNumberInstance();
		format.setGroupingUsed(false);
		//format.setGroupingUsed(true);
		format.setMaximumIntegerDigits(10);
		format.setMinimumIntegerDigits(0);
		format.setMaximumFractionDigits(3);
		format.setMinimumFractionDigits(0);
		format.setRoundingMode(RoundingMode.HALF_UP);
		tempField = new JFormattedTextField(format);
		humidityField = new JFormattedTextField(format);
		pressureField = new JFormattedTextField(format);
		locationField = new JTextField(10);
		
		// buttons
		JButton btnAddStatus = new JButton("Add status");
		btnAddStatus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.addStatus();
			}
		});
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.returnDashboard();
			}
		});
		
		
		setLayout(new GridLayout(5,2));
		add(tempLabel);
		add(tempField);
		add(pressureLabel);
		add(humidityField);
		add(humidityLabel);
		add(pressureField);
		add(locationLabel);
		add(locationField);
		add(btnAddStatus);
		add(btnCancel);
		
		
		
		pack();
		setResizable(false);
		setLocationRelativeTo(null);
	}
	
	public String getTempField() {
		return tempField.getText();
		//Might have to get changed to this 
		//setText(String.valueOf(controller.getTemperature()));
	}
	
	public String getHumidityField() {
		return humidityField.getText();
	}
	
	public String getLocationField() {
		return locationField.getText();
	}
	
	
	
	public String getpressureField() {
		return pressureField.getText();
	}
		
		public void showError() {
			JOptionPane.showMessageDialog(this, "Not all fields were filled out", "Create status error", JOptionPane.ERROR_MESSAGE);
		}
	}
