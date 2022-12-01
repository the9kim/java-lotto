package lotto.controller;

import lotto.view.InputView;

public class InputController {

    public static int getPurchasingMoney() {
        while (true) {
            try {
                return InputView.readPurchasingMoney();
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }



}
