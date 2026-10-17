
import java.awt.Rectangle;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author xdosek1
 */
public class Bullet {
    private int x;
    private int y;
    
    private double direction;
    private double speed;
    private int damage;
    private Rectangle hitbox;

    public Bullet(int x, int y, double direction, double speed, int damage) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.speed = speed;
        this.damage = damage;
        hitbox = new Rectangle(x-damage/2,y-damage/2,damage,damage);
    }

    public int getPaintX() {
        return x-damage/2;
    }

    public int getPaintY() {
        return y-damage/2;
    }

    public int getDamage() {
        return damage;
    }
    public void updatePos(){
        x = (int)(x+speed*Math.cos(direction));
        y = (int)(y+speed*Math.sin(direction));
        hitbox.x = x-damage/2;
        hitbox.y = y-damage/2;
    }
    
    public int getHitboxX (){
        return hitbox.x;
    }
    
    public int getHitboxY (){
        return hitbox.y;
    }
    
    public boolean checkColision(Rectangle rect){
        return hitbox.intersects(rect);
    }

    public Rectangle getHitbox() {
        return hitbox;
    }
    
}
