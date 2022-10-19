package gui.table;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SmsScreen extends JFrame implements ActionListener {

	MyMenu menu = new MyMenu(this);
	JMenuBar mainBar = menu.menuBar();

	JPanel center, bottom;
	JLabel from, to, content;
	JTextField fromTxt, toTxt;
	JTextArea contentTxt;
	JButton ok, cancel;

	public SmsScreen() {

		setJMenuBar(mainBar);

		setTitle("문자 발송  UI");
		setSize(300, 320);
		setLayout(new BorderLayout());

		// Panel...
		center = new JPanel();
		bottom = new JPanel();

		// Label...
		from = new JLabel("발신번호");
		to = new JLabel("수신번호");
		content = new JLabel("내용(40자이내)");

		// TextField...
		fromTxt = new JTextField(20);
		fromTxt.setText("01085601636");
		toTxt = new JTextField(20);
		contentTxt = new JTextArea(10, 25);

		// Button...
		ok = new JButton("Send");
		cancel = new JButton("Cancel");
		// event ..
		ok.addActionListener(this);
		cancel.addActionListener(this);

		// center component..
		center.add(from);
		center.add(fromTxt);
		center.add(to);
		center.add(toTxt);
		center.add(content);
		center.add(contentTxt);

		// bottom component...
		bottom.add(ok);
		bottom.add(cancel);

		add("Center", center);
		add("South", bottom);

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();

		if (src == menu.miEmp) {
			new JTableTest("");
			dispose();

		} else if (src == menu.miSms) {
			new SmsScreen();
			dispose();

		} else if (src == menu.miMail) {
			new MailScreen();
			dispose();

		} else if (src == menu.miExit) {
			System.exit(0);

//		} else if (src == menu.miCopy) {

//		} else if (src == menu.miPaste) {

		}

		if (src == ok) {
			sendSms();
		} else if (src == cancel) {

		}
	}

	public void sendSms() {
		SmsApp app = new SmsApp();
		String from = fromTxt.getText();
		String to = toTxt.getText();
		String content = contentTxt.getText();
		Scanner scn = new Scanner(content);
		StringBuffer sb = new StringBuffer();

		while (scn.hasNext()) {
			String temp = scn.nextLine();
			sb.append(temp + "\n");
		}

		if (app.sendMsg(from, to, sb.toString()).equals("Success")) {
			JOptionPane.showMessageDialog(null, "발송 성공!!", "전송완료", JOptionPane.DEFAULT_OPTION);
			contentTxt.setText("");

		} else {
			JOptionPane.showMessageDialog(null, "메일 발송 중 에러", "경고창", JOptionPane.WARNING_MESSAGE);
		}
		scn.close();
	}

	public static void main(String[] args) {
		new SmsScreen();
	}

}
