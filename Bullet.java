import java.awt.Color;
import java.awt.Graphics;

public class Bullet {
    private int bulletSpeed;
    private int bulletX;
    private int bulletY;
    private boolean active = true;


    public Bullet(int bulletX, int bulletY, int bulletSpeed) {
        this.bulletX = bulletX;
        this.bulletY = bulletY;
        this.bulletSpeed = bulletSpeed;
    }

    public void bulletShoot() {
        bulletY -= bulletSpeed;

        if (bulletY < 0) {
            active = false;
        }
    }

    public void drawBullet(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(bulletX, bulletY, 5, 5);
    }

    public boolean isActive() {
        return active;
    }
}
