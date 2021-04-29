package dk.dtu.management.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import dk.dtu.management.controller.AdminDashboardController;
import dk.dtu.management.model.LogisticCompany;
@SuppressWarnings("serial")
public class AdminDashboardView extends JFrame {
	private AdminDashboardController controller;
	private JTable tblClients;
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
	
	
	public AdminDashboardView(AdminDashboardController controller) {
		this.controller = controller;
		initGUI();
	}
	
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Admin Dashboard");
		setPreferredSize(new Dimension(600, 485));
		
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
		JButton btnNewContainer = new JButton("Add container");
		btnNewContainer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.addContainer();
			}
		});
		
		final JLabel sureLabel = new JLabel();
		JFrame frame = null;
		JButton btnDeleteClient = new JButton("Delete Marked");
		btnDeleteClient.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
	            int result = JOptionPane.showConfirmDialog(frame,"Sure? Are you sure you want to remove the Client(s) ?", "Swing Tester",
			               JOptionPane.YES_NO_OPTION,
			               JOptionPane.QUESTION_MESSAGE);
			            if(result == JOptionPane.YES_OPTION){
							for(int i = 0; i<tblClients.getRowCount(); i++) {
								boolean selected = Boolean.valueOf(tblClients.getValueAt(i, 5).toString());
							
								if(selected) {
									controller.deleteClient(Integer.parseInt(tblClients.getValueAt(i, 0).toString()));
								}
								
							}
			            }else if (result == JOptionPane.NO_OPTION){
			               
			            }else {
			               sureLabel.setText("None selected");
			            }

				controller.clientSearch();
		}});
		
		
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
		
		tblClients = new JTable(clientModel);
		
		tblClients.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		tblClients.addMouseListener(new MouseAdapter() {
		    public void mousePressed(MouseEvent mouseEvent) {
		        JTable table =(JTable) mouseEvent.getSource();
		        Point point = mouseEvent.getPoint();
		        int row = table.rowAtPoint(point);
		        if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
		        	controller.selectClient(tblClients.getSelectedRow());
		        }
		    }
		});
		
		
		
		
		setLayout(null);
		
		// distribution for a more distinct looking page:
		logoutButton.setBounds(450, 20, 120, 40);
		lblNameSearch.setBounds(20, 70, 120, 40);
		txtNameSearch.setBounds(20,100,120,40);
		lblEmailSearch.setBounds(150, 70, 120, 40);
		txtEmailSearch.setBounds(150, 100, 120, 40);
		btnClientSearch.setBounds(320, 100, 120, 40);
		btnNewClient.setBounds(20, 20, 120, 40);
		btnNewContainer.setBounds(150, 20, 120, 40);
		btnDeleteClient.setBounds(450, 100, 120, 40);
		
		// adding buttons and text fields
		add(logoutButton);
		add(lblNameSearch);
		add(txtNameSearch);
		add(lblEmailSearch);
		add(txtEmailSearch);
		add(btnClientSearch);
		add(btnNewClient);
		add(btnNewContainer);
		add(btnDeleteClient);
		
		// color modification
		getContentPane().setBackground(Color.decode("#E2ECF6"));
		
		JScrollPane pane = new JScrollPane(tblClients);
		
		// Visual modification to change the column width
		tblClients.setRowHeight(30);
		tblClients.getColumnModel().getColumn(0).setPreferredWidth(20);
		tblClients.getColumnModel().getColumn(5).setMaxWidth(35);;
		
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
