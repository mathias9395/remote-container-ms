package dk.dtu.management.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import dk.dtu.management.controller.UpdateClientController;
import dk.dtu.management.model.Client;

public class updateClientInfo extends JFrame {
	private UpdateClientController controller;
	private Client client;
	private JButton button;
	private JTextField textRef;
	private JTextField textEma;
	private JLabel updateMessage;
	
	public updateClientInfo(UpdateClientController controller){
		this.controller = controller;
		initGUI();
	}
	
	private void initGUI() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		
		button = new JButton("Update Information");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==button) {
					if(!textRef.getText().equals("Reference Person")) {
						client.setReferencePerson(textRef.getText());
					}
					if(!textEma.getText().equals("Email Address")) {
						client.setEmail(textEma.getText());
					}
					updateMessage.setVisible(true);
				}
			}
		});
		
		textRef = new JTextField();
		textRef.setPreferredSize(new Dimension(250,40));
		textRef.setText("Reference Person");
		
		textEma = new JTextField();
		textEma.setPreferredSize(new Dimension(250,40));
		textEma.setText("Email Address");
		
		updateMessage = new JLabel("Update Successful");
		updateMessage.setVisible(false);
		
		this.add(button);
		this.add(textRef);
		this.add(textEma);
		this.add(updateMessage);
		this.pack();
		this.setVisible(true);
		
	}
}
