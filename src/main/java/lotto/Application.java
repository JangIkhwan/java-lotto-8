package lotto;

import lotto.controller.LottoController;
import lotto.model.factory.LottoIssuer;
import lotto.model.runner.LottoRunner;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class Application {
    public static void main(String[] args) {
        LottoInputView inputView = new LottoInputView();
        LottoOutputView outputView = new LottoOutputView();
        LottoRunner lottoRunner = new LottoRunner(new LottoIssuer());
        LottoController controller = new LottoController(inputView, lottoRunner, outputView);
        controller.run();
    }
}
