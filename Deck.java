// Deck consists of an array of PlayingCards.

import java.util.ArrayList;

public class Deck 
{
	private ArrayList<PlayingCard> deck;
	private boolean isShuffled;
	
	private char[] validSuits = {'♥', '♦', '♣', '♠'};
	private char[] validRanks = {'A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K'     };

	// Default deck has one card of each rank for each suit, for a total of 52 cards.
	public Deck() 
	{
		deck = new ArrayList<PlayingCard>();
		for(char suit : validSuits)
		{
			for(char rank : validRanks)
				deck.add(new PlayingCard(rank, suit));
		}
		
		isShuffled = false;
	}
	
	// showDeck prints the remaining cards in the deck to the screen.
	// Useful for debugging.
	public void showDeck()
	{
		int pos = 0;
		for(PlayingCard card : deck)
		{
			card.flipCard();
			System.out.print(card.getValue() + "  ");
			card.flipCard();
			pos++;
			if((pos) % 13 == 0)
				System.out.println();
		}
		System.out.println();
	}
	
	// shuffle changes the order of PlayingCards in the deck.
	public void shuffle()
	{
        if(!isShuffled)
        {
            System.out.println("Shuffling the deck...");
            
            int j;
            PlayingCard temp;
            
            for(int i = 0; i < deck.size(); i++)
            {
                j = (int)(Math.random() * 104) % 52;
                temp = deck.get(i);
                deck.set(i, deck.get(j));
                deck.set(j, temp);
            }
            
            isShuffled = true;
        }
	}
	
    // deal deals the first card in the deck to the provided hand parameter.
	public void deal(Hand hand)
	{
		System.out.println("Dealing...");
		PlayingCard dealt = deck.get(0);
		deck.remove(0);
		
		hand.accept(dealt);
	}
    
    // reset recreates the deck when if it has less than 12 cards in it.
    public void reset()
    {
        if(deck.size() < 12)
        {
            deck.clear();
            deck = new ArrayList<PlayingCard>();
            for(char suit : validSuits)
            {
                for(char rank : validRanks)
                    deck.add(new PlayingCard(rank, suit));
            }
		
		isShuffled = false;
        }
    }
    
    // getSize returns the size of the deck.
    public int getSize()
    {
        return deck.size();
    }
}