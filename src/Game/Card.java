package Game;
import javax.swing.ImageIcon;

public class Card {

	int hauteur; // As=1, Jack=11, Queen=12, King=13
	int suits; //1=coeur, 2=pique, 3=trèfle ezt 4=carreau
	ImageIcon image;
	
	Card(){
		
		this.hauteur=0;
		this.suits=0;
		this.image=null;
	}
	

	public Card(int hauteur, int suits, String imagePath){
		
		
		this.hauteur=hauteur;
		this.suits=suits;
		this.image= new ImageIcon(imagePath);
	}
	
	public int getHauteur(){
		return this.hauteur;
	}
	
	public int getSuits() {
		return this.suits;
	}
	
	
	public ImageIcon getImage() {
        return this.image;
    }
	
}
