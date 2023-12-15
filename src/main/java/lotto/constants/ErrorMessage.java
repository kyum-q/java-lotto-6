package lotto.constants;

public enum ErrorMessage {
    ERROR_BUY_PRICE("구입금액은 " + LottoConstants.LOTTO_PRICE + " 단위의 숫자여야 합니다."),
    ERROR_LOTTO_NUMBERS("로또 번호는 "+ LottoConstants.LOTTO_MIN_NUMBER + "부터 "
            + LottoConstants.LOTTO_MAX_NUMBER + " 사이의 서로 다른 "+ LottoConstants.LOTTO_NUMBER_COUNT +"개의 숫자여야 합니다."),
    ERROR_BONUS_NUMBER("보너스 번호는 "+ LottoConstants.LOTTO_MIN_NUMBER + "부터 "
            + LottoConstants.LOTTO_MAX_NUMBER + " 사이의 숫자여야 합니다.");

    private String message;
    ErrorMessage(String s) {
        message = s;
    }

    @Override
    public String toString() {
        return "[ERROR] " + message;
    }
}
