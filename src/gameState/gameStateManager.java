package gameState;

import java.util.ArrayList;

public class gameStateManager {

    private ArrayList<gameState> gameStates;
    public static final int MENUSTATE=0;
    private int currentState;
    public static final int LEVEL1STATE=1;
    gameStateManager(){
    gameStates=new ArrayList<gameState>();
    currentState =MENUSTATE;
    gameStates.add(new MenuState(this));
    }

    public void setState(int state){
        currentState=state;
        gameStates.get(currentState).init();
    }

    public void update(){
        gameStates.get(currentState).update();
    }

    public void draw(java.awt.Graphics2D g){
        gameStates.get(currentState).draw(g);
    }

    public void keyPressed(int k){
        gameStates.get(currentState).keyPressed(k);
    }

    public void keyReleased(int k){
        gameStates.get(currentState).update();
    }
}
