
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

    public Pawn(int x, int y, int damage, int health, int size, int speed, Player player) {
        this.values = new ValueTracker(x, y, damage, health, size, speed, player);
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

    public int getPaintX() {
        return values.getPaintX();
    }

    public int getPaintY() {
        return values.getPaintY();
    }

    public int getSize() {
        return values.size;
    }

    public boolean isAlive() {
        return values.isAlive();

    }
}
