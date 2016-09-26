package exercises;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import static java.lang.System.*;

/**
 * Catching raindrops in bucket (possibly a game?)
 */
public class CatchTheRain extends JPanel {

    public static void main(String[] args) {
        new CatchTheRain().program();
    }

    final int width = 500;
    final int height = 500;

    final Random rand = new Random();
    final Bucket bucket = null; // TODO
    final RainDrop[] drops = null; // TODO

    void program() {
        // Testing

        /*for (int i = 0; i < drops.length; i++) {
            drops[i] = createRainDrop();
        }*/
        initGraphics();
        initEvents();
    }

    // ---- Game logic ---------

    void updateWorld() {
        // TODO
    }



    void handleKeys(int keyCode) {
        if (keyCode == KeyEvent.VK_LEFT) {
           // TODO
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            // TODO
        }
    }

    // -- Utilities -----------------------

    RainDrop createRainDrop() {
        // TODO
        return null;
    }

    // Convert logical bounding box too screen coordinates
    Rectangle flipBoundingBox(Rectangle r) {
        r.y = height - r.y;
        return r;
    }
    //----- Classes --------------------------------

    class RainDrop {



    }

    class Bucket {



    }

    // ---- Below is just initialization and graphics (i.e. no program logic) ------------
    final int delay = 20;

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        drawBucket(g2, bucket);
        drawRainDrops(g2, drops);
        Toolkit.getDefaultToolkit().sync();
    }

    // Draw all drops
    void drawRainDrops(Graphics2D g2, RainDrop[] drops) {
        for (int i = 0; i < drops.length; i++) {
            if (drops[i] != null) {
                drawRainDrop(g2, drops[i]);
            }
        }
    }

    void drawBucket(Graphics2D g2, Bucket b) {
        Color old = g2.getColor();
        // TODO g2.setColor(...);
        // TODO g2.fillRect(...);
        g2.setColor(old);
    }

    // A single drop
    void drawRainDrop(Graphics2D g2, RainDrop d) {
        Color old = g2.getColor();
        // TODO g2.setColor(...);
        //TODO g2.fillOval(...);
        g2.setColor(old);
    }

    void initGraphics() {
        setPreferredSize(new Dimension(width, height));
        JFrame window = new JFrame();
        window.setTitle("Catch the Rain");
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.add(this);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                handleKeys(e.getKeyCode());
            }
        });
    }

    void initEvents() {
        Timer timer = new Timer(delay, e -> {
            updateWorld();
            repaint();
        });
        timer.start();
    }
}
