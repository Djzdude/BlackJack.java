
package blackJack;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		//generate card array
		Card[] deck = new Card[52];
		for (int i = 0; i < deck.length; i++){
            deck[i] = new Card(i);
        }
        
        //display player and dealer's starting amounts
        int playerTotal = 500;
        int dealerTotal = 500;
        
        int top = 0;
        
        int playerValue = 0;
        int dealerValue = 0;
        
        int betTotal = 0;
        
        String playerHand = ""; 
        String dealerHand = "";
        
        String input = "";
        
        Scanner scanner = new Scanner(System.in);
        
        for (int i = 0; i < deck.length; i++) {
	        int r = i + (int) (Math.random() * (deck.length-i));
	        Card temp = deck[r];
	        deck[r] = deck[i];
	        deck[i] = temp;
	    }
        
        while (playerTotal > 0 && dealerTotal > 0) {
        	//shuffle
        	if(top > 42) {
	        	for (int i = 0; i < deck.length; i++) {
	    	        int r = i + (int) (Math.random() * (deck.length-i));
	    	        Card temp = deck[r];
	    	        deck[r] = deck[i];
	    	        deck[i] = temp;
	    	    }
        	}
        	//initial bank totals
		    System.out.println("Your money is $" + playerTotal);
		    System.out.println("Banker's money is $" + dealerTotal);
		    System.out.println("");
		    int small = 0;
		    //prompt player for numerical bet
		    while (small < 1) {
			    System.out.print("Enter the amount of money you want to bet: ");
			    System.out.println("");
			    input = scanner.nextLine();
			    small++;
			    
			    try{
		            betTotal = Integer.parseInt(input);
		            if (betTotal > playerTotal || betTotal < 0) {
				        System.out.println("You can not bet that amount of money");
				        System.out.println("Input an integer");
				        break;
				    } else if (betTotal <= playerTotal) {
				        System.out.println("You chose to bet $" + input );
				    }
		        } catch(NumberFormatException ex){ 
		        	System.out.println("Input an integer");
		        	small = 0;
		        }
		    	    
		    //variable arrays for hands
		    //initial hands
		    
		    playerHand = "";
		    playerValue = 0;
		    dealerHand = "";
		    dealerValue = 0;
		    
		    playerHand = playerHand + ", " + deck[top].toString();
		    playerValue = playerValue + deck[top].getValue();
		    top ++;
		    playerHand = playerHand + ", " + deck[top].toString();
		    playerValue = playerValue + deck[top].getValue();
		    top++;
 
		    dealerHand = deck[top].toString();
	    	dealerValue = dealerValue + deck[top].getValue();
	    	top++;
		    
		    System.out.println("");
			System.out.println("Dealer's hand: " + dealerHand + ", and a facedown card");
			System.out.println("Dealer's total: " + dealerValue);
			System.out.println("");
			
			System.out.println("Your hand: " + playerHand);
			System.out.println("Your total: " + playerValue);
			System.out.println("");
		
			dealerHand = dealerHand + ", " + deck[top].toString();
			dealerValue = dealerValue + deck[top].getValue();
			String flippedCard = deck[top].toString();
			top++;
			
			String choice = "h";
			//playerValue <= 21 || dealerValue <= 21
			while (choice.equals("h")){
				System.out.println("");
				System.out.println("Type (H) to hit or (S) to stand:");
				choice = scanner.nextLine().toLowerCase();
				if (choice.equals("s")) {
					System.out.println("You chose to stand");
					System.out.println("Your hand's value: " + playerValue);
					System.out.println("");
					System.out.println("Dealer flips card and reveals " + flippedCard + " and now has a value of " + dealerValue);
					System.out.println("");
					while (dealerValue < 17) {
						System.out.println("Dealer chose to hit and drew a(n) " + deck[top]);
						dealerValue += deck[top].getValue();
						dealerHand = dealerHand + ", " + deck[top].toString();
						System.out.println("Dealer's hand: " + dealerHand);
						System.out.println("Dealer's hand's value: " + dealerValue);
						System.out.println("");
						top++;
					} 
					if (dealerValue > 21) {
						System.out.println("Dealer busted");
						System.out.println("");
						playerTotal = playerTotal + betTotal;
						dealerTotal = dealerTotal - betTotal;
						break;	
					} else if (dealerValue >= 17) {
						System.out.println("Dealer chose to stand");
						System.out.println("Dealer's hand's value: " + dealerValue);
						System.out.println("");
						
						if (dealerValue > playerValue) {
							playerTotal = playerTotal - betTotal;
							dealerTotal = dealerTotal + betTotal;
							System.out.println("Dealer won this hand");
						} else if (playerValue > dealerValue) {
							playerTotal = playerTotal + betTotal;
							dealerTotal = dealerTotal - betTotal;
							System.out.println("You win this hand");
						} else {
							System.out.println("This hand was a tie");
						}
						
						break;	
						
					}
				} else  if(choice.equals("h")) {
					System.out.println("You chose to hit and drew a(n) " + deck[top]);
					playerValue += deck[top].getValue();
					if (playerValue > 21) {
						System.out.println("You busted");
						playerTotal = playerTotal - betTotal;
						dealerTotal = dealerTotal + betTotal;
						break;
					}
					System.out.println("Your Total: " + playerValue);
					top++;
				} else {
					System.out.println("Invalid Choice, choose (H) or (S)");
					choice = "h";
						
				}			
			}//while
			
			if (playerTotal <= 0) {
				System.out.println("");
				System.out.println("You lose, you are out of money");			
			} else if (dealerTotal <= 0) {
				System.out.println("");
				System.out.println("You won, the dealer is out of money");
			} 
			
        }//while		
        scanner.close();
	}//public static       
}//class
