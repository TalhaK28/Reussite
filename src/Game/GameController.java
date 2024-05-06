package Game;


public class GameController {

	  Pile cardPile;
      Hand Hand;
      int score, joker;
	
    GameController() {

    	  this.cardPile = new Pile();
          this.Hand = new Hand();

          for (int i = 0; i < 4; i++) {

              Hand.addCard(cardPile.cardDraw());

          }
          
    }
    
    GameController(GameController gamecontrol){
    	
    	this.cardPile=gamecontrol.cardPile;
        this.Hand=gamecontrol.Hand;
        this.score=gamecontrol.score;
        this.joker=gamecontrol.joker;
    	
    }

    public int testHand() {
        
        if (this.Hand.getHead().isHauteurEqual(this.Hand.getTail())) {

           return 1;

        } else if (this.Hand.getHead().isSuitEqual(this.Hand.getTail())) {

        	return 2;

        } else if (joker < 3) {
                    
             return 3;

        }else {

             return 4;
        }
             
    }

 
    
    public void firstCaseHand() {
    	   this.Hand.allDiscarded();

                for (int i = 0; i < 4; i++) {
                    if (this.Hand.getHiddenCardSize() != 0) {
                        this.Hand.uncoverCard();
                    } else {
                        this.Hand.addCard(this.cardPile.cardDraw());
                    }
                }
                this.score += 5;
    }
    
    public void secondCaseHand() {
    	 this.Hand.twoDiscarded();

                for (int i = 0; i < 2; i++) {
                    if (this.Hand.getHiddenCardSize() != 0) {
                        this.Hand.uncoverCard();
                    } else {
                        this.Hand.addCard(this.cardPile.cardDraw());
                    }
                }

                this.score += 2;
    }
    
    public void  thirdCaseHand() {
    	 joker++;
         this.Hand.twoDiscarded();

         for (int i = 0; i < 2; i++) {
             if (this.Hand.getHiddenCardSize() != 0) {
                 this.Hand.uncoverCard();
             } else {
                 this.Hand.addCard(this.cardPile.cardDraw());
             }
         }
    }
    
    public void fourthCaseHand() {
    	
    	this.Hand.hideCard();
    	this.Hand.addCard(this.cardPile.cardDraw());
    	
    }
    
    public int getScore() {
    	return this.score;
    }

    public String getCardImage(int rang) {
    	
    	return this.Hand.getCard(rang).getImage(); 
    
    }
    
    public int getJoker() {
    	return joker;
    }
}

