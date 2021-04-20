package dk.dtu.management.view;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Add extends JFrame implements ActionListener{

    private static final String Vector = null;
	JButton button;
    JLabel label;
    JLabel l1;
    JTextField origin;
    JLabel l2;
    JTextField destination;
    JLabel l3;
    JTextField content;

    public Add() {

        label = new JLabel("Add a journey");
        label.setBounds(20, 10, 300, 30);
        add(label);
        
        l1 = new JLabel("origin");
        l1.setBounds(20, 70, 300, 30);
        add(l1);
        
        l2 = new JLabel("destination");
        l2.setBounds(20, 120, 300, 30);
        add(l2);
        
        l3 = new JLabel("content");
        l3.setBounds(20, 170, 300, 30);
        add(l3);

        button = new JButton("Place a new journey");
        button.setBounds(20,300,180,40);
        button.addActionListener(e -> {
        	
        	String newOrigin = origin.getText();
        	String newDestination = destination.getText();
        	String newContent = content.getText();
        	
        	ClientDashboard c = new ClientDashboard();
        	c.model.addRow(new Object[] {"ID", newOrigin,newDestination,newContent, false});
        	dispose();
        });
        
        add(button);
        
        origin = new JTextField(20);
        origin.setBounds(20, 100, 110, 25);
        add(origin);
        
        destination = new JTextField(20);
        destination.setBounds(20, 150, 110, 25);
        add(destination);
        
        content = new JTextField(20);
        content.setBounds(20, 200, 110, 25);
        add(content);

        setLayout(null);
        setSize(350, 400);
        setVisible(true);
        
        
        
    }
    
	public static void main(String[] args) {
		
		Add c = new Add();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}