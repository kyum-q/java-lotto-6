package lotto.constants;

public enum LottoConstants {
    LOTTO_PRICE(1_000),
    LOTTO_MIN_NUMBER(1),
    LOTTO_MAX_NUMBER(45),
    LOTTO_NUMBER_COUNT(6);

    private int num;
    LottoConstants(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    @Override
    public String toString() {
        return String.format("%,d", num);
    }
}
