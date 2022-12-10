package lotto.controller;

import lotto.domain.LottoMachine;
import lotto.domain.LottoTicket;
import lotto.view.InputView;

public class InputController {

    public LottoTicket generateLottoTicket() {
        while (true) {
            try {
                String input = InputView.readPurchasingAmount();
                return LottoMachine.makeTicket(Integer.parseInt(input));
            } catch () {
            }
        }
    }
}
