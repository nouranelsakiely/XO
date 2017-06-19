/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Strategy;

import Views.GameTable;

/**
 *
 * @author noura
 */
public class TwoPlayers extends GameStrategy {

    public void Player2(int place ,GameTable table) {
        table.SetPosition("O", place);
    }
    
}
