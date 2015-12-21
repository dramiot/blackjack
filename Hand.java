// Hand consists of an array of PlayingCards used in determining the player's score.
// It also keeps track of the number of cards and their total value. softCount keeps
// track of aces and helps to determine their value (1 or 11).

import java.util.ArrayList;

public class Hand
{
	private ArrayList<PlayingCard> hand;
	private int numCards;
	private int score;
	private int softCount;
	
	// Default Hand consists of 0 cards.
	public Hand()
	{
		hand = new ArrayList<PlayingCard>();
		numCards = 0;
		score = 0;
		softCount = 0;
	}
	
	// showHand prints the player's hand to the screen.
	public void showHand()
	{
		for(PlayingCard card : hand)
		{
			card.flipCard();
			System.out.print(card.getValue() + "  ");
			card.flipCard();
		}
	}
	
	// showDealer prints the hand to the screen, hiding the first card.
	// Used for displaying the dealer's hand.
	public void showDealer()
	{
		hand.get(0).flipCard();
		for(PlayingCard card : hand)
		{
			card.flipCard();
			System.out.print(card.getValue() + "  ");
			card.flipCard();
		}
		hand.get(0).flipCard();
	}
	
	// acceptCard adds the PlayingCard provided by the parameter to the hand.
	public void acceptCard(PlayingCard card)
	{
		hand.add(card);
	}
}