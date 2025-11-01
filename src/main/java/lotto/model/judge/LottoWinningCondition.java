package lotto.model.judge;

public interface LottoWinningCondition {
    boolean satisfy(int matchedCount, boolean bonusMatched);

    LottoRank rank();
}
