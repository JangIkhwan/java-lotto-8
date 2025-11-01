package lotto.model;

import lotto.model.judge.LottoJudge;
import lotto.model.judge.LottosResult;

public class LottoRunner {
    Lottos lottos;
    LottoIssuer lottoIssuer;

    public LottoRunner(LottoIssuer lottoIssuer){
        this.lottos = new Lottos();
        this.lottoIssuer = lottoIssuer;
    }

    public LottosStatus issueLottos(LottoPayment payment) {
        lottos.addAll(lottoIssuer.issueLottos(payment));
        return lottos.getStatus();
    }

    public LottosResult getResult(LottoWiningNumbers winningNumbers, LottoNumber bonusNumber, LottoPayment payment) {
        return lottos.checkWinning(new LottoJudge(winningNumbers, bonusNumber, payment));
    }
}
