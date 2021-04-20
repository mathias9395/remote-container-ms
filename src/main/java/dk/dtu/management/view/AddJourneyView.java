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

import dk.dtu.management.controller.AddJourneyController;

public class AddJourneyView extends JFrame {
	private AddJourneyController controller;
	JButton button;
    JLabel label;
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
		setPreferredSize(new Dimension(350, 400));
		setLayout(new FlowLayout());
		label = new JLabel("Add a journey");
        label.setBounds(20, 10, 300, 30);
        
        
        l1 = new JLabel("Origin:");
        l1.setBounds(20, 70, 300, 30);
        
        
        l2 = new JLabel("Destination:");
        l2.setBounds(20, 120, 300, 30);
        
        
        l3 = new JLabel("Content:");
        l3.setBounds(20, 170, 300, 30);
        
        l4 = new JLabel("Company:");
        l4.setBounds(20, 170, 300, 30);
        

        button = new JButton("Create");
        button.setBounds(20,300,180,40);
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
        origin.setBounds(20, 100, 110, 25);
       
        
        destination = new JTextField(20);
        destination.setBounds(20, 150, 110, 25);
        
        
        content = new JTextField(20);
        content.setBounds(20, 200, 110, 25);
        
        company = new JTextField(20);
        company.setBounds(20, 200, 110, 25);
        

        
        
        
        add(label);
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












