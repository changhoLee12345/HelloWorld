package co.edu.statics;

public class Singleton {
	
	Car car;

	private static Singleton singleton = new Singleton();

	private Singleton() {

	}

	public static Singleton getInstance() {
		return singleton;
	}
	
}
