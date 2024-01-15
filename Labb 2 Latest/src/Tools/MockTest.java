package Tools;

import Games.MockGame;

public class MockTest {
    public static void main(String[] args) {
        MockGame game = new MockGame();
        ViewControl wind = new ViewControl(game, 5, 600, 600, "Welcome to the Mock game");
        wind.setVisible(true);
    }
}
