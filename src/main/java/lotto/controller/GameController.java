package lotto.controller;

import lotto.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoTicket;
import lotto.domain.Result;
import lotto.view.OutputView;

public class GameController {

    InputController inputController;

    public void run() {
        LottoTicket lottoTicket = createLottoTicket();
        Lotto winningLotto = generateWinningLottery();
        Result result = pickWinners(lottoTicket, winningLotto);
        printResult(result);
    }

    private LottoTicket createLottoTicket() {
        LottoTicket lottoTicket = LottoMachine.makeLottoTicket(inputController.getPurchasingMoney());
        OutputView.printLottoTicket(lottoTicket);
        return lottoTicket;
    }

    private Lotto generateWinningLottery() {
        Lotto winningLotto = Lotto.winningLotto(inputController.getWinningNumber());
        winningLotto.generateBonusNumber(inputController.getBonusNumber());
        return winningLotto;
    }

    private Result pickWinners(LottoTicket lottoTicket, Lotto winningLotto) {
        Result result = lottoTicket.pickWinningNumber(winningLotto);
        return result;
    }

    private void printResult(Result result) {
        OutputView.printWinningResult(result);
    }
}
