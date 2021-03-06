package dk.dtu.management.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import dk.dtu.management.controller.AddClientController;
import dk.dtu.management.util.JTextFieldLimit;
@SuppressWarnings("serial")
public class AddClientView extends JFrame {
	private AddClientController controller;
	private JTextField nameField;
	private JTextField emailField;
	private JTextField referencePersonField;
	private JTextField passwordField;
	private JTextField addressField;
	
	public AddClientView(AddClientController controller) {
		this.controller = controller;
		initGUI();
	}
	
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Add Client");
		
		
		
		
		// labels
		JLabel nameLabel = new JLabel(" Name:");
		JLabel emailLabel = new JLabel(" Email:");
		JLabel referencePersonLabel = new JLabel(" Reference Person:");
		JLabel passwordLabel = new JLabel(" Password:");
		JLabel addressLabel = new JLabel(" Address:");
		
		// fields
		nameField = new JTextField(10);
		nameField.setDocument(new JTextFieldLimit(60));
		
		emailField = new JTextField(10);
		emailField.setDocument(new JTextFieldLimit(60));
		
		referencePersonField = new JTextField(10);
		referencePersonField.setDocument(new JTextFieldLimit(60));
		
		passwordField = new JPasswordField(15);
		passwordField.setDocument(new JTextFieldLimit(60));
		
		addressField = new JTextField(10);
		addressField.setDocument(new JTextFieldLimit(60));
		
		// buttons
		JButton btnAddClient = new JButton("Add client");
		btnAddClient.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.addClient();
			}
		});
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.returnDashboard();
			}
		});
		
		
		// layout settings
		setPreferredSize(new Dimension(300, 200));
		setLayout(new GridLayout(6,2));
		
		add(nameLabel);
		add(nameField);
		add(emailLabel);
		add(emailField);
		add(referencePersonLabel);
		add(referencePersonField);
		add(passwordLabel);
		add(passwordField);
		add(addressLabel);
		add(addressField);
		add(btnAddClient);
		add(btnCancel);
		
		
		
		pack();
		setResizable(false);
		setLocationRelativeTo(null);
	}
	
	public String getNameField() {
		return nameField.getText();
	}
	
	public String getEmailField() {
		return emailField.getText();
	}
	
	public String getReferencePersonField() {
		return referencePersonField.getText();
	}
	
	public String getPasswordField() {
		return passwordField.getText();
	}
	
	public String getAddressField() {
		return addressField.getText();
	}
	
	public void showError() {
		JOptionPane.showMessageDialog(this, "Not all fields were filled out", "Create client error", JOptionPane.ERROR_MESSAGE);
	}
	
	public void showEmailError() {
		JOptionPane.showMessageDialog(this, "This email is already in use, please choose another email.", "Duplicate email error", JOptionPane.ERROR_MESSAGE);
	}
}
