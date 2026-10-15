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

    public Bullet(int x, int y, double direction, double speed, int damage) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.speed = speed;
        this.damage = damage;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDamage() {
        return damage;
    }
    public void updatePos(){
        x = (int)(x+speed*Math.cos(direction));
        y = (int)(y+speed*Math.sin(direction));
    }
}
