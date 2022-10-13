package gui.exercise;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GridLayoutTest extends JFrame {

	JButton[] jbtns = new JButton[16];
	String[] operators = { "+", "-", "*", "/" };
	String[] keypad = { "1", "2", "3", "+", "4", "5", "6", "-", "7", "8", "9", "*", "0", "=", "C", "/" };
	JPanel panel;
	JPanel displayPanel;
	JTextField display;
	ClickListener listener = new ClickListener();
	String displayText, left, right;

	GridLayoutTest() {

		displayText = "0";
		setTitle("ui test");

		setLayout(new FlowLayout());
		setBounds(700, 550, 300, 250);

		displayPanel = new JPanel();
		displayPanel.setLayout(new FlowLayout());

		display = new JTextField("0", 20);
		display.setHorizontalAlignment(JTextField.RIGHT);
		displayPanel.add(display);

		panel = new JPanel();
		panel.setLayout(new GridLayout(4, 4));
		for (int i = 0; i < jbtns.length; i++) {
			jbtns[i] = new JButton(keypad[i]);
			jbtns[i].addActionListener(listener);
			panel.add(jbtns[i]);
		}

		add(displayPanel);
		add(panel);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private class ClickListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String oper = ((JButton) e.getSource()).getText();
			if (oper.equals("C")) {
				displayText = "0";
				display.setText(displayText);
			} else if (oper.equals("=")) {
				String currentOper = "";
				for (String operator : operators) {
					if (displayText.indexOf(operator) != -1) {
						currentOper = operator;
					}
				}
				left = displayText.substring(0, displayText.indexOf(currentOper));
				right = displayText.substring(displayText.indexOf(currentOper) + 1);
				int result = 0;
				if (currentOper.equals("+")) {
					result = Integer.parseInt(left) + Integer.parseInt(right);
				} else if (currentOper.equals("-")) {
					result = Integer.parseInt(left) - Integer.parseInt(right);
				} else if (currentOper.equals("*")) {
					result = Integer.parseInt(left) * Integer.parseInt(right);
				} else if (currentOper.equals("/")) {
					result = Integer.parseInt(left) / Integer.parseInt(right);
				}
				displayText = String.valueOf(result);
				display.setText(displayText);
			} else {
				displayText += oper;
				if (displayText.charAt(0) == '0')
					displayText = displayText.substring(1);
				display.setText(displayText);
			}

		}
	}

	public static void main(String[] args) {
		GridLayoutTest ui = new GridLayoutTest();

	}
}
