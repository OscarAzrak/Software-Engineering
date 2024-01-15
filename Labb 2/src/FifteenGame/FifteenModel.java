package FifteenGame;

import Tools.Boardgame;
//import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

class FifteenModel implements Boardgame {
    // Implementera Boardgame-metoderna
    // Deklarera variabler och övriga metoder som ni
    // tycker behövs för ett femtonspel

    private final String currentMessage = "No message yet";
    private final String[][] board = new String[4][4];   // spelplanen
    private int iemp, jemp;                        // index till den tomma rutan

    public FifteenModel() {
        int n = 1;
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                board[x][y] = Integer.toString(n);
                System.out.println(Arrays.deepToString(board));

            }
        }

    }
}