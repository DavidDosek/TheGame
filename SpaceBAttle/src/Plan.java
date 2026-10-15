
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import static java.lang.Math.*;
import java.util.LinkedList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author xdosek1
 */
public class Plan extends JComponent{
    private int screenWidth=400;
    private int screenHeight=300;
    private int mouseX = 1;
    private int mouseY = 1;
    
    public void setScreenWidth(int screenWidth) {
        this.screenWidth = screenWidth;
    }

    public void setScreenHeight(int screenHeight) {
        this.screenHeight = screenHeight;
    }

    public void setMouseX(int mouseX) {
        this.mouseX = mouseX;
    }

    public void setMouseY(int mouseY) {
        this.mouseY = mouseY;
    }
    
    

    
    
    private Turret player = new Turret(screenWidth/2, screenHeight/2, 50, 50);

    @Override
    protected void paintComponent(Graphics g) {
        
        
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.black);
        g2d.fillRect(0, 0, screenWidth, screenHeight);
        //updejtujeme pozici hraci v pripade resize okna
        player.updatePos(screenWidth/2, screenHeight/2,mouseX,mouseY);
        //kreslime hrace
        g2d.setColor(Color.blue);
        
        g2d.fillOval(player.getPaintX(), player.getPaintY(), player.getTurretWidth(), player.getTurretWidth());
        //kreslime hlavici
        
        /*System.out.println(player.getHeadX());
        System.out.println(player.getHeadY());*/
        g2d.setColor(Color.red);
        g2d.fillOval(player.getHeadX(), player.getHeadY(), 10,10);
        paintBullets(g2d);
        g2d.setColor(Color.black);
        g2d.fillOval(player.getX(), player.getY(), 5, 5);
        System.out.println(mouseY);
    }
    
    
    LinkedList<Bullet> bullets = new LinkedList<>();
    
    private void paintBullets(Graphics2D g2d){
        int i =0;
        
        //proc tu je while a ne for each???, zamysli se a bud chytry :)))
        while (i<bullets.size()) {
            Bullet b = bullets.get(i);
            b.updatePos();
            if (b.getX()>screenWidth||b.getX()<0||b.getY()>screenHeight||b.getY()<0) {
                bullets.remove(b);
            }else{
                g2d.setColor(Color.YELLOW);
            g2d.fillOval(b.getX(), b.getY(), 10, 10);
            }
            i++;
        }
        
    }
    public void shoot(){
        bullets.add(player.shoot());
    }
    
}
