
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
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
public class Plan extends JComponent implements KeyListener {

    private int mouseX = 1;
    private int mouseY = 1;
    private Turret player;
    private BulletManager bulletsManager;
    private boolean freezedScreen = false;

    public void setMouseX(int mouseX) {
        this.mouseX = mouseX;
    }

    public void setMouseY(int mouseY) {
        this.mouseY = mouseY;
    }

    public boolean isFreezedScreen() {
        return freezedScreen;
    }

    public Plan() {
        bulletsManager = new BulletManager();
        try {
            player = new Turret(getWidth() / 2, getHeight() / 2, 50, 50);
        } catch (IOException ex) {
            System.getLogger(Plan.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        addKeyListener(this);
        setFocusable(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        //drawing a different state based of the game state
        if (!freezedScreen) {
            
            g2d.setColor(Color.gray);
            g2d.fillRect(0, 0, getWidth(), getHeight());
            //updejtujeme pozici hraci v pripade resize okna
            player.updatePos(getWidth() / 2, getHeight() / 2, mouseX, mouseY);
            player.paintPlayer(g2d);
            bulletsManager.paintBullets(g2d, getWidth(),getHeight(), false);
            
        } else{
            //drawing the scene without updating positions and then drawing a seethrough layer
            g2d.setColor(Color.gray);
            g2d.fillRect(0, 0, getWidth(), getHeight());
            player.paintPlayer(g2d);
            bulletsManager.paintBullets(g2d, getWidth(),getHeight(),true);
            player.updatePos(getWidth() / 2, getHeight() / 2);
            //drawing a seethrough layer
            g2d.setColor(new Color(10, 10, 10,100));
            g2d.fillRect(0, 0, getWidth(), getHeight());
        }

    }

    

    public void shoot() {
        int xDif = mouseX-player.getX();
        int yDif = mouseY-player.getY();
        double distance = Math.sqrt(xDif*xDif+yDif*yDif);
        if (distance<=player.getTurretHeadLenght()) {

        } else {
            bulletsManager.addBullet(player.shoot(mouseX, mouseY));
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_E) {

            freezedScreen = !freezedScreen;
            
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
