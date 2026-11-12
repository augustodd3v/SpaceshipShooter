import java.awt.Color;
import java.awt.Graphics;

public class Player {
    private int hp;
    private int playerX;
    private int playerY;
    private int playerSpeed;

    public Player(int hp, int playerX, int playerY, int playerSpeed) {
        this.hp = hp;
        this.playerX = playerX;
        this.playerY = playerY;
        this.playerSpeed = playerSpeed;
    }

    public void drawPlayer(Graphics g) {
        g.setColor(Color.yellow);
        g.fillRect(playerX, playerY, 20, 20);
    }

    public void moveUp() {
        playerY -= playerSpeed;
        windowLimit();
    }

    public void moveDown() {
        playerY += playerSpeed;
        windowLimit();
    }

    public void moveLeft() {
        playerX -= playerSpeed;
        windowLimit();
    }

    public void moveRight() {
        playerX += playerSpeed;
        windowLimit();
    }

    private void windowLimit() {
        if (playerX <= 0) {
            playerX = 0;
        }

        if (playerX >= 600 - 20) {
            playerX = 600 - 20;
        }

        if (playerY <= 0) {
            playerY = 0;
        }

        if (playerY >= 800 - 20) {
            playerY = 800 - 20;
        }
    }

    public int getPlayerX() {
        return playerX;
    }

    public int getPlayerY() {
        return playerY;
    }
}