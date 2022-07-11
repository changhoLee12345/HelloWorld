package co.yedam.fly;

public class AppMain {
	public static void main(String[] args) {
		Human human = new Human();
		human.eat();
		human.think();

		Bird bird = new Bird();
		bird.eat();
		bird.run();
		bird.sleep();
		bird.layEggs();

		Superman superman = new Superman();
		superman.run();
		superman.eat();   // animal
		superman.think(); // human
		superman.fly();   // superman
	}
}
