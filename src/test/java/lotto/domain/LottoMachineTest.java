package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoMachineTest {

    @DisplayName("1,000원 이하의 금액을 입력하여 로또 티켓을 생성하면 예외가 발생한다.")
    @Test()
    void makeLottoTicketWithWrongRangeInput() {
        int inputMoney = 500;

        assertThatThrownBy(() -> {
            LottoMachine.makeLottoTicket(inputMoney);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1,000원 단위가 아닌 금액을 입력하여 로또 티켓을 생성하면 예외가 발생한다.")
    @Test
    void makeLottoTicketWithWrongUnit() {
        int inputMoney = 1500;

        assertThatThrownBy(() -> {
            LottoMachine.makeLottoTicket(inputMoney);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1000원 이상이고 1000원 단위인 금액을 입력하면 정상적으로 로또 티켓이 생성된다")
    @Test
    void makeLottoTicket() {
        int inputMoney = 5000;

        assertThat(LottoMachine.makeLottoTicket(inputMoney)).isInstanceOf(LottoTicket.class);
    }
}
