package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @DisplayName("1-45 범위를 벗어나는 정수가 입력되면 예외가 발생한다.")
    @Test
    void getLottoNumberWithOutOfRangeNumber() {
        Integer input = 0;

        assertThatThrownBy(() -> {
            LottoNumber.winningNumber(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}