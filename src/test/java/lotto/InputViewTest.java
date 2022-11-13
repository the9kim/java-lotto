package lotto;

import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;


import lotto.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {

    @Test
    @DisplayName("로또 당첨번호 입력값 ',' 제거")
    void revertInputToList() {
        String winningNumInput = "124,,123,4,12,3,1";

        List<String> winningNumList = InputView.revertInputToList(winningNumInput);

        assertThat(winningNumList).isEqualTo(Arrays.asList("124","","123","4","12","3","1"));
    }
}