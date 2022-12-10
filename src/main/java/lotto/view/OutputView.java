package lotto.view;

import lotto.domain.LottoTicket;
import lotto.domain.Rank;
import lotto.domain.Result;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public static void printLottoTicket(LottoTicket lottoTicket) {
        int purchaseAmount = lottoTicket.getPurchasingAmount();
        List<List<Integer>> lottoNumbers = lottoTicket.getLottoNumbers();
        System.out.printf("%d개를 구매했습니다.\n", purchaseAmount);
        for (List<Integer> number : lottoNumbers) {
            System.out.println(number.stream().sorted().collect(Collectors.toList()));
        }
    }

    public static void printResult(Result result) {
        System.out.println("당첨통계\n---");
        for (Rank rank : result.getResultMap().keySet()) {
            if (rank.equals(Rank.ELSE)) {
                continue;
            }
            printWinner(rank, result);
        }
        System.out.printf("총 수익률은 %s입니다.", String.format("%.1f%%", result.getProfitRatio()));
    }

    private static void printWinner(Rank rank, Result result) {
        if (rank.equals(Rank.SECOND)) {
            System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개\n", rank.getWinningNumber()
                    , String.valueOf(rank.getPrize()).replaceAll("\\B(?=(\\d{3})+(?!\\d))", ","), result.getResultMap().get(rank));
            return;
        }
        System.out.printf("%d개 일치 (%s원) - %d개\n", rank.getWinningNumber()
                , String.valueOf(rank.getPrize()).replaceAll("\\B(?=(\\d{3})+(?!\\d))", ","), result.getResultMap().get(rank));
    }
}
