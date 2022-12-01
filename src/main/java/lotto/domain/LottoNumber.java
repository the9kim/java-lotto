package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoNumber {

    private static final int START_LOTTO_NUM = 1;
    private static final int END_LOTTO_NUM = 45;
    private Integer lottoNumber;

    private static Map<Integer, LottoNumber> lottoNumberCache = new HashMap<>();

    static {
        for (int num = START_LOTTO_NUM; num <= END_LOTTO_NUM; num++) {
            lottoNumberCache.put(num, new LottoNumber(num));
        }
    }

    private LottoNumber(Integer lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber of(Integer lottoNumber) {
        return lottoNumberCache.get(lottoNumber);
    }

    public Integer getLottoNumber() {
        return lottoNumber;
    }
}
