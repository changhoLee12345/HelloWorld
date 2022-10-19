package gui.table;

import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MyMenu {
	private JMenuBar menuBar;

	private JMenu mFile;
	private JMenu mEdit;

	JMenuItem miEmp, miSms, miMail, miExit;
//	JMenuItem miCopy, miPaste;

	public MyMenu(ActionListener listener) {
		menuBar = new JMenuBar();

		mFile = new JMenu("File");
		mEdit = new JMenu("Edit");

		// File 메뉴에 추가할려는 메뉴아이템.
		miEmp = new JMenuItem("Employee");
		miSms = new JMenuItem("SMS");
		miMail = new JMenuItem("Mail");
		miExit = new JMenuItem("Exit");

		// Edit 메뉴에 추가할려는 메뉴아이템.
//		miCopy = new JMenuItem("Copy");
//		miPaste = new JMenuItem("Paste");

		// add event.
		miEmp.addActionListener(listener);
		miSms.addActionListener(listener);
		miMail.addActionListener(listener);
		miExit.addActionListener(listener);
//		miCopy.addActionListener(listener);
//		miPaste.addActionListener(listener);

		mFile.add(miEmp);
		mFile.add(miSms);
		mFile.add(miMail);
		mFile.addSeparator();
		mFile.add(miExit);

//		mEdit.add(miCopy);
//		mEdit.add(miPaste);

		menuBar.add(mFile);
		menuBar.add(mEdit);
	}

	public JMenuBar menuBar() {
		return menuBar;
	}
}
