package dk.dtu.management.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import dk.dtu.management.controller.AdminMessageController;
import dk.dtu.management.util.JTextFieldLimit;
@SuppressWarnings("serial")
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
		setTitle("Messages");
		setPreferredSize(new Dimension(400, 400));
		
		txtNewMessage = new JTextArea();
		txtNewMessage.setLineWrap(true);
		txtNewMessage.setWrapStyleWord(true);
		txtNewMessage.setDocument(new JTextFieldLimit(255));
		JScrollPane txtMessage = new JScrollPane(txtNewMessage);  
		
		JButton btnSendMessage = new JButton("Send");
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
		
		textArea = new JTextArea(); 
		textArea.setText(controller.displayMessages());
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		JScrollPane viewMessages = new JScrollPane(textArea);

		setLayout(null);
		
		JLabel l1 = new JLabel("Message window");
		JLabel l2 = new JLabel("Type a message: ");
		
		l1.setBounds(5, 10, 300,20);
		viewMessages.setBounds(5,30,375,200);
		viewMessages.setForeground(Color.BLUE);
		viewMessages.setBackground(Color.decode("#E2ECF6"));
		l2.setBounds(5,230,300,20);
		txtMessage.setBounds(5,250,375,50);
		btnCancel.setBounds(100,320,100,30);
		btnSendMessage.setBounds(5,320,100,30);
		
		
		add(viewMessages);
		add(l1);
		add(l2);
		add(txtMessage);
		add(btnCancel);
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
