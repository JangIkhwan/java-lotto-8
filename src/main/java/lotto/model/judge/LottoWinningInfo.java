package lotto.model.judge;

public enum LottoWinningInfo {
    FIFTH(LottoRank.FIFTH, "3개 일치", 5000),
    FOURTH(LottoRank.FOURTH, "4개 일치", 50000),
    THIRD(LottoRank.THIRD, "5개 일치", 1500000),
    SECOND(LottoRank.SECOND, "5개 일치, 보너스 볼 일치", 30000000),
    FIRST(LottoRank.FIRST, "6개 일치", 2000000000);

    private final LottoRank rank;
    private final String condition;
    private final long winnings;

    LottoWinningInfo(LottoRank rank, String condition, long winnings) {
        this.rank = rank;
        this.condition = condition;
        this.winnings = winnings;
    }

    public LottoRank getRank() {
        return rank;
    }

    public String getCondition() {
        return condition;
    }

    public long getWinnings() {
        return winnings;
    }
}
