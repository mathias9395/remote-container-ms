package dk.dtu.management.view;

import javax.swing.JFrame;
import javax.swing.JTextField;

import dk.dtu.management.controller.AddStatusController;

import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JOptionPane;

public class AddStatusView extends JFrame{
	private AddStatusController controller;
	private JTextField tempField;
	private JTextField humidityField;
	private JTextField pressureField;

	
	
	public AddStatusView(AddStatusController controller) {
		this.controller = controller;
		initGUI();
	}
	
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Add Status");
		setPreferredSize(new Dimension(250, 150));
		
		
		
		
		// labels
		JLabel tempLabel = new JLabel("Temperature:");
		JLabel humidityLabel= new JLabel("Humidity:");
		JLabel pressureLabel = new JLabel("Pressure:");
		
		// fields
		tempField = new JTextField(10);
		humidityField = new JTextField(10);
		pressureField = new JTextField(10);
		
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
		
		
		setLayout(new FlowLayout());
		add(tempLabel);
		add(humidityField);
		add(pressureLabel);
		add(tempField);
		add(humidityLabel);
		add(pressureField);
		add(btnAddStatus);
		add(btnCancel);
		
		
		
		pack();
		setResizable(false);
		setLocationRelativeTo(null);
	}
	
	public String getTempField() {
		return tempField.getText();
	}
	
	public String getHumidityField() {
		return humidityField.getText();
	}
	
	public String getpressureField() {
		return pressureField.getText();
	}
		
		public void showError() {
			JOptionPane.showMessageDialog(this, "Not all fields were filled out", "Create status error", JOptionPane.ERROR_MESSAGE);
		}
	}
