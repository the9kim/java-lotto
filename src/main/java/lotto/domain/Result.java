package lotto.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class Result {

    private static Map<Rank, Integer> winnerCounter = new LinkedHashMap<>();
    private static int accumulatedPrize;
    private static double profitRatio;
    private static final int DEFAULT_COUNT = 0;

    static {
        for (Rank rank : Rank.values()) {
            winnerCounter.put(rank, DEFAULT_COUNT);
        }
    }

    public void updateWinnerCount(Rank rank) {
        winnerCounter.put(rank, winnerCounter.get(rank)+1);
    }

    public void updatePrize(Rank rank) {
        accumulatedPrize += rank.prize;
    }

    public Map<Rank, Integer> getWinnerCounter() {
        return winnerCounter;
    }

    public int getAccumulatedPrize() {
        return accumulatedPrize;
    }

    public void updateProfitRatio(int purchasingMoney) {
        profitRatio = purchasingMoney / accumulatedPrize * 100;
    }

    public double getProfitRatio() {
        return profitRatio;
    }
}
