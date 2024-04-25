package Game;
import javax.swing.ImageIcon;

public class Card {

	int hauteur; // As=1, Jack=11, Queen=12, King=13
	int suits; //1=coeur, 2=pique, 3=trèfle ezt 4=carreau
	String image;
	
	Card(){
		
		this.hauteur=0;
		this.suits=0;
		this.image=null;
	}
	

	public Card(int hauteur, int suits, String imagePath){
		
		
		this.hauteur=hauteur;
		this.suits=suits;
		this.image= imagePath;
	}
	
	public int getHauteur(){
		return this.hauteur;
	}
	
	public int getSuits() {
		return this.suits;
	}
	
	
	public String getImage() {
        return this.image;
    }
	
	public boolean isHauteurEqual(Card e) {
		
		return this.hauteur == e.hauteur;
		
	}
	
	public boolean isSuitEqual(Card e) {
		
		return this.suits == e.suits;
		
	}
}
