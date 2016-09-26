package assignments.uber.breakout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

/*
 * Basic Break Out Game
 * See https://en.wikipedia.org/wiki/Breakout_(video_game)
 *
 * For a live (similar) version (using JavScript) see
 * https://developer.mozilla.org/en-US/docs/Games/Tutorials/2D_breakout_game_Phaser/Randomizing_gameplay
 * (click "result" above code sample to run game)
 * NOTE: We use arrow keys to move the paddle *NOT* the mouse.
 * (there is a key-delay in Java, we have to live with it, or you fix it, optional)
 *
 *
 * NOTE: Issues with collisions (multiple strange bouncing) is acceptable.
 *
 *  Have fun: Add features to enhance the game experience!
 *
 *  Plan and Process: Compare CatchTheRain from exercises
 */
public class Breakout extends JPanel {

    public static void main(String[] args) {
        new Breakout().program();
    }

    final int width = 500;
    final int height = 500;
    final Random rand = new Random();
    final Paddle paddle = null; // TODO
    final Brick[] bricks = new Brick[6];
    Ball ball;

    void program() {
        for (int i = 0; i < bricks.length; i++) {
            bricks[i] = null; // TODO
        }
        ball = newBall();
        initGraphics();
        initEvents();
    }

    // -------- Game logic ----------------------------

    void updateWorld() {
        // TODO
        // Move the ball, check collisions and act ...
    }

    // Create boolean methods for different types of collisions
    // Possibly use the Rectangle class from Java to detect collisions
    // (method intersect)
    // TODO

    void handleKeys(int keyCode) {
        if (keyCode == KeyEvent.VK_LEFT) {
            // TODO
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            // TODO
        }
    }

    // ------ Utilities --------------------

    Ball newBall() {
        // TODO
        return null;
    }

    // Convert logical bounding box too screen coordinates bounding box
    Rectangle flipBoundingBox(Rectangle r) {
        r.y = height - r.y;
        return r;
    }

    //----- Classes --------------------------------

    class Brick {

    }

    class Ball {

    }

    class Paddle {

    }

    // ----- Nothing to do below, it's just initialization and graphics ----------------------

    final int delay = 10;

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        drawBall(g2, ball);
        drawPaddle(g2, paddle);
        drawBricks(g2, bricks);
        Toolkit.getDefaultToolkit().sync();
    }

    void drawBricks(Graphics2D g2, Brick[] bricks) {
        for (int i = 0; i < bricks.length; i++) {
            if (bricks[i] != null) {
                drawBrick(g2, bricks[i]);
            }
        }
    }

    void drawBall(Graphics2D g2, Ball ball) {
        Color old = g2.getColor();
        // TODO g2.setColor(...);
        // TODO g2.fillOval(...);

        g2.setColor(old);
    }

    void drawPaddle(Graphics2D g2, Paddle p) {
        // TODO drawRect(...);

    }

    void drawBrick(Graphics2D g2, Brick b) {
        // TODO drawRect(...);

    }

    void drawRect(Graphics2D g2, double x, double y, double width, double height, Color color) {
        Color old = g2.getColor();
        g2.setColor(color);
        g2.fillRect((int) x, (int) y, (int) width, (int) height);
        g2.setColor(old);
    }

    void drawBoundingBox(Graphics2D g2, Rectangle r) {
        Color old = g2.getColor();
        g2.setColor(Color.BLACK);
        g2.drawRect(r.x, height - r.y, r.width, r.height);
        g2.setColor(old);
    }

    void initGraphics() {
        setPreferredSize(new Dimension(width, height));
        JFrame window = new JFrame();
        window.setTitle("Breakout");
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
