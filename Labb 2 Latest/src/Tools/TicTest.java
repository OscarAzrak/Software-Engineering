package Tools;


import Games.TicTacToe;

import java.util.Scanner;

public class TicTest {
    public static void main(String[] u) {
        Scanner scan = new Scanner(System.in);
        Boardgame thegame = new TicTacToe();                 // Model object is created
        System.out.println("\nWelcome to TicTacToe\n");
        while (true) {
            // Print the current board
            for (int i=0; i<3; i++) {
                for (int j=0; j<3; j++)
                    System.out.print("  " + thegame.getStatus(i,j)); // getStatus
                System.out.println();
            }
            System.out.println();
            System.out.print("Your move: ");
            int i = scan.nextInt();  // get an int number from terminal window
            int j = scan.nextInt();
            thegame.move(i,j);	                             // move
            System.out.println(thegame.getMessage());	     // getMessage
        }
    }
}
