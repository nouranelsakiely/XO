/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SnapShot;

import Models.Table;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author noura
 */
public class SaveLoad {
    
    public static void Save(Table table) throws IOException{
        String[][] map = table.Model;
        File file = new File("game.txt");
        FileWriter fileWriter = new FileWriter(file);
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                fileWriter.write(map[i][j]);
            }
            fileWriter.write("\n");
        }
        fileWriter.flush();
        fileWriter.close();
    }
    
}
