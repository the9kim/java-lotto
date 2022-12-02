package lotto;

import lotto.domain.BonusNumber;
import lotto.domain.LottoNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Lotto {

    private final List<LottoNumber> numbers;
    private BonusNumber bonusNumber;

    private Lotto(List<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public static Lotto RandomLotto(List<Integer> numbers) {
        List<LottoNumber> lotto = new ArrayList<>();
        for (Integer number : numbers) {
            lotto.add(LottoNumber.randomNumber(number));
        }
        return new Lotto(lotto);
    }

    public static Lotto winningLotto(List<Integer> numbers) {
        List<LottoNumber> lotto = new ArrayList<>();
        validate(numbers);
        for (Integer number : numbers) {
            lotto.add(LottoNumber.winningNumber(number));
        }
        return new Lotto(lotto);
    }

    public void generateBonusNumber(int bonusNumber) {
        this.bonusNumber = BonusNumber.of(bonusNumber, numbers);
    }
    private static void validate(List<Integer> numbers) {
        validateSize(numbers);
        isDuplicated(numbers);
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private static void isDuplicated(List<Integer> numbers) {
        if (numbers.size() != Set.copyOf(numbers).size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 수는 입력할 수 없습니다.");
        }
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }

    public List<Integer> getSortedNumbers() {
        List<Integer> sortedNumbers = new ArrayList<>();
        for (LottoNumber number : numbers) {
            sortedNumbers.add(number.getLottoNumber());
        }
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }
}
