package lotto.domain;

import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {

    private final List<Lotto> lottoTicket;
    private final int purchasingMoney;
    private final int purchasingAmount;

    private LottoTicket(List<Lotto> lottoTicket, int purchasingMoney, int purchasingAmount) {
        this.lottoTicket = lottoTicket;
        this.purchasingMoney = purchasingMoney;
        this.purchasingAmount = purchasingAmount;
    }

    public static LottoTicket of(List<List<Integer>> lottoTicket, int purchasingMoney, int purchasingAmount) {
        List<Lotto> lottos = new ArrayList<>();
        for (List<Integer> lotto : lottoTicket) {
            lottos.add(Lotto.of(lotto));
        }
        return new LottoTicket(lottos, purchasingMoney, purchasingAmount);
    }
}
