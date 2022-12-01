package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoNumber {

    private static final int MIN_LOTTO_NUM = 1;
    private static final int MAX_LOTTO_NUM = 45;
    private Integer lottoNumber;

    private static Map<Integer, LottoNumber> lottoNumberCache = new HashMap<>();

    static {
        for (int num = MIN_LOTTO_NUM; num <= MAX_LOTTO_NUM; num++) {
            lottoNumberCache.put(num, new LottoNumber(num));
        }
    }

    private LottoNumber(Integer lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber of(Integer lottoNumber) {
        validateRange(lottoNumber);
        return lottoNumberCache.get(lottoNumber);
    }

    private static void validateRange(Integer lottoNumber) {
        if (lottoNumber < MIN_LOTTO_NUM || lottoNumber > MAX_LOTTO_NUM) {
            throw new IllegalArgumentException("[ERROR] 1-45까지 숫자만 입력가능합니다.");
        }
    }

    public Integer getLottoNumber() {
        return lottoNumber;
    }
}
