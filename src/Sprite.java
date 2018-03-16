import java.awt.*;

public class Sprite implements Move, Paint {

    Board board;
    Color color;
    int x, y, width, height;

    double dx, dy;

    final int SPEED = 10;

    public Sprite(Color color, int x, int y, int width, int height){

        this.color = color;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        while(dx < 1 || dy < 1){
            double angle = Math.PI * Math.random();
            double speed = 1 + SPEED;
            dx = Math.cos(angle);
            dy = Math.sin(angle);
        }
    }


    @Override
    public void move(int boardHeight, int boardWidth) {

    }

    @Override
    public Rectangle getBounds() {
        return null;
    }

    @Override
    public void paint(Graphics g) {

    }

    @Override
    public void setPosition(int x, int y) {

    }
}
