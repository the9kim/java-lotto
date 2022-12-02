package lotto.domain;

import lotto.Lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoTicket {

    private final List<Lotto> lottoTicket;
    private final Result result = new Result();
    private final int purchasingMoney;
    private final int purchasingAmount;

    private LottoTicket(List<Lotto> lottoTicket, int purchasingMoney, int purchasingAmount) {
        this.lottoTicket = lottoTicket;
        this.purchasingMoney = purchasingMoney;
        this.purchasingAmount = purchasingAmount;
    }

    public static LottoTicket of(List<List<Integer>> lottoTicket, int purchasingMoney, int purchasingAmount) {
        List<Lotto> lottos = new ArrayList<>();
        for (List<Integer> lotto : lottoTicket) {
            lottos.add(Lotto.RandomLotto(lotto));
        }
        return new LottoTicket(lottos, purchasingMoney, purchasingAmount);
    }

    public Result pickWinningNumber(Lotto winningLotto) {
        for (Lotto lotto : lottoTicket) {
            int winningCount = checkWinningCount(lotto, winningLotto);
            boolean isSecondWinner = isSecondWinner(lotto, winningLotto, winningCount);
            Rank rank = updateRank(winningCount, isSecondWinner);
            updateProfit(rank);
        }
        return result;
    }

    private int checkWinningCount(Lotto lotto, Lotto winningLotto) {
        Set<LottoNumber> commonNumber = new HashSet<>(winningLotto.getNumbers());
        commonNumber.retainAll(lotto.getNumbers());
        return commonNumber.size();
    }

    private boolean isSecondWinner(Lotto lotto, Lotto winningLotto, int winningCount) {
        if (winningCount == 5 && lotto.getNumbers().contains(winningLotto.getBonusNumber().getNumber())) {
            return true;
        }
        return false;
    }

    private Rank updateRank(int winningCount, boolean isSecondWinner) {
        Rank rank = Rank.getRankByWinningCount(winningCount, isSecondWinner);
        result.updateWinnerCount(rank);
        return rank;
    }

    private void updateProfit(Rank rank) {
        result.updatePrize(rank);
        result.updateProfitRatio(purchasingMoney);
    }

    public List<Lotto> getLottoTicket() {
        return List.copyOf(lottoTicket);
    }

    public int getPurchasingAmount() {
        return purchasingAmount;
    }
}
