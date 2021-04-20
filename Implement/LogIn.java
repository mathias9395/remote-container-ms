package dk.dtu.management.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

class ImagePanel extends JPanel {

	  private Image img;

	  public ImagePanel(String img) {
	    this(new ImageIcon(img).getImage());
	  }

	  public ImagePanel(Image img) {
	    this.img = img;
	    Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
	    setPreferredSize(size);
	    setMinimumSize(size);
	    setMaximumSize(size);
	    setSize(size);
	    setLayout(null);
	  }

	  public void paintComponent(Graphics g) {
	    g.drawImage(img, 0, 0, null);
	  }

	}

 class LogIn implements ActionListener{

	private static JFrame frame;
	private static JLabel label;
	private static JTextField usertext;
	private static JLabel password ;
	private static JPasswordField insertPassword ;
	private static JButton button ;
	private static JLabel success;
	
	LogIn (){
		frame = new JFrame("Log in window");
		frame.setSize(300,200);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImagePanel panel = new ImagePanel(
		        new ImageIcon("C:\\Users\\umada\\Desktop\\background.jfif").getImage());
		
		frame.add(panel);
		panel.setLayout(null);
		//panel.setBackground(Color.getHSBColor(870, 750, 500)); // nice pistachio green
		
		label = new JLabel("User");
		label.setBounds(10, 20, 80, 30);
		panel.add(label);
		usertext = new JTextField(20);
		usertext.setBounds(100, 20, 170, 30);
		usertext.setFont(new java.awt.Font("Arial", Font.ITALIC, 12));
		
		panel.add(usertext);
		
		password = new JLabel("Password");
		password.setBounds(10, 50, 170, 30);;
		
		insertPassword = new JPasswordField();
		insertPassword.setBounds(100, 50, 170, 30);
		
		panel.add(password);
		
		panel.add(insertPassword);
		
		button = new JButton("Login");
		button.setBounds(10, 90, 80, 30);
		
		button.addActionListener(e -> {
			String user = usertext.getText();
			String password = insertPassword.getText();
			
			if(user.equals("Matthias") && password.equals("Nima")) {
				success.setText("You logged in!");
				frame.dispose();
				ClientDashboard c = new ClientDashboard();	
			}else {
				success.setText("Incorrect credentials");
			}
		});
		
		frame.add(button);
		
		
		panel.add(button);
		success = new JLabel("");
		success.setBounds(10, 120, 200, 30);
		success.setFont(Font.getFont("TimesNewRoman"));
		panel.add(success);
		

		frame.setVisible(true);
		
	}
	
	
	public static void main(String[] args) {
		
		new LogIn();
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	

}
