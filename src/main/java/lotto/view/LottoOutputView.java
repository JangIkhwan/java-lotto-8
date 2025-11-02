package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottosStatus;
import lotto.model.judge.LottosResult;

import java.text.DecimalFormat;
import java.util.List;

public class LottoOutputView {
    public void printLottosStatus(LottosStatus lottosStatus) {
        List<Lotto> lottos = lottosStatus.getLottos();
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for(Lotto lotto : lottos){
            System.out.println(lotto.convertToString());
        }
    }

    public void printResult(LottosResult result) {
        for(LottosResult.ResultRow row : result.getRows()){
            String winnings = new DecimalFormat("#,##0").format(row.getWinnings());
            System.out.println(row.getCondition() + " (" + winnings +"원) - " + row.getCount() + "개");
        }
        System.out.printf("총 수익률은 %.1f%%입니다.", result.getRoi());
    }
}
