package lotto.domain;

import lotto.Lotto;
import lotto.view.OutputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketTest {

    @DisplayName("로또 티켓과 당첨 로또 번호를 비교하여 당첨자를 올바르게 파악한다.")
    @Test
    void pickWinningNumber() {
        List<Integer> firstRankNum = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> secondRankNum = List.of(1, 2, 3, 4, 5, 7);
        List<Integer> thirdRankNum = List.of(1, 2, 3, 4, 5, 8);
        List<Integer> fourthRankNum = List.of(1, 2, 3, 4, 9, 10);
        List<Integer> fifthRankNum = List.of(1, 2, 3, 11, 12, 13);
        List<Integer> loser1 = List.of(1,2,13,14,15,16);
        List<Integer> loser2 = List.of(1,12,13,14,15,16);
        List<Integer> loser3 = List.of(11,12,13,14,15,16);

        List<List<Integer>> ticketNumber = List.of(firstRankNum, secondRankNum,
                thirdRankNum, fourthRankNum, fifthRankNum, loser1, loser2, loser3);
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);
        Integer bonusNumber = 7;
        int purchasingPrice = 5000;
        int purchasingAmount = 5;

        LottoTicket lottoTicket = LottoTicket.of(ticketNumber, purchasingPrice, purchasingAmount);
        Lotto winningLotto = Lotto.winningLotto(winningNumber);
        winningLotto.generateBonusNumber(bonusNumber);

        Result result = lottoTicket.pickWinningNumber(winningLotto);

        assertThat(result).isInstanceOf(Result.class);

        System.out.println(result.getWinnerCounter());
        System.out.println(result.getAccumulatedPrize());
        OutputView.printWinningResult(result);

    }
}