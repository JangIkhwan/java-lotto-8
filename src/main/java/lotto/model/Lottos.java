package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos(){
        lottos = new ArrayList<>();
    }

    public void addAll(List<Lotto> lottos) {
        this.lottos.addAll(lottos);
    }

    public LottoResult getResult(LottoWiningNumbers winningNumbers, LottoNumber bonusNumber, LottoWinningPolicy lottoWinningPolicy) {
        return null;
    }

    public LottosStatus getStatus() {
        List<Lotto> copyedLottos = lottos.stream()
                .map(Lotto::new)
                .toList();
        return new LottosStatus(copyedLottos);
    }

    public LottoResult checkWinning(LottoWiningNumbers winningNumbers, LottoNumber bonusNumber, LottoWinningPolicy lottoWinningPolicy) {
        return null;
    }
}
