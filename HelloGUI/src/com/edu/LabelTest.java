package com.edu;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LabelTest extends JFrame {

	public LabelTest() {
		setTitle("label test");
		setSize(400, 150);

		JPanel panel = new JPanel();
		JLabel lbl1 = new JLabel("Color Label");
		lbl1.setFont(new Font("Arial", Font.ITALIC, 20));
		lbl1.setForeground(Color.BLUE);
		JLabel lbl2 = new JLabel("Font Label");
		lbl2.setFont(new Font("Arial", Font.ITALIC, 30));
		lbl2.setForeground(Color.ORANGE);
		
		panel.add(lbl1);
		panel.add(lbl2);
		
		add(panel);
		
		setVisible(true);

	}

	public static void main(String[] args) {
		new LabelTest();
	}
}
