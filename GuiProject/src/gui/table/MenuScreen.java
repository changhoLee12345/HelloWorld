package gui.table;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import gui.table.MenuScreen2.MyActionListener;

public class MenuScreen extends JFrame implements ActionListener {

	MyMenu menu = new MyMenu(this);
	JMenuBar mainBar = menu.menuBar();

	public MenuScreen() {

		setTitle("menu test");
		setSize(350, 250);

		setJMenuBar(mainBar);

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();

		if (src == menu.miEmp) {

		} else if (src == menu.miSms) {

		} else if (src == menu.miMail) {

		} else if (src == menu.miExit) {
			System.exit(0);

//		} else if (src == menu.miCopy) {

//		} else if (src == menu.miPaste) {

		}
	}

	public static void main(String[] args) {
		new MenuScreen();
	}
}
