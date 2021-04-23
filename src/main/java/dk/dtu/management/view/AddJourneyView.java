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
import javax.swing.JTextField;

import dk.dtu.management.controller.AddJourneyController;

public class AddJourneyView extends JFrame {
	private AddJourneyController controller;
	JButton button;
    JLabel l1;
    JTextField origin;
    JLabel l2;
    JTextField destination;
    JLabel l3;
    JLabel l4;
    JTextField content;
    JTextField company;
	
	public AddJourneyView(AddJourneyController controller) {
		this.controller = controller;
		initGUI();
	}
	
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Add Journey");
         
        l1 = new JLabel("Origin:");
        l2 = new JLabel("Destination:");
        l3 = new JLabel("Content:");
        l4 = new JLabel("Company:");
        

        button = new JButton("Create");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.addJourney();
			}
		});
        JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.returnDashboard();
			}
		});
        
        
        
        origin = new JTextField(20);
        destination = new JTextField(20);
        content = new JTextField(20);
        company = new JTextField(20);

        setPreferredSize(new Dimension(300, 200));
		setLayout(new GridLayout(5,2));
        
        
        add(l1);
        add(origin);
        add(l2);
        add(destination);
        add(l3);
        add(content);
        add(l4);
        add(company);
        add(button);
        add(btnCancel);
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
	}
	
	public String getOrigin() {
		return origin.getText();
	}
	
	public String getDestination() {
		return destination.getText();
	}
	
	public String getContent() {
		return content.getText();
	}
	
	public String getCompany() {
		return company.getText();
	}
	
	public void showError() {
		JOptionPane.showMessageDialog(this, "Not all fields were filled out", "Add journey error", JOptionPane.ERROR_MESSAGE);
	}
}

