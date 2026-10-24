
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import javax.imageio.ImageIO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author rdbab
 */
public class BulletManager {

    private LinkedList<Bullet> bullets = new LinkedList<>();
    private BufferedImage bulletTexture;
    final private int bulletWidth = 10;
    
    

    public BulletManager() {
        InputStream bodyFile = getClass().getResourceAsStream("/Textures/bullet.png");
        try {
            bulletTexture  = ImageIO.read(bodyFile);
        } catch (IOException ex) {
            System.getLogger(BulletManager.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    public void addBullet(Bullet b) {
        bullets.add(b);
    }

    public void paintBullets(Graphics2D g2d, int screenWidth, int screenHeight) {
        int i = 0;

        //proc tu je while a ne for each???, zamysli se a bud chytry :)))
        while (i < bullets.size()) {
            Bullet b = bullets.get(i);
            b.updatePos();
            if (b.getPaintX() > screenWidth || b.getPaintX() < 0 || b.getPaintY() > screenHeight || b.getPaintY() < 0) {
                bullets.remove(b);
            } else {
                
                
                g2d.drawImage(bulletTexture, b.getPaintX(), b.getPaintY(), bulletWidth, bulletWidth, null);
                /* hitbox testing
             g2d.setColor(Color.green);
             g2d.drawRect(b.getHitboxX(), b.getHitboxY(), b.getDamage(), b.getDamage());*/
                // just a test, to be finished checkCollision(b);
            }
            i++;
        }

    }

    //finise this fumction after doind meteor
    public void checkCollision(Bullet b) {
        if (bullets.size() >= 2) {
            for (int i = bullets.indexOf(b); i < bullets.size(); i++) {
                if (b.checkColision(bullets.get(i).getHitbox())) {
                    bullets.remove(b);
                    bullets.remove(i);
                }
            }
        }

    }
}
