/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mediator;

import Models.Table;
import java.util.Stack;

/**
 *
 * @author noura
 */
public class UndoRedo {
    private static Stack<Table> undo = new Stack();
    private static Stack<Table> redo = new Stack();
    
    public static void Move(Table table){
        undo.add(table);
        redo.clear();
    }
    
    public static Table Undo(){
        if(undo.empty()) return null;
        Table table = undo.pop();
        redo.add(table);
        return table;
    }
    
    public static Table Redo(){
        if(redo.empty()) return null;
        Table table = redo.pop();
        undo.add(table);
        return table;
    }
    
}
