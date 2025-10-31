package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoWiningNumbersTest {
    @DisplayName("로또 당첨 번호 생성에 성공한다")
    @Test
    void shouldCreateLottoWinningNumbers(){
        // given
        List<LottoNumber> lottoNumbers = List.of(new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6));

        // when & then
        assertDoesNotThrow(() -> new LottoWiningNumbers(lottoNumbers));
    }

    @DisplayName("로또 당첨 번호에 중복된 수가 존재하면 예외를 발생시킨다")
    @Test
    void shouldThrowExceptionWhenNumberIsDuplicate(){
        // given
        int sameNumber = 1;
        List<LottoNumber> lottoNumbers = List.of(new LottoNumber(sameNumber),
                new LottoNumber(sameNumber),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6));

        // when & then
        assertThatThrownBy(() -> new LottoWiningNumbers(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 당첨 번호가 6개가 아니면 예외를 발생시킨다")
    @Test
    void shouldThrowExceptionWhenLengthIsNot6(){
        // given
        List<LottoNumber> lottoNumbers1 = List.of(new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5));

        List<LottoNumber> lottoNumbers2 = List.of(new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6),
                new LottoNumber(7));

        // when & then
        assertThatThrownBy(() -> new LottoWiningNumbers(lottoNumbers1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new LottoWiningNumbers(lottoNumbers2))
                .isInstanceOf(IllegalArgumentException.class);
    }

}