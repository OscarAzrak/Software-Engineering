package Tools;
import Games.Fifteen;

public class testViewControl {
    public static void main(String[] args) {
        Fifteen gm = new Fifteen();
        ViewControl window = new ViewControl(gm, 4, 450, 600, "Welcome to the Fifteenpuzzle");
        window.setVisible(true);

    }
}
