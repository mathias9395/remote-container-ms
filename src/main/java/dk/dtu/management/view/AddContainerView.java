package dk.dtu.management.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import dk.dtu.management.controller.AddContainerController;
import dk.dtu.management.util.JTextFieldLimit;
@SuppressWarnings("serial")
public class AddContainerView extends JFrame {
	private AddContainerController controller;
	private JTextField txtLocation;
	

	public AddContainerView(AddContainerController controller) {
		this.controller = controller;
		initGUI();
	}
	
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Add Container");
		
		
		
		
		// labels
		JLabel lblLocation = new JLabel(" Location:");
		
		// fields
		txtLocation = new JTextField(10);
		txtLocation.setDocument(new JTextFieldLimit(60));
		
		// buttons
		JButton btnAddClient = new JButton("Add container");
		btnAddClient.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.addContainer();
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
		setPreferredSize(new Dimension(300, 250));
		setLayout(new GridLayout(6,2));
		
		add(lblLocation);
		add(txtLocation);
		add(btnAddClient);
		add(btnCancel);
		
		
		
		pack();
		setResizable(false);
		setLocationRelativeTo(null);
	}
	
	public String getLocationField() {
		return txtLocation.getText();
	}

	public void showError() {
		JOptionPane.showMessageDialog(this, "Not all fields were filled out", "Create container error", JOptionPane.ERROR_MESSAGE);
		
	}

}
