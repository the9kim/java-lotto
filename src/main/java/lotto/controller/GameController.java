package lotto.controller;

import lotto.domain.LottoMachine;
import lotto.domain.LottoTicket;

public class GameController {

    InputController inputController;

    public void run() {
        LottoTicket lottoTicket = LottoMachine.makeLottoTicket(inputController.getPurchasingMoney());
        // generateWinningNumber();
        // pickWinners();
        // printResult();
    }
}
