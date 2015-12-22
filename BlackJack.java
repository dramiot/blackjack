import java.util.Scanner;

public class BlackJack 
{
    public static void main(String[] args) 
    {
        Deck blackjack = new Deck();
        Hand player = new Hand();
        Hand dealer = new Hand();
        
        String playAgain;
        Scanner input = new Scanner(System.in);
		System.out.println("Hello, welcome to BlackJack!");
        System.out.print("Would you like to play (y/n)? ");
        playAgain = input.next();

        while(!(playAgain.equals("y") || playAgain.equals("n")))
        {
            System.out.print("Please enter y or n: ");
            playAgain = input.next();
        }
        
        while(playAgain.equals("y"))
        {
            blackjack.shuffle();
            
            blackjack.deal(player);
            blackjack.deal(dealer);
            blackjack.deal(player);
            blackjack.deal(dealer);
            
            System.out.print("Your hand: ");
            player.showHand();
            System.out.print("Dealer's hand: ");
            dealer.showDealer();
            System.out.println("Cards remaining: " + blackjack.getSize());
            
            // Blackjack logic following
            if(player.isBlackjack())
            {
                if(dealer.isBlackjack())
                {
                    System.out.print("Dealer's hand: ");
                    dealer.showHand();
                    System.out.println("Push - you both got blackjack.");
                }
                else
                {
                    System.out.print("Dealer's hand: ");
                    dealer.showHand();
                    System.out.println("Blackjack! You win!");
                }
            }
            else if(dealer.isBlackjack())
            {
                System.out.print("Dealer's hand: ");
                dealer.showHand();
                System.out.println("Dealer got blackjack - you lose!");
            }
            
            // Next round logic following
            else
            {
                boolean nextRound = true;
                
                while(nextRound)
                {
                    String next;
                    System.out.print("Hit or Stand? ");
                    next = input.next();
                    while(!(next.equals("Hit") || next.equals("Stand")))
                    {
                        System.out.print("Please enter Hit or Stand: ");
                        next = input.next();
                    }
                    if(next.equals("Hit"))
                    {
                        blackjack.deal(player);
                        System.out.print("Your hand: ");
                        player.showHand();
                    }
                    else
                        nextRound = false;
                    
                    if(player.isBust())
                    {
                        System.out.println("Bust, you lost!");
                        nextRound = false;
                    }
                    else if(player.getScore() == 21)
                        nextRound = false;
                }
                
                if(!player.isBust())
                {
                    while(dealer.getScore() < 16 || (dealer.getScore() < 20 && dealer.getSoftCount() > 0))
                    {
                        blackjack.deal(dealer);
                        System.out.print("Dealer's hand: ");
                        dealer.showDealer();
                    }
                    System.out.print("Dealer's hand: ");
                    dealer.showHand();
                    
                    if(dealer.isBust())
                        System.out.println("Dealer busts, you win!");
                    
                    else if(dealer.getScore() > player.getScore())
                        System.out.println("Dealer wins!");
                    else if(dealer.getScore() < player.getScore())
                        System.out.println("You win!");
                    else
                        System.out.println("Push!");
                }
            }
            
            // Reset game for next game
            blackjack.reset();
            player.reset();
            dealer.reset();
            
            // Play again?
            System.out.print("Would you like to play again (y/n)? ");
            playAgain = input.next();
            while(!(playAgain.equals("y") || playAgain.equals("n")))
            {
                System.out.print("Please enter y or n: ");
                playAgain = input.next();
            }
        }
        System.out.println("Thanks for playing!");
	}
}