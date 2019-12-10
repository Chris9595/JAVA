import java.awt.Dimension;
import javax.swing.JFrame;

public class Window extends JFrame {
    private Rond ro = new Rond();

    public Window() {
        this.setTitle("Animation");
        this.setSize(1000, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setContentPane(ro);
        this.setVisible(true);
        go();
    }

    private void go() {
        for(int i = -50; i < ro.getWidth(); i++) {
            int x = ro.getPosX(), y = ro.getPosY();
            x++;
            y++;
            ro.setPosX(x);
            ro.setPosY(y);
            ro.repaint();
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}