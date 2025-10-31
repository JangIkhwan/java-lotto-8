package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    List<Lotto> lottos;

    public Lottos(){
        lottos = new ArrayList<>();
    }

    public void addAll(List<Lotto> lottos) {
        lottos.addAll(lottos);
    }

    public LottoResult checkWinning(LottoWiningNumbers winningNumbers, Integer bonusNumber, LottoWinningPolicy lottoWinningPolicy) {
        return null;
    }
}
