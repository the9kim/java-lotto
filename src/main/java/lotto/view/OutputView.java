package lotto.view;

import lotto.Lotto;
import lotto.domain.LottoTicket;

public class OutputView {

    public static void printLottoTicket(LottoTicket lottoTicket) {
        printLottoPurchasingAmount(lottoTicket);
        printLotto(lottoTicket);
    }

    private static void printLottoPurchasingAmount(LottoTicket lottoTicket) {
        System.out.printf("%s개 구매했습니다.\n", lottoTicket.getPurchasingAmount());
    }

    private static void printLotto(LottoTicket lottoTicket) {
        for (Lotto lotto : lottoTicket.getLottoTicket()) {
            System.out.println(lotto.getSortedNumbers());
        }
    }

}
