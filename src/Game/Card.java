package Game;
import javax.swing.ImageIcon;

public class Card {

	int hauteur;
	int suits; //1=coeur, 2=pique, 3=trèfle ezt 4=careau
	boolean visible;
	ImageIcon image;
	
	Card(){
		
		this.hauteur=0;
		this.suits=0;
		this.visible=true;
		this.image=null;
	}
	

	public Card(int hauteur, int suits, boolean visible, String imagePath){
		
		
		this.hauteur=hauteur;
		this.suits=suits;
		this.visible=visible;
		this.image= new ImageIcon(imagePath);
	}
	
	public int getHauteur(){
		return this.hauteur;
	}
	
	public int getSuits() {
		return this.suits;
	}
	
	public boolean isVisible() {
		return this.visible;
	}
	
	public ImageIcon getImage() {
        return this.image;
    }
	
}
