package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constants.LottoConstants;

public class NumberGenerator {
    public static int createRandomNumber() {
        return Randoms.pickNumberInRange(LottoConstants.LOTTO_MIN_NUMBER.getNum(), LottoConstants.LOTTO_MAX_NUMBER.getNum());
    }
}
