package co.test.web;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AutoRun implements ServletContextListener {
	Timer timer = null;

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		timer = new Timer(true);
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println(new Date().toString());
			}
		}, 0, 1000 * 10);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		timer.cancel();
		System.out.println("timer canceled.");
	}
}
