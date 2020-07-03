package game.blackjack;

	import java.util.ArrayList;

public abstract class Attender {
	protected ArrayList<Card> cards;
	protected String name;

	public Attender(String name) {
		this.name = name;
		initialize();
	}

	public void initialize() {
		this.cards = new ArrayList<Card>();
	}

	public void start(Stock stock) {
		this.cards.clear();
		for(int i = 0; i < 2; i++) {
			Card card = stock.pickCard();
			this.cards.add(card);
		}
	}

	public String getName() {
		return name;
	}

	public void hit(Stock stock) {
		Card card = stock.pickCard();
		this.cards.add(card);
	}

	public int calculateStrength() {
		int strength = 0;


		for(int i = 0; i < this.cards.size(); i++) {
			Card card = this.cards.get(i);
			int number = card.getNumber();

			if(number == 1) {
				strength += 1;
			} else if(number == 11 || number == 12 || number ==13) {
				strength += 10;
			} else {
				strength += number;
			}
		}

		if(strength <= 11) {
			for(int j = 0; j < this.cards.size(); j++) {
				Card cardcheck = this.cards.get(j);
				int number1 = cardcheck.getNumber();
				if(number1 == 1) {
					strength += 10;
				}
			}
		} else if(strength > 21) {
			strength = 0;
		}

		return strength;
	}

	public String toString() {
		String string = name + ": ";
		for(int i = 0; i < this.cards.size(); i++) {
			Card card = this.cards.get(i);
			string = string + card.toString();
		}
		return string;
	}

	public void display() {
		System.out.println(this.toString());
	}

	public abstract void play(Stock stock);

}
