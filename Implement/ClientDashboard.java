package dk.dtu.management.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

	
public class ClientDashboard implements ActionListener{
	
	private static JFrame frame; // frame for the entire thing
	private static JPanel panel;
	private static JLabel title; // title for the client interface 
	private static JLabel orgin;
	private static JTextField enterOrigin;
	private static JLabel content;
	private static JTextField enterContent;
	private static JLabel destination;
	private static JTextField enterDestination;
	private static JButton search;
	private static JButton update;
	private static JButton logout;
	public static DefaultTableModel model;
	public static JTable table;
	private static JButton AddSelected;
	private static JButton RemoveSelected;
	
	
	public ClientDashboard(){
		
		frame = new JFrame("Client Dashboard");
		frame.setSize(600,340);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		frame.add(panel);
		panel.setLayout(null);
		
		title = new JLabel("Client's Dashboard");
		title.setBounds(20,5,110,50);
		panel.add(title);
		
		orgin = new JLabel("Origin");
		orgin.setBounds(20,35,110,50);
		panel.add(orgin);
		
		enterOrigin = new JTextField(20);
		enterOrigin.setBounds(20, 70, 110, 30);
		panel.add(enterOrigin);
		
		content = new JLabel("Content");
		content.setBounds(20,95,110,50);
		panel.add(content);
		
		enterContent = new JTextField(20);
		enterContent.setBounds(20, 130, 110, 30);
		panel.add(enterContent);
		
		destination = new JLabel("Destination");
		destination.setBounds(20,155,110,50);
		panel.add(destination);
		
		enterDestination = new JTextField(20);
		enterDestination.setBounds(20, 190, 110, 30);
		panel.add(enterDestination);
		
		search = new JButton("Search");
		search.setBounds(20, 240, 110, 30);
		search.addActionListener(e -> {
			// search based on the text fields 
			String content = enterContent.getText();
			String destination = enterDestination.getText();
			String origin = enterOrigin.getText();
			
		for(int i = 0; i<model.getRowCount(); i++) {
			
			// we can also delete the rows that don't qualify, to be discussed later// print out all info??
			
			if(origin.equals(model.getValueAt(i, 1).toString())) {
				System.out.println(model.getValueAt(i, 1).toString());
			}
			if(destination.equals(model.getValueAt(i, 2).toString())) {
				System.out.println(model.getValueAt(i, 2).toString());
			}
			if(content.equals(model.getValueAt(i, 3).toString())) {
				System.out.println(model.getValueAt(i, 3).toString());
			}
		}
			
		});
		// implement click of a button search here
		
		panel.add(search);
		
		// other buttons
		
		// UPDATE
		update = new JButton("Update");
		update.setBounds(330, 20, 110, 30);
		// implement action reader
		update.addActionListener(e -> {
			frame.dispose();
			Update n = new Update();
			model.setValueAt("a".toString(), 2, 1);
		});
		panel.add(update);
		
		
		// LOGOUT
		logout = new JButton("Log out");
		logout.setBounds(450,20,110,30);
		// implement action reader here
		logout.addActionListener(e -> { // logout puts us back into the login page
		    frame.dispose();
		    LogIn n = new LogIn();
		});
		panel.add(logout);
		
		
		// ADD NEW JOURNEY
		AddSelected = new JButton("Add");
		AddSelected.setBounds(330, 240, 110, 30);
		AddSelected.addActionListener(e -> {
		    frame.dispose();
		    Add n = new Add();
		});
		panel.add(AddSelected);
		//frame.add(AddSelected);
		
		
		// REMOVE SELECTED
		RemoveSelected =new JButton("Remove");
		RemoveSelected.setBounds(450,240,110,30);
		// implement action reader here
		RemoveSelected.addActionListener(e -> {
			
			for(int i = 0; i<table.getRowCount(); i++) {
				
				boolean selected = Boolean.valueOf(table.getValueAt(i, 4).toString());
				
				if(selected) {
					model.removeRow(i); // works perfectly!
					// don't forget to make changes in the database
				}	
			}	
		});
		
		panel.add(RemoveSelected);
		
		// TABLE
		// data must come from the database!!

		
	      //COLUMN HEADERS
	        String[] columnHeaders={"ID","Origin","Destination","Content","Mark"};
	    
	    // modeling the table //
	    
	       model = new DefaultTableModel(null, columnHeaders){
	          public Class<?> getColumnClass(int column){
	            switch(column){
	            case 0:
	              return String.class;
	            case 1:
	              return String.class;
	            case 2:
	              return String.class;
	            case 3:
	              return String.class;
	            case 4:
	              return Boolean.class;

	            default:
	              return String.class;
	              }
	          }
	     };        
	        
	    table = new JTable(model) ;
	    
	    // FILLING the row
	    
	    for(int i=0;i<=7;i++) // set for int i : hashmap length
	    {
	      model.addRow(new Object[i]); // add new object for every entry
	      
	      // all the entries should originate from a map. Use hashmap.getname(i) or similar to get each entry value
	      
	      model.setValueAt(i,i,0); // 0th column ID 
	      model.setValueAt("Origin"+(i+1), i, 1); // 1st column
	      model.setValueAt("Destination", i, 2); // 2nd column
	      model.setValueAt("Content", i, 3); // 3rd column
	      model.setValueAt(false, i, 4); // 4th column, initially everything is false
	      
	    }
	    

		table.getColumnModel().getColumn(0).setPreferredWidth(5);
		table.getColumnModel().getColumn(4).setPreferredWidth(5);
		table.setRowHeight(30);
		
		// scrollable form 
		
		JScrollPane scrollable = new JScrollPane(table);
		scrollable.setBounds(200, 70, 360, 150);
	    scrollable.setVisible(true);
		panel.add(scrollable);
		
		// 
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		
		new ClientDashboard();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}



}
