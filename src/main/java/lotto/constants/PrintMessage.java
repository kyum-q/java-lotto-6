package lotto.constants;

public enum PrintMessage {
    PRINT_RANDOM_LOTTO_COUNT("개를 구매했습니다.");

    private String message;

    PrintMessage(String s) {
        message = s;
    }

    @Override
    public String toString() {
        return message;
    }
}
