package lotto.model.factory;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import lotto.model.LottoNumber;
import lotto.model.LottoPayment;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class LottoIssuer {
    private final int LOTTO_PRICE = 1000;
    public List<Lotto> issueLottos(LottoPayment payment) {
        List<Lotto> lottos = new ArrayList<>();
        int numberOfLottos = payment.caculateNumberOfLottos(LOTTO_PRICE);
        for(int i = 0; i < numberOfLottos; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            List<LottoNumber> lottoNumbers = numbers.stream().map(LottoNumber::new).collect(toList());
            lottos.add(new Lotto(lottoNumbers));
        }
        return lottos;
    }
}
