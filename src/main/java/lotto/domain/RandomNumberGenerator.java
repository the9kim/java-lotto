package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator implements LottoGenerator{

    @Override
    public List<Integer> generate() {
        List<Integer> lottoNumber = new ArrayList<>();
        lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return lottoNumber;
    }
}
