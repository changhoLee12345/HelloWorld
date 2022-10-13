package gui.basic;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ImageLabelTest extends JFrame {

	JPanel panel;
	JLabel label;
	JButton button;

	ImageLabelTest() {
		setTitle("레이블 테스트");
		setSize(400, 500);

		panel = new JPanel();
		label = new JLabel("Dog");
		ImageIcon icon = new ImageIcon("/home/ubuntie/Pictures/sample.png");
		label.setIcon(icon);
		label.setSize(10, 15);

		button = new JButton("자세한 정보를 보려면 클릭하세요!");
		panel.add(label);
		panel.add(button);
		add(panel);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		ImageLabelTest gui = new ImageLabelTest();
	}
}
