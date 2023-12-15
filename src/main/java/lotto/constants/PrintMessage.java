package lotto.constants;

public enum PrintMessage {
    PRINT_RANDOM_LOTTO_COUNT("개를 구매했습니다."),
    PRINT_RESULT_PRIZE("당첨 통계\n---");

    private String message;

    PrintMessage(String s) {
        message = s;
    }

    @Override
    public String toString() {
        return message;
    }
}
