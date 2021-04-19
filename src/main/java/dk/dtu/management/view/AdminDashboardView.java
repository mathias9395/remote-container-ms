package dk.dtu.management.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import dk.dtu.management.controller.AdminDashboardController;
import dk.dtu.management.model.LogisticCompany;

public class AdminDashboardView extends JFrame {
	private AdminDashboardController controller;
	private JTable tblClients;
	private DefaultTableModel clientModel = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};
	private JTextField txtNameSearch;
	private JTextField txtEmailSearch;
	
	
	public AdminDashboardView(AdminDashboardController controller) {
		this.controller = controller;
		initGUI();
	}
	
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Admin Dashboard");
		setPreferredSize(new Dimension(800, 600));
		
		// buttons
		
		JButton logoutButton = new JButton("Logout");
		logoutButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.logout();
			}
		});
		
		JButton btnClientSearch = new JButton("Search");
		btnClientSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.clientSearch();
			}
		});
		
		JButton btnNewClient = new JButton("Add client");
		btnNewClient.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.addClient();
			}
		});
		
		JButton btnDeleteClient = new JButton("Delete client");
		btnDeleteClient.setEnabled(false);
		btnDeleteClient.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.deleteClient(tblClients.getSelectedRow());
			}
		});
		
		JButton btnSelectClient = new JButton("Select");
		btnSelectClient.setEnabled(false);
		btnSelectClient.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.selectClient(tblClients.getSelectedRow());
			}
		});
		
		// labels
		JLabel lblNameSearch = new JLabel("Name:");
		JLabel lblEmailSearch = new JLabel("Email");
		
		// text fields
		txtNameSearch = new JTextField(10);
		txtEmailSearch = new JTextField(10);
		
		
		
		
		// table
		clientModel.addColumn("ID");
		clientModel.addColumn("Name");
		clientModel.addColumn("Email");
		clientModel.addColumn("Reference Person");
		clientModel.addColumn("Address");
		
		tblClients = new JTable(clientModel);
		tblClients.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblClients.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				btnDeleteClient.setEnabled((tblClients.getSelectedRow() >= 0));
				btnSelectClient.setEnabled((tblClients.getSelectedRow() >= 0));
			}
		});
		
		
		
		
		
		setLayout(new FlowLayout());
		add(logoutButton);
		add(lblNameSearch);
		add(txtNameSearch);
		add(lblEmailSearch);
		add(txtEmailSearch);
		add(btnClientSearch);
		add(btnNewClient);
		add(btnDeleteClient);
		add(new JScrollPane(tblClients));
		add(btnSelectClient);
		
		pack();
		setLocationRelativeTo(null);
		
		
	}
	
	public void setTableModel(TableModel model) {
		tblClients.setModel(model);
	}
	
	public void resetTable() {
		DefaultTableModel clientModel = (DefaultTableModel) tblClients.getModel();
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
