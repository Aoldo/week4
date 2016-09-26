package samples;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Using key events and a key listener
 * (Sadly we have an key delay, a bit technical to remove so we don't ...)
 */
public class KeyEvents extends JPanel {

    public static void main(String[] args) {
        new KeyEvents().program();
    }

    final int width = 400;
    final int height = 400;

    final Square s = new Square();

    void program() {
        initGraphics();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawString("Use arrow keys to move me", 10, 10);
        g2.fillRect((int) s.x, (int) (height - s.y), (int) s.width, (int) s.height);
    }

    // Our method to handle pressed keys
    void handleKeys(int keyCode) {
        if (keyCode == KeyEvent.VK_UP) {
            s.y++;
        } else if (keyCode == KeyEvent.VK_DOWN) {
            s.y--;
        } else if (keyCode == KeyEvent.VK_LEFT) {
            s.x--;
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            s.x++;
        }
    }

    void initGraphics() {
        setPreferredSize(new Dimension(width, height));
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.add(this);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        // Connect a key listener object to the window
        window.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                handleKeys(e.getKeyCode());
                repaint();
            }
        });
    }


    // --------- Trivial class -------------------

    class Square {
        double x = 100;
        double y = 100;
        double width = 20;
        double height = 20;
    }

}




