package Game;

import java.util.LinkedList;
import java.util.Collections;

public class Pile {

    LinkedList<Card> cardPile = new LinkedList<>();
    public int cardNumber = 52;

 
    public Pile() {
        // Initialize the pile with cards
        for (int suit = 1; suit <= 4; suit++) {
            for (int height = 1; height <= 13; height++) {
                Card card = new Card(height, suit, true, "tqt");
                cardPile.add(card);
            }
        }
        
        // Shuffle the card pile 
        Collections.shuffle(cardPile);
    }

    
    public Card cardDraw() {
    	
    	Card returnedCard = new Card();
    	returnedCard = this.cardPile.getFirst();
    	cardPile.removeFirst();
    	
    	return returnedCard;
    	
    }
}
