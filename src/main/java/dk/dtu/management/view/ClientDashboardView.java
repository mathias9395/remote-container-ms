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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import dk.dtu.management.controller.ClientDashboardController;

@SuppressWarnings("serial")	
public class ClientDashboardView extends JFrame{
	
	private ClientDashboardController controller;
	
	private static JFrame frame; // frame for the entire thing
	private static JPanel panel;
	private static JLabel origin;
	private static JTextField enterOrigin;
	private static JLabel content;
	private static JTextField enterContent;
	private static JLabel destination;
	private static JTextField enterDestination;
	private static JButton search;
	private static JButton btnChat;
	private static JButton update;
	private static JButton logout;
	private static JButton sharedata;
	private static JButton viewSharedData;
	
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
		
		// color modification for a more distinguishable look
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(600, 330));
		
		panel = new JPanel();
		add(panel);
		panel.setLayout(null);
		
		panel.setBackground(Color.decode("#E2ECF6"));
		
		origin = new JLabel("Origin");
		enterOrigin = new JTextField(20);
		content = new JLabel("Content");
		enterContent = new JTextField(20);
		destination = new JLabel("Destination");
		enterDestination = new JTextField(20);
		search = new JButton("Search");
		search.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.journeySearch();
			}
		});	
		// other buttons
		// UPDATE
		update = new JButton("Settings");
		
		update.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.clientSettings();
			}
		});
		
		
		
		// LOGOUT
		logout = new JButton("Log out");
		logout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.logout();
			}
		});
		
		
		// CHAT
		btnChat = new JButton("Chat");
		btnChat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.sendMessage();
			}
		});
		
		// MOUSE LISTENER for graph DISPLAY
		
		
		JCheckBox cbAllJourneys = new JCheckBox("Include completed"); 
		cbAllJourneys.setBackground(Color.decode("#E2ECF6"));
		cbAllJourneys.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.displayAllJourneys(cbAllJourneys.isSelected());
			}
		});
		
		// SHARE DATA WITH ANOTHER CLIENT
		
		sharedata = new JButton("Share data");
		
		sharedata.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.clientShareData();
			}
		});
		
		viewSharedData = new JButton("View shared");
		
		viewSharedData.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.viewSharedData();
			}
		});
		
		
		
		// ADD NEW JOURNEY
		AddSelected = new JButton("Add journey");
		
		AddSelected.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.addJourney();
			}
		});
		
		RemoveSelected = new JButton("Remove");
		
		//frame.add(AddSelected);
		
		
		
		
		
		
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
	    final JLabel sureLabel = new JLabel();
	    RemoveSelected.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(frame,"Sure? Are you sure you want to remove the Journey(s) ?", "Swing Tester",
			               JOptionPane.YES_NO_OPTION,
			               JOptionPane.QUESTION_MESSAGE);
			            if(result == JOptionPane.YES_OPTION){
							for(int i = 0; i<table.getRowCount(); i++) {
								boolean selected = Boolean.valueOf(table.getValueAt(i, 4).toString());
							
								if(selected) {
									controller.removeJourney(Integer.parseInt(table.getValueAt(i, 0).toString()));

								}
								
							}
			            }else if (result == JOptionPane.NO_OPTION){
			               
			            }else {
			               sureLabel.setText("None selected");
			            }

				controller.journeySearch();
		}});
		


		table.getColumnModel().getColumn(0).setPreferredWidth(5);
		table.getColumnModel().getColumn(4).setPreferredWidth(5);
		table.setRowHeight(30);
		
		// scrollable form 
		
		JScrollPane scrollable = new JScrollPane(table);
		
	    scrollable.setVisible(true);
		

		// bounds
	    
		logout.setBounds(450,14,110,30);
		cbAllJourneys.setBounds(17, 45, 150, 30);
		enterOrigin.setBounds(20, 90, 110, 30);
		sharedata.setBounds(190, 240, 110, 30);
		viewSharedData.setBounds(20, 14, 110, 30);
		RemoveSelected.setBounds(450,240,110,30);
		scrollable.setBounds(180, 70, 380, 150);
		origin.setBounds(20,55,110,50);
		AddSelected.setBounds(320, 240, 110, 30);
		enterContent.setBounds(20, 150, 110, 30);
		content.setBounds(20,115,110,50);
		destination.setBounds(20,175,110,50);
		enterDestination.setBounds(20, 210, 110, 30);
		
		search.setBounds(20, 240, 110, 30);
		update.setBounds(320, 14, 110, 30);
		btnChat.setBounds(190, 14, 110, 30);
		// panel adds
		
		panel.add(AddSelected);
		panel.add(RemoveSelected);
	    panel.add(enterOrigin);
		panel.add(origin);
		panel.add(scrollable);
		panel.add(content);
		panel.add(enterContent);
		panel.add(destination);
		panel.add(enterDestination);
		panel.add(search);
		panel.add(update);
		panel.add(logout);
		panel.add(btnChat);
		panel.add(viewSharedData);
		panel.add(sharedata);
		panel.add(cbAllJourneys);
		
		
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
		int id =  (int) model.getValueAt(n,0);
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
