
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author xdosek1
 */
public class Player {

    private int x; //turret x pos
    private int y; //turret y pos
    private int headLenght; //the length of the shooting head
    private int headX; //head x pos
    private int headY; //head x pos
    private int turretWidth; //the width of the drawn circle of the turret body
    private int baseHeadX;
    private int baseHeadY;
    private double angle;
    private BufferedImage bodyTexture;
    private BufferedImage headTexture;
    private int health;

    public Player(int x, int y, int turretHeadLenght, int turretWidth,int health) throws IOException {
        this.x = x;
        this.y = y;
        this.headLenght = turretHeadLenght;
        this.turretWidth = turretWidth;
        baseHeadX = x;
        baseHeadY = y + turretHeadLenght;

        InputStream bodyFile = getClass().getResourceAsStream("/Textures/player.png");
        bodyTexture = ImageIO.read(bodyFile);
        InputStream headFile = getClass().getResourceAsStream("/Textures/playerHead.png");

        headTexture = ImageIO.read(headFile);
    }

    public void setHeadCords(int mouseX, int mouseY) {
        setAngle(mouseX, mouseY);
        Pair rotatedPoint = turnPoint(this.angle, baseHeadX, baseHeadY);
        headX = rotatedPoint.getX();
        headY = rotatedPoint.getY();
    }

    //turns the point with X,Y cords by "angle" radians
    private Pair turnPoint(double angle, int baseX, int baseY) {
        Pair rotatedPoint = new Pair();

        int x = (int) (this.x + headLenght * Math.cos(angle));
        int y = (int) (this.y + headLenght * Math.sin(angle));
        rotatedPoint.setX(x);
        rotatedPoint.setY(y);
        return rotatedPoint;
    }

    //returns angle in radians based off arctangens between start angle 0 (UP)
    private void setAngle(int mouseX, int mouseY) {
        double x = mouseX - this.x;
        double y = mouseY - this.y;

        double angle = Math.atan2(y, x);
        this.angle = angle;
    }

    public Bullet shoot(int targetX, int targetY) {
        int x = headX;
        int y = headY;
        double angle = this.angle;

        Bullet b = new Bullet(x, y, targetX, targetY, 1, 10);
        return b;
    }

    public int getPaintX() {
        return x - turretWidth / 2;
    }

    public int getPaintY() {
        return y - turretWidth / 2;
    }

    public BufferedImage getBodyTexture() {
        return bodyTexture;
    }

    public BufferedImage getHeadTexture() {
        return headTexture;
    }

    public int getHeadX() {
        return headX;
    }

    public void setHeadX(int headX) {
        this.headX = headX;
    }

    public int getHeadY() {
        return headY;
    }

    public void setHeadY(int headY) {
        this.headY = headY;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getTurretWidth() {
        return turretWidth;
    }

    public int getTurretHeadLenght() {
        return headLenght;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
    
    public void addHealth(int health) {
        this.health += health;
    }
    
    public void doDamage(int damage) {
        this.health -= damage;
    }
    
    

    public void updatePos(int x, int y, int mouseX, int mouseY) {
        this.x = x;
        this.y = y;
        setHeadCords(mouseX, mouseY);
    }
    
    public void updatePos(int x, int y) {
        this.x = x;
        this.y = y;
        
    }

    public void paintPlayer(Graphics2D g2d) {
        g2d.setColor(Color.gray);
        //kreslime hrace
        g2d.drawImage(getBodyTexture(), getPaintX(), getPaintY(), getTurretWidth(), getTurretWidth(), null);
        //kreslime hlavici
        g2d.drawImage(getHeadTexture(), getHeadX() - getTurretWidth() / 10, getHeadY() - getTurretWidth() / 10, getTurretWidth() / 5, getTurretWidth() / 5, null);
    }
}
