package RPS;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.io.*;
import java.util.Objects;
import java.util.Scanner;

class RPSSkel extends JFrame implements ActionListener {
    Gameboard myboard, computersboard;
    int counter; // To count ONE ... TWO  and on THREE you play
    Socket socket;
    BufferedReader in;
    PrintWriter out;
    JButton closebutton;
	String playerName;


	RPSSkel (String name) {
		playerName = name;
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		closebutton = new JButton("Close");
		myboard = new Gameboard(playerName, this); // Must be changed
		computersboard = new Gameboard("Computer");

		JPanel boards = new JPanel();
		boards.setLayout(new GridLayout(1,2));
		boards.add(myboard);
		boards.add(computersboard);
		add(boards, BorderLayout.CENTER);

		ActionListener close = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				out.println("");
				out.flush();
				System.exit(0);
			}
		};

		this.closebutton.addActionListener(close);
		add(closebutton, BorderLayout.SOUTH);
		server();
		setSize(350, 650);
		setVisible(true);
	}

	public void server() {
		try {
			this.socket = new Socket("localhost",4711);

			this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			this.out = new PrintWriter(socket.getOutputStream());
			out.println(this.playerName);
			out.flush();
			in.readLine();

		} catch(Exception e) {
			System.err.println(e);
			System.exit(0);
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		//counter display
		counter += 1;
		if (counter == 1){
			myboard.setLower("ETT");
			computersboard.setLower("ETT");
			myboard.resetColor();
			computersboard.resetColor();
		}
		else if (counter == 2){
			myboard.setLower("TVÅ");
			computersboard.setLower("TVÅ");
		}
		else {
			counter = 0;
			showChoice(e);
			}
		}


	public void showChoice(ActionEvent e) {
		JButton pressedButton = (JButton) e.getSource();
		String playerMove = ((ImageIcon) pressedButton.getIcon()).getDescription(); //descirption hämtar namnet på iconen
		playerMove = readMoves(playerMove);
		try {
			myboard.markPlayed(playerMove);
			out.println(playerMove);
			out.flush();
			String computerMove = in.readLine();
			computersboard.markPlayed(computerMove);

			myboard.setUpper(playerMove);
			computersboard.setUpper(computerMove);
			winnerIs(playerMove, computerMove, myboard, computersboard);

		} catch(IOException exc) {
			exc.printStackTrace();
		}
	}

	public String readMoves(String move){
		if (move.equals("src/RPS/rock.gif")){
			move = "STEN";
		}
		else if (move.equals("src/RPS/paper.gif")){
			move = "PASE";
		}
		else{
			move="SAX";
		}
		return move;
	}

	public void winnerIs (String playerMove, String computerMove, Gameboard playerBoard, Gameboard computersboard){
		if (playerMove.equals(computerMove)){
			playerBoard.setLower("DRAW");
			computersboard.setLower("DRAW");
		}
		else if ((computerMove.equals("SAX") && playerMove.equals("STEN")) ||
				(computerMove.equals("PASE") && playerMove.equals("SAX")) ||
				(computerMove.equals("STEN") && playerMove.equals("PASE"))) {
			playerBoard.setLower("WIN");
			computersboard.setLower("LOSE");
			playerBoard.wins();
		}
		else {
			playerBoard.setLower("LOSE");
			computersboard.setLower("WIN");
			computersboard.wins();

		}
	}

	public static void main (String[] u) {
		System.out.println("Enter player name:");
		Scanner sc = new Scanner(System.in);
		String playerName = sc.nextLine();
		new RPSSkel(playerName);
	}

}



