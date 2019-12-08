import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fenetre extends JFrame {
    public Fenetre() {
        this.setTitle("JEU SNAKE");
        this.setSize(1000, 1000);
        this.setLocationRelativeTo(null);
        JPanel pan = new JPanel();
        pan.setBackground(Color.ORANGE);
        this.setContentPane(pan);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(new Panneau());



        this.setVisible(true);

    }
}
