package lotto.model;

import lotto.constants.PrizeResult;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private int prizeCount;
    private boolean isBonusPrize;


    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public int checkPrize(List<Integer> prize, int bonus) {
        prizeCount = numbers.stream().mapToInt(n -> containCheck(prize, n)).sum();
        isBonusPrize = numbers.contains(bonus);

        if(isBonusPrize) prizeCount++;

        if(prizeCount == 6 && !isBonusPrize)
            return 4;
        return prizeCount - 3;
    }

    private int containCheck(List<Integer> prize, int n) {
        if(prize.contains(n))
            return 1;
        return 0;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
