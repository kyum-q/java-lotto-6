package lotto.model;

import lotto.constants.LottoConstants;
import lotto.constants.PrintMessage;
import lotto.constants.PrizeResult;

import java.util.*;

public class Lottos {
    private List<Lotto> lottos;
    private List<Integer> prizeLotto;
    private int bonusLotto;
    private int lottoCount;

    private int [] prizeCount;

    public Lottos(int buyPrice) {
        lottoCount = buyPrice / LottoConstants.LOTTO_PRICE.getNum();
        settingLottos();
    }

    private void settingLottos() {
        lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(NumberGenerator.createRandomNumber()));
        }
    }

    public void setPrizeLotto(List<Integer> prizeLotto, int bonusLotto) {
        this.prizeLotto = prizeLotto;
        this.bonusLotto = bonusLotto;

        checkPrizeResult();
    }

    private void checkPrizeResult() {
        prizeCount = new int[PrizeResult.values().length];
        for (int i = 0; i < lottoCount; i++) {
            int result = lottos.get(i).checkPrize(prizeLotto, bonusLotto);
            if(result >= 0)
               prizeCount[result]++;
        }
    }

    public double getAvgPrize() {
        double sum = 0;
        PrizeResult[] values = PrizeResult.values();
        for (int i = 0; i < values.length; i++) {
            sum += values[i].getPrice() * prizeCount[i];
        }

        return sum / (lottoCount * LottoConstants.LOTTO_PRICE.getNum()) * 100;
    }

    public String printPrize() {
        String result = "";
        PrizeResult[] values = PrizeResult.values();
        for (int i = 0; i < values.length; i++) {
            result += values[i].toString() + " - " + prizeCount[i] + "개\n";
        }
        return result;
    }

    @Override
    public String toString() {
        String result = lottoCount + PrintMessage.PRINT_RANDOM_LOTTO_COUNT.toString() + "\n";
        for (int i = 0; i < lottoCount; i++) {
            result += lottos.get(i).toString() + "\n";
        }

        return result;
    }
}
