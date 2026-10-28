
import java.awt.Rectangle;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author rdbab
 */
public class ValueTracker {

    public double x;
    public double y;
    public int damage;
    public int health;
    public Rectangle hitbox;
    public int size;
    public int speed;
    private Player player;    
    private double xDirection;
    private double yDirection;   
    private EnemyState state;

    public ValueTracker(int x, int y, int damage, int health, int size, int speed, Player player) {
        this.x = x;
        this.y = y;
        this.damage = damage;
        this.health = health;
        this.size = size;
        this.speed = speed;
        hitbox = new Rectangle(x, y, size, size);
        this.player = player;
        setDirection();
    }

    private void updateHitbox() {
        hitbox.setLocation((int)Math.round(x)-size/2, (int)Math.round(y)-size/2);
    }

    private void setDirection() {
       double xDif = player.getX() - x;
       double yDif = player.getY() - y;
        double hypotenuse = Math.hypot(xDif, yDif);
        if (hypotenuse <=player.getTurretWidth()) {
            state = EnemyState.ATTACKING;
            xDirection = 0;
            yDirection = 0;
        } else {
            state = EnemyState.MOVING;
            
            xDirection = xDif/hypotenuse;
            yDirection = yDif/hypotenuse;
        }
        

    }

    public void doDamage(){
        if (state==EnemyState.ATTACKING) {
            player.doDamage(damage);
        }
}
    public void updatePos(int playerX, int playerY) {
        setDirection();
       x += xDirection*speed;
       y += yDirection*speed;
        
        updateHitbox();
        isAlive();
    }
    
    public boolean isAlive(){
        if (health<=0) {
            state = EnemyState.DEAD;
            return false;
        } else{
            return true;
        }
    }
    
    public int getPaintX() {
        return (int)Math.round(x)-size/2;
    }

    public int getPaintY() {
        return (int)Math.round(y)-size/2;
    }

}
