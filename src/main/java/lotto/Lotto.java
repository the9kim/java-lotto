package lotto;

import java.util.List;

public class Lotto {
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
        for (int i = 0; i < numbers.size()-1; i++) {
            if (numbers.subList(i + 1, numbers.size()).contains(numbers.get(i))) {
                throw new IllegalArgumentException("[ERROR] 중복 숫자는 입력할 수 없습니다.");
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

// TODO: 추가 기능 구현
}
