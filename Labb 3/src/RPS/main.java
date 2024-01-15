package RPS;

import java.io.IOException;
import java.net.*;
import java.io.*;
import java.util.*;

public class main {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost",4711);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            String user = "Alp Osc";
            out.println(user);
            out.flush();
            System.out.println(in.readLine());

            Scanner sc = new Scanner(System.in);
            String[] options = {"STEN", "SAX", "PASE"};
            Boolean win = false;
            Boolean good_move = false;
            String player_Move = new String();
            String comp_move = new String();
            System.out.println("Enter your move, 'STEN', 'SAX' or 'PASE'. Enter nothing to exit the program.");



        while (!win) {
            good_move = false;
            while (!good_move){
                player_Move = sc.nextLine().toUpperCase(Locale.ROOT);
                if (player_Move.equals("")){
                    System.out.println("Exiting");
                    System.exit(0);
                }
                for (String move : options){
                    if(move.equals(player_Move)){
                        good_move = true;
                        break;
                    }
                }
                if (!good_move){
                    System.out.println("Choose between 'STEN', 'SAX' or 'PASE'.");
                }
            }
            System.out.println("Player shows: " + player_Move);
            out.println(player_Move);
            out.flush();
            comp_move = in.readLine();
            System.out.println("Computer shows: " + comp_move);
            if (player_Move.equals(comp_move)){
                System.out.println("No winner, play again.");
                continue;
            }
            else if (comp_move.equals("STEN") && player_Move.equals("SAX")){
                System.out.println("Computer wins");
            }
            else if (comp_move.equals("SAX") && player_Move.equals("PASE")){
                System.out.println("Computer wins");
            }
            else if (comp_move.equals("PASE") && player_Move.equals("STEN")){
                System.out.println("Computer wins");
            }
            else {
                System.out.println("Player wins");
            }
        }
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }
}