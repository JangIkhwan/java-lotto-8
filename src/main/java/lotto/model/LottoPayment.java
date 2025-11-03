package lotto.model;

import static lotto.common.ErrorMessage.PAYMENT_IS_OUT_OF_RANGE;
import static lotto.common.ErrorMessage.PAYMENT_UNIT_IS_INVALID;

public class LottoPayment {
    private int amount;
    public LottoPayment(int amount) {
        if(amount < 0){
            throw new IllegalArgumentException(PAYMENT_IS_OUT_OF_RANGE.getMessage());
        }
        if(amount % 1000 != 0){
            throw new IllegalArgumentException(PAYMENT_UNIT_IS_INVALID.getMessage());
        }
        this.amount = amount;
    }

    public int caculateNumberOfLottos(int lottoPrice) {
        return amount / lottoPrice;
    }

    public int getValue() {
        return amount;
    }
}
