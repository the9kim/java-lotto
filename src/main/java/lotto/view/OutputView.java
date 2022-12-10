package lotto.view;

import lotto.domain.LottoTicket;

import java.util.Collections;
import java.util.List;

public class OutputView {
    public static void printLottoTicket(LottoTicket lottoTicket) {
        int purchaseAmount = lottoTicket.getPurchasingAmount();
        List<List<Integer>> lottoNumbers = lottoTicket.getLottoNumbers();
        System.out.printf("%d개를 구매했습니다\n", purchaseAmount);
        for (List<Integer> number : lottoNumbers) {
            Collections.sort(number);
            System.out.println(number);
        }
    }
}
