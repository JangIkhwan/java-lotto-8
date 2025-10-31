package lotto.model;

public class LottoPayment {
    private int amount;
    public LottoPayment(int amount) {
        if(amount < 0){
            throw new IllegalArgumentException("구매 금액은 음수일 수가 없습니다.");
        }
        if(amount % 1000 != 0){
            throw new IllegalArgumentException("구매 금액은 1000원 단위로 나누어 떨어져야 합니다.");
        }
        this.amount = amount;
    }

    public int caculateNumberOfLottos(int lottoPrice) {
        return amount / lottoPrice;
    }
}
