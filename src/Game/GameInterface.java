package Game;


import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.DropMode;

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
	private JLabel scoreLabel_1;
	private JLabel jokerLabel_1;
	
	int scoreKeeper=0, nbrJoker=3;
	private JTextField txtAnalyse;
	private JTextField textAction;
	
	public void refreshFrame() {
        getContentPane().repaint();
    }
	
	public void refreshInternalFrame(JInternalFrame frame) {
	    frame.repaint();
	}

	
	
	public GameInterface() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\talha\\eclipse-workspace\\Reussite\\src\\Cards\\1.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1331, 746);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JInternalFrame HandViewer = new JInternalFrame("Hand");
		HandViewer.setBounds(177, 36, 936, 492);
		HandViewer.setBorder(null);
		
		JButton drawButton = new JButton("Draw cards");
		drawButton.setBounds(252, 546, 248, 95);
		drawButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(GameControl.cardPile.getSize()>0) {
				txtAnalyse.setText("");
				textAction.setText("");
			
				switch (GameControl.testHand()) {
				    case 1:
				    	GameControl.firstCaseHand();
				    	txtAnalyse.setText("Same number");
				    	textAction.setText("All cards had been discarded");
				        break;
				    case 2:
				        GameControl.secondCaseHand();
				        txtAnalyse.setText("Same suit");
				        textAction.setText("2 cards had been discarded");
				        break;
				    case 3:
				    	if(joker) {
				    		
				    		GameControl.fourthCaseHand();
				    		GameInterface.this.jokerButton.setEnabled(false);
				    		joker=false;
				    		txtAnalyse.setText("You didn't use joker");
					        textAction.setText("1 card added and 1 covered");
				    		
				    	}else {
				    		joker=true;
				    		if(GameControl.joker<3) {
				    			GameInterface.this.jokerButton.setEnabled(true);
				    			txtAnalyse.setText("You can use a joker");
						        textAction.setText("2 cards will be discarded");
				    			
				    		}else {
				    			GameControl.fourthCaseHand();
				    			joker=false;
				    			txtAnalyse.setText("No combination");
						        textAction.setText("1 card added and 1 covered");
				    		}
				    	}
				        break;
				    case 4:
				        GameControl.fourthCaseHand();
				        txtAnalyse.setText("No combination");
				        textAction.setText("1 card added and 1 covered");
				        break;
				    default:
				        
				}

				scoreKeeper=GameControl.getScore();
				nbrJoker=3-GameControl.getJoker();
				this.Update(GameControl.Hand, scoreKeeper, nbrJoker);
				
				refreshFrame();
				refreshInternalFrame(HandViewer);
				
				}else {
					
					String message="Votre score final : "+String.valueOf(GameControl.getScore())+".";
					showNotificationWithButton( message);
					
				}

			}

			public void Update(Hand hand, int score, int joker) {
				path1=hand.getCard(0).getImage();
				path2=hand.getCard(1).getImage();
				path3=hand.getCard(2).getImage();
				path4=hand.getCard(3).getImage();
				
				firstCard.setIcon(new ImageIcon(path1));
			    secondCard.setIcon(new ImageIcon(path2));
			    thirdCard.setIcon(new ImageIcon(path3));
			    fourthCard.setIcon(new ImageIcon(path4));
			    
			    scoreLabel_1.setText(String.valueOf(score));
			    jokerLabel_1.setText(String.valueOf(joker));
			    
			}
		
			public  void showNotificationWithButton(String message) {
		        // Créer un tableau d'objets pour les options de bouton
		        Object[] options = { "OK" };

		        // Afficher une boîte de dialogue avec un bouton de validation personnalisé
		        int choice = JOptionPane.showOptionDialog(null, message, "Notification",
		                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
		                null, options, options[0]);

		        // Traiter la réponse de l'utilisateur
		        if (choice == JOptionPane.OK_OPTION) {
		            dispose();
		        }
		    }
		});
		drawButton.setFont(new Font("Old English Text MT", Font.PLAIN, 29));
		
		jokerButton = new JButton("Joker");
		jokerButton.setBounds(734, 546, 248, 95);
		jokerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				joker=false;
				GameControl.thirdCaseHand();
				
				scoreKeeper=GameControl.getScore();
				nbrJoker=3-GameControl.getJoker();
				this.Update(GameControl.Hand, scoreKeeper, nbrJoker);
				
				txtAnalyse.setText("You used a joker");
		        textAction.setText("2 cards had been discarded");
				refreshInternalFrame(HandViewer);
				GameInterface.this.jokerButton.setEnabled(false);
			}
			
			public void Update(Hand hand, int score, int joker) {
				path1=hand.getCard(0).getImage();
				path2=hand.getCard(1).getImage();
				path3=hand.getCard(2).getImage();
				path4=hand.getCard(3).getImage();
				
				firstCard.setIcon(new ImageIcon(path1));
			    secondCard.setIcon(new ImageIcon(path2));
			    thirdCard.setIcon(new ImageIcon(path3));
			    fourthCard.setIcon(new ImageIcon(path4));
			    
			    scoreLabel_1.setText(String.valueOf(score));
			    jokerLabel_1.setText(String.valueOf(joker));
			}
			
		});
		jokerButton.setEnabled(false);
		jokerButton.setFont(new Font("Old English Text MT", Font.PLAIN, 29));
		
		JButton exitButton = new JButton("Exit");
		exitButton.setBounds(1072, 567, 173, 54);
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		exitButton.setFont(new Font("Old English Text MT", Font.PLAIN, 29));
		
		txtAnalyse = new JTextField();
		txtAnalyse.setEditable(false);
		txtAnalyse.setBounds(557, 567, 96, 23);
		txtAnalyse.setText("");
		txtAnalyse.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 15));
		txtAnalyse.setColumns(10);
		
		textAction = new JTextField();
		textAction.setEditable(false);
		textAction.setBounds(557, 608, 150, 23);
		textAction.setText("");
		textAction.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 15));
		textAction.setColumns(25);
		contentPane.setLayout(null);
		
		firstCard = new JLabel("");
		firstCard.setIcon(new ImageIcon(path1));
		
		secondCard = new JLabel("");
		secondCard.setIcon(new ImageIcon(path2));
		
		thirdCard = new JLabel("");
		thirdCard.setIcon(new ImageIcon(path3));
		
		fourthCard = new JLabel("");
		fourthCard.setIcon(new ImageIcon(path4));
		
		JLabel scoreLabel = new JLabel("Score :");
		scoreLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 31));
		
		JLabel jokerLabel = new JLabel("Joker :");
		jokerLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 32));
		
		scoreLabel_1 = new JLabel((String.valueOf(scoreKeeper)));
		scoreLabel_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 31));
		
		jokerLabel_1 = new JLabel(String.valueOf(nbrJoker));
		jokerLabel_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 31));
		GroupLayout groupLayout = new GroupLayout(HandViewer.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(32)
					.addComponent(firstCard, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
					.addGap(14)
					.addComponent(secondCard, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(thirdCard, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(fourthCard, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(153)
					.addComponent(scoreLabel, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(scoreLabel_1, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addGap(263)
					.addComponent(jokerLabel, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(jokerLabel_1, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(firstCard, GroupLayout.PREFERRED_SIZE, 413, GroupLayout.PREFERRED_SIZE)
						.addComponent(secondCard, GroupLayout.PREFERRED_SIZE, 413, GroupLayout.PREFERRED_SIZE)
						.addComponent(thirdCard, GroupLayout.PREFERRED_SIZE, 413, GroupLayout.PREFERRED_SIZE)
						.addComponent(fourthCard, GroupLayout.PREFERRED_SIZE, 413, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scoreLabel, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addComponent(scoreLabel_1, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addComponent(jokerLabel, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addComponent(jokerLabel_1, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)))
		);
		HandViewer.getContentPane().setLayout(groupLayout);
		contentPane.add(HandViewer);
		contentPane.add(drawButton);
		contentPane.add(txtAnalyse);
		contentPane.add(textAction);
		contentPane.add(jokerButton);
		contentPane.add(exitButton);
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
