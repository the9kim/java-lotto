package lotto.domain;

import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {

    private final List<Lotto> lottoTicket;
    private final int purchasingMoney;

    private LottoTicket(List<Lotto> lottoTicket, int purchasingMoney) {
        this.lottoTicket = lottoTicket;
        this.purchasingMoney = purchasingMoney;
    }

    public static LottoTicket of(List<List<Integer>> lottoTicket, int purchasingMoney) {
        List<Lotto> lottos = new ArrayList<>();
        for (List<Integer> lotto : lottoTicket) {
            lottos.add(Lotto.of(lotto));
        }
        return new LottoTicket(lottos, purchasingMoney);
    }
}
