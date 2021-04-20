package dk.dtu.management.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dk.dtu.management.controller.ClientSettingsController;

public class ClientSettingsView extends JFrame {

	private ClientSettingsController controller;
	
	public ClientSettingsView(ClientSettingsController controller) {
		this.controller = controller;
		initGUI();
	}
	
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Settings");
		setPreferredSize(new Dimension(350, 400));
		setLayout(new FlowLayout());
		
		// labels
		JLabel lblName = new JLabel("Name:");
		JLabel lblEmail = new JLabel("Email:");
		JLabel lblReferencePerson = new JLabel("Reference person:");
		JLabel lblAddress = new JLabel("Address:");
		
		// text fields
		JTextField txtName = new JTextField(10);
		txtName.setText(controller.getName());
		JTextField txtEmail = new JTextField(10);
		txtEmail.setText(controller.getEmail());
		JTextField txtReferencePerson = new JTextField(10);
		txtReferencePerson.setText(controller.getReferencePerson());
		JTextField txtAddress = new JTextField(10);
		txtAddress.setText(controller.getAddress());
		
		// buttons
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.updateClient(txtName.getText(),txtEmail.getText(),txtReferencePerson.getText(),txtAddress.getText());
			}
		});
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.returnDashboard();
			}
		});
		
		add(lblName);
		add(txtName);
		add(lblEmail);
		add(txtEmail);
		add(lblReferencePerson);
		add(txtReferencePerson);
		add(lblAddress);
		add(txtAddress);
		add(btnSave);
		add(btnCancel);
		
		pack();
		setLocationRelativeTo(null);
		
		
		
	}

	public void showEmptyError() {
		JOptionPane.showMessageDialog(this, "Not all fields were filled out", "Error", JOptionPane.ERROR_MESSAGE);
		
	}
	
	public void showEmailError() {
		JOptionPane.showMessageDialog(this, "Email is already in use", "Error", JOptionPane.ERROR_MESSAGE);
	}

}
