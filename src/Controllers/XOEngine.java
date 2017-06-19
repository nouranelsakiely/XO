/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Singleton.Singleton;

/**
 *
 * @author noura
 */
public class XOEngine {
    private static XOEngine EngineInstance = null;
    private XOEngine() { }
    public static XOEngine getInstance() {
        if(EngineInstance == null) {
            EngineInstance = new XOEngine();
        }
        return EngineInstance;
    }
    
    
}
