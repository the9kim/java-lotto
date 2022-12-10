package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIFTH(3, 5000, false),
    FOURTH(4, 50000, false),
    THIRD(5, 1500000, false),
    SECOND(5, 30000000, true),
    FIRST(6, 2000000000, false),
    Else(0, 0, false);

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
                .orElse(Rank.Else);
    }

    public int getPrize() {
        return prize;
    }
}
