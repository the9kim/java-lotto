package lotto;

import lotto.domain.BonusNumber;
import lotto.domain.LottoTicket;
import lotto.domain.Rank;
import lotto.domain.Result;

import java.util.List;

public class Lotto {

    private static final int BONUS_COUNT = 5;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplication(numbers);

    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6자리 숫자가 아닙니다.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 1-45 범위를 벗어난 숫자입니다.");
            }
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        for (int i = 0; i < numbers.size() - 1; i++) {
            if (numbers.subList(i + 1, numbers.size()).contains(numbers.get(i))) {
                throw new IllegalArgumentException("[ERROR] 중복 숫자는 입력할 수 없습니다.");
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Result checkWinner(LottoTicket lottoTicket, BonusNumber bonusNumber, Result result) {
        for (List<Integer> lottoNumber : lottoTicket.getLottoNumbers()) {
            int winningCount = getCount(lottoNumber);
            boolean isBonusNumber = checkBonusNumber(lottoNumber, winningCount, bonusNumber);
            result.updateWinner(Rank.findBy(winningCount, isBonusNumber));
            result.updateProfitRatio(Rank.findBy(winningCount, isBonusNumber), lottoTicket.getPurchasingMoney());
        }
        return result;
    }


    private int getCount(List<Integer> lottoNumber) {
        int winningCount = 0;
        for (Integer number : numbers) {
            if (lottoNumber.contains(number)) {
                winningCount++;
            }
        }
        return winningCount;
    }

    private boolean checkBonusNumber(List<Integer> lottoNumber, int winningCount, BonusNumber bonusNumber) {
        if (winningCount == BONUS_COUNT && lottoNumber.contains(bonusNumber.getBonusNumber())) {
            return true;
        }
        return false;
    }

// TODO: 추가 기능 구현
}
