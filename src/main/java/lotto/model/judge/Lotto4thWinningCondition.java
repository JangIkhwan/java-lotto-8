package lotto.model.judge;

public class Lotto4thWinningCondition implements LottoWinningCondition {
    private final LottoRank rank = LottoRank.FOURTH;
    @Override
    public boolean satisfy(int matchedCount, boolean bonusMatched) {
        return matchedCount == 4;
    }

    public LottoRank rank(){
        return rank;
    }
}
