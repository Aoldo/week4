package samples;

import javax.swing.*;
import java.awt.*;

import java.util.Random;

/**
 * Basic animation (bit crude not so smooth ... but simple )
 * Created by hajo
 */
public class Animation extends JPanel {

    public static void main(String[] args) {
        new Animation().program();
    }

    final int width = 400;
    final int height = 400;
    final Random rand = new Random();
    MovingBlock block;

    void program() {
        // Create first block
        block = createMovingBlock();
        block.setVelocity(rand.nextDouble(), rand.nextDouble());
        initGraphics();
        initEvents();
    }

    void updateWorld() {
        if (isInsideWorld()) {
            block.move();
        } else {
            block = createMovingBlock();
            block.setVelocity(rand.nextDouble() * 3, rand.nextDouble() * 3);
        }
    }

    boolean isInsideWorld() {
        return 0 < block.x && block.x < width
                && 0 < block.y && block.y + block.height < height;
    }

    // Utility
    MovingBlock createMovingBlock() {
        return new MovingBlock(rand.nextInt(width / 2), rand.nextInt(height / 2),
                rand.nextInt(100) + 20, rand.nextInt(100) + 20, 5, new Color(rand.nextInt(255),
                rand.nextInt(255), rand.nextInt(255)));
    }

    // ---------- Class for moving blocks ----------------

    class MovingBlock {
        final Color color;
        final double maxSpeed;
        double[] vel = {0, 0};  // Velocity, dx, dy
        double x;     // Top
        double y;     // Left
        double width;
        double height;

        MovingBlock(double x, double y, double width, double height, double maxSpeed, Color color) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
            this.maxSpeed = maxSpeed;
            this.color = color;
        }

        // Assume user normalize and < maxSpeed
        void setVelocity(double dx, double dy) {
            vel[0] = dx;
            vel[1] = dy;
        }

        // Move using velocity
        void move() {
            x += maxSpeed * vel[0];     // x = x + vel[0];
            y += maxSpeed * vel[1];
        }
    }

    // -----Below is just initialization and graphics ----------------------

    final int delay = 30;   // Update freq for animation milli sec

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        drawBlock(g2, block);
        Toolkit.getDefaultToolkit().sync();  // Technical stuff don't bother
    }

    void drawBlock(Graphics2D g2, MovingBlock b) {
        int x = (int) b.x;
        int y = (int) b.y;
        int w = (int) b.width;
        int h = (int) b.height;
        Color old = g2.getColor();
        g2.setColor(b.color);
        g2.drawRect(x, height - y, w, h);
        g2.setColor(old);
    }

    void initGraphics() {
        setPreferredSize(new Dimension(width, height));
        JFrame window = new JFrame();
        window.setTitle("Animation");
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.add(this);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    void initEvents() {
        Timer timer = new Timer(delay, e -> {
            updateWorld();
            repaint();
        });
        timer.start();
    }
}




