package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    List<List<Integer>> lottoTicket = new ArrayList<>();
    public static LottoTicket makeTicket(int purchasingMoney) {
        validate(purchasingMoney);
    }

    private static void validate(int purchasingMoney) {
        validateRange(purchasingMoney);
        validateUnit(purchasingMoney);
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
