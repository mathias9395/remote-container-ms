import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Admin_clientDashboardView extends JPanel {

    private String[] columnNames
            = { "ID", "Origin", "Destination", "Content" };

    private String[][] data = {
            { "1", "Denmark", "China", "Bananas" },
            { "2", "Zimbabwe", "America", "Apples" },
            { "3", "Zimbabwe", "Amerissssa", "Apples"}
            //controller.getclientlist()
        };

    private static String clientName;
    
    private DefaultTableModel model = new DefaultTableModel(data, columnNames);
    private JTable jTable = new JTable(model) {
    	public boolean isCellEditable(int rowIndex, int colIndex) {
      	  return false; //Disallow the editing of any cell
      	  }
    };
    
    
    static JTextField origin;
    static JTextField content;
    static JTextField destination;
    
    public Admin_clientDashboardView() {
    	
    	
    	jTable.getColumnModel().getColumn(0).setPreferredWidth(5);
    	jTable.getColumnModel().getColumn(1).setPreferredWidth(500);
    	jTable.getColumnModel().getColumn(2).setPreferredWidth(500);
    	jTable.getColumnModel().getColumn(3).setPreferredWidth(500);
    	
    	
    	
        
        JPanel panel = new JPanel();
        
        JLabel origin = new JLabel("Origin");
        origin.setBounds(20, 35, 110, 50);
        panel.add(origin);
        
        JTextField enterOrigin = new JTextField(20);
        enterOrigin.setBounds(20, 70, 110, 30);
        panel.add(enterOrigin);
        
        JLabel content = new JLabel("Content");
        content.setBounds(20, 35, 110, 50);
        panel.add(content);
        
        JTextField enterContent = new JTextField(20);
        enterContent.setBounds(20, 70, 110, 30);
        panel.add(enterContent);
        
        JLabel destination = new JLabel("Destination");
        destination.setBounds(20, 35, 110, 50);
        panel.add(destination);
        
        JTextField enterDestination = new JTextField(20);
        enterDestination.setBounds(20, 70, 110, 30);
        panel.add(enterDestination);
        	
        JButton search = new JButton("Search");
        search.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// uses origin content and destination
			}
		});
        
//        jTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
//			@Override
//			public void valueChanged(ListSelectionEvent e) {
//				btn2.setEnabled((jTable.getSelectedRow() >= 0));
//			}
//		});
        
        
        
        search.setBounds(20, 240, 110, 30);
        panel.add(search);
        
       
      
        setLayout(new BorderLayout());
        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(jTable), BorderLayout.CENTER);

    }
    
    
    
   

    
    

    public static void main(String[] args) {
    	// label
    	String clientName = "Nima";
        JLabel label = new JLabel(clientName);
        
        //logout
        JButton logout = new JButton("log out");
        logout.addActionListener(new ActionListener() {
	         @Override
	         public void actionPerformed(ActionEvent e) {
	           // controller.logout()
	         }
	      });
//        logout.setHorizontalAlignment(SwingConstants.CENTER);
        
        BasicArrowButton leftbtn = new BasicArrowButton(BasicArrowButton.WEST);
        leftbtn.addActionListener(new ActionListener() {
	         @Override
	         public void actionPerformed(ActionEvent e) {
	           // controller.back()
	         }
	      });
        
        
        
        JPanel overview = new JPanel(new BorderLayout());
        
        overview.add(leftbtn, BorderLayout.WEST);
        overview.add(label, BorderLayout.CENTER);
        overview.add(logout, BorderLayout.EAST);
        
        
        
        JFrame frame = new JFrame("Admin ClientView");
        
		JButton btn1 = new JButton("Update status");
		
		JButton btn2 = new JButton("Remove");
		btn2.setEnabled(true);
		
		btn1.addActionListener(new ActionListener() {
	         @Override
	         public void actionPerformed(ActionEvent e) {
	           // new frame for updating item 
	         }
	      });
		
		btn2.addActionListener(new ActionListener() {
	         @Override
	         public void actionPerformed(ActionEvent e) {
	            int result = JOptionPane.showConfirmDialog(frame,"Are you sure you want to delete this journey?", "Confirmation",
	               JOptionPane.YES_NO_OPTION,
	               JOptionPane.QUESTION_MESSAGE);
	            if(result == JOptionPane.YES_OPTION){
	               //controller.deleteItem()
	            }else if (result == JOptionPane.NO_OPTION){
	               
	            }else {
	               label.setText("None selected");
	            }
	         }
	      });
		

		
		JPanel panel1 = new JPanel(new BorderLayout());
        panel1.add(btn1,
                BorderLayout.WEST);
        panel1.add(btn2, BorderLayout.EAST);
        
        
        
        frame.add(new Admin_clientDashboardView());
        frame.add(overview, BorderLayout.NORTH);
        frame.add(panel1, BorderLayout.SOUTH);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}