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

import dk.dtu.management.controller.ClientViewSharedDataController;
import dk.dtu.management.util.JTextFieldLimit;

@SuppressWarnings("serial")
public class ClientViewSharedDataView extends JFrame {
	private ClientViewSharedDataController controller;
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
	private static BasicArrowButton back;
	
	
	public ClientViewSharedDataView(ClientViewSharedDataController controller) {
		this.controller = controller;
		initGUI();
	}
	
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Shared Data");
		getContentPane().setBackground(Color.decode("#E2ECF6"));
		setPreferredSize(new Dimension(600, 425));
		
		// buttons
		
		JButton btnClientSearch = new JButton("Search");
		btnClientSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.clientSearch();
			}
		});
		
		JButton btnDeleteClient = new JButton("Delete Marked");
		btnDeleteClient.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				for(int i = 0; i<tblClients.getRowCount(); i++) {
					System.out.println(tblClients.getRowCount());
					boolean selected = Boolean.valueOf(tblClients.getValueAt(i, 5).toString());
				
					if(selected) {
						controller.deleteClient(Integer.parseInt(tblClients.getValueAt(i, 0).toString()),tblClients.getValueAt(i, 2).toString());
					}
					
				}
				controller.clientSearch();
		}});
		back = new BasicArrowButton(BasicArrowButton.WEST);
		back.setBounds(0,0,20,20);
		back.addActionListener(e -> { 
		    controller.back();
		});
		add(back);
		
		// labels
		JLabel lblNameSearch = new JLabel("Name:");
		JLabel lblEmailSearch = new JLabel("Email:");
		
		// text fields
		txtNameSearch = new JTextField(10);
		txtNameSearch.setDocument(new JTextFieldLimit(32));
		txtEmailSearch = new JTextField(10);
		txtEmailSearch.setDocument(new JTextFieldLimit(32));
		
		// table
		clientModel.addColumn("ID");
		clientModel.addColumn("Name");
		clientModel.addColumn("Email");
		clientModel.addColumn("Reference Person");
		clientModel.addColumn("Address");
		clientModel.addColumn("Mark");
		
		tblClients = new JTable(clientModel);
		
		tblClients.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		// For viewing a clients data
		tblClients.addMouseListener(new MouseAdapter() {
		    public void mousePressed(MouseEvent mouseEvent) {
		        JTable table =(JTable) mouseEvent.getSource();
		        if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
		        	controller.selectClient(tblClients.getSelectedRow());
		        }
		    }
		});
		
		
		
		
		
		
		setLayout(null);
		
		// distribution for a more distinct looking page:
		lblNameSearch.setBounds(20, 10, 120, 40);
		txtNameSearch.setBounds(20,40,120,40);
		lblEmailSearch.setBounds(150, 10, 120, 40);
		txtEmailSearch.setBounds(150, 40, 120, 40);
		btnDeleteClient.setBounds(450, 40, 120, 40);
		btnClientSearch.setBounds(320, 40, 120, 40);
		
		// adding buttons and text fields
		add(lblNameSearch);
		add(txtNameSearch);
		add(lblEmailSearch);
		add(txtEmailSearch);
		add(btnDeleteClient);
		add(btnClientSearch);
		
		// color modification
		getContentPane().setBackground(Color.decode("#E2ECF6"));
		
		JScrollPane pane = new JScrollPane(tblClients);
		
		// Visual modification to change the column width
		tblClients.setRowHeight(30);
		tblClients.getColumnModel().getColumn(0).setPreferredWidth(20);
		tblClients.getColumnModel().getColumn(5).setMaxWidth(35);;
		
		// scrollable pane
		pane.setBounds(20, 90, 550, 280);
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
