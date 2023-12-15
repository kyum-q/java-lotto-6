package lotto.constants;

public enum PrizeResult {
    PRIZE_5("3개 일치", 5_000),
    PRIZE_4("4개 일치", 50_000),
    PRIZE_3("5개 일치", 1_500_000),

    PRIZE_2("5개 일치, 보너스 볼 일치", 30_000_000),

    PRIZE_1("6개 일치", 2_000_000_000);

    private String message;
    private int price;
    PrizeResult(String s, int num) {
        message = s;
        price = num;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return message + " (" + String.format("%,d", price) + "원)";
    }
}
