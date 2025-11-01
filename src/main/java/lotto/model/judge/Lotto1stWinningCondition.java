package lotto.model.judge;

public class Lotto1stWinningCondition implements LottoWinningCondition {
    private final LottoRank rank = LottoRank.FIRST;
    @Override
    public boolean satisfy(int matchedCount, boolean bonusMatched) {
        return matchedCount == 6;
    }

    public LottoRank rank(){
        return rank;
    }
}
