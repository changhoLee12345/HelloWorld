package gui.table;

import java.awt.BorderLayout;
import java.awt.Dimension;
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

public class MailScreen extends JFrame implements ActionListener {

	MyMenu menu = new MyMenu(this);
	JMenuBar mainBar = menu.menuBar();

	Dimension lblDim = new Dimension(65, 15); // 제목이 긴 라벨에 적용.
	Dimension lblDim2 = new Dimension(45, 15); // 제목이 짧은 라벨에 적용.

	JPanel centerPanel, bottomPanel;

	JLabel toLbl, fromLbl, subjectLbl, contentLbl; // 라벨 선언.
	JTextField toTxt, fromTxt, subjectTxt; // 텍스트필드 선언.
	JTextArea contentTxt; // 텍스트에어리어.

	JButton sendBtn, cancelBtn, empBtn; // 버튼 선언.

	MailApp app = new MailApp();

	public MailScreen() {

		setJMenuBar(mainBar);

		setTitle("메세지 보내기");
		setSize(340, 300);
		setLayout(new BorderLayout());

		//
		toLbl = new JLabel("받는 사람:");
		toLbl.setPreferredSize(lblDim);

		fromLbl = new JLabel("보내는 사람:");
		fromLbl.setPreferredSize(lblDim);

		subjectLbl = new JLabel("제목");
		subjectLbl.setPreferredSize(lblDim);

		contentLbl = new JLabel("내용");
		contentLbl.setPreferredSize(lblDim2);

		toTxt = new JTextField(22);
		fromTxt = new JTextField(22);
		subjectTxt = new JTextField(22);
		contentTxt = new JTextArea(10, 25);

		sendBtn = new JButton("보내기");
		cancelBtn = new JButton("취소");
		empBtn = new JButton("리스트화면");

		sendBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
		empBtn.addActionListener(this);

		// centerPanel setting...
		centerPanel = new JPanel();
		centerPanel.add(toLbl);
		centerPanel.add(toTxt);

		centerPanel.add(fromLbl);
		centerPanel.add(fromTxt);

		centerPanel.add(subjectLbl);
		centerPanel.add(subjectTxt);

		centerPanel.add(contentLbl);
		centerPanel.add(contentTxt);

		// bottomPanel setting...
		bottomPanel = new JPanel();
		bottomPanel.add(sendBtn);
		bottomPanel.add(cancelBtn);
		bottomPanel.add(empBtn);

		add("Center", centerPanel);
		add("South", bottomPanel);

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	public void mailing() {
		String from = fromTxt.getText();
		String to = toTxt.getText();
		String subject = subjectTxt.getText();
		String content = contentTxt.getText();

		Scanner scn = new Scanner(content);
		StringBuffer sb = new StringBuffer();
		String temp = "";
		while (scn.hasNext()) {
			temp = scn.nextLine();
			sb.append(temp + "<br>");
		}
		scn.close();
		if (app.sendMail(from, to, subject, sb.toString()).equals("Success")) {
			JOptionPane.showMessageDialog(null, "발송 성공!!", "전송완료", JOptionPane.DEFAULT_OPTION);
			subjectTxt.setText("");
			contentTxt.setText("");
		} else {
			JOptionPane.showMessageDialog(null, "메일 발송 중 에러", "경고창", JOptionPane.WARNING_MESSAGE);
		}
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

		if (src == sendBtn) {
			mailing();
		} else if (src == empBtn) {
			new JTableTest("");
			dispose();
		}
	}

	public static void main(String[] args) {
		new MailScreen();
	}
}
