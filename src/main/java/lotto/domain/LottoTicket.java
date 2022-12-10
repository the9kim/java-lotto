package lotto.domain;

import java.util.Collections;
import java.util.List;

public class LottoTicket {

    private static final int LOTTO_PRICE = 1000;
    private List<List<Integer>> lottoNumbers;
    private int purchasingMoney;

    private LottoTicket(List<List<Integer>> lottoNumbers, int purchasingMoney) {
        this.lottoNumbers = lottoNumbers;
        this.purchasingMoney = purchasingMoney;
    }

    public static LottoTicket of(List<List<Integer>> lottoNumbers, int purchasingMoney) {
        return new LottoTicket(lottoNumbers, purchasingMoney);
    }

    public List<List<Integer>> getLottoNumbers() {
        return List.copyOf(lottoNumbers);
    }

    public int getPurchasingMoney() {
        return purchasingMoney;
    }

    public int getPurchasingAmount() {
        return purchasingMoney / LOTTO_PRICE;
    }
}
