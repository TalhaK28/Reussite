package Game;

import java.awt.EventQueue;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GameInterface extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	String path1, path2, path3, path4;
	GameController GameControl  = new GameController();
	private JButton jokerButton;
	private boolean joker;
	private JLabel firstCard;
	private JLabel secondCard;
	private JLabel thirdCard;
	private JLabel fourthCard;
	
	public void refreshFrame() {
        getContentPane().repaint();
    }
	
	public void refreshInternalFrame(JInternalFrame frame) {
	    frame.repaint();
	}

	
	/**
	 * Create the frame.
	 */
	public GameInterface() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\talha\\eclipse-workspace\\Reussite\\src\\Cards\\1.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1331, 746);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JInternalFrame HandViewer = new JInternalFrame("Hand");
		HandViewer.setBorder(null);
		
		JButton drawButton = new JButton("Draw cards");
		drawButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//this.updateImagesPaths(GameControl.Hand);
				
			
				switch (GameControl.testHand()) {
				    case 1:
				    	GameControl.firstCaseHand();
				        break;
				    case 2:
				        GameControl.secondCaseHand();
				        break;
				    case 3:
				    	if(joker) {
				    		
				    		GameControl.fourthCaseHand();
				    		GameInterface.this.jokerButton.setEnabled(false);
				    		joker=false;
				    		
				    	}else {
				    		joker=true;
				    		if(GameControl.joker<3) {
				    			GameInterface.this.jokerButton.setEnabled(true);
				    	
				    		}else {
				    			GameControl.fourthCaseHand();
				    			joker=false;
				    		}
				    	}
				        break;
				    case 4:
				        GameControl.fourthCaseHand();
				        break;
				    default:
				        
				}

				this.updateImagesPaths(GameControl.Hand);
				refreshFrame();
				refreshInternalFrame(HandViewer);

			}

			public void updateImagesPaths(Hand hand) {
				path1=hand.getCard(0).getImage();
				path2=hand.getCard(1).getImage();
				path3=hand.getCard(2).getImage();
				path4=hand.getCard(3).getImage();
				
				firstCard.setIcon(new ImageIcon(path1));
			    secondCard.setIcon(new ImageIcon(path2));
			    thirdCard.setIcon(new ImageIcon(path3));
			    fourthCard.setIcon(new ImageIcon(path4));
			}
		});
		drawButton.setFont(new Font("Old English Text MT", Font.PLAIN, 29));
		
		jokerButton = new JButton("Joker");
		jokerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				joker=false;
				GameControl.thirdCaseHand();
				this.updateImagesPaths(GameControl.Hand);
				refreshInternalFrame(HandViewer);
				GameInterface.this.jokerButton.setEnabled(false);
			}
			
			public void updateImagesPaths(Hand hand) {
				path1=hand.getCard(0).getImage();
				path2=hand.getCard(1).getImage();
				path3=hand.getCard(2).getImage();
				path4=hand.getCard(3).getImage();
				
				firstCard.setIcon(new ImageIcon(path1));
			    secondCard.setIcon(new ImageIcon(path2));
			    thirdCard.setIcon(new ImageIcon(path3));
			    fourthCard.setIcon(new ImageIcon(path4));
			}
			
		});
		jokerButton.setEnabled(false);
		jokerButton.setFont(new Font("Old English Text MT", Font.PLAIN, 29));
		
		JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		exitButton.setFont(new Font("Old English Text MT", Font.PLAIN, 29));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(248)
							.addComponent(drawButton, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE)
							.addGap(218)
							.addComponent(jokerButton, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
							.addComponent(exitButton, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(172)
							.addComponent(HandViewer, GroupLayout.PREFERRED_SIZE, 936, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(31, Short.MAX_VALUE)
					.addComponent(HandViewer, GroupLayout.PREFERRED_SIZE, 440, GroupLayout.PREFERRED_SIZE)
					.addGap(87)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(drawButton, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
								.addComponent(jokerButton, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
							.addGap(37))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(exitButton, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		
		firstCard = new JLabel("");
		firstCard.setIcon(new ImageIcon(path1));
		
		secondCard = new JLabel("");
		secondCard.setIcon(new ImageIcon(path2));
		
		thirdCard = new JLabel("");
		thirdCard.setIcon(new ImageIcon(path3));
		
		fourthCard = new JLabel("");
		fourthCard.setIcon(new ImageIcon(path4));
		GroupLayout groupLayout = new GroupLayout(HandViewer.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(32)
					.addComponent(firstCard, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
					.addGap(14)
					.addComponent(secondCard, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(thirdCard, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(fourthCard, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(34, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(firstCard, GroupLayout.PREFERRED_SIZE, 413, GroupLayout.PREFERRED_SIZE)
						.addComponent(fourthCard, GroupLayout.PREFERRED_SIZE, 413, GroupLayout.PREFERRED_SIZE)
						.addComponent(thirdCard, GroupLayout.PREFERRED_SIZE, 413, GroupLayout.PREFERRED_SIZE)
						.addComponent(secondCard, GroupLayout.PREFERRED_SIZE, 413, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		HandViewer.getContentPane().setLayout(groupLayout);
		contentPane.setLayout(gl_contentPane);
		HandViewer.setVisible(true);
	}
	
	public void updateImagesPaths(LinkedList<Card> List) {
		
		this.path1=List.get(0).getImage();
		this.path2=List.get(1).getImage();
		this.path3=List.get(2).getImage();
		this.path4=List.get(3).getImage();
		
	}
	
	public void refreshFrame(JFrame frame) {
		frame.repaint();
	}
}
