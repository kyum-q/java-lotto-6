package lotto.model;

import lotto.constants.LottoConstant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        Collections.sort(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoConstant.LOTTO_SIZE.getConstant()) {
            throw new IllegalArgumentException();
        }
    }

    public int getComparePrizeNumSameSize(ArrayList<Integer> prizeNum, int bonusNum) {
        List<Integer> checkSameSize = (List<Integer>) prizeNum.clone();
        checkSameSize.add(bonusNum);

        checkSameSize.retainAll(numbers);

        if(checkSameSize.size() == numbers.size() && !checkSameSize.contains(bonusNum)) {
            return numbers.size()+1;
        }

        return checkSameSize.size();
    }

    @Override
    public String toString() {
         return numbers.toString();
    }
}
