package lotto;

import lotto.domain.LottoNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<LottoNumber> numbers;

    private Lotto(List<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public static Lotto of(List<Integer> numbers) {
        List<LottoNumber> lotto = new ArrayList<>();
        for (Integer number : numbers) {
            lotto.add(LottoNumber.of(number));
        }
        return new Lotto(lotto);
    }
    public List<Integer> getSortedNumbers() {
        List<Integer> sortedNumbers = new ArrayList<>();
        for (LottoNumber number : numbers) {
            sortedNumbers.add(number.getLottoNumber());
        }
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }


    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

}
