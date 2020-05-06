package de.devabler.jco;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;

/**
 * 
 * Mein erstes krasses Spiel!
 */
public class MyFirstFancyGame {

    void runGame(Screen screen, TextGraphics textGraphics) throws Exception {
      
        var y = screen.getTerminalSize().getRows() -1; 
        var x = screen.getTerminalSize().getColumns() /2;
        while(true) {

            var eingabe = screen.pollInput();
            if(eingabe != null && eingabe.getKeyType() == KeyType.ArrowLeft) {
                x = x-1;
            }
            textGraphics.putString(x,y, " -/\\- ");
            screen.refresh();
            Thread.sleep(100);
        }
    }
}
