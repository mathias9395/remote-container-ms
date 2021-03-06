package dk.dtu.management.view;

import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import dk.dtu.management.controller.ClientShareDataController;
import dk.dtu.management.util.JTextFieldLimit;
@SuppressWarnings("serial")
public class ClientShareDataView extends JFrame {
	private ClientShareDataController controller;
	private JTable tblAllClients;
	private JTable tblSharedClients;
	private static BasicArrowButton back;
	private DefaultTableModel clientAllModel = new DefaultTableModel() {
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
	
	private DefaultTableModel clientSharedModel = new DefaultTableModel() {
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
		getContentPane().setBackground(Color.decode("#E2ECF6"));
		setPreferredSize(new Dimension(885, 485));
		
		
		JButton btnClientSearch = new JButton("Search");
		btnClientSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.clientSearch();
			}
		});
		
		JButton btnRemoveClient = new JButton("Remove Marked");
		btnRemoveClient.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				for(int i = 0; i<tblSharedClients.getRowCount(); i++) {
					boolean selected = Boolean.valueOf(tblSharedClients.getValueAt(i, 5).toString());
				
					if(selected) {
						System.out.println(Integer.parseInt(tblSharedClients.getValueAt(i, 0).toString()));
						controller.removeSharedClient(Integer.parseInt(tblSharedClients.getValueAt(i, 0).toString()),tblSharedClients.getValueAt(i, 2).toString());
					}
					
				}
				controller.sharedTable();
		}});
		
		back = new BasicArrowButton(BasicArrowButton.WEST);
		back.setBounds(0,0,20,20);
		back.addActionListener(e -> { 
		    controller.back();
		});
			
		// labels
		JLabel lblNameSearch = new JLabel("Name:");
		JLabel lblEmailSearch = new JLabel("Email:");
		
		JLabel lblClientAll = new JLabel("All clients:");
		JLabel lblClientShared = new JLabel("Clients your data is shared with:");
		
		// text fields
		txtNameSearch = new JTextField(10);
		txtNameSearch.setDocument(new JTextFieldLimit(32));
		txtEmailSearch = new JTextField(10);
		txtEmailSearch.setDocument(new JTextFieldLimit(32));
		
		// table
		clientAllModel.addColumn("ID");
		clientAllModel.addColumn("Name");
		clientAllModel.addColumn("Email");
		clientAllModel.addColumn("Reference Person");
		clientAllModel.addColumn("Address");
		
		tblAllClients = new JTable(clientAllModel);
		
		clientSharedModel.addColumn("ID");
		clientSharedModel.addColumn("Name");
		clientSharedModel.addColumn("Email");
		clientSharedModel.addColumn("Reference Person");
		clientSharedModel.addColumn("Address");
		clientSharedModel.addColumn("Mark");
		
		tblSharedClients = new JTable(clientSharedModel);
		
		tblAllClients.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblSharedClients.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		// For adding clients to the sharedWithClients set
		tblAllClients.addMouseListener(new MouseAdapter() {
		    public void mousePressed(MouseEvent mouseEvent) {
		        JTable table =(JTable) mouseEvent.getSource();
		        if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
		        	controller.selectClient(tblAllClients.getSelectedRow());
		        }
		    }
		});
		
		setLayout(null);
		
		// distribution for a more distinct looking page:
		
		lblNameSearch.setBounds(20, 30, 120, 40);
		txtNameSearch.setBounds(20,60,120,40);
		lblEmailSearch.setBounds(150, 30, 120, 40);
		txtEmailSearch.setBounds(150, 60, 120, 40);
		btnClientSearch.setBounds(297, 60, 120, 40);
		btnRemoveClient.setBounds(687, 60, 160, 40);
		
		lblClientAll.setBounds(20, 100, 120,40);
		lblClientShared.setBounds(450,100,190,40);
	
		
		// adding buttons and text fields
		add(lblNameSearch);
		add(txtNameSearch);
		add(lblEmailSearch);
		add(txtEmailSearch);
		add(btnClientSearch);
		add(btnRemoveClient);
		add(back);
		add(lblClientAll);
		add(lblClientShared);
		
		// color modification
		getContentPane().setBackground(Color.decode("#E2ECF6"));
		
		JScrollPane pane = new JScrollPane(tblAllClients);
		JScrollPane pane2 = new JScrollPane(tblSharedClients);
		
		// Visual modification to change the column width
		tblAllClients.setRowHeight(30);
		tblAllClients.getColumnModel().getColumn(0).setPreferredWidth(40);
		tblAllClients.getColumnModel().getColumn(4).setMaxWidth(55);;
		
		tblSharedClients.setRowHeight(30);
		tblSharedClients.getColumnModel().getColumn(0).setPreferredWidth(20);
		tblSharedClients.getColumnModel().getColumn(5).setMaxWidth(35);;
		
		// scrollable pane
		pane.setBounds(20, 130, 400, 280);
		setResizable(false);
		add(pane);
		
		pane2.setBounds(450, 130, 400, 280);
		setResizable(false);
		add(pane2);
		
		// practical display details
		pack();
		setResizable(false);
		setLocationRelativeTo(null);
		
		
	}
	
	public void setTableModel(TableModel model) {
		tblAllClients.setModel(model);
		tblSharedClients.setModel(model);
	}
	
	public void resetAllTable() {
		DefaultTableModel clientModel = (DefaultTableModel) tblAllClients.getModel();
		clientModel.setRowCount(0);
	}
	
	public void resetSharedTable() {
		DefaultTableModel clientModel = (DefaultTableModel) tblSharedClients.getModel();
		clientModel.setRowCount(0);
	}
	
	public void addAllTableRow(Object[] object) {
		clientAllModel.addRow(object);
	}
	
	public void addSharedTableRow(Object[] object) {
		clientSharedModel.addRow(object);
	}
	
	public Object[] getAllTableRow(int n) {
		Object[] data = new Object[2];
		data[0] = clientAllModel.getValueAt(n, 0);
		data[1] = clientAllModel.getValueAt(n, 2);
		
		return data;
	}
	
	public Object[] getSharedTableRow(int n) {
		Object[] data = new Object[2];
		data[0] = clientSharedModel.getValueAt(n, 0);
		data[1] = clientSharedModel.getValueAt(n, 2);
		
		return data;
	}
	
	public String getTxtNameSearch() {
		return txtNameSearch.getText();
	}
	
	public String getTxtEmailSearch() {
		return txtEmailSearch.getText();
	}
	
}


