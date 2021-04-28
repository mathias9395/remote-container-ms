package dk.dtu.management.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import dk.dtu.management.controller.ClientClientsDataController;

@SuppressWarnings("serial")
public class ClientClientsDataView extends JFrame {
private ClientClientsDataController controller;
	
	private static JPanel panel;
	private static JLabel title; // title for the client interface 
	private static JLabel origin;
	private static JTextField enterOrigin;
	private static JLabel content;
	private static JTextField enterContent;
	private static JLabel destination;
	private static JTextField enterDestination;
	private static JButton search;
	private static BasicArrowButton back;
	private static JPanel info;
	
	// For info display
	
	private static JLabel ID;
	private static JLabel name;
	private static JLabel email;
	private static JLabel Ref;
	private static JLabel Address;
	
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
		setPreferredSize(new Dimension(600, 360));
		
		panel = new JPanel();
		add(panel);
		panel.setLayout(null);
		
		info = new JPanel();
		info.setBackground(Color.decode("#E2ECF6"));
		info.setLayout(null);
		info.setBounds(0,0, 600, 80);
		
		// ADDING CLIENT INFORMATION ON DISPLAY
		
		ID = new JLabel("ID is : " + controller.getId());
		name = new JLabel( controller.getName() +"'s information: ");
		email = new JLabel("Email is: "+ controller.getEmail());
		Ref = new JLabel("Reference person is : "+ controller.getReferencePerson());
		Address = new JLabel("Address is: "+ controller.getAddress());
		
		ID.setOpaque(true);
		ID.setBackground(Color.lightGray);
		email.setOpaque(true);
		email.setBackground(Color.LIGHT_GRAY);
		Ref.setOpaque(true);
		Ref.setBackground(Color.LIGHT_GRAY);
		Address.setOpaque(true);
		Address.setBackground(Color.LIGHT_GRAY);
		
		name.setBounds(250,10,250,15);
		ID.setBounds(20,30,250,15);
		email.setBounds(20,55,250,15);
		Ref.setBounds(315,30,250,15);
		Address.setBounds(315,55,250,15);
		
		info.add(name);
		info.add(ID);
		info.add(email);
		info.add(Ref);
		info.add(Address);
		
		// BACK BUTTON
				back = new BasicArrowButton(BasicArrowButton.WEST);
				back.addActionListener(e -> { 
					controller.back();
				});
				info.add(back);
		
		panel.add(info);
		
		title = new JLabel(controller.getName() + "'s information");
		panel.add(title);
		
		origin = new JLabel("Origin");
		panel.add(origin);
		
		enterOrigin = new JTextField(20);
		panel.add(enterOrigin);
		
		content = new JLabel("Content");
		panel.add(content);
		
		enterContent = new JTextField(20);
		panel.add(enterContent);
		
		destination = new JLabel("Destination");
		panel.add(destination);
		
		enterDestination = new JTextField(20);
		panel.add(enterDestination);
		
		search = new JButton("Search");
		search.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.journeySearch();
			}
		});
		
		panel.add(search);
		
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
		scrollable.setBounds(200, 30, 360, 150);
	    scrollable.setVisible(true);
		panel.add(scrollable);
		
		enterOrigin.setBounds(20, 110, 110, 30);
		scrollable.setBounds(180, 110, 380, 150);
		origin.setBounds(20,75,110,50);
		enterContent.setBounds(20, 170, 110, 30);
		content.setBounds(20,135,110,50);
		destination.setBounds(20,195,110,50);
		enterDestination.setBounds(20, 230, 110, 30);
		back.setBounds(0,0,20,20);
		search.setBounds(20, 280, 110, 30);
	
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
