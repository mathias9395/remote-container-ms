package dk.dtu.management.view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import dk.dtu.management.controller.ClientClientsDataController;
import dk.dtu.management.controller.ApplicationController;
import dk.dtu.management.model.Client;
import dk.dtu.management.model.Journey;

public class ClientClientsDataView extends JFrame {
private ClientClientsDataController controller;
	
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
	private static BasicArrowButton back;
	private static JButton btnChat;
	private DefaultTableModel model = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
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
            default:
              return String.class;
        }
    }
	};
	private static JTable table;
	
	public ClientClientsDataView(ClientClientsDataController controller) {
		this.controller = controller;
		initGUI();
	}
	
	
	private void initGUI() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Shared Data view");
		setPreferredSize(new Dimension(600, 340));
		
		panel = new JPanel();
		add(panel);
		panel.setLayout(null);
		
		title = new JLabel(controller.getName() + "'s information");
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
		
		panel.add(search);
		
		// BACK BUTTON
		back = new BasicArrowButton(BasicArrowButton.WEST);
		back.setBounds(0,0,20,20);
		back.addActionListener(e -> { 
				controller.back();
				});
		panel.add(back);
		
		// TABLE
		// data must come from the database!!

		
	      //COLUMN HEADERS
	   String[] columnHeaders={"ID","Origin","Destination","Content","Mark"};
	    
	    // modeling the table
	        
	    model.addColumn("ID");
	    model.addColumn("Origin");
	    model.addColumn("Destination");
	    model.addColumn("Content");
	    table = new JTable(model);
	    table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

	    

		table.getColumnModel().getColumn(0).setPreferredWidth(5);
		table.getColumnModel().getColumn(3).setPreferredWidth(5);
		table.setRowHeight(30);
		
		// scrollable form 
		
		JScrollPane scrollable = new JScrollPane(table);
		scrollable.setBounds(200, 70, 360, 150);
	    scrollable.setVisible(true);
		panel.add(scrollable);
		
		pack();
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
