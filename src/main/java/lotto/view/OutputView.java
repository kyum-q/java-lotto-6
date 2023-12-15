package lotto.view;

import lotto.constants.PrintMessage;
import lotto.model.Lottos;

public class OutputView {
    public void printLottos(Lottos lottos) {
        System.out.println(lottos.toString());
    }

    public void printPrizeResult(Lottos lottos) {
        System.out.println(PrintMessage.PRINT_RESULT_PRIZE);
        System.out.print(lottos.printPrize());
    }

    public void printPrizeAvg(Lottos lottos) {
        System.out.println("총 수익률은 " + String.format("%.1f",lottos.getAvgPrize()) + "%입니다.");
    }
}
