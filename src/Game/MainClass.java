package Game;
import javax.swing.*;
import java.awt.*;

public class MainClass {

	public static void main(String[] args) {
		
		GameController GameControl=new GameController();
		
		int score =GameControl.start();

	}

}
