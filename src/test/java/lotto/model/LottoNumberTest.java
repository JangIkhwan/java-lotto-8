package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumberTest {
    @DisplayName("로또번호 생성에 성공한다")
    @Test
    void shouldCreateLottoNumber(){
        // given
        int number = 1;

        // when & then
        assertDoesNotThrow(() -> new LottoNumber(number));
    }

    @DisplayName("로또번호 범위를 벗어나면 예외가 발생한다.")
    @Test
    void shouldThrowExceptionWhenNumberIsOutOfRange(){
        // given
        int number1 = -1;
        int number2 = 46;

        // when & then
        assertThatThrownBy(() -> new LottoNumber(number1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new LottoNumber(number2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("값이 같으면 로또 번호는 동등하다")
    @Test
    void shouldEqualToAnotherWhenSameValue(){
        // given
        int number = 1;
        LottoNumber lottoNumber1 = new LottoNumber(number);
        LottoNumber lottoNumber2 = new LottoNumber(number);

        // when
        boolean equals = lottoNumber1.equals(lottoNumber2);

        // then
        assertThat(equals).isTrue();
    }
}