package Game;
import java.awt.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;

public class GameInterface extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    String path1, path2, path3, path4;
    GameController GameControl = new GameController();
    private JButton jokerButton;
    private boolean joker;
    private JLabel firstCard, secondCard, thirdCard, fourthCard, scoreLabel_1, jokerLabel_1;

    int scoreKeeper = 0, nbrJoker = 3;
    private JTextField txtAnalyse, textAction;

    public GameInterface() {
    	 setIconImage(Toolkit.getDefaultToolkit().getImage("src\\Cards\\1.png"));
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setExtendedState(JFrame.MAXIMIZED_BOTH);
         contentPane = new JPanel() {
             @Override
             protected void paintComponent(Graphics g) {
                 super.paintComponent(g);
                 // Charger l'image de fond
                 Image img = Toolkit.getDefaultToolkit().getImage("src\\Game\\gameFond.PNG");
                 // Dessiner l'image de fond
                 g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
             }
         };
         contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
         setContentPane(contentPane);

        JInternalFrame HandViewer = new JInternalFrame("Hand");
        HandViewer.setBounds(177, 36, 936, 492);
        HandViewer.setBorder(null);
        HandViewer.getContentPane().setBackground(new Color(0, 128, 64));
        
        
        
        JButton drawButton = new JButton("Draw cards", new ImageIcon("src\\Game\\gameFond.PNG"));
        drawButton.setVerticalTextPosition(SwingConstants.CENTER);
        drawButton.setHorizontalTextPosition(SwingConstants.CENTER);
        drawButton.setBounds(252, 546, 248, 95);
        drawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (GameControl.cardPile.getSize() > 0) {
                    Update(GameControl.Hand, scoreKeeper, nbrJoker);
                    txtAnalyse.setText("");
                    textAction.setText("");

                    switch (GameControl.testHand()) {
                        case 1:
                            GameControl.firstCaseHand();
                            setTextLabel(GameControl);
                            break;
                        case 2:
                            GameControl.secondCaseHand();
                            setTextLabel(GameControl);
                            break;
                        case 3:
                            if (joker) {

                                GameControl.fourthCaseHand();
                                GameInterface.this.jokerButton.setEnabled(false);

                                setTextLabel(GameControl);
                                joker = false;

                            } else {
                                joker = true;
                                if (GameControl.joker < 3) {
                                    GameInterface.this.jokerButton.setEnabled(true);
                                    txtAnalyse.setText("You can use a joker");
                                    textAction.setText("2 cards will be discarded");

                                } else {
                                    GameControl.fourthCaseHand();
                                    joker = false;

                                    setTextLabel(GameControl);
                                }
                            }
                            break;
                        case 4:
                            GameControl.fourthCaseHand();

                            setTextLabel(GameControl);
                            break;
                        default:

                    }

                    scoreKeeper = GameControl.getScore();
                    nbrJoker = 3 - GameControl.getJoker();
                    Update(GameControl.Hand, scoreKeeper, nbrJoker);

                } else {

                    String message = "Votre score final : " + String.valueOf(GameControl.getScore()) + ".";
                    showNotificationWithButton(message);

                }

            }

            public void showNotificationWithButton(String message) {
                // Créer un tableau d'objets pour les options de bouton
                Object[] options = {"Exit", "Restart"};

                // Afficher une boîte de dialogue avec un bouton de validation personnalisé
                int choice = JOptionPane.showOptionDialog(null, message, "Notification",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                        null, options, options[0]);

                // Traiter la réponse de l'utilisateur
                if (choice == 0) {
                    dispose();
                } else {

                    dispose();
                    GameInterface sinterface = new GameInterface();
                    sinterface.setVisible(true);
                }
            }
        });
        drawButton.setFont(new Font("Old English Text MT", Font.PLAIN, 29));

        jokerButton = new JButton("Joker", new ImageIcon("src\\Game\\gameFond.PNG"));
        jokerButton.setBounds(734, 546, 248, 95);
        jokerButton.setVerticalTextPosition(SwingConstants.CENTER);
        jokerButton.setHorizontalTextPosition(SwingConstants.CENTER);
        jokerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                joker = false;
                GameControl.thirdCaseHand();

                scoreKeeper = GameControl.getScore();
                nbrJoker = 3 - GameControl.getJoker();
                Update(GameControl.Hand, scoreKeeper, nbrJoker);

                txtAnalyse.setText("You used a joker");
                textAction.setText("2 cards had been discarded");
                GameInterface.this.jokerButton.setEnabled(false);

                drawButton.setEnabled(false);

                ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
                executor.schedule(() -> {
                    drawButton.setEnabled(true);
                    setTextLabel(GameControl);
                    executor.shutdown();
                }, 1, TimeUnit.SECONDS);

            }
        });
        jokerButton.setEnabled(false);
        jokerButton.setFont(new Font("Old English Text MT", Font.PLAIN, 29));

        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(1150, 580, 100, 54);
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        exitButton.setFont(new Font("Old English Text MT", Font.PLAIN, 29));

        txtAnalyse = new JTextField();
        txtAnalyse.setEditable(false);
        txtAnalyse.setBounds(570, 567, 120, 23);
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
                groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
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
                groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(firstCard, GroupLayout.PREFERRED_SIZE, 413, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(secondCard, GroupLayout.PREFERRED_SIZE, 413, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(thirdCard, GroupLayout.PREFERRED_SIZE, 413, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fourthCard, GroupLayout.PREFERRED_SIZE, 413, GroupLayout.PREFERRED_SIZE))
                                .addGap(6)
                                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
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

        JButton restartButton = new JButton("Restart");
        restartButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                dispose();
                GameInterface sinterface = new GameInterface();
                sinterface.setVisible(true);
            }
        });
        restartButton.setFont(new Font("Old English Text MT", Font.PLAIN, 29));
        restartButton.setBounds(1135, 500, 140, 54);
        contentPane.add(restartButton);
        HandViewer.setVisible(true);
    }

    public void Update(Hand hand, int score, int joker) {
        path1 = hand.getCard(0).getImage();
        path2 = hand.getCard(1).getImage();
        path3 = hand.getCard(2).getImage();
        path4 = hand.getCard(3).getImage();

        firstCard.setIcon(new ImageIcon(path1));
        secondCard.setIcon(new ImageIcon(path2));
        thirdCard.setIcon(new ImageIcon(path3));
        fourthCard.setIcon(new ImageIcon(path4));

        scoreLabel_1.setText(String.valueOf(score));
        jokerLabel_1.setText(String.valueOf(joker));

    }

    public void setTextLabel(GameController GC) {
        GameController temp = new GameController(GC);

        switch (GC.testHand()) {
            case 1:
                txtAnalyse.setText("Same number");
                textAction.setText("All cards will be discarded");
                break;
            case 2:
                txtAnalyse.setText("Same suit");
                textAction.setText("2 cards will be discarded");
                break;
            case 3:
                if (joker) {
                    temp.fourthCaseHand();
                    setTextLabel(temp);

                } else {

                    if (GameControl.joker > 3) {

                        txtAnalyse.setText("No combination");
                        textAction.setText("1 card added and 1 covered");
                    } else {
                        txtAnalyse.setText("If you don't use joker");
                        textAction.setText("1 card added and 1 covered");
                    }
                }
                break;
            case 4:

                txtAnalyse.setText("No combination");
                textAction.setText("1 card added and 1 covered");
                break;
            default:

        }
    }


}
