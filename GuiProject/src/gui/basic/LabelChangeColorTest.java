package gui.basic;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LabelChangeColorTest extends JFrame {
	JPanel panel;
	JButton ybtn;
	JButton pbtn;
	MyListener listener = new MyListener();

	LabelChangeColorTest() {
		setTitle("color change test");
		setLayout(new FlowLayout());
		setBounds(10, 10, 300, 350);
		panel = new JPanel();

		ybtn = new JButton("노란색");
		pbtn = new JButton("핑크색");

		ybtn.addActionListener(listener);
		pbtn.addActionListener(listener);

		panel.add(ybtn);
		panel.add(pbtn);

		add(panel);

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private class MyListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == ybtn) {
				getContentPane().setBackground(Color.yellow);
			} else if (e.getSource() == pbtn) {
				getContentPane().setBackground(Color.pink);
			}
		}
	}

	public static void main(String[] args) {
		LabelChangeColorTest gui = new LabelChangeColorTest();
	}
}
