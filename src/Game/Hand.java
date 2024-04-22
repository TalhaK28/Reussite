package Game;
import java.util.LinkedList;


public class Hand {

	LinkedList<Card> cardHand = new LinkedList<>();
	LinkedList<Card> hiddenCard = new LinkedList<>();
	
	Hand(){
		this.cardHand=null;
		this.hiddenCard=null;
	}
	
	public int getSize() {
		return this.cardHand.size();
	}
	
	public int getHiddenCardSize() {
		return this.hiddenCard.size();
	}
	
	public void allDiscarded() {
		
		this.cardHand=null;
		
	}
	
	public void twoDiscarded() {
		
		this.cardHand.remove(2);
		this.cardHand.remove(2);
		
	}
	
	public void hideCard() {
		this.hiddenCard.addFirst(this.cardHand.get(4));
		this.cardHand.remove(4);
	}
	
	public void uncoverCard() {
		
		this.cardHand.addLast(this.hiddenCard.get(1));
		this.hiddenCard.removeFirst();
		
	}
	
	public void addCard(Card e ) {
		
		this.cardHand.add(e);
		
	}
	
	public Card getHead() {
		return cardHand.getFirst();
	}
	
	public Card getTail() {
		return cardHand.getLast();
	}
	
}
