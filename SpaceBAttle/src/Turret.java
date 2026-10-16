
import java.awt.Polygon;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author xdosek1
 */
public class Turret {

    private int x; //turret x pos
    private int y; //turret y pos
    private int headLenght; //the length of the shooting head
    private int headX; //head x pos
    private int headY; //head x pos
    private int turretWidth; //the width of the drawn circle of the turret body
    private int baseHeadX;
    private int baseHeadY;
    private double angle;
    

    public Turret(int x, int y, int turretHeadLenght, int turretWidth) {
        this.x = x;
        this.y = y;
        this.headLenght = turretHeadLenght;
        this.turretWidth = turretWidth;
        baseHeadX = x;
        baseHeadY = y+turretHeadLenght;
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
        
        int x = (int) (this.x+headLenght*Math.cos(angle));
        int y = (int) (this.y+headLenght*Math.sin(angle));
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
    
    public Bullet shoot(){
        int x = headX;
        int y = headY;
        double angle = this.angle;
        Bullet b = new Bullet(x,y,angle,5,10);
        return b;
    }

    public int getPaintX() {
        return x - turretWidth / 2;
    }

    public int getPaintY() {
        return y - turretWidth / 2;
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

    public void updatePos(int x, int y, int mouseX, int mouseY) {
        this.x = x;
        this.y = y;
        setHeadCords(mouseX, mouseY);
    }
}
