package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIFTH(3, 5_000, false),
    FOURTH(4, 50_000, false),
    THIRD(5, 1_500_000, false),
    SECOND(5, 30_000_000, true),
    FIRST(6, 2_000_000_000, false),
    ELSE(0, 0, false);

    int winningNumber;
    int prize;
    boolean isBonusNumber;

    Rank(int winningNumber, int prize, boolean isBonusNumber) {
        this.winningNumber = winningNumber;
        this.prize = prize;
        this.isBonusNumber = isBonusNumber;
    }

    public static Rank findBy(int winningNumber, boolean isBonusNumber) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.winningNumber == winningNumber && rank.isBonusNumber == isBonusNumber)
                .findAny()
                .orElse(Rank.ELSE);
    }

    public int getWinningNumber() {
        return winningNumber;
    }

    public int getPrize() {
        return prize;
    }
}
