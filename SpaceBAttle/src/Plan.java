
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
   
    private int mouseX = 1;
    private int mouseY = 1;
    
    
    

    public void setMouseX(int mouseX) {
        this.mouseX = mouseX;
    }

    public void setMouseY(int mouseY) {
        this.mouseY = mouseY;
    }
    
    

    
    
    private Turret player = new Turret(getWidth()/2, getHeight()/2, 50, 50);

    @Override
    protected void paintComponent(Graphics g) {
        
        
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.black);
        g2d.fillRect(0, 0, getWidth(), getHeight());
        //updejtujeme pozici hraci v pripade resize okna
        player.updatePos(getWidth()/2, getHeight()/2,mouseX,mouseY);
        //kreslime hrace
        g2d.setColor(Color.blue);
        
        g2d.fillOval(player.getPaintX(), player.getPaintY(), player.getTurretWidth(), player.getTurretWidth());
        //kreslime hlavici
        
        
        g2d.setColor(Color.red);
        g2d.fillOval(player.getHeadX()-5, player.getHeadY()-5, 10,10);
        paintBullets(g2d);
        
        
    }
    
    
    LinkedList<Bullet> bullets = new LinkedList<>();
    
    private void paintBullets(Graphics2D g2d){
        int i =0;
        
        //proc tu je while a ne for each???, zamysli se a bud chytry :)))
        while (i<bullets.size()) {
            Bullet b = bullets.get(i);
            b.updatePos();
            if (b.getPaintX()>getWidth()||b.getPaintX()<0||b.getPaintY()>getHeight()||b.getPaintY()<0) {
                bullets.remove(b);
            }else{
                g2d.setColor(Color.YELLOW);
            g2d.fillOval(b.getPaintX(), b.getPaintY(), 10, 10);
            /* hitbox testing
             g2d.setColor(Color.green);
             g2d.drawRect(b.getHitboxX(), b.getHitboxY(), b.getDamage(), b.getDamage());*/
                // just a test, to be finished checkCollision(b);
            }
            i++;
        }
        
    }
    //finise this fumction after doind meteor
    private void checkCollision(Bullet b){
        if (bullets.size()>=2) {
            for (int i = bullets.indexOf(b); i < bullets.size(); i++) {
            if (b.checkColision(bullets.get(i).getHitbox())) {
                bullets.remove(b);
                bullets.remove(i);
            }
        }
        }
        
    }
    public void shoot(){
        bullets.add(player.shoot(mouseX,mouseY));
    }
    
}
