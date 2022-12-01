package lotto.controller;

import lotto.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoTicket;
import lotto.view.OutputView;

import java.util.List;

public class GameController {

    InputController inputController;

    public void run() {
        LottoTicket lottoTicket = createLottoTicket();
        Lotto winningLotto = generateWinningLottery();
        // pickWinners();
        // printResult();
    }

    private LottoTicket createLottoTicket() {
        LottoTicket lottoTicket = LottoMachine.makeLottoTicket(inputController.getPurchasingMoney());
        OutputView.printLottoTicket(lottoTicket);
        return lottoTicket;
    }

    private Lotto generateWinningLottery() {
        List<Integer> winningNumber = inputController.getWinningNumber();
        Lotto winningLotto = Lotto.winningLotto(winningNumber);
        int bonusNumber = inputController.getBonusNumber();
        winningLotto.generateBonusNumber(bonusNumber);
        return winningLotto;
    }
}
