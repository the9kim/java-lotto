package lotto.view;

import lotto.domain.LottoMachine;
import lotto.domain.LottoTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {

    @DisplayName("생성한 로또 번호를 출력한다")
    @Test
    void printLottoTicket() {
        int purchasingMoney = 5000;

        LottoTicket lottoTicket = LottoMachine.makeLottoTicket(purchasingMoney);
        OutputView.printLottoTicket(lottoTicket);
    }

}