package dk.dtu.management.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import dk.dtu.management.controller.AdminClientDashboardController;
import dk.dtu.management.util.JTextFieldLimit;


@SuppressWarnings("serial")	
public class AdminClientDashboardView extends JFrame{
	
	private AdminClientDashboardController controller;
	
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
	private static JButton logout;
	private static BasicArrowButton back;
	private static JPanel info;
	private static JButton btnChat;
	private static JTable table;
	private static JButton AddSelected;
	private static int choice;
	private JCheckBox cbAllJourneys;
	private JCheckBox cbContainer;
	//private static JButton RemoveSelected;
	
	// for the info display
	
	private static JLabel ID;
	private static JLabel name;
	private static JLabel email;
	private static JLabel Ref;
	private static JLabel Address;
	
	
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
            	return String.class;

            default:
              return String.class;
        }
    }
	};

	
	public AdminClientDashboardView(AdminClientDashboardController controller) {
		this.controller = controller;
		initGUI();
	}
	
	
	private void initGUI() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Admin Dashboard");
		setPreferredSize(new Dimension(600, 400));
		
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.decode("#E2ECF6"));
		add(panel);
		
		info = new JPanel();
		info.setBackground(Color.white);
		info.setLayout(null);
		info.setBounds(0,0, 600, 80);
		
		// ADDING CLIENT INFORMATION ON DISPLAY
		
		ID = new JLabel("ID: " + controller.getId());
		name = new JLabel( controller.getName() +"'s information: ");
		email = new JLabel("Email: "+ controller.getEmail());
		Ref = new JLabel("Reference person: "+ controller.getReferencePerson());
		Address = new JLabel("Address: "+ controller.getAddress());
		
		
		ID.setOpaque(true);
		ID.setBackground(Color.WHITE);
		email.setOpaque(true);
		email.setBackground(Color.WHITE);
		Ref.setOpaque(true);
		Ref.setBackground(Color.WHITE);
		Address.setOpaque(true);
		Address.setBackground(Color.WHITE);
		cbContainer = new JCheckBox("New journeys"); 
		cbContainer.setBackground(Color.decode("#E2ECF6"));
		cbAllJourneys = new JCheckBox("Include completed");
		cbAllJourneys.setBackground(Color.decode("#E2ECF6"));
		
		name.setBounds(250,10,250,15);
		ID.setBounds(20,30,250,15);
		email.setBounds(20,55,250,15);
		Ref.setBounds(315,30,250,15);
		cbContainer.setBounds(20, 80, 150, 30);
		cbAllJourneys.setBounds(20, 105, 150, 30);
		
		
		cbContainer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.newContainers(cbContainer.isSelected());
			}
		});
		
		cbAllJourneys.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.allJourneys(cbAllJourneys.isSelected());
			}
		});
		
		Address.setBounds(315,55,250,15);
		
		info.add(name);
		info.add(ID);
		info.add(email);
		info.add(Ref);
		info.add(Address);
		info.setBackground(Color.decode("#E2ECF6"));
		

		// BACK BUTTON
		back = new BasicArrowButton(BasicArrowButton.WEST);
		back.addActionListener(e -> {
			controller.back();
		});
		info.add(back);
		
		
		panel.add(info);
		
		
		// OTHER DISPLAYABLES
			
		title = new JLabel(controller.getName() + "'s information");
		panel.add(title);
		panel.add(cbAllJourneys);
		
		origin = new JLabel("Origin");
		panel.add(origin);
		
		enterOrigin = new JTextField(20);
		enterOrigin.setDocument(new JTextFieldLimit(60));
		panel.add(enterOrigin);
		
		content = new JLabel("Content");
		panel.add(content);
		
		enterContent = new JTextField(20);
		enterContent.setDocument(new JTextFieldLimit(60));
		panel.add(enterContent);
		
		destination = new JLabel("Destination");
		panel.add(destination);
		
		enterDestination = new JTextField(20);
		enterDestination.setDocument(new JTextFieldLimit(60));
		panel.add(enterDestination);
		
		panel.add(cbContainer);
		
		search = new JButton("Search");
		search.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.journeySearch();
			}
		});	
		panel.add(search);
		
		btnChat = new JButton("Chat");
		btnChat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.message();
			}
		});
		panel.add(btnChat);
		

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
		
		
 

		
	      //COLUMN HEADERS
	        String[] columnHeaders={"ID","Origin","Destination","Content","Company"};
	    
	    // modeling the table
	        
	    model.addColumn("ID");
	    model.addColumn("Origin");
	    model.addColumn("Destination");
	    model.addColumn("Content");
	    model.addColumn("Company");
	    table = new JTable(model);
	    table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    table.addMouseListener(new MouseAdapter() {
		    public void mousePressed(MouseEvent mouseEvent) {
		        JTable table =(JTable) mouseEvent.getSource();
		        Point point = mouseEvent.getPoint();
		        int row = table.rowAtPoint(point);
		        if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
		        	controller.selectJourney(table.getSelectedRow());
		        }
		    }
		});

	    

		table.getColumnModel().getColumn(0).setPreferredWidth(5);
		table.setRowHeight(30);
		
		// scrollable form 
		
		JScrollPane scrollable = new JScrollPane(table);
 
	    scrollable.setVisible(true);
		panel.add(scrollable);
		
		// PANEL ADDS
		
		logout.setBounds(450,100,110,30);
		enterOrigin.setBounds(20, 150, 110, 30);
		scrollable.setBounds(180, 150, 380, 200);
		origin.setBounds(20,115,110,50);
		enterContent.setBounds(20, 210, 110, 30);
		content.setBounds(20,175,110,50);
		destination.setBounds(20,235,110,50);
		enterDestination.setBounds(20, 270, 110, 30);
		back.setBounds(0,0,20,20);
		search.setBounds(20, 320, 110, 30);
		btnChat.setBounds(180, 100, 110, 30);
		
		
		
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


	public void showCompleted() {
		JOptionPane.showMessageDialog(this, "This journey has already been completed", "Journey completed", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void setAllSelected(boolean b) {
		cbAllJourneys.setSelected(b);
	}
	
	public void setNewSelected(boolean b) {
		cbContainer.setSelected(b);
	}
	
	
}