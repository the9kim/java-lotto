package lotto.controller;

import lotto.domain.LottoTicket;
import lotto.view.OutputView;

public class GameController {
    InputController inputController;

    public GameController(InputController inputController) {
        this.inputController = inputController;
    }

    public void run() {
        LottoTicket lottoTicket = generateLottoTicket();
    }

    private LottoTicket generateLottoTicket() {
        LottoTicket lottoTicket = inputController.generateLottoTicket();
        OutputView.printLottoTicket(lottoTicket);
        return lottoTicket;
    }
}
