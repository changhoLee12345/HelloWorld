package gui.control;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	JButton[] btns = new JButton[4];
	String[] lblStrAry = { "확인", "취소", "앞으로", "뒤로" };

	MyFrame() {
		setTitle("프레임 연습");
		setSize(300, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container cntnr = getContentPane();
		cntnr.setLayout(new FlowLayout());

		int x, y, w, h;
		x = y = w = h = 0;
		h = 26;
		w = 75;

		for (int i = 0; i < btns.length; i++) {
			btns[i] = new JButton(lblStrAry[i]);
			btns[i].setBounds(x, y += h, w, h);
			cntnr.add(btns[i]);
		}

		setVisible(true);

		for (int i = 0; i < btns.length; i++) {
			Rectangle rect = btns[i].getBounds();
			System.out.printf("%d, %d, %d, %d\n", rect.x, rect.y, rect.width, rect.height);
		}

	}

	public static void main(String[] args) {
		new MyFrame();
	}
}
