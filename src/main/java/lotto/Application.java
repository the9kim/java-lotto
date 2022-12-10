package lotto;

import lotto.controller.GameController;
import lotto.controller.InputController;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController(new InputController());
        gameController.run();
    }
}
