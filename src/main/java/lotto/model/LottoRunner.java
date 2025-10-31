package lotto.model;

public class LottoRunner {
    Lottos lottos;
    LottoIssuer lottoIssuer;

    public LottoRunner(LottoIssuer lottoIssuer){
        this.lottos = new Lottos();
        this.lottoIssuer = lottoIssuer;
    }

    public void issueLottos(LottoPayment payment) {
        lottos.addAll(lottoIssuer.issueLottos(payment));
    }
}
