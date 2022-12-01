package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> Lotto.winningLotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> Lotto.winningLotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 정상적으로 입력되면 로또 번호 객체가 생성된다")
    @Test
    void createLotto() {
        Lotto lotto = Lotto.winningLotto(List.of(1, 2, 3, 6, 5, 4));

        assertThat(lotto.getSortedNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("보너스 번호가 로또 번호와 중복되면 예외가 발생한다.")
    @Test
    void createdBonusNumberByDuplicatedWinningNumber() {
        Lotto winningLotto = Lotto.winningLotto(List.of(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(() -> {
            winningLotto.generateBonusNumber(6);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호를 로또 번호와 중복되지 않게 입력하면 보너스 넘버 객체가 정상적으로 생성된다.")
    @Test
    void createBonusNumber() {
        Lotto winningLotto = Lotto.winningLotto(List.of(1, 2, 3, 4, 5, 6));

        winningLotto.generateBonusNumber(7);

        assertThat(winningLotto.getBonusNumber().getNumber().getLottoNumber()).isEqualTo(7);
    }
}
