package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constants.RequestMessage;
import lotto.validator.BonusNumberValidator;
import lotto.validator.BuyPriceValidator;
import lotto.validator.LottoNumbersValidator;

import java.util.List;

public class InputView {

    BuyPriceValidator priceValidator;
    LottoNumbersValidator lottoValidator;
    BonusNumberValidator bonusValidator;

    public int requestBuyLottoPrice() {
        priceValidator = new BuyPriceValidator();

        System.out.println(RequestMessage.REQUEST_BUY_PRICE);
        String input = Console.readLine();

        while(!priceValidator.valid(input)) {
            System.out.println(priceValidator);
            input = Console.readLine();
        }

        return Integer.parseInt(input);
    }

    public List<Integer> requestLottoNumbers() {
        lottoValidator = new LottoNumbersValidator();

        System.out.println(RequestMessage.REQUEST_LOTTO_NUMBERS);
        String input = Console.readLine();

        while(!lottoValidator.valid(input)) {
            System.out.println(lottoValidator);
            input = Console.readLine();
        }

        return lottoValidator.getLottoNumbers();
    }

    public int requestBonusNumbers() {
        bonusValidator = new BonusNumberValidator(lottoValidator.getLottoNumbers());

        System.out.println(RequestMessage.REQUEST_BONUS_NUMBER);
        String input = Console.readLine();

        while(!bonusValidator.valid(input)) {
            System.out.println(bonusValidator);
            input = Console.readLine();
        }

        return Integer.parseInt(input);
    }
}
