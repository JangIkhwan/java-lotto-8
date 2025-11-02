package lotto.controller;

import lotto.model.*;
import lotto.model.judge.LottosResult;
import lotto.model.runner.LottoRunner;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class LottoController {
    private LottoInputView inputView;
    private LottoRunner lottoRunner;
    private LottoOutputView outputView;

    public LottoController(LottoInputView inputView, LottoRunner lottoRunner, LottoOutputView outputView) {
        this.inputView = inputView;
        this.lottoRunner = lottoRunner;
        this.outputView = outputView;
    }

    public void run() {
        LottoPayment payment = inputView.getPayment();
        LottosStatus lottosStatus = lottoRunner.issueLottos(payment);
        outputView.printLottosStatus(lottosStatus);
        LottoWiningNumbers winingNumbers = inputView.getWiningNumbers();
        LottoNumber bonusNumber = inputView.getBonusNumber(winingNumbers);
        LottosResult result = lottoRunner.getResult(winingNumbers, bonusNumber, payment);
        outputView.printResult(result);
    }
}
