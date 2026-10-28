
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
    private double x;
    private double y;
    private double xDir;
    private double yDir;
   
    private double speed;
    private int damage;
    private Rectangle hitbox;

    public Bullet(int x, int y, int endX,int endY, double speed, int damage) {
        this.x = x;
        this.y = y;
        
        double xDif = endX-(double)x;
        double yDif = endY-(double)y;
        double hypotenuse = Math.hypot(xDif, yDif);
        
        if (hypotenuse == 0.0) {
            xDir = 0.0;
            yDir = 0.0;
        } else {
            xDir = xDif / hypotenuse;
            yDir = yDif / hypotenuse;
        }
        this.speed = speed;
        this.damage = damage;
        hitbox = new Rectangle(x-damage/2,y-damage/2,damage,damage);
    }

    public int getPaintX() {
        return (int)Math.round(x)-damage/2;
    }

    public int getPaintY() {
        return (int)Math.round(y)-damage/2;
    }

    public int getDamage() {
        return damage;
    }
    public void updatePos(){
        x += xDir * speed;
        y +=  yDir * speed;
        hitbox.setLocation((int)Math.round(x)-damage/2, (int)Math.round(y)-damage/2);
       
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
