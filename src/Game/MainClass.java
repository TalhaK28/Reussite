package Game;
//import javax.swing.*;
//import java.awt.*;

import java.awt.EventQueue;

public class MainClass {

	public static void main(String[] args) {
		
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
		
		
	
	}

}
