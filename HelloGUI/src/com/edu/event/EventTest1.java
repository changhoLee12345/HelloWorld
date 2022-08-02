package com.edu.event;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class EventTest1 extends JFrame {

	private static final long serialVersionUID = 1L;

	int counter = 0;
	JButton button;
	JLabel label;

	class MyListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			counter++;
			label.setText("counter: " + counter);
		}
	}

	public EventTest1() {
		setSize(400, 150);
		setTitle("event example");

		setLayout(new FlowLayout());
		button = new JButton("increase");
		button.addActionListener(new MyListener());
		label = new JLabel("counter: " + counter);

		add(button, "East");
		add(label, "Center");

		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new EventTest1();
	}
}
