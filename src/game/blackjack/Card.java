package game.blackjack;

public class Card {
	public enum Suit {
		SPADE,
		HEART,
		DIAMOND,
		CLUB
	}

	private Suit suit;
	private int number;

	public Card(Suit suit, int number) {
		this.suit = suit;
		this.number = number;
	}

//	ゲッターでsuitの中身を見れるようにする
	public Suit getSuit() {
		return this.suit;
	}

//	ゲッターでnumberの中身を見れるようにする
	public int getNumber() {
		return this.number;
	}

	public static String getSuitString(Suit suit) {
		String string = null;

		if(suit == Suit.SPADE) {
			string = "スペード";
		} else if(suit == Suit.HEART) {
			string = "ハート";
		} else if(suit == Suit.DIAMOND) {
			string = "ダイアモンド";
		} else if(suit == Suit.CLUB) {
			string = "クラブ";
		}

		return string;
	}

	public static String getNumberString(int number) {
		String string = null;

		if(number == 1) {
			string = "A";
		} else if(number == 11) {
			string = "J";
		} else if(number == 12) {
			string = "Q";
		} else if(number == 13) {
			string = "K";
		} else if(number >= 2 && number <= 10) {
			string = Integer.toString(number);
		}

		return string;
	}

	public String toString() {
		String suit = getSuitString(this.suit);
		String number = getNumberString(this.number);

		String string = "[]";
		if(suit != null && number != null) {
			string = "[" + suit + number + "]";
		}

		return string;
	}


	public static Card[] getAllCards() {
		Card[] cards = new Card[52];
		int index = 0;

		Suit[] suits = {Suit.SPADE, Suit.HEART, Suit.DIAMOND, Suit.CLUB};
		for(int i = 0; i < suits.length; i++) {
			Suit suit = suits[i];
			for(int number = 1; number <= 13; number++) {
				Card card = new Card(suit,number);
				cards[index] = card;
				index++;
			}
		}

		return cards;
	}

}
