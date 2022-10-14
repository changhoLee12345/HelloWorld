package gui.basic;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginWindow extends JFrame {

	LoginWindow() {
		setTitle("login window");
		setSize(300, 150);

		JPanel panel = new JPanel(new FlowLayout());
		panel.setSize(new Dimension(300, 150));

		JLabel idLbl = new JLabel("id");
		idLbl.setPreferredSize(new Dimension(45, 26));

		JLabel passLbl = new JLabel("passwd");
		passLbl.setPreferredSize(new Dimension(45, 26));

		JTextField idTxt = new JTextField(18);
		JPasswordField psTxt = new JPasswordField(18);

		JButton loginBtn = new JButton("로그인");
		JButton cancelBtn = new JButton("취 소");
		cancelBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		panel.add(idLbl);
		panel.add(idTxt);
		panel.add(passLbl);
		panel.add(psTxt);
		panel.add(loginBtn);
		panel.add(cancelBtn);

		add(panel);

		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new LoginWindow();
	}
}
