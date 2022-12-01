package lotto.controller;

import lotto.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class InputController {

    public int getPurchasingMoney() {
        while (true) {
            try {
                String purchasingMoney = InputView.readPurchasingMoney();
                return Integer.parseInt(purchasingMoney);
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> getWinningNumber() {
        while (true) {
            try {
                String winningNumber = InputView.readWinningNumber();
                return convertType(winningNumber);
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Integer getBonusNumber() {
        while (true) {
            try {
                String bonusNumber = InputView.readBonusNumber();
                return Integer.parseInt(bonusNumber);
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }


    }
    private List<Integer> convertType(String input) {
        List<Integer> winningNumber = new ArrayList<>();
        String[] numberArray = input.split(",");
        for (String number : numberArray) {
            winningNumber.add(Integer.parseInt(number));
        }
        return winningNumber;
    }



}
