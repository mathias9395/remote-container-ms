package dk.dtu.management.view;


import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import dk.dtu.management.controller.LoginController;
import dk.dtu.management.util.JTextFieldLimit;



public class LoginView extends JFrame {

	private static final long serialVersionUID = 8981053836072595592L;
	
	private JButton btnLogin;
	private JTextField txtLogin;
	private JPasswordField txtPass;
	private LoginController controller;

	public LoginView(LoginController controller) {
		this.controller = controller;
		initGUI();
	}
	
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setTitle("Login");
		setLayout(new GridLayout(3,2,0,5));
		
		txtLogin = new JTextField(15);
		txtLogin.setDocument(new JTextFieldLimit(32));
		txtPass = new JPasswordField(15);
		txtPass.setDocument(new JTextFieldLimit(32));
		btnLogin = new JButton(" Login");
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.validateCredentials(txtLogin.getText(), String.valueOf(txtPass.getPassword()));
			}
		});
		txtPass.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
					controller.validateCredentials(txtLogin.getText(), String.valueOf(txtPass.getPassword()));
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		add(new JLabel(" Email:"));
		add(txtLogin);
		add(new JLabel(" Password:"));
		add(txtPass);
		add(new JLabel(" Welcome back!"));
		add(btnLogin);
		
		getContentPane().setBackground(Color.white);
		pack();
		setResizable(false);
		setLocationRelativeTo(null);
	}
	
	public void showError() {
		JOptionPane.showMessageDialog(this, "Wrong username/password combination", "Login error", JOptionPane.ERROR_MESSAGE);
	}
}
