package com.edu;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginWindow extends JFrame {

	public LoginWindow() {

		setTitle("login window");
		setSize(300, 150);

		JPanel panel = new JPanel();
		add(panel);

		JLabel id = new JLabel("id");
		JLabel pw = new JLabel("pass");

		JTextField idtxt = new JTextField(20);
		JPasswordField pwtxt = new JPasswordField(20);

		id.setBounds(50, 15, 100, 30);
		pw.setBounds(50, 30, 100, 30);
		
		idtxt.setBounds(250, 15, 100, 30);

		panel.add(id);
		panel.add(idtxt);

		panel.add(pw);
		panel.add(pwtxt);

		setVisible(true);

	}

	public static void main(String[] args) {
		new LoginWindow();
	}
}
