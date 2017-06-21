/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Mediator.UndoRedo;
import Models.Table;
import Observer.GameObserver;
import Strategy.*;
import Views.GameTable;

/**
 *
 * @author noura
 */
public class XOEngine {
    public static enum Player{
        Player1, Player2
    }
    
    private static Player CurrentPlayer = Player.Player1;
    private static GameStrategy strategy = null;
    private static GameObserver observer = new GameObserver();
    private Table Model = new Table();
    
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
        UndoRedo.Move(new Table(Model.Model));
        if(CurrentPlayer == Player.Player1){
            XOEngine.strategy.Player1(place, table);
            Model.setPosition(place, "X");
            Model.print();
            if(observer.checkWin(Model, CurrentPlayer)){
                table.setWinner("Player 1 Wins");
            }
            if(observer.checkDraw(Model)){
                table.setWinner("Draw");
            }
            CurrentPlayer = Player.Player2;
        } else {
            XOEngine.strategy.Player2(place, table);
            Model.setPosition(place, "O");
            Model.print();
            if(observer.checkWin(Model, CurrentPlayer)){
                table.setWinner("Player 2 Wins");
            }
            if(observer.checkDraw(Model)){
                table.setWinner("Draw");
            }
            CurrentPlayer =Player.Player1;
        }
    }
    
    public void undo(GameTable table){
        Table model = UndoRedo.Undo(Model);
        if(model == null) return;
        table.loadMap(model.Model);
        Model = model;
        if(CurrentPlayer == Player.Player1){
            CurrentPlayer = Player.Player2;
        } else {
            CurrentPlayer = Player.Player1;
        }
    }
    
    public void redo(GameTable table){
        Table model = UndoRedo.Redo(Model);
        if(model == null) return;
        table.loadMap(model.Model);
        Model = model;
        model.print();
        if(CurrentPlayer == Player.Player1){
            CurrentPlayer = Player.Player2;
        } else {
            CurrentPlayer = Player.Player1;
        }
    }
    
}
