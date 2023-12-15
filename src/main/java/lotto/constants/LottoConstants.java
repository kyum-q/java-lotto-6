package lotto.constants;

public enum LottoConstants {
    LOTTO_PRICE(1_000);

    private int num;
    LottoConstants(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }
}
