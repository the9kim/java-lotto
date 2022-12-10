package lotto.controller;

import lotto.Lotto;
import lotto.domain.BonusNumber;
import lotto.domain.LottoTicket;
import lotto.domain.Result;
import lotto.view.OutputView;

public class GameController {
    InputController inputController;

    public GameController(InputController inputController) {
        this.inputController = inputController;
    }

    public void run() {
        LottoTicket lottoTicket = generateLottoTicket();
        Lotto lotto = getWinningLotto();
        BonusNumber bonusNumber = getBonusNumber(lotto);
        Result result = getWinner(lottoTicket, lotto, bonusNumber);
    }

    private LottoTicket generateLottoTicket() {
        LottoTicket lottoTicket = inputController.generateLottoTicket();
        OutputView.printLottoTicket(lottoTicket);
        return lottoTicket;
    }

    private Lotto getWinningLotto() {
        Lotto lotto = inputController.getWinningNumber();
        return lotto;
    }

    private BonusNumber getBonusNumber(Lotto lotto) {
        BonusNumber bonusNumber = inputController.getBonusNumber(lotto);
        return bonusNumber;
    }

    private Result getWinner(LottoTicket lottoTicket, Lotto lotto, BonusNumber bonusNumber) {
        Result result = new Result();
        result = lotto.checkWinner(lottoTicket, bonusNumber, result);
        System.out.println(result.getResultMap());
        return result;
    }
}
