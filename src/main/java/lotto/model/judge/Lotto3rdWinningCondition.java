package lotto.model.judge;

public class Lotto3rdWinningCondition implements LottoWinningCondition {
    private final LottoRank rank = LottoRank.THIRD;
    @Override
    public boolean satisfy(int matchedCount, boolean bonusMatched) {
        return matchedCount == 5 && !bonusMatched;
    }

    public LottoRank rank(){
        return rank;
    }
}
