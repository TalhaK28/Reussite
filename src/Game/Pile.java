package Game;

import java.util.LinkedList;
import java.util.Collections;

public class Pile {

    public LinkedList<Card> cardPile = new LinkedList<>();

 
    public Pile() {
    	int i=1;
        // Initialize the pile with cards
        for (int suit = 1; suit <= 4; suit++) {
            for (int height = 1; height <= 13; height++) {
            	try {
                    Card card = new Card(height, suit, "C:\\Users\\talha\\eclipse-workspace\\Reussite\\src\\Cards\\"+i+".png");
                    cardPile.add(card);
                    i++;
                } catch (Exception e) {
                    System.out.println("Erreur lors du chargement de l'image pour la carte " + i + ": " + e.getMessage());
                }
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
    
    public int getSize() {
    	return this.cardPile.size();
    }
    
    
}
