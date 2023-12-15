package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constants.LottoConstants;

import java.util.List;

public class NumberGenerator {
    public static List<Integer> createRandomNumber() {
        return Randoms.pickUniqueNumbersInRange(LottoConstants.LOTTO_MIN_NUMBER.getNum(), LottoConstants.LOTTO_MAX_NUMBER.getNum(),
                LottoConstants.LOTTO_NUMBER_COUNT.getNum());
    }
}
