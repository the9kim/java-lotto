package lotto.domain;

import java.util.List;

public class BonusNumber {

    LottoNumber bonusNumber;

    private BonusNumber(LottoNumber bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public static BonusNumber of(int bonusNumber, List<LottoNumber> winningNumbers) {
        LottoNumber bonusLottoNumber = LottoNumber.winningNumber(bonusNumber);
        isDuplicated(bonusLottoNumber, winningNumbers);
        return new BonusNumber(bonusLottoNumber);
    }

    private static void isDuplicated(LottoNumber bonusLottoNumber, List<LottoNumber> winningNumber) {
        if (winningNumber.contains(bonusLottoNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public LottoNumber getNumber() {
        return bonusNumber;
    }
}
