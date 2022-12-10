package lotto.controller;

import lotto.domain.LottoTicket;
import lotto.view.InputView;

public class InputController {

    public LottoTicket generateLottoTicket() {
        while (true) {
            try {
                InputView.readPurchasingAmount();
            } catch () {
            }
        }
    }
}
