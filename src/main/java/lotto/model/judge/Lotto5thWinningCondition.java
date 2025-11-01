package lotto.model.judge;

public class Lotto5thWinningCondition implements LottoWinningCondition {
    private final LottoRank rank = LottoRank.FIFTH;
    @Override
    public boolean satisfy(int matchedCount, boolean bonusMatched) {
        return matchedCount == 3;
    }

    public LottoRank rank(){
        return rank;
    }
}
