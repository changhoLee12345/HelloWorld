package com.edu;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ImageLabelTest extends JFrame {

	public ImageLabelTest() {
		setTitle("image label test");
		setSize(800, 450);

		BorderLayout layout = new BorderLayout();
		setLayout(layout);

		JPanel panel = new JPanel();
		JLabel label = new JLabel("Dog");
		ImageIcon icon = new ImageIcon("d:/dog.png");
		label.setIcon(icon);
		panel.add(label);

		add(panel, "Center");

		JButton button = new JButton("click for detail info");
		add(button, "South");

		setVisible(true);
	}

	public static void main(String[] args) {
		new ImageLabelTest();
	}
}
