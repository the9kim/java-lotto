package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {


    private static final int LOTTO_PRICE = 1000;
    private static LottoGenerator lottoGenerator;
    private static List<List<Integer>> lottoTicket = new ArrayList<>();

    public static LottoTicket makeTicket(int purchasingMoney) {
        validate(purchasingMoney);
        generateRandomNumber(purchasingMoney);
        return LottoTicket.of(lottoTicket, purchasingMoney);
    }

    private static void validate(int purchasingMoney) {
        validateRange(purchasingMoney);
        validateUnit(purchasingMoney);
    }

    private static void generateRandomNumber(int purchasingMoney) {
        int purchasingAmount = purchasingMoney / LOTTO_PRICE;
        lottoGenerator = new RandomNumberGenerator();
        for (int amount = 0; amount < purchasingAmount; amount++) {
            List<Integer> lottoNumber = lottoGenerator.generate();
            lottoTicket.add(lottoNumber);
        }

    }

    private static void validateRange(int purchasingMoney) {
        if (purchasingMoney < 1000) {
            throw new IllegalArgumentException("[ERROR] 1000원 미만 정수는 입력할 수 없습니다.");
        }
    }

    private static void validateUnit(int purchasingMoney) {
        if (purchasingMoney % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위 정수만 입력 가능합니다.");
        }
    }
}
