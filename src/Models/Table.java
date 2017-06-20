/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author noura
 */
public class Table {
    public String[][] Model = new String[3][3];
    
    public Table(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                Model[i][j] = " ";
            }
        }
    }
    
    public void setPosition(int place, String symbol){
        switch(place){
            case 1:
                Model[0][0] = symbol;
                break;
            case 2:
                Model[0][1] = symbol;
                break;
            case 3:
                Model[0][2] = symbol;
                break;
            case 4:
                Model[1][0] = symbol;
                break;
            case 5:
                Model[1][1] = symbol;
                break;
            case 6:
                Model[1][2] = symbol;
                break;
            case 7:
                Model[2][0] = symbol;
                break;
            case 8:
                Model[2][1] = symbol;
                break;
            case 9:
                Model[2][2] = symbol;
                break;
        }
    }
        
    public void print(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                System.out.print(Model[i][j] + "|");
            }
            System.out.println("");
            System.out.println("------");
        }
    }
    
}
