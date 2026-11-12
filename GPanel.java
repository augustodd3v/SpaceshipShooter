import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class GPanel extends JPanel implements ActionListener{

    private ArrayList<Bullet> bullets = new ArrayList<>();
    private Player player;
    private Timer gameTimer;

    private boolean upPressed, downPressed, leftPressed, rightPressed, xPressed;

    public GPanel(Player player) {
        this.player = player;
        this.setPreferredSize(new Dimension(600, 800));
        this.setBackground(Color.black);
        this.setFocusable(true);

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();

                if (key == KeyEvent.VK_UP) {
                    upPressed = true;
                }
                if (key == KeyEvent.VK_DOWN) {
                    downPressed = true;
                }  
                if (key == KeyEvent.VK_LEFT) {
                    leftPressed = true;
                }
                if (key == KeyEvent.VK_RIGHT) {
                    rightPressed = true;
                }
                
                if (key == KeyEvent.VK_X) {
                    xPressed = true;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                int key = e.getKeyCode();

                if (key == KeyEvent.VK_UP) {
                    upPressed = false;
                }
                if (key == KeyEvent.VK_DOWN) {
                    downPressed = false;
                }  
                if (key == KeyEvent.VK_LEFT) {
                    leftPressed = false;
                }
                if (key == KeyEvent.VK_RIGHT) {
                    rightPressed = false;
                }

                if (key == KeyEvent.VK_X) {
                    xPressed = false;
                    bullets.add(new Bullet(player.getPlayerX() + 7, player.getPlayerY(), 10));
                }
            }
        });

        gameTimer = new Timer(16, this);
        gameTimer.start();
    }

    @Override 
    public void actionPerformed(ActionEvent e) {
        if (upPressed) {
            player.moveUp();
        }
        if (downPressed) {
            player.moveDown();
        }
        if (leftPressed) {
            player.moveLeft();
        }
        if (rightPressed) {
            player.moveRight();
        }

        Iterator<Bullet> iterator = bullets.iterator();
        while (iterator.hasNext()) {
            Bullet b = iterator.next();
            b.bulletShoot();

            if (!b.isActive()) {
                iterator.remove();
            }
        }

        repaint();
    }

    @Override 
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.black);
        g.fillRect(0, 0, getWidth(), getHeight());

        if (player != null) {
            player.drawPlayer(g);
        }

        for (Bullet b : bullets) {
            b.drawBullet(g);
        }
    }
}