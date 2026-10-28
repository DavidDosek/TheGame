
import java.awt.Rectangle;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author rdbab
 */
public class Pawn {

    private ValueTracker values;

    public Pawn(ValueTracker values) {
        this.values = values;
    }

    public void takeDamage(int damage) {
        values.health -= damage;
    }

    public void updatePos(int playerX, int playerY) {
        values.updatePos(playerX, playerY);
    }

    public Rectangle getHitbox() {
        return values.hitbox;
    }

    public int getX() {
        return values.x;
    }

    public int getY() {
        return values.y;
    }

    public int getSize() {
        return values.size;
    }

    public boolean isAlive() {
        return values.isAlive();

    }
}
