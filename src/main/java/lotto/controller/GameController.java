package lotto.controller;

import lotto.Lotto;
import lotto.domain.LottoTicket;
import lotto.view.OutputView;

public class GameController {
    InputController inputController;

    public GameController(InputController inputController) {
        this.inputController = inputController;
    }

    public void run() {
        LottoTicket lottoTicket = generateLottoTicket();
        Lotto lotto = getWinningLotto();
    }

    private LottoTicket generateLottoTicket() {
        LottoTicket lottoTicket = inputController.generateLottoTicket();
        OutputView.printLottoTicket(lottoTicket);
        return lottoTicket;
    }

    private Lotto getWinningLotto() {
        Lotto lotto = inputController.getWinningNumber();
        inputController.getBonusNumber(lotto);
        return lotto;
    }
}
