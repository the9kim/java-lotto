package lotto;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

import lotto.domain.RandomLottoNumber;
import lotto.util.RandomUtil;
import lotto.view.OutputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputViewTest {

    @Test
    @DisplayName("로또 생성값 출력")
    void purchaseResultMsg() {

        String inputMoney = "6000";
        int countFromMoney = 6;

        List<RandomLottoNumber> lottoNumbers = RandomUtil.getLottoNumbers(inputMoney);
        OutputView.purchaseResultMsg(lottoNumbers, countFromMoney);
    }
}