package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoIssuer {
    private final int LOTTO_PRICE = 1000;
    public List<Lotto> issueLottos(LottoPayment payment) {
        List<Lotto> lottos = new ArrayList<>();
        int numberOfLottos = payment.caculateNumberOfLottos(LOTTO_PRICE);
        for(int i = 0; i < numberOfLottos; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }
}
