package lotto.model;

import lotto.constants.LottoConstants;
import lotto.constants.PrintMessage;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private List<Lotto> lottos;
    private int lottoCount;
    public Lottos(int buyPrice) {
        lottoCount = buyPrice / LottoConstants.LOTTO_PRICE.getNum();

        settingLottos();
    }

    private void settingLottos() {
        lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(getRandomLottoNum()));
        }
    }

    private List<Integer> getRandomLottoNum() {
        List<Integer> numbers = new ArrayList<>();
        int lottoCount = LottoConstants.LOTTO_NUMBER_COUNT.getNum();
        for (int i = 0; i < lottoCount; i++) {
            int num;
            do {
                num = NumberGenerator.createRandomNumber();
            }while(numbers.contains(num));

            numbers.add(num);
        }

        return numbers;
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
