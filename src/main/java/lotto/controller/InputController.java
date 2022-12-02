package lotto.controller;

import lotto.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoTicket;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class InputController {

    public LottoTicket getPurchasingMoney() {
        while (true) {
            try {
                String purchasingMoney = InputView.readPurchasingMoney();
                return LottoMachine.makeLottoTicket(Integer.parseInt(purchasingMoney));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Lotto getWinningNumber() {
        while (true) {
            try {
                String winningNumber = InputView.readWinningNumber();
                return Lotto.winningLotto(convertType(winningNumber));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void getBonusNumber(Lotto winningLotto) {
        while (true) {
            try {
                winningLotto.generateBonusNumber(Integer.parseInt(InputView.readBonusNumber()));
                return;
            } catch (IllegalArgumentException e) {
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
