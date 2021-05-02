package dk.dtu.management.view;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;

import dk.dtu.management.controller.AddStatusController;
import dk.dtu.management.util.JTextFieldLimit;

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
		JLabel tempLabel = new JLabel("Temperature (K):*");
		JLabel humidityLabel= new JLabel("Humidity (%):*");
		JLabel pressureLabel = new JLabel("Pressure (hPa):*");
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
		
		NumberFormatter formatterT = new NumberFormatter(format);
		formatterT.setMinimum(0.0); // below zero K cannot be achieved
		formatterT.setMaximum(5800.0); // no realistic container temperature can be higher

		NumberFormatter formatterH = new NumberFormatter(format);
		formatterH.setMinimum(0.0);
		formatterH.setMaximum(100.0); // humidity can range from 0% to 100%
		
		NumberFormatter formatterP = new NumberFormatter(format);
		formatterP.setMinimum(0.0);
		formatterP.setMaximum(1080.0); // pressure range
		
		tempField = new JFormattedTextField(formatterT);
		humidityField = new JFormattedTextField(formatterH);
		pressureField = new JFormattedTextField(formatterP);
		locationField = new JTextField(10);
		locationField.setDocument(new JTextFieldLimit(60));
		
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
		add(pressureField);
		add(humidityLabel);
		add(humidityField);
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
