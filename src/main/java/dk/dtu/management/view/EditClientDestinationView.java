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
import java.awt.GridLayout;

import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class EditClientDestinationView extends JFrame{
	
	private ContainerController controller;
	private JTextField idField;
	private JTextField originField;
	private JTextField destinationField;
	private JTextField contentField;
	
	
	public EditClientDestinationView(ContainerController controller) {
		this.controller = controller;
		initGUI();	
	}
	
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Client Destination");
	
		//labels
		JLabel idLabel = new JLabel("ID:");
		JLabel originLabel= new JLabel("Origin:");
		JLabel destinationLabel = new JLabel("Destination:");
		JLabel contentLabel = new JLabel("Content:");
		{
		
			//fields
			idField = new JTextField(10);
			originField = new JTextField(10);
			destinationField = new JTextField(10);
			contentField = new JTextField(10);
			
			//buttons
			JButton btnAddEdit = new JButton("Submit");
			btnAddEdit.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					controller.addEdit();
					//probably something to go back aswell
				}
			});
		
	        setPreferredSize(new Dimension(300, 200));
			setLayout(new GridLayout(4,2));
			
			add(idLabel);
			add(idField);
			add(originLabel);
			add(originField);
			add(destinationLabel);
			add(destinationField);
			add(contentLabel);
			add(contentField);
			
			pack();
			setResizable(false);
			setLocationRelativeTo(null);
		}
	}
	

		public String getidField() {
			return idField.getText();
		}
		
		public String getoriginField() {
			return originField.getText();
		}
		
		public String getdestinationField() {
			return destinationField.getText();
		}
		
		public String getcontentField() {
			return contentField.getText();
		}
		
		public void showError() {
			JOptionPane.showMessageDialog(this, "ayo the pizza here", "how", JOptionPane.ERROR_MESSAGE);
		}
		
	}

