package lotto.model.judge;

import lotto.model.Lotto;
import lotto.model.LottoNumber;
import lotto.model.LottoPayment;
import lotto.model.LottoWiningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoJudgeTest {
    @DisplayName("로또 심판 생성에 성공한다.")
    @Test
    void shouldCreateLottoJudge(){
        // given
        List<LottoNumber> numbers = List.of(new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6));
        LottoWiningNumbers winingNumbers = new LottoWiningNumbers(numbers);
        LottoNumber bonusNumber = new LottoNumber(9);
        LottoPayment lottoPayment = new LottoPayment(2000);

        // when & then
        assertDoesNotThrow(() -> new LottoJudge(winingNumbers, bonusNumber, lottoPayment));
    }

    @DisplayName("1등으로 판정한다")
    @Test
    void shouldReturnFirstRank(){
        // given
        List<LottoNumber> numbers = new ArrayList<>(List.of(new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)));

        LottoWiningNumbers winingNumbers = new LottoWiningNumbers(numbers);
        LottoNumber bonusNumber = new LottoNumber(9);

        Lotto lotto = new Lotto(numbers);

        LottoPayment lottoPayment = new LottoPayment(2000);
        LottoJudge lottoJudge = new LottoJudge(winingNumbers, bonusNumber, lottoPayment);

        // when
        LottoRank rank = lottoJudge.check(lotto);

        // then
        assertThat(rank).isEqualTo(LottoRank.FIRST);
    }

    @DisplayName("2등으로 판정한다")
    @Test
    void shouldReturnSecondRank(){
        // given
        List<LottoNumber> winningNumbers = new ArrayList<>(List.of(new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)));

        LottoWiningNumbers winingNumbers = new LottoWiningNumbers(winningNumbers);
        LottoNumber bonusNumber = new LottoNumber(9);

        List<LottoNumber> secondNumbers = new ArrayList<>(List.of(new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(9)));

        Lotto lotto = new Lotto(secondNumbers);
        LottoPayment lottoPayment = new LottoPayment(2000);
        LottoJudge lottoJudge = new LottoJudge(winingNumbers, bonusNumber, lottoPayment);

        // when
        LottoRank rank = lottoJudge.check(lotto);

        // then
        assertThat(rank).isEqualTo(LottoRank.SECOND);
    }

    @DisplayName("낙첨으로 판정한다")
    @Test
    void shouldReturnLose(){
        // given
        List<LottoNumber> winNumbers = new ArrayList<>(List.of(new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)));

        List<LottoNumber> numbers = new ArrayList<>(List.of(new LottoNumber(11),
                new LottoNumber(12),
                new LottoNumber(13),
                new LottoNumber(14),
                new LottoNumber(15),
                new LottoNumber(16)));

        Lotto lotto = new Lotto(numbers);

        LottoWiningNumbers winingNumbers = new LottoWiningNumbers(winNumbers);
        LottoNumber bonusNumber = new LottoNumber(9);
        LottoPayment lottoPayment = new LottoPayment(2000);
        LottoJudge lottoJudge = new LottoJudge(winingNumbers, bonusNumber, lottoPayment);

        // when
        LottoRank rank = lottoJudge.check(lotto);

        // then
        assertThat(rank).isEqualTo(LottoRank.LOSE);
    }

    @DisplayName("결과와 수익률 계산에 성공한다")
    @Test
    void shouldReturnResultContainingTwoFirstRank(){
        // given
        List<LottoNumber> firstWinningNumbers = new ArrayList<>(List.of(new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)));

        List<LottoNumber> loseNumbers = new ArrayList<>(List.of(new LottoNumber(11),
                new LottoNumber(12),
                new LottoNumber(13),
                new LottoNumber(14),
                new LottoNumber(15),
                new LottoNumber(16)));

        Lotto lotto1 = new Lotto(firstWinningNumbers);
        Lotto lotto2 = new Lotto(firstWinningNumbers);
        Lotto lotto3 = new Lotto(loseNumbers);

        LottoWiningNumbers winingNumbers = new LottoWiningNumbers(firstWinningNumbers);
        LottoNumber bonusNumber = new LottoNumber(9);
        LottoPayment lottoPayment = new LottoPayment(3000);
        LottoJudge lottoJudge = new LottoJudge(winingNumbers, bonusNumber, lottoPayment);

        // when
        lottoJudge.check(lotto1);
        lottoJudge.check(lotto2);
        lottoJudge.check(lotto3);
        LottosResult result = lottoJudge.getResult();

        // then
        assertThat(result.getRows()).hasSize(5);
        assertThat(result.getRows().get(0).getCount()).isEqualTo(0);
        assertThat(result.getRows().get(1).getCount()).isEqualTo(0);
        assertThat(result.getRows().get(2).getCount()).isEqualTo(0);
        assertThat(result.getRows().get(3).getCount()).isEqualTo(0);
        assertThat(result.getRows().get(4).getCount()).isEqualTo(2);
        assertThat(result.getRoi()).isEqualTo((double) (LottoWinningInfo.FIRST.getWinnings() * 100 * 2) / lottoPayment.getValue());
    }
}