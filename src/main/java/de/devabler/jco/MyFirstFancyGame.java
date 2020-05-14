package de.devabler.jco;

import java.util.Random;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;

/**
 * 
 * Mein erstes krasses Spiel!
 */
public class MyFirstFancyGame {

    void runGame(Screen screen, TextGraphics textGraphics) throws Exception {
        var gegnerY = 0;
        var gegnerX = screen.getTerminalSize().getColumns() / 2;
        var bewegung = 0;

        var y = screen.getTerminalSize().getRows() - 1;
        var x = screen.getTerminalSize().getColumns() / 2;
        Raketenbauplan rakete = null ;
        while (true) {
            bewegung = berechneBewegung(bewegung);
            gegnerX = gegnerX - bewegung;

            var eingabe = screen.pollInput();
            if ((eingabe != null) && (eingabe.getKeyType() == KeyType.ArrowLeft)) {
                x = x - 1;

            }
            if ((eingabe != null) && (eingabe.getKeyType() == KeyType.ArrowRight)) {
                x = x + 1;

            }
            if ((eingabe != null) && (eingabe.getKeyType() == KeyType.ArrowUp) && (rakete == null)) {
               rakete = new Raketenbauplan();
               rakete.x = x +2 ;
               rakete.y = y -1 ;

             }
             if (rakete != null ) {
                 textGraphics.putString(rakete.x, rakete.y, "I") ;
                 var leery = rakete.y +1 ;      
                 textGraphics.putString(rakete.x,leery , " ") ;
                 rakete.y = rakete.y -1 ;
             }
            
            textGraphics.putString(x, y, " -/\\- ");
            textGraphics.putString(gegnerX, gegnerY, " I--V--I ");
            
            while (screen.pollInput() != null);
            screen.refresh();
            Thread.sleep(100);
        }
    }

    private int berechneBewegung(int opponentDirection) {
        Random random = new Random();
        int nextInt = random.nextInt(100);
        if (nextInt < 10) {
            return 0;
        } else if (nextInt < 15) {
            return (int) Math.pow(-1.0, (double) random.nextInt(2));
        }
        return opponentDirection;
    }

}
