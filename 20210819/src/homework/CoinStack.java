package homework;

import java.util.LinkedList;
import co.yedam.collect.Coin;

/*  LinkedList로 스택을 구현
 *  */
public class CoinStack {
	public static void main(String[] args) {

		LinkedList<Coin> coinBox = new LinkedList<>();
		// push -> add, addfirst, addlast
		coinBox.push(new Coin(100));
		coinBox.push(new Coin(60));
		coinBox.push(new Coin(50));
		coinBox.push(new Coin(80));

		while (!coinBox.isEmpty()) {
			// pop ->get + remove, removeLast, removeFirst
			Coin coin = coinBox.pop();
			System.out.println(coin.getValue());
		}
	}
}
