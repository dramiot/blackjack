public class Deck {
	String[] deck = new String[52];
	
	String[] suits = {"♥", "♦", "♣", "♠"};
	String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K"};
	
	public Deck() {
		int pos = 0;
		for(String suit : suits) {
			for(String rank : ranks) {
				deck[pos] = rank + suit;
				pos++;
			}
		}
	}
	
	public int getSize() {
		return deck.length;
	}
	
	public String getCard(int pos) {
		return deck[pos];
	}
	
	public void shuffle() {
		for(int i = 0; i < deck.length; i++) {
			int j = (int)(Math.random() * 100) % 52;
			String temp = deck[i];
			deck[i] = deck[j];
			deck[j] = temp;
		}
	}
	
	public static void main(String[] args) {
		Deck blackjackDeck = new Deck();
		
		System.out.println("Before shuffling: ");
		for(int i = 0; i < blackjackDeck.getSize(); i++) {
			System.out.print(blackjackDeck.getCard(i) + "  ");
			
			if((i + 1) % 13 == 0) {System.out.println();}
		}
		
		System.out.println();
		blackjackDeck.shuffle();
		
		System.out.println("After shuffling: ");
		for(int i = 0; i < blackjackDeck.getSize(); i++) {
			System.out.print(blackjackDeck.getCard(i) + "  ");
			
			if((i + 1) % 13 == 0) {System.out.println();}
		}
		
		System.out.println();
	}
}