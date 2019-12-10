import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;

public class Panneau extends JPanel {
    public void paintComponent(Graphics g) {
        int x1 = this.getWidth() / 2;
        int y1 = this.getHeight() /  2;
        System.out.println("la fenêtre s'éxécute !");
        g.fillOval(x1, y1, this.getWidth() / 60, this.getHeight() / 60);

        Font font = new Font("Courier", Font.BOLD, 20);
        g.setFont(font);
        g.setColor(Color.red);
        g.drawString("Jeu SNAKE !", 450, 50);
    }
}