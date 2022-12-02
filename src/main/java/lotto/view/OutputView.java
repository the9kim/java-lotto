package lotto.view;

import lotto.Lotto;
import lotto.domain.LottoTicket;
import lotto.domain.Rank;
import lotto.domain.Result;

public class OutputView {

    public static void printLottoTicket(LottoTicket lottoTicket) {
        printLottoPurchasingAmount(lottoTicket);
        printLotto(lottoTicket);
    }

    private static void printLottoPurchasingAmount(LottoTicket lottoTicket) {
        System.out.printf("%s개 구매했습니다.\n", lottoTicket.getPurchasingAmount());
    }

    private static void printLotto(LottoTicket lottoTicket) {
        for (Lotto lotto : lottoTicket.getLottoTicket()) {
            System.out.println(lotto.getSortedNumbers());
        }
    }

    public static void printWinningResult(Result result) {
        StringBuilder stringBuilder = new StringBuilder();
        addBasicFormat(stringBuilder);
        addWinners(stringBuilder, result);
        addProfitRatio(stringBuilder, result);

        System.out.println(stringBuilder);
    }

    private static void addBasicFormat(StringBuilder stringBuilder) {
        stringBuilder.append("당첨 통계\n---\n");
    }

    private static void addWinners(StringBuilder stringBuilder, Result result) {
        for (Rank rank : result.getWinnerCounter().keySet()) {
            addWinningCount(stringBuilder, rank);
            addSecondWinnerComment(stringBuilder, rank);
            addPrize(stringBuilder, rank);
            addWinnerCount(stringBuilder, rank, result);
        }
    }

    private static void addWinningCount(StringBuilder stringBuilder, Rank rank) {
        stringBuilder.append(String.format("%d개 일치", rank.getWinningCount()));
    }

    private static void addSecondWinnerComment(StringBuilder stringBuilder, Rank rank) {
        if (rank == Rank.SECOND) {
            stringBuilder.append(", 보너스 볼 일치");
        }
    }

    private static void addPrize(StringBuilder stringBuilder, Rank rank) {
        stringBuilder.append(String.format(" (%,d원)", rank.getPrize()));
    }

    private static void addWinnerCount(StringBuilder stringBuilder,Rank rank, Result result) {
        stringBuilder.append(String.format(" - %,d개\n", result.getWinnerCounter().get(rank)));
    }

    private static void addProfitRatio(StringBuilder stringBuilder, Result result) {
        stringBuilder.append(String.format("총 수익률은 %,.1f%%입니다.", result.getProfitRatio()));
    }
}
