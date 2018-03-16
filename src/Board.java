import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Board extends JPanel implements ActionListener {


    Timer timer;
    List<Sprite> characters = new ArrayList<Sprite>();


    final int alienNum = 15;

    private boolean isBlasted = false;

    private long lastMoment, currentMoment;


    public Board(){
        setPreferredSize(new Dimension(600,800));
        setBackground(Color.BLACK);

        timer = new Timer(1000/60, this);
        timer.start();
        lastMoment = System.currentTimeMillis();

    }

    public void setup() {


        characters.add(0, new Starship(Color.ORANGE, getWidth()/2, getHeight()/2, 15));


        for (int i = 0; i < alienNum; i++) {
            characters.add(new Aliens(Color.GREEN, getWidth() / 4, getHeight() / 4, 10, 20));
        }



    }

    public void checkCollisions() {

        for (int i = 0; i < characters.size(); i++) {
            if (characters.get(i) instanceof Missle) {
                if (((Missle) characters.get(i)).isShot()) {
                    characters.remove(i);
                }
            }
        }
    }

    public void setPlayerPos(int x, int y){
        characters.get(0).setPosition(x, y);
    }

    public void shootMissle(){

        currentMoment = System.currentTimeMillis();
        if(currentMoment - lastMoment > 100) {
            characters.add((new Missle(Color.PINK, characters.get(0).x, characters.get(0).y, 5, 5)));
            lastMoment = System.currentTimeMillis();
        }

    }



    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(int i = 0; i < characters.size(); i++){
            characters.get(i).paint(g);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        checkCollisions();

        for(int i = 1; i < characters.size(); i++){
            characters.get(i).move(getHeight(), getWidth());
        }
        repaint();
    }
}
