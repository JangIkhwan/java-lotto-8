package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoIssuerTest {
    @DisplayName("로또 발행에 성공한다")
    @Test
    void shouldIssueLottos(){
        LottoPayment lottoPayment = new LottoPayment(20000);
        LottoIssuer lottoIssuer = new LottoIssuer();

        List<Lotto> lottos = lottoIssuer.issueLottos(lottoPayment);

        assertThat(lottos).isNotEmpty();
        assertThat(lottos).hasSize(20);
    }
}