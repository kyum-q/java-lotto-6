package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constants.RequestMessage;
import lotto.validator.BuyPriceValidator;

public class InputView {
    public int requestBuyLottoPrice() {
        BuyPriceValidator validator = new BuyPriceValidator();

        System.out.println(RequestMessage.REQUEST_BUY_PRICE.getMessage());
        String input = Console.readLine();

        while(!validator.valid(input)) {
            System.out.println(validator);
            input = Console.readLine();
        }

        return Integer.parseInt(input);
    }
}
