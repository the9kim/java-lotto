package lotto.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class Result {

    private static final int DEFAULT_WINNER = 0;
    private int accumulatedPrize;
    private double profitRatio;
    private static Map<Rank, Integer> resultMap = new LinkedHashMap<>();

    static {
        for (Rank rank : Rank.values()) {
            resultMap.put(rank, DEFAULT_WINNER);
        }
    }

    public void updateWinner(Rank rank) {
        resultMap.put(rank, resultMap.get(rank) + 1);
    }

    public void updateProfitRatio(Rank rank, int purchasingMoney) {
        accumulatedPrize += rank.getPrize();
        profitRatio = (double) accumulatedPrize / (double) purchasingMoney * 100;

    }

    public Map<Rank, Integer> getResultMap() {
        return resultMap;
    }

    public double getProfitRatio() {
        return profitRatio;
    }
}
