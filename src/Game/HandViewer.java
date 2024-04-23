package Game;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class HandViewer extends JFrame {

    public HandViewer(List<Card> cards) {
        setTitle("Hand Cards");
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        for (Card card : cards) {
            JLabel label = new JLabel(new ImageIcon(card.getImage().getImage().getScaledInstance(200, 305, Image.SCALE_SMOOTH)));
            panel.add(label);
        }

        getContentPane().add(panel);
        pack();
        setVisible(true);
    }
}
