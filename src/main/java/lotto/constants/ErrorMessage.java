package lotto.constants;

public enum ErrorMessage {
    ERROR_BUY_PRICE("구입금액은 " + LottoConstants.LOTTO_PRICE.getNum() + "단위의 숫자여야 합니다.");

    private String message;
    ErrorMessage(String s) {
        message = s;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}
