package dk.dtu.management.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import dk.dtu.management.controller.ClientShareDataController;

public class ClientShareDataView extends JFrame {
	private ClientShareDataController controller;
	private JTable tblAllClients;
	private DefaultTableModel clientModel = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int row, int column) {
			if(column<5){
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
            case 5:
              return Boolean.class;

            default:
              return String.class;
        }
    }
				
	};
	private JTextField txtNameSearch;
	private JTextField txtEmailSearch;
	
	
	public ClientShareDataView(ClientShareDataController controller) {
		this.controller = controller;
		initGUI();
	}
	
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Share Data");
		setPreferredSize(new Dimension(600, 485));
		
		// buttons
		
//		JButton logoutButton = new JButton("Logout");
//		logoutButton.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				controller.logout();
//			}
//		});
		
		JButton btnClientSearch = new JButton("Search");
		btnClientSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.clientSearch();
			}
		});
// Needs to be updated to add client to share client
		
//		JButton btnNewClient = new JButton("Add client");
//		btnNewClient.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				controller.addClient();
//			}
//		});
		
// Needs to be updated to delete share client
		
//		JButton btnDeleteClient = new JButton("Delete Marked");
//		btnDeleteClient.setEnabled(false);
//		btnDeleteClient.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				
//				for(int i = 0; i<tblClients.getRowCount(); i++) {
//					System.out.println(tblClients.getRowCount());
//					boolean selected = Boolean.valueOf(tblClients.getValueAt(i, 5).toString());
//				
//					if(selected) {
//						controller.deleteClient(Integer.parseInt(tblClients.getValueAt(i, 0).toString()),tblClients.getValueAt(i, 2).toString());
//					}
//					
//				}
//				controller.clientSearch();
//		}});
		
		
		
		
		// labels
		JLabel lblNameSearch = new JLabel("Name:");
		JLabel lblEmailSearch = new JLabel("Email:");
		
		// text fields
		txtNameSearch = new JTextField(10);
		txtEmailSearch = new JTextField(10);
		
		// table
		clientModel.addColumn("ID");
		clientModel.addColumn("Name");
		clientModel.addColumn("Email");
		clientModel.addColumn("Reference Person");
		clientModel.addColumn("Address");
		clientModel.addColumn("Mark");
		
		tblAllClients = new JTable(clientModel);
		
		tblAllClients.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		tblAllClients.addMouseListener(new MouseAdapter() {
		    public void mousePressed(MouseEvent mouseEvent) {
		        JTable table =(JTable) mouseEvent.getSource();
		        Point point = mouseEvent.getPoint();
		        int row = table.rowAtPoint(point);
		        if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
		        	controller.selectClient(tblAllClients.getSelectedRow());
		        }
		    }
		});
		
		
		
		setLayout(null);
		
		// distribution for a more distint looking page:
		//logoutButton.setBounds(450, 20, 120, 40);
		lblNameSearch.setBounds(20, 70, 120, 40);
		txtNameSearch.setBounds(20,100,120,40);
		lblEmailSearch.setBounds(150, 70, 120, 40);
		txtEmailSearch.setBounds(150, 100, 120, 40);
		btnClientSearch.setBounds(320, 100, 120, 40);
		// NEEDS to be add share client btnNewClient.setBounds(20, 20, 120, 40);
		// NEEDS to be remove share client btnDeleteClient.setBounds(450, 100, 120, 40);
		btnSelectClient.setBounds(150, 20, 120, 40);
		
		// adding buttons and text fields
		//add(logoutButton);
		add(lblNameSearch);
		add(txtNameSearch);
		add(lblEmailSearch);
		add(txtEmailSearch);
		add(btnClientSearch);
		//NEEDS to be add share client add(btnNewClient);
		//NEEDS to be remove share client add(btnDeleteClient);
		
		// color modification
		getContentPane().setBackground(Color.decode("#E2ECF6"));
		
		JScrollPane pane = new JScrollPane(tblAllClients);
		
		// Visual modification to change the column width
		tblAllClients.setRowHeight(30);
		tblAllClients.getColumnModel().getColumn(0).setPreferredWidth(20);
		tblAllClients.getColumnModel().getColumn(5).setMaxWidth(35);;
		
		// scrollable pane
		pane.setBounds(20, 150, 550, 280);
		setResizable(false);
		add(pane);
		
		// practical display details
		pack();
		setResizable(false);
		setLocationRelativeTo(null);
		
		
	}
	
	public void setTableModel(TableModel model) {
		tblAllClients.setModel(model);
	}
	
	public void resetTable() {
		DefaultTableModel clientModel = (DefaultTableModel) tblAllClients.getModel();
		clientModel.setRowCount(0);
	}
	
	public void addTableRow(Object[] object) {
		clientModel.addRow(object);
		
	}
	
	public Object[] getTableRow(int n) {
		Object[] data = new Object[2];
		data[0] = clientModel.getValueAt(n, 0);
		data[1] = clientModel.getValueAt(n, 2);
		
		return data;
	}
	
	public String getTxtNameSearch() {
		return txtNameSearch.getText();
	}
	
	public String getTxtEmailSearch() {
		return txtEmailSearch.getText();
	}
	
}


