package Game;
import java.util.LinkedList;


public class Hand {

	LinkedList<Card> cardHand;
	LinkedList<Card> hiddenCard;
	
	Hand(){
		this.cardHand = new LinkedList<>();
        this.hiddenCard = new LinkedList<>();
	}
	
	public int getSize() {
		return this.cardHand.size();
	}
	
	public int getHiddenCardSize() {
		
		if (!this.hiddenCard.isEmpty()) { 
			return this.hiddenCard.size();
		}else { 
			return 0;
		}
	}
	
	public void allDiscarded() {
		
		this.cardHand=new LinkedList<>();
		
	}
	
	public void twoDiscarded() {
		
		this.cardHand.remove(1);
		this.cardHand.remove(1);
		
	}
	
	public void hideCard() {
		
		this.hiddenCard.addFirst(this.cardHand.get(3));
		this.cardHand.remove(3);
		
	}
	
	public void uncoverCard() {
		
		this.cardHand.addLast(this.hiddenCard.get(0));
		this.hiddenCard.removeFirst();
		
	}
	
	public void addCard(Card e ) {
		
		this.cardHand.addFirst(e);
		
	}
	
	public Card getHead() {
		return cardHand.getFirst();
	}
	
	public Card getTail() {
		return cardHand.getLast();
	}
	
	public Card getCard(int rang) {
		return this.cardHand.get(rang);
	}
	

}
