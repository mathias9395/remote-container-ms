package dk.dtu.management.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import dk.dtu.management.controller.AdminMessageController;

public class AdminMessageView extends JFrame {
	private AdminMessageController controller;
	private JTextArea textArea;
	private JTextArea txtNewMessage;

	public AdminMessageView(AdminMessageController controller) {
		this.controller = controller;
		initGUI();
	}
	
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Message");
		setPreferredSize(new Dimension(800, 600));
		
		txtNewMessage = new JTextArea(2,40);
		txtNewMessage.setLineWrap(true);
		txtNewMessage.setWrapStyleWord(true);
		JScrollPane txtMessage = new JScrollPane(txtNewMessage);  
		
		JButton btnSendMessage = new JButton("Send");
		btnSendMessage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.sendMessage(txtNewMessage.getText());
			}
		});
		
		
		
		textArea = new JTextArea(20, 40); 
		textArea.setText(controller.displayMessages());
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		JScrollPane viewMessages = new JScrollPane(textArea);  
		
		setLayout(new FlowLayout());
		add(viewMessages);
		add(txtMessage);
		add(btnSendMessage);
		
		pack();
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
