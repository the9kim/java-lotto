package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoMachine {

    private static final int START_LOTTO_NUM = 1;
    private static final int END_LOTTO_NUM = 45;
    private static final int LOTTO_SIZE = 6;

    private static List<List<Integer>> lottoTicket = new ArrayList<>();

    public static LottoTicket makeLottoTicket(int purchasingMoney) {
        validateMoney(purchasingMoney);
        int purchasingAmount = convertMoneyToAmount(purchasingMoney);
        generateLottoTicket(purchasingAmount);
        return LottoTicket.of(lottoTicket, purchasingMoney);
    }

    private static void validateMoney(int purchasingMoney) {
        validateRange(purchasingMoney);
        validateUnit(purchasingMoney);
    }

    private static void validateRange(int purchasingMoney) {
        if (purchasingMoney < 1000) {
            throw new IllegalArgumentException("[ERROR] 1000원 이하의 금액은 입력할 수 없습니다.");
        }
    }

    private static void validateUnit(int purchasingMoney) {
        if (purchasingMoney % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로만 구입 가능합니다.");
        }
    }

    private static int convertMoneyToAmount(int purchasingMoney) {
        int purchasingAmount = purchasingMoney / 1000;
        return purchasingAmount;
    }

    private static void generateLottoTicket(int purchasingAmount) {
        for (int i = 0 ; i < purchasingAmount; i++) {
            lottoTicket.add(generateRandomNumber());
        }
    }

    private static List<Integer> generateRandomNumber() {
        List<Integer> randomNumber = Randoms.pickUniqueNumbersInRange(START_LOTTO_NUM, END_LOTTO_NUM, LOTTO_SIZE);
        return randomNumber;
    }
}
