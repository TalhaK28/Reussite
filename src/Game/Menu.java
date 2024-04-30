package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Menu extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Create the frame.
     */
    public Menu() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage("\\src\\Cards\\1.png"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1324, 754);

        // Background Image
        ImageIcon backgroundImg = new ImageIcon("src\\Game\\backgroundLP2A_1.png"); 
        contentPane = new JPanel() {
            @Override
            protected void paintComponent(java.awt.Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImg.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        setContentPane(contentPane);

        
        
        
        
        // Title label
        JLabel titleLabel = new JLabel("Réussite");
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setFont(new Font("Old English Text MT", Font.PLAIN, 51));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Start button
        JButton startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              
               
                // Dispose the main window
            	disposeWithoutExiting();
            	GameInterface frame = new GameInterface();
            	frame.setVisible(true);
            }
        });
        startButton.setFont(new Font("Arial", Font.BOLD, 16));

        // Produced by label
        JLabel producedByLabel = new JLabel("Produced by Samuel, Ilyas and Talha");
        producedByLabel.setFont(new Font("Arial", Font.BOLD, 12));
        producedByLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Exit button
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               dispose();
            }
        });
        exitButton.setFont(new Font("Arial", Font.BOLD, 16));

        // Layout
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
            gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(gl_contentPane.createSequentialGroup()
                .addGap(107)
                .addComponent(producedByLabel, GroupLayout.DEFAULT_SIZE, 1061, Short.MAX_VALUE)
                .addGap(115))
            .addGroup(gl_contentPane.createSequentialGroup()
                .addContainerGap(500, Short.MAX_VALUE)
                .addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE)
                .addGap(498))
            .addGroup(gl_contentPane.createSequentialGroup()
                .addContainerGap(458, Short.MAX_VALUE)
                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(exitButton, GroupLayout.PREFERRED_SIZE, 369, GroupLayout.PREFERRED_SIZE)
                    .addComponent(startButton, GroupLayout.PREFERRED_SIZE, 369, GroupLayout.PREFERRED_SIZE))
                .addGap(456))
        );
        gl_contentPane.setVerticalGroup(
            gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(gl_contentPane.createSequentialGroup()
                .addGap(46)
                .addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                .addGap(159)
                .addComponent(startButton, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
                .addGap(28)
                .addComponent(exitButton, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
                .addGap(104)
                .addComponent(producedByLabel)
                .addGap(159))
        );
        contentPane.setLayout(gl_contentPane);
    }


    public void disposeWithoutExiting(){
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            dispose();
        }
}
