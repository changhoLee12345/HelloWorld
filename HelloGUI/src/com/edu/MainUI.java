package com.edu;

import javax.swing.JFrame;

public class MainUI {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Frame");
		frame.setTitle("MyFrame");
		frame.setSize(300, 200);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
