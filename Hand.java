// Hand consists of an array of PlayingCards used in determining the player's score.
// It also keeps track of the number of cards and their total value. softCount keeps
// track of aces and helps to determine their value (1 or 11).

import java.util.ArrayList;

public class Hand
{
	private ArrayList<PlayingCard> hand;
	private int score;
	private int softCount;
	
	// Default Hand consists of 0 cards.
	public Hand()
	{
		hand = new ArrayList<PlayingCard>();
		score = 0;
		softCount = 0;
	}
	
	// showHand prints the player's hand to the screen.
	public void showHand()
	{
		for(PlayingCard card : hand)
			System.out.print(card.getValue() + "  ");
		System.out.println();
	}
	
	// showDealer prints the hand to the screen, hiding the first card.
	// Used for displaying the dealer's hand.
	public void showDealer()
	{
		hand.get(0).flipCard();
		for(PlayingCard card : hand)
			System.out.print(card.getValue() + "  ");
		hand.get(0).flipCard();
		System.out.println();
	}
	
	// acceptCard adds the PlayingCard provided by the parameter to the hand.
	// It then calculates the points to be added by checking the rank of the new card.
	// If the card is an Ace and the score is greater than 20, 10 points is subtracted
	// from the score.
	public void accept(PlayingCard card)
	{
		card.flipCard();
		hand.add(card);
		char[] ranks = {'A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K'};
		int points[] = { 11,   2,   3,   4,   5,   6,   7,   8,   9,  10,  10,  10,  10};
		
		for(int i = 0; i < 13; i++)
		{
			if(card.getRank() == ranks[i])
				score += points[i];
		}
		
		if(card.getRank() == 'A')
			softCount += 1;
		
		while(softCount > 0 && score > 20)
		{
			score -= 10;
			softCount--;
		}
	}
	
	public int getScore()
	{
		return score;
	}
    
    public int getSoftCount()
    {
        return softCount;
    }
	
	// isBlackjack returns true if a 2-card hand consists of an A and a T/J/Q/K.
	public boolean isBlackjack()
	{
		boolean blackjack = false;
		if(hand.size() == 2)
		{
			// If card 1 is an Ace and card 2 is a 10/J/Q/K
			if     (hand.get(0).getRank() == 'A' &&
                   (hand.get(1).getRank() == 'T' ||
                    hand.get(1).getRank() == 'J' ||
                    hand.get(1).getRank() == 'Q' ||
                    hand.get(1).getRank() == 'K' ))
                        blackjack = true;
			// If card 2 is an Ace and card 1 is a 10/J/Q/K
			else if(hand.get(1).getRank() == 'A' &&
                   (hand.get(0).getRank() == 'T' ||
                    hand.get(0).getRank() == 'J' ||
                    hand.get(0).getRank() == 'Q' ||
                    hand.get(0).getRank() == 'K' ))
                        blackjack = true;
				
		}
		return blackjack;
	}
	
	//Returns true if the hand has a score greater than 21.
	public boolean isBust()
	{
		return	(score > 21);
	}
	
	// reset deletes the cards in the hand and resets score and softCount to 0.
	public void reset()
	{
		hand.clear();
		score = 0;
		softCount = 0;
	}
}