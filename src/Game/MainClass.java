package Game;
//import javax.swing.*;
//import java.awt.*;

import java.awt.EventQueue;

public class MainClass {

	public static void main(String[] args) {
		
		GameController GameControl=new GameController();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		//int score =GameControl.start();

		//System.out.println("Le score final :" + score);
	}

}
