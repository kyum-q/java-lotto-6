package lotto.validator;

import lotto.constants.ErrorMessage;
import lotto.constants.LottoConstants;

import java.util.List;

public class BonusNumberValidator {

    private List<Integer> lottoNumbers;
    private int bonusNumber;
    private ErrorMessage errorMessage;
    private int minLottoNum, maxLottoNum;

    public BonusNumberValidator(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
        errorMessage = ErrorMessage.ERROR_LOTTO_NUMBERS;
        minLottoNum = LottoConstants.LOTTO_MIN_NUMBER.getNum();
        maxLottoNum = LottoConstants.LOTTO_MAX_NUMBER.getNum();
    }
    public boolean valid(String s) {
        return validNumber(s) && validLessMinOrOverMaxNumber()
                && validOverlapBonusNumbers();
    }

    private boolean validNumber(String s) {
        try {
            bonusNumber = Integer.parseInt(s);
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    private boolean validLessMinOrOverMaxNumber() {
        try {
            if(bonusNumber < minLottoNum || bonusNumber > maxLottoNum) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    private boolean validOverlapBonusNumbers() {
        try {
            if(lottoNumbers.stream().anyMatch(n -> n == bonusNumber)) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    public String toString() {
        return errorMessage.toString();
    }
}
