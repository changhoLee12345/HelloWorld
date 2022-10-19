package gui.table;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

public class MenuScreen2 extends JFrame {

	MyMenu menu = new MyMenu(new MyActionListener());
	JMenuBar mainBar = menu.menuBar();

	public MenuScreen2() {

		setTitle("menu test");
		setSize(350, 250);

		setJMenuBar(mainBar);

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

	}

	class MyActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			Object src = e.getSource();
			if (src == menu.miEmp) {

			} else if (src == menu.miSms) {

			} else if (src == menu.miMail) {

			} else if (src == menu.miExit) {
				System.exit(0);

//			} else if (src == menu.miCopy) {

//			} else if (src == menu.miPaste) {

			}
		}
	}

	public static void main(String[] args) {
		new MenuScreen2();
	}
}
