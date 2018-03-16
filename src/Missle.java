import java.awt.*;

public class Missle extends Sprite {

    private boolean isShot;

    public Missle(Color color, int x, int y, int width, int height){
        super(color, x, y, width, height);
        isShot = false;
    }

    @Override
    public void move(int boardHeight, int boardWidth){
        if(x < 0 || x > boardWidth){
            isShot = true;
        }
        if(y < 0 || y > boardHeight){
            isShot = true;
        }
    }

    @Override
    public void paint(Graphics g){
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }

    public boolean isShot(){
        return isShot;
    }
}
