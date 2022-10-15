package gui.basic;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class BorderTest extends JFrame {

	BorderTest() {
		setTitle("borderlayout test");
		setLayout(new BorderLayout(10, 10));
		setSize(new Dimension(300, 150));

		JPanel center = new JPanel();
		JPanel right = new JPanel();
		JPanel bottom = new JPanel();
		
		

		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new BorderTest();
	}
}
