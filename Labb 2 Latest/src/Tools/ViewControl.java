package Tools;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewControl extends JFrame implements ActionListener{

    private Boardgame game;
    private int size;
    private Square[][] board;        // Square är subklass till JButton
    private JTextField mess = new JTextField();  // JLabel funkar också

    ViewControl(Boardgame gm, int n, int width, int length, String name) {
        game = gm;
        size = n;
        setTitle(name);
        frameInit();
        getGraphics();
        setSize(width, length);
        Container cp = getContentPane();
        GridLayout grid = new GridLayout(n+1,n);
        cp.setLayout(grid);
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE ); //If this is not prominent, have to close program manually
        setLayout(new FlowLayout() );       // set the layout manager, fixes the label
        setVisible(true); //ask it to become visible

        board = new Square[n][n];
        for (int i = 0; i<n;i++){
            for (int j = 0; j<n;j++) {
                board[i][j] = new Square(i, j, game.getStatus(i, j));
                board[i][j].setPreferredSize(new Dimension(100, 100));
                board[i][j].addActionListener(this);
                add(board[i][j]);
            }

            mess.setText("Choose a square");
            mess.setPreferredSize(new Dimension(300, 40));
            add(mess);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i< board.length;i++) {
            for (int j = 0; j < board.length; j++) {
                if (e.getSource() == board[i][j]) {
                    if(game.move(i, j)){
                        for (int r = 0; r < size;r++){
                            for (int c = 0;c < size; c++){
                                board[r][c].changedisp(game.getStatus(r,c));
                            }
                        }
                    }
                }
            }
        }
        mess.setText(game.getMessage());
    }

}
