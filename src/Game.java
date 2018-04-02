import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;

public class Game extends JFrame {

    int dx;
    Board board;
    Sprite sprite;

    public Game() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setTitle("Galaga");
        board = new Board();
        add(board);
        pack();
        setLocationRelativeTo(null);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    board.shootMissle();
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    dx -= 5;
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    dx -= 5;
                }

            }
        });


    }
        public static void main (String[]args){

            Game game = new Game();
            game.board.setup();
        }
    }

