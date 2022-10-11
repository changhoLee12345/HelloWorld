package gui.control;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BookMemberApp extends JFrame {

	BookMemberApp() {
		setTitle("회원관리");
		setBounds(10, 10, 450, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// panel 을 2개 만들고 하나는 등록정보, 하나는 입력리스트를 테이블로 보여주기.
		JPanel panelInfo = new JPanel(new GridLayout(2,4));

		JLabel lblNo = new JLabel("회원번호:");
		JLabel lblNm = new JLabel("회원이름:");
		JLabel lblPh = new JLabel("회원연락처:");
		JLabel lblPt = new JLabel("회원점수:");

		JTextField txtNo = new JTextField(10);
		JTextField txtNm = new JTextField(10);
		JTextField txtPh = new JTextField(10);
		JTextField txtPt = new JTextField(10);

		panelInfo.add(lblNo);
		panelInfo.add(txtNo);

		panelInfo.add(lblNm);
		panelInfo.add(txtNm);

		panelInfo.add(lblPh);
		panelInfo.add(txtPh);

		panelInfo.add(lblPt);

		panelInfo.add(txtPt);

		JPanel panelData = new JPanel(new FlowLayout());
		
		

		add(panelInfo);
		add(panelData);
		setVisible(true);
	}

	public static void main(String[] args) {
		new BookMemberApp();
	}
}
