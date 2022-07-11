package co.yedam.collect;

import java.util.Stack;

public class StackExample {

	public static void main(String[] args) {

		Stack<Coin> coinBox = new Stack<Coin>();
		coinBox.push(new Coin(100));
		coinBox.push(new Coin(60));
		coinBox.push(new Coin(50));
		coinBox.push(new Coin(80));

		while (!coinBox.isEmpty()) {
			Coin coin = coinBox.pop();
			System.out.println(coin.getValue());
		}
	}

}
