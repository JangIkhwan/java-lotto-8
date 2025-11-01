package lotto.model.judge;

public class Lotto2ndWinningCondition implements LottoWinningCondition {
    private final LottoRank rank = LottoRank.SECOND;
    @Override
    public boolean satisfy(int matchedCount, boolean bonusMatched) {
        return matchedCount == 5 & bonusMatched;
    }

    public LottoRank rank(){
        return rank;
    }
}
