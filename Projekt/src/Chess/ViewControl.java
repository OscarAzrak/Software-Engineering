package Chess;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewControl extends JFrame implements ActionListener{

    private Boardgame game;
    private int size;
    private JButton[][] board;
    private static JLabel message = new JLabel(" ", JLabel.CENTER);
    private JTextField mess = new JTextField();  // JLabel funkar också
    private JButton selected, possible = null;
    private Color white = new Color(255,255,255);
    private Color black = new Color(0,0,0);
    private static boolean USE_CROSS_PLATFORM_UI = true;


    public ViewControl(Boardgame gm) {
        game = gm;
        size = 8;

        setTitle("Chess");
        board = new JButton[size][size];

        frameInit();
        getGraphics();
        setSize(1000, 1000);
        Container cp = getContentPane();
        GridLayout grid = new GridLayout(size + 1, size);
        cp.setLayout(grid);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //If this is not prominent, have to close program manually

        readBoard();
    }
    //Create board, every second square is image_pieces.black.black, other second square is white. Get correct piece to correct square
   
    private void readBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if ((i + j) % 2 == 0) {
                    board[i][j] = new JButton();
                    board[i][j].setBackground(white);
                    board[i][j].setOpaque(true);
                    board[i][j].setBorderPainted(false);
                    board[i][j].addActionListener(this);
                    board[i][j].setActionCommand(i + " " + j);
                    getContentPane().add(board[i][j]);
                } else {
                    board[i][j] = new JButton();
                    board[i][j].setBackground(black);
                    board[i][j].setOpaque(true);
                    board[i][j].setBorderPainted(false);
                    board[i][j].addActionListener(this);
                    board[i][j].setActionCommand(i + " " + j);
                    getContentPane().add(board[i][j]);
                }
            }
        }
        getContentPane().add(message);
        getContentPane().add(mess);
        message.setText(game.getMessage());
        mess.setText(game.getMessage());
    }

    

    /*public void readBoard(){
        for (int i = 0; i<size;i++){
            for (int j = 0; j<size;j++) {
                board[i][j] = new JButton();//lägg rätt piece här
                board[i][j].setOpaque(true); //needed to show colors to buttons on mac
                board[i][j].setBorderPainted(false); //needed to show colors to buttons on mac
                if ((i+j)%2==0)
                {
                    board[i][j].setBackground(white);
                }
                else {
                    board[i][j].setBackground(black);
                }
                board[i][j].addActionListener(this);
                add(board[i][j]);
            }
        }
    }*/

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i< board.length;i++) {
            for (int j = 0; j < board.length; j++) {
                if (e.getSource() == board[i][j]) {
                    if(game.move(i, j)){
                        for (int r = 0; r < size;r++){
                            for (int c = 0;c < size; c++){
                                System.out.println("h");
                                //board[r][c].changedisp(game.getStatus(r,c));
                            }
                        }
                    }
                }
            }
        }
        mess.setText(game.getMessage());
    }

}
