package lotto.controller;

import lotto.model.Lottos;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    private InputView inputView;
    private OutputView outputView;
    private Lottos lottos;

    public LottoController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void start() {
        buyLotto();
        outputView.printLottos(lottos);
        requestPrizeLottoNumber();
        outputView.printPrizeResult(lottos);
        outputView.printPrizeAvg(lottos);
    }

    private void buyLotto() {
        int buyLottoPrice = inputView.requestBuyLottoPrice();
        lottos = new Lottos(buyLottoPrice);
    }

    private void requestPrizeLottoNumber() {
        List<Integer> prizeLotto = inputView.requestLottoNumbers();
        int bonus = inputView.requestBonusNumbers();


        lottos.setPrizeLotto(prizeLotto, bonus);
    }
}
