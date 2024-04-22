package Game;

import java.util.Scanner;

public class GameController {

    GameController() {

    }

    public int start() {

        Scanner scanner = new Scanner(System.in);
        char choice;
        int score = 0, joker = 0;

        Pile cardPile = new Pile();
        Hand Hand = new Hand();

        for (int i = 0; i < 4; i++) {

            Hand.addCard(cardPile.cardDraw());

        }

        while (cardPile.getSize() > 0) {

            if (Hand.getHead().isHauteurEqual(Hand.getTail())) {

                Hand.allDiscarded();

                for (int i = 0; i < 4; i++) {
                    if (Hand.getHiddenCardSize() == 0) {
                        Hand.uncoverCard();
                    } else {
                        Hand.addCard(cardPile.cardDraw());
                    }
                }
                score += 5;

            } else if (Hand.getHead().isSuitEqual(Hand.getTail())) {

                Hand.twoDiscarded();

                for (int i = 0; i < 2; i++) {
                    if (Hand.getHiddenCardSize() == 0) {
                        Hand.uncoverCard();
                    } else {
                        Hand.addCard(cardPile.cardDraw());
                    }
                }

                score += 2;

            } else {
                if (joker < 3) {
                    System.out.println("Do you want to use a joker ? (Y/N)");
                    choice = scanner.next().charAt(0);
                    if (choice == 'Y' || choice == 'y') {

                        joker++;
                        Hand.twoDiscarded();

                        for (int i = 0; i < 2; i++) {
                            if (Hand.getHiddenCardSize() == 0) {
                                Hand.uncoverCard();
                            } else {
                                Hand.addCard(cardPile.cardDraw());
                            }
                        }
                    } else {

                        Hand.hideCard();
                        Hand.addCard(cardPile.cardDraw());

                    }
                }
            }
        }
        scanner.close();
        return score;

    }
}
