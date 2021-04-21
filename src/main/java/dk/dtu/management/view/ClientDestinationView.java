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


public class ClientDestinationView extends JFrame{
	
	private ContainerController controller;
	private JLabel id;
	private JLabel origin;
	private JLabel destination;
	private JLabel content;
	
	public ClientDestinationView(ContainerController controller) {
		this.controller = controller;
		initGUI();
	}
	
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Client Destination");
		setPreferredSize(new Dimension(350,350));
		
		//labels
		JLabel idLabel = new JLabel("ID:");
		JLabel originLabel= new JLabel("Origin:");
		JLabel destinationLabel = new JLabel("Destination:");
		JLabel contentLabel = new JLabel("Content:");
		
		{
			//labelData
			id = new JLabel(getidField());
			origin = new JLabel(getoriginField());
			destination = new JLabel(getdestinationField());
			content = new JLabel(getcontentField());
			
			//buttons
			JButton btnGotoEdit = new JButton("Edit");
			btnGotoEdit.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					controller.gotoEdit(); //Close this and go to EditClientDestinationView.java
				}
			});
			
			JButton btnGotoStatus = new JButton("View status");
			btnGotoStatus.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					controller.gotoStatus(); //Close this and go to StatusView.java
				}
			});
			
			setLayout(new FlowLayout());
			add(idLabel);
			add(id);
			add(originLabel);
			add(origin);
			add(destinationLabel);
			add(destination);
			add(contentLabel);
			add(content);
			
			pack();
			setLocationRelativeTo(null);
		}
	}
	
	public String getidField() {
		return id.getText();
	}
	
	public String getoriginField() {
		return origin.getText();
	}
	
	public String getdestinationField() {
		return destination.getText();
	}
	
	public String getcontentField() {
		return content.getText();
	}
	
	public void showError() {
		JOptionPane.showMessageDialog(this, "ayo the pizza here", "how", JOptionPane.ERROR_MESSAGE);
	}
	
}
