import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Rond extends JPanel {
    private int posX = -50;
    private int posY = -50;

    public void paintComponent(Graphics g) {
        g.setColor(Color.red);
        g.fillOval(posX, posY, 20, 20);
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY){
        this.posY = posY;
    }
}