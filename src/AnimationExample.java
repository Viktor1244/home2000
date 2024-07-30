import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnimationExample extends JPanel implements ActionListener {
    private Timer timer;
    private Sprite sprite1, sprite2;

    public AnimationExample() {
        sprite1 = new Sprite(50, 50, 2, 2);
        sprite2 = new Sprite(100, 100, -2, 2);
        timer = new Timer(10, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        sprite1.draw(g);
        sprite2.draw(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        sprite1.updatePosition(getWidth(), getHeight());
        sprite2.updatePosition(getWidth(), getHeight());
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Animation Example");
        AnimationExample animationPanel = new AnimationExample();
        frame.add(animationPanel);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    class Sprite {
        private int x, y, dx, dy;

        public Sprite(int x, int y, int dx, int dy) {
            this.x = x;
            this.y = y;
            this.dx = dx;
            this.dy = dy;
        }

        public void updatePosition(int width, int height) {
            x += dx;
            y += dy;

            if (x < 0 || x > width) {
                dx = -dx;
            }
            if (y < 0 || y > height) {
                dy = -dy;
            }
        }

        public void draw(Graphics g) {
            g.setColor(Color.RED);
            g.fillRect(x, y, 20, 20);
        }
    }
}
