import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class Fenetre extends JFrame implements KeyListener { // Constructeur et implémentation de boutons sonores
    JPanel container = new JPanel();
    public static int LargeurFen = 800;
    public static int HauteurFen = 600;
    Serpent anaconda;

    JLabel gameOver = new JLabel();

    public Fenetre() {
        this.setTitle("Snake");
        this.setSize(LargeurFen, HauteurFen);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        container.setBackground(Color.BLACK);

        gameOver.setBounds((LargeurFen/2)-40, 0, 100, 20);

        this.addKeyListener(this);

        this.setContentPane(container);
        this.setVisible(true);

        anaconda = new Serpent(this.getGraphics(), 4);
    }

        public void startGame() {
        anaconda.jouer();
        gameOver();
        }

        public void gameOver() {
        gameOver.setText("Game Over!");
        container.add(gameOver);
        container.repaint();
        }

public void keyPressed(KeyEvent arg0) {
    if(arg0.getKeyCode() == KeyEvent.VK_UP && anaconda.direction != 3)
        anaconda.direction = 1;
    if(arg0.getKeyCode() == KeyEvent.VK_RIGHT && anaconda.direction != 4)
        anaconda.direction = 2;
    if(arg0.getKeyCode() == KeyEvent.VK_DOWN && anaconda.direction != 1)
        anaconda.direction = 3;
    if(arg0.getKeyCode() == KeyEvent.VK_LEFT && anaconda.direction != 2)
        anaconda.direction = 4;
    }

public void keyReleased(KeyEvent arg0) {

        }
public void keyTyped(KeyEvent arg0) {

        }
}