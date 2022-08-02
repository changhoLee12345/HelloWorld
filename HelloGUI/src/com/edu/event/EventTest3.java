package com.edu.event;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EventTest3 extends JFrame {

	JButton button;
	JLabel label;
	int counter = 0;

	public EventTest3() {
		setSize(400, 150);
		setTitle("event example3");

		JPanel panel = new JPanel();

		button = new JButton("increase");
		button.addActionListener(e -> {
			counter++;
			label.setText("counter: " + counter);
		});
		label = new JLabel("counter: " + counter);

		panel.add(button);
		panel.add(label);

		add(panel);

		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		new EventTest3();
	}
}
