package dk.dtu.management.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import dk.dtu.management.controller.AssignContainerController;
@SuppressWarnings("serial")
public class AssignContainerView extends JFrame {
	private AssignContainerController controller;
	private JTable tblContainers;
	private DefaultTableModel containerModel = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int row, int column) {
			if(column<5){
				return false;
			}else {
				return true;
			}
		}
	};

	public AssignContainerView(AssignContainerController controller) {
		this.controller = controller;
		initGUI();
	}
	
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Assign container");
		setPreferredSize(new Dimension(300, 300));
		
		JLabel lblAvailable = new JLabel("Available Containers:");
		lblAvailable.setBounds(20, 20, 140, 20);
		add(lblAvailable);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.back();
			}
		});
		btnCancel.setBounds(210, 20, 80, 30);
		add(btnCancel);
		
		containerModel.addColumn("ID");
		containerModel.addColumn("Location");
		
		tblContainers = new JTable(containerModel);
		tblContainers.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		tblContainers.addMouseListener(new MouseAdapter() {
		    public void mousePressed(MouseEvent mouseEvent) {
		        JTable table =(JTable) mouseEvent.getSource();
		        Point point = mouseEvent.getPoint();
		        int row = table.rowAtPoint(point);
		        if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
		        	controller.selectedContainer(tblContainers.getSelectedRow());
		        }
		    }
		});
		
		JScrollPane pane = new JScrollPane(tblContainers);
		pane.setBounds(0, 50, 300, 200);
		add(pane);
		
		//add(btnCancel);
		
		getContentPane().setBackground(Color.decode("#E2ECF6"));
		
		setLayout(null);
		pack();
		setResizable(false);
		setLocationRelativeTo(null);
	}
	
	

	public void setTableModel(TableModel model) {
		tblContainers.setModel(model);
	}
	public void addTableRow(Object[] object) {
		containerModel.addRow(object);
		
	}
	public void resetTable() {
		DefaultTableModel containerModel = (DefaultTableModel) tblContainers.getModel();
		containerModel.setRowCount(0);
	}

	public int getTableRow(int row) {
		int id = (int) containerModel.getValueAt(row, 0);
		return id;
	}

	public void showError() {
		JOptionPane.showMessageDialog(this, "The container is not at the same location as the journey origin", "Error", JOptionPane.ERROR_MESSAGE);
		
	}
	
}
