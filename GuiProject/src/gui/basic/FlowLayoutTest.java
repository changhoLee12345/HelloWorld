package gui.basic;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FlowLayoutTest extends JFrame {

	public FlowLayoutTest() {

		setTitle("flowlayout window");
		setLayout(null);
		setSize(new Dimension(300, 200));

		JPanel panel = new JPanel(new FlowLayout());
		panel.setSize(new Dimension(150, 100));
		panel.setBackground(Color.yellow);

		panel.add(new JButton("btn1"));
		panel.add(new JButton("btn2"));
		panel.add(new JButton("btn3"));
		panel.add(new JButton("btn4"));
		panel.add(new JButton("btn5"));

		add(panel);

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

	}

	public static void main(String[] args) {
		new FlowLayoutTest();
	}
}
