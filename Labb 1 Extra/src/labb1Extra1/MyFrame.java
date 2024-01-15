
package labb1Extra1;

import java.awt.*; 
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	private MyButton[] button_list;
	public MyButton button;


  // constructor
  MyFrame()
  {
	
    super();// invoke the JFrame constructor

    setTitle("Alperen och Oscar");
    setSize(500, 500);
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE ); //If this is not prominent, have to close program manually
    
    setLayout(new FlowLayout() );       // set the layout manager, fixes the label
    getContentPane().setBackground(Color.YELLOW); //Cool color
    setVisible(true); //ask it to become visible
    
  }
  
	public MyFrame(MyButton[] buttons) {
		this();		
		button_list = buttons; 
		for(MyButton button: button_list) {
			button.addActionListener(this);
			add(button);
		}
}

	@Override
	public void actionPerformed(ActionEvent e) {
		for(MyButton button: button_list) {
			if(e.getSource() != button) {
				button.togglestate();
				}
			}
		
	}
}
