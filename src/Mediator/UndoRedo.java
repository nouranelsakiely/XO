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
        undo.add(new Table(table.Model));
        redo.clear();
    }
    
    public static Table Undo(Table currentTable){
        if(undo.empty()) return null;
        Table table = undo.pop();
        redo.add(new Table(currentTable.Model));
        return table;
    }
    
    public static Table Redo(Table currentTable){
        if(redo.empty()) return null;
        Table table = redo.pop();
        undo.add(new Table(currentTable.Model));
        return table;
    }
    
}
