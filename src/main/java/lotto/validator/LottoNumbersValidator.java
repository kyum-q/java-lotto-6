package lotto.validator;

import lotto.constants.ErrorMessage;
import lotto.constants.LottoConstants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LottoNumbersValidator {
    private List<Integer> lottoNumbers;
    private ErrorMessage errorMessage;
    private int minLottoNum, maxLottoNum, lottoCount;

    public LottoNumbersValidator() {
        errorMessage = ErrorMessage.ERROR_LOTTO_NUMBERS;
        minLottoNum = LottoConstants.LOTTO_MIN_NUMBER.getNum();
        maxLottoNum = LottoConstants.LOTTO_MAX_NUMBER.getNum();
        lottoCount = LottoConstants.LOTTO_NUMBER_COUNT.getNum();
    }
    public boolean valid(String s) {
        return validNumbers(s) && validLessOrOverLottoCount()
                && validLessMinOrOverMaxNumbers() && validOverlapNumbers();
    }

    private boolean validNumbers(String s) {
        try {
            lottoNumbers = new ArrayList<>();
            Arrays.stream(s.split(",", -1))
                    .forEach(num -> lottoNumbers.add(Integer.parseInt(num)));
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    private boolean validLessOrOverLottoCount() {
        try {
            if(lottoNumbers.size() != lottoCount)
                throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    private boolean validLessMinOrOverMaxNumbers() {
        try {
            if(lottoNumbers.stream().anyMatch(this::checkLessMinOrOverMaxNumber)) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    private boolean checkLessMinOrOverMaxNumber(int n) {
        return n < minLottoNum || n > maxLottoNum;
    }

    private boolean validOverlapNumbers() {
        try {
            if(lottoNumbers.stream().distinct().count() != lottoCount) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return errorMessage.toString();
    }

    public List<Integer> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }
}
