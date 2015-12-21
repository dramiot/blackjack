// PlayingCard consists of a char suit (♥, ♦, ♣, or ♠), and a char rank (A-K), which 
// together form the 'value' of the card. Boolean face determines whether the value
// is known (true) or hidden (false).

public class PlayingCard 
{
	private char rank;
	private char suit;
	private boolean face;
	
	// Default PlayingCard is the Ace of Spades, face-down.
	public PlayingCard() 
	{
		rank = 'A';
		suit = '♠';
		face = false;
	}
	
	// Create a face-down card with a rank 'r' and suit 's'.
	public PlayingCard(char r, char s) 
	{
		rank = r;
		suit = s;
		face = false;
	}
	
	// getValue returns a string of "??" for face-down cards and 
	// "RS", where R is rank and S is suit, for face-up cards.
	public String getValue() 
	{
		String value;
		if(!face)
			value = "??";
		else
		{
			value = "" + rank + suit;
		}
		return value;
	}
	
	// flipCard makes face-down cards face-up and vice-versa.
	public void flipCard() 
	{
		face = !face;
	}
	
	public char getRank()
	{
		return rank;
	}
	
	public char getSuit() 
	{
		return suit;
	}
}