package game.blackjack;

import org.junit.jupiter.api.Test;

class CardTest {

	@Test
	void testCard() {
		Card[] cards = Card.getAllCards();
		for(int i = 0; i < cards.length; i++) {
			Card card = cards[i];
			System.out.println(card.toString());
		}
	}

}
