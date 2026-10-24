/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author rdbab
 */
public class GameActionsManager {

    private boolean componentResized = false;
    private boolean gameMouseMoved = false;
    private boolean gameMousePressed = false;
    private Plan gamePlan;
    

    public GameActionsManager(Plan gamePlan) {
        this.gamePlan = gamePlan;
    }
    
    public void componentResized(){
        
    }
    
    public void gameMouseMoved(){

    }
    
    public void gameMousePressed(){
        
        
        gamePlan.shoot();

    }
    
    public void updateGameState(){
        if (gameMouseMoved) {
            gameMouseMoved();
            gameMouseMoved = false;
        }
        if (gameMousePressed) {
            gameMousePressed();
            gameMousePressed = false;
        }
       
            gamePlan.repaint();
            
        
    }

    public void setComponentResized(boolean componentResized) {
        this.componentResized = componentResized;
    }

    public void setGameMouseMoved(boolean gameMouseMoved) {
        this.gameMouseMoved = gameMouseMoved;
    }

    public void setGameMousePressed(boolean gameMousePressed) {
        this.gameMousePressed = gameMousePressed;
    }
    
    

}
