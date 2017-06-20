/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Observer;

import Controllers.XOEngine;
import Models.Table;

/**
 *
 * @author noura
 */
public class GameObserver {
    private static String symbol = null;
    
    public boolean checkDraw(Table model){
        String[][] table = model.Model;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(" ".equals(table[i][j])){
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean checkWin(Table model, XOEngine.Player player){
        String[][] table = model.Model;
        if(player == XOEngine.Player.Player1){
            symbol = "X";
        }else{
            symbol = "O";
        }
        
        if(checkRow(table) || checkColumn(table) || checkDiagonal(table)){
            return true;
        }
        return false;
    }
    
    private boolean checkRow(String[][] model){
        for(int i = 0; i < 3; i++){
            if(symbol.equalsIgnoreCase(model[i][0]) && symbol.equalsIgnoreCase(model[i][1]) && symbol.equalsIgnoreCase(model[i][2])){
                return true;
            }
        }
        return false;
    }
    
    private boolean checkColumn(String[][] model){
        for(int i = 0; i < 3; i++){
            if(symbol.equalsIgnoreCase(model[0][i]) && symbol.equalsIgnoreCase(model[1][i]) && symbol.equalsIgnoreCase(model[2][i])){
                return true;
            }
        }
        return false;
    }
    
    private boolean checkDiagonal(String[][] model){
        if(symbol.equalsIgnoreCase(model[0][0]) && symbol.equalsIgnoreCase(model[1][1]) && symbol.equalsIgnoreCase(model[2][2])){
            return true;
        }
        if(symbol.equalsIgnoreCase(model[0][2]) && symbol.equalsIgnoreCase(model[1][1]) && symbol.equalsIgnoreCase(model[2][0])){
            return true;
        }
        return false;
    }
    
}
