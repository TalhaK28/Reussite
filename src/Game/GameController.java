package Game;

public class GameController {

	
	
	GameController(){
		
	}
	
	public int start() {
		
		int score=0;
		
		Pile cardPile = new Pile();
		Hand Hand = new Hand();
		
		for(int i=0; i<4;i++) {
		
			Hand.addCard(cardPile.cardDraw());
			
		}
		
		while (cardPile.getSize()>0) {
			
			if(Hand.getHead().isHauteurEqual(Hand.getTail())) {
				
				Hand.allDiscarded();
				
				for(int i=0; i<4;i++) {
					if (Hand.getHiddenCardSize()==0) {
						Hand.uncoverCard();
					}else {
						Hand.addCard(cardPile.cardDraw());
					}
				}
				score =+ 5;
				
			}else if (Hand.getHead().isSuitEqual(Hand.getTail())) {
				
				Hand.twoDiscarded();
				
				for(int i=0; i<2;i++) {
					if (Hand.getHiddenCardSize()==0) {
						Hand.uncoverCard();
					}else {
						Hand.addCard(cardPile.cardDraw());
					}
				}
				
				score =+ 2;
				
			}else {
				
				Hand.hideCard();
				Hand.addCard(cardPile.cardDraw());
				
				
			}
			
			
			
		}
		
		
		
		
		return score;
		
	}
	
	
	
}
