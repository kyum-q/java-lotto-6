package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constants.RequestMessage;
import lotto.validator.BuyPriceValidator;
import lotto.validator.LottoNumbersValidator;

import java.util.List;

public class InputView {
    public int requestBuyLottoPrice() {
        BuyPriceValidator validator = new BuyPriceValidator();

        System.out.println(RequestMessage.REQUEST_BUY_PRICE);
        String input = Console.readLine();

        while(!validator.valid(input)) {
            System.out.println(validator);
            input = Console.readLine();
        }

        return Integer.parseInt(input);
    }

    public List<Integer> requestLottoNumbers() {
        LottoNumbersValidator validator = new LottoNumbersValidator();

        System.out.println(RequestMessage.REQUEST_LOTTO_NUMBERS);
        String input = Console.readLine();

        while(!validator.valid(input)) {
            System.out.println(validator);
            input = Console.readLine();
        }

        return validator.getLottoNumbers();
    }
}
