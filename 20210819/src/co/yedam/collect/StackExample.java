package co.yedam.collect;

import java.util.Stack;

class Coin {
	private int value;

	public Coin(int value) {
		super();
		this.value = value;
	}

	public int getValue() {
		return value;
	}

}

public class StackExample {

	public static void main(String[] args) {

		Stack<Coin> coinBox = new Stack<Coin>();
		coinBox.push(new Coin(100));
		coinBox.push(new Coin(60));
		coinBox.push(new Coin(50));
		coinBox.push(new Coin(80));
		
		System.out.println(coinBox.peek().getValue());
		while (!coinBox.isEmpty()) {
			Coin coin = coinBox.pop();
			System.out.println(coin.getValue());
		}
	}

}
