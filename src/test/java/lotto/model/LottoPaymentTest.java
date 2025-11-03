package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.common.ErrorMessage.PAYMENT_IS_OUT_OF_RANGE;
import static lotto.common.ErrorMessage.PAYMENT_UNIT_IS_INVALID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoPaymentTest {

    @DisplayName("로또 구입 금액 생성에 성공한다")
    @Test
    void shouldCreateLottoPayment() {
        // given
        int amount = 2000;

        // when & then
        assertDoesNotThrow(() -> new LottoPayment(amount));
    }

    @DisplayName("로또 구입 금액이 음수면 예외를 발생시킨다")
    @Test
    void shouldThrowExceptionWhenAmountIsOutOfRange(){
        // given
        int amount = -1;

        // when & then
        assertThatThrownBy(() -> new LottoPayment(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(PAYMENT_IS_OUT_OF_RANGE.getMessage());
    }

    @DisplayName("로또 구입 금액이 1000으로 나누어 떨어지지 않으면 예외를 발생시킨다")
    @Test
    void shouldThrowExceptionWhenAmountIsNotDividedBy1000(){
        // given
        int amount = 200;

        // when & then
        assertThatThrownBy(() -> new LottoPayment(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(PAYMENT_UNIT_IS_INVALID.getMessage());
    }

    @DisplayName("로또 개수 계산에 성공한다")
    @Test
    void shouldCalculateNumberOfLotto(){
        // given
        int payment = 20000;
        LottoPayment lottoPayment = new LottoPayment(payment);
        int lottoPrice = 1000;

        // when
        int number = lottoPayment.caculateNumberOfLottos(lottoPrice);

        // then
        assertThat(number).isEqualTo(payment / lottoPrice);
    }
}