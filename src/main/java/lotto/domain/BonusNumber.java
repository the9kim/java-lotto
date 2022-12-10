package lotto.domain;

import lotto.Lotto;

public class BonusNumber {
    private final Lotto lotto;
    private final int bonusNumber;

    private BonusNumber(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public static BonusNumber of(Lotto lotto, int bonusNumber) {
        validateRange(bonusNumber);
        validateDuplication(lotto, bonusNumber);
        return new BonusNumber(lotto, bonusNumber);
    }

    private static void validateRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 1-45 범위를 벗어난 숫자입니다.");
        }
    }

    private static void validateDuplication(Lotto lotto, int bonusNumber) {
        if (lotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}
