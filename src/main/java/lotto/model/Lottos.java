package lotto.model;

import lotto.model.judge.LottoJudge;
import lotto.model.judge.LottosResult;

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

    public LottosStatus getStatus() {
        List<Lotto> copyedLottos = lottos.stream()
                .map(Lotto::new)
                .toList();
        return new LottosStatus(copyedLottos);
    }

    public LottosResult checkWinning(LottoJudge lottoJudge) {
        for(Lotto lotto : lottos){
            lottoJudge.check(lotto);
        }
        return lottoJudge.getResult();
    }
}
