/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SnapShot;

import Models.Table;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
    
    public static Table Load() throws FileNotFoundException, IOException{
        String[][] map = new String[3][3];
        
        File file = new File("game.txt");
        FileReader fileReader = new FileReader(file);
        StringBuilder stringBuffer = new StringBuilder();
        int numCharsRead;
        char[] charArray = new char[1024];
        while ((numCharsRead = fileReader.read(charArray)) > 0) {
                stringBuffer.append(charArray, 0, numCharsRead);
        }
        fileReader.close();
        System.out.println("Contents of file:");
        System.out.println(stringBuffer.toString());
        
        int x = 0, y = 0;
        for(int i = 0; i < stringBuffer.toString().length(); i++){
            if(stringBuffer.toString().charAt(i) == '\n'){
                y++;
            }else{
                map[x][y] = "" + stringBuffer.toString().charAt(i);
                x++;
                x%=3;
            }
        }
        
        Table table = new Table(map);
        return table;
    }
    
}
