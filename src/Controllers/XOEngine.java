/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Strategy.*;
import Views.GameTable;

/**
 *
 * @author noura
 */
public class XOEngine {
    enum Player{
        Player1, Player2
    }
    
    private static Player CurrentPlayer = Player.Player1;
    private static GameStrategy strategy = null;
    
    // Singleton
    private static XOEngine EngineInstance = null;
    private XOEngine() { }
    public static XOEngine getInstance() {
        if(EngineInstance == null) {
            EngineInstance = new XOEngine();
        }
        return EngineInstance;
    }
    
    public void setStrategy(GameStrategy strategy){
        XOEngine.strategy = strategy;
    }
    
    public void Play(int place, GameTable table){
        if(CurrentPlayer == Player.Player1){
            XOEngine.strategy.Player1(place, table);
            CurrentPlayer = Player.Player2;
        }
        else{
            XOEngine.strategy.Player2(place, table);
            CurrentPlayer =Player.Player1;
        }
    }
    
}
