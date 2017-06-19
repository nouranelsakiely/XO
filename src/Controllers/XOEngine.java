/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Strategy.*;

/**
 *
 * @author noura
 */
public class XOEngine {
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
    
    public void Play(int place){
        
    }
    
}
