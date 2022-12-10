package lotto.domain;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Result {

    private static final int DEFAULT_WINNER = 0;
    private static Map<Rank, Integer> resultMap = new LinkedHashMap<>();

    static {
        for (Rank rank : Rank.values()) {
            resultMap.put(rank, DEFAULT_WINNER);
        }
    }

    public void updateWinner(Rank rank, boolean isBonusNumber) {
        resultMap.put(rank, resultMap.get(rank) + 1);
    }

    public Map<Rank, Integer> getResultMap() {
        return resultMap;
    }
}
