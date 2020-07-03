package game.blackjack;

import org.junit.jupiter.api.Test;

class DealerTest {

	@Test
	void testDealer() {
		Stock stock = new Stock();
		Dealer dealer = new Dealer();

		dealer.start(stock);
		dealer.play(stock);
		System.out.println(dealer.toString());

	}
}
