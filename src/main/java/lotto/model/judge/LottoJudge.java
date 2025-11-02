package lotto.model.judge;

import lotto.model.Lotto;
import lotto.model.LottoNumber;
import lotto.model.LottoPayment;
import lotto.model.LottoWiningNumbers;

import java.util.ArrayList;
import java.util.List;

public class LottoJudge {
    private LottoWiningNumbers winningNumbers;
    private LottoNumber bonusNumber;
    private List<LottoWinningCondition> winningConditions;
    private int[] rankCount;
    private LottoPayment payment;

    public LottoJudge(LottoWiningNumbers winningNumbers, LottoNumber bonusNumber, LottoPayment payment) {
        if(winningNumbers == null || bonusNumber == null || payment == null){
            throw new IllegalArgumentException("[ERROR] 인자는 null일 수 없습니다");
        }
        winningNumbers.validateBonusNumber(bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        initWinningConditions();
        rankCount = new int[6];
        this.payment = payment;
    }

    private void initWinningConditions() {
        this.winningConditions = new ArrayList<>();
        winningConditions.add(new Lotto5thWinningCondition());
        winningConditions.add(new Lotto4thWinningCondition());
        winningConditions.add(new Lotto3rdWinningCondition());
        winningConditions.add(new Lotto2ndWinningCondition());
        winningConditions.add(new Lotto1stWinningCondition());
    }

    public LottoRank check(Lotto lotto) {
        if(lotto == null){
            throw new IllegalArgumentException("[ERROR] 인자는 null일 수 없습니다");
        }
        int matchedCount = lotto.matchWinningNumber(winningNumbers);
        boolean bonusMatched = lotto.matchBonusNumber(bonusNumber);
        for(LottoWinningCondition condition : winningConditions){
            if(condition.satisfy(matchedCount, bonusMatched)){
                rankCount[condition.rank().getValue()]++;
                return condition.rank();
            }
        }
        return LottoRank.LOSE;
    }

    public LottosResult getResult(){
        LottosResult lottosResult = new LottosResult();
        int profit = 0;
        for(LottoWinningInfo rank : LottoWinningInfo.values()){
            lottosResult.addRow(rank.getCondition(), rank.getWinnings(), rankCount[rank.getRank().getValue()]);
            profit += rankCount[rank.getRank().getValue()] * rank.getWinnings();
        }
        lottosResult.setRoi((double) (profit * 100) / payment.getValue());
        return lottosResult;
    }
}
