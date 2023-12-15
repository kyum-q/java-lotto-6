package lotto.constants;

public enum RequestMessage {
    REQUEST_BUY_PRICE("구입금액을 입력해 주세요."),
    REQUEST_LOTTO_NUMBERS("당첨 번호를 입력해 주세요."),
    REQUEST_BONUS_NUMBER("보너스 번호를 입력해 주세요.");

    private String message;
    RequestMessage(String s) {
        message = s;
    }

    @Override
    public String toString() {
        return message;
    }
}
