import java.awt.*;

public class Starship extends Sprite {

    public Starship(Color color, int x, int y, int diameter){

        super(color, x, y, diameter, diameter);
    }

    @Override
    public void paint(Graphics g){

        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
}
