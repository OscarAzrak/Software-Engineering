package labb1Extra1;


public class Main {
	public static void main(String[] args) {
			
		int n = 0;
        try {
            n = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("Incorrect input: Integer required. Try again");
            System.exit(0);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("No buttons added");
            System.exit(0);
        }

        if ((args.length - 1) != n*2) {
            System.out.println("Incorrect input: Incorrect number of strings");
            System.exit(0);
        }



		MyButton[] buttons = new MyButton[Integer.parseInt(args[0])];
		int j = 0;
	    
	    for (int i=1;j < Integer.parseInt(args[0]);i+=2)
	    {	    
	    	buttons[j] = new MyButton(args[i],args[i+1]);
			j = j+1;
	    	}


		MyFrame test_frame = new MyFrame(buttons);
		test_frame.setVisible(true);
		
		
	}

}

