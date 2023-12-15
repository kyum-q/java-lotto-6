package lotto.validator;

import lotto.constants.ErrorMessage;
import lotto.constants.LottoConstants;

public class BuyPriceValidator {
    private int price;
    private ErrorMessage errorMessage;

    private int lottoPrice;

    public BuyPriceValidator() {
        errorMessage = ErrorMessage.ERROR_BUY_PRICE;
        lottoPrice = LottoConstants.LOTTO_PRICE.getNum();
    }

    public boolean valid(String s) {
        return validNumber(s) && validLessMinLottoPrice() && validNotSplit();
    }

    private boolean validNumber(String s) {
        try {
            price = Integer.parseInt(s);
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    private boolean validLessMinLottoPrice() {
        try {
            if(price < lottoPrice) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    private boolean validNotSplit() {
        try {
            if(price % lottoPrice != 0) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return errorMessage.getMessage();
    }
}
