package lotto.controller;

import lotto.domain.LottoMachine;
import lotto.domain.LottoTicket;

public class GameController {

    InputController inputController;

    public void run() {
        LottoTicket lottoTicket = createLottoTicket();
        // generateWinningNumber();
        // pickWinners();
        // printResult();
    }

    private LottoTicket createLottoTicket() {
        LottoTicket lottoTicket = LottoMachine.makeLottoTicket(inputController.getPurchasingMoney());

    }
}
