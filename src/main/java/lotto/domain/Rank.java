package lotto.domain;

public enum Rank {
    LOSER(0, false, 0),
    FIFTH(3, false, 5000),
    FOURTH(4, false, 50000),
    THIRD(5, false, 1500000),
    SECOND(5, true, 30000000),
    FIRST(6, false, 2000000000);


    int winningCount;
    boolean bonusNumber;
    int prize;

    Rank(int winningCount, boolean bonusNumber, int prize) {
        this.winningCount = winningCount;
        this.bonusNumber = bonusNumber;
        this.prize = prize;
    }

    public static Rank getRankByWinningCount(int winningCount, boolean isSecondWinner) {
        for (Rank rank : Rank.values()) {
            if (rank.winningCount == winningCount && rank.bonusNumber == isSecondWinner) {
                return rank;
            }
        }
        return LOSER;
    }

    public int getWinningCount() {
        return winningCount;
    }

    public int getPrize() {
        return prize;
    }
}
