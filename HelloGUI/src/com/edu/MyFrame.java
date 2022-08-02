package com.edu;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	public MyFrame() {

		setTitle("CardLayoutTest");
		setSize(new Dimension(300, 150));
		Container cPane = getContentPane();
		CardLayout layout = new CardLayout();

		setLayout(layout);

		JButton b1 = new JButton("Card #1");
		JButton b2 = new JButton("Card #2");
		JButton b3 = new JButton("Card #3");

		add(b1);
		add(b2);
		add(b3);

		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				layout.next(cPane);
			}
		});
		
		b2.addActionListener(e -> layout.next(cPane));
		
		b3.addActionListener(e -> layout.next(cPane));
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		new MyFrame();
	}

}
