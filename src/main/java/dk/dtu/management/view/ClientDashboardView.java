package dk.dtu.management.view;

import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import dk.dtu.management.controller.ClientDashboardController;

	
public class ClientDashboardView extends JFrame{
	
	private ClientDashboardController controller;
	
	private static JFrame frame; // frame for the entire thing
	private static JPanel panel;
	private static JLabel title; // title for the client interface 
	private static JLabel origin;
	private static JTextField enterOrigin;
	private static JLabel content;
	private static JTextField enterContent;
	private static JLabel destination;
	private static JTextField enterDestination;
	private static JButton search;
	private static JButton update;
	private static JButton logout;
	private DefaultTableModel model = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int row, int column) {
			if(column<4){
				return false;
			}else {
				return true;
			}
		}
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
	private static JTable table;
	private static JButton AddSelected;
	private static JButton RemoveSelected;
	
	public ClientDashboardView(ClientDashboardController controller) {
		this.controller = controller;
		initGUI();
	}
	
	
	private void initGUI() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Client Dashboard");
		setPreferredSize(new Dimension(600, 340));
		
		panel = new JPanel();
		add(panel);
		panel.setLayout(null);
		
		title = new JLabel("Client's Dashboard");
		title.setBounds(20,5,110,50);
		panel.add(title);
		
		origin = new JLabel("Origin");
		origin.setBounds(20,35,110,50);
		panel.add(origin);
		
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
		search.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.journeySearch();
			}
		});
			
		// implement click of a button search here
		
		panel.add(search);
		
		
		// other buttons
		
		// UPDATE
		update = new JButton("Settings");
		update.setBounds(330, 20, 110, 30);
		update.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.clientSettings();
			}
		});
		panel.add(update);
		
		
		// LOGOUT
		logout = new JButton("Log out");
		logout.setBounds(450,20,110,30);
		logout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.logout();
			}
		});
		
		panel.add(logout);
		
		
		// ADD NEW JOURNEY
		AddSelected = new JButton("Add");
		AddSelected.setBounds(330, 240, 110, 30);
		AddSelected.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.addJourney();
			}
		});
		panel.add(AddSelected);
		//frame.add(AddSelected);
		
		JButton btnMessage = new JButton("Send message");
		btnMessage.setBounds(210, 240, 110, 30);
		btnMessage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.sendMessage();
			}
		});
		panel.add(btnMessage);
		
		
		// REMOVE SELECTED
		RemoveSelected =new JButton("Remove");
		RemoveSelected.setBounds(450,240,110,30);
		RemoveSelected.setEnabled(false);
		RemoveSelected.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				for(int i = 0; i<table.getRowCount(); i++) {
					
					boolean selected = Boolean.valueOf(table.getValueAt(i, 4).toString());
					
					if(selected) {
						controller.removeJourney(table.getSelectedRow());
					}
				
				}
			}
		});
		panel.add(RemoveSelected);
		
		// TABLE
		// data must come from the database!!

		
	      //COLUMN HEADERS
	        String[] columnHeaders={"ID","Origin","Destination","Content","Mark"};
	    
	    // modeling the table
	    
	    
	    model.addColumn("ID");
	    model.addColumn("Origin");
	    model.addColumn("Destination");
	    model.addColumn("Content");
	    model.addColumn("Mark");
	    table = new JTable(model) ;
	    table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				RemoveSelected.setEnabled((table.getSelectedRow() >= 0));
			}
		});
	    

		table.getColumnModel().getColumn(0).setPreferredWidth(5);
		table.getColumnModel().getColumn(4).setPreferredWidth(5);
		table.setRowHeight(30);
		
		// scrollable form 
		
		JScrollPane scrollable = new JScrollPane(table);
		scrollable.setBounds(200, 70, 360, 150);
	    scrollable.setVisible(true);
		panel.add(scrollable);
		
		pack();
		setResizable(false);
		setLocationRelativeTo(null);
	}
	
	public void setTableMode(TableModel model) {
		table.setModel(model);
	}
	
	public void resetTable() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
	}
	
	public void addTableRow(Object[] object) {
		model.addRow(object);
	}
	
	public int getTableRow(int n) {
		int id = (int) model.getValueAt(n,0);
		return id;
	}
	
	public String getEnterOrigin() {
		return enterOrigin.getText();
	}
	
	public String getEnterContent() {
		return enterContent.getText();
	}
	
	public String getEnterDestination() {
		return enterDestination.getText();
	}
	
	
}
