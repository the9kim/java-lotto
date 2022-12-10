package lotto.controller;

import lotto.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoTicket;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class InputController {

    public LottoTicket generateLottoTicket() {
        while (true) {
            try {
                String input = InputView.readPurchasingAmount();
                return LottoMachine.makeTicket(Integer.parseInt(input));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Lotto getWinningNumber() {
        while (true) {
            try {
                String[] winningNumber = InputView.readWinningNumber().split("");
                return new Lotto(setFormat(winningNumber));
            } catch (IllegalArgumentException e2) {
                System.out.println(e2.getMessage());
            }
        }
    }

    private List<Integer> setFormat(String[] inputNumber) {
        List<Integer> winningNumber = new ArrayList<>();
        for (String number : inputNumber) {
            winningNumber.add(Integer.parseInt(number));
        }
        return winningNumber;
    }

    public void getBonusNumber(Lotto lotto) {
        while (true) {
            try {
                String input = InputView.readBonusNumber();
                lotto.setBonusNumber(Integer.parseInt(input));
            } catch (IllegalArgumentException e3) {
                System.out.println(e3.getMessage());
            }
        }
    }
}
