package dk.dtu.management.view;

import java.awt.Dimension;

import javax.swing.JFrame;

import dk.dtu.management.controller.ClientDashboardController;

public class ClientDashboardView extends JFrame {
	ClientDashboardController controller;
	
	
	public ClientDashboardView(ClientDashboardController controller) {
		this.controller = controller;
		initGUI();
	}
	
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(controller.getUser() + "'s Dashboard");
		setPreferredSize(new Dimension(800, 600));
		
		pack();
		setLocationRelativeTo(null);
	}
}
