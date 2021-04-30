package dk.dtu.management.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import dk.dtu.management.controller.ClientMessageController;
import dk.dtu.management.util.JTextFieldLimit;
@SuppressWarnings("serial")
public class ClientMessageView extends JFrame {

	private ClientMessageController controller;
	private JTextArea textArea;
	private JTextArea txtNewMessage;
	
	
	public ClientMessageView(ClientMessageController controller) {
		this.controller = controller;
		initGUI();
	}
	
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Messages");
		setPreferredSize(new Dimension(400, 400));
		
		txtNewMessage = new JTextArea(10,40);
		txtNewMessage.setLineWrap(true);
		txtNewMessage.setWrapStyleWord(true);
		txtNewMessage.setDocument(new JTextFieldLimit(255));
		
		JScrollPane txtMessage = new JScrollPane(txtNewMessage);  
		
		JButton btnSendMessage = new JButton("Send");
		btnSendMessage.setBounds(200, 100, 130, 200);
		btnSendMessage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.sendMessage(txtNewMessage.getText());
			}
		});
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.returnDashboard();
			}
		});
		
		
		textArea = new JTextArea(50, 50); 
		textArea.setText(controller.displayMessages());
		
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		JScrollPane viewMessages = new JScrollPane(textArea);  
		

		setLayout(null);
		
		JLabel l1 = new JLabel("Message window");
		l1.setBounds(5, 10, 300,20);
		add(l1);
		
		viewMessages.setBounds(5,30,375,200);
		viewMessages.setForeground(Color.decode("#E2ECF6"));
		
		add(viewMessages);
		
		JLabel l2 = new JLabel("Type a message: ");
		l2.setBounds(5,230,300,20);
		add(l2);
		
		txtMessage.setBounds(5,250,375,50);
		add(txtMessage);
		
		btnCancel.setBounds(100,320,100,30);
		add(btnCancel);
		btnSendMessage.setBounds(5,320,100,30);
		add(btnSendMessage);
		
		
		pack();
		setResizable(false);
		setLocationRelativeTo(null);
	}

	public void showMessageError() {
		JOptionPane.showMessageDialog(this, "Please type something in the message field.", "Error", JOptionPane.ERROR_MESSAGE);	
	}
	
	public void resetText() {
		textArea.setText(controller.displayMessages());
		txtNewMessage.setText(null);
	}
}