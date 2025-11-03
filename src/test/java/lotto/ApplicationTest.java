package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static lotto.common.ErrorMessage.*;
import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("입력이 올바르면 결과를 반환한다")
    @Test
    void 기능_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("8000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "8개를 구매했습니다.",
                            "[8, 21, 23, 41, 42, 43]",
                            "[3, 5, 11, 16, 32, 38]",
                            "[7, 11, 16, 35, 36, 44]",
                            "[1, 8, 11, 31, 41, 42]",
                            "[13, 14, 16, 38, 42, 45]",
                            "[7, 11, 30, 40, 42, 43]",
                            "[2, 13, 22, 32, 38, 45]",
                            "[1, 3, 5, 14, 22, 45]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 62.5%입니다."
                    );
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }

    @DisplayName("예외 상황이 발생하면 ERROR로 시작하는 메시지를 출력한다")
    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("구매금액이 숫자가 아니면 예외를 발생시킨다")
    @Test
    void shouldThrowExceptionWhenPaymentIsNotNumber() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(PAYMENT_IS_NOT_INTEGER.getMessage());
        });
    }

    @DisplayName("구매금액이 1000원 단위가 아니면 예외를 발생시킨다")
    @Test
    void shouldThrowExceptionWhenPaymentUnitIsInvalid() {
        assertSimpleTest(() -> {
            runException("100");
            assertThat(output()).contains(PAYMENT_UNIT_IS_INVALID.getMessage());
        });
    }

    @DisplayName("당첨번호 끝에 콤마가 오면 예외가 발생한다")
    @Test
    void shouldThrowExceptionWhenWinningNumbersEndsWithDelimiter() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6,");
            assertThat(output()).contains(INVALID_WINNING_NUMBERS_FORMAT.getMessage());
        });
    }

    @DisplayName("당첨번호가 범위를 벗어나면 예외가 발생한다")
    @Test
    void shouldThrowExceptionWhenWinningNumbersIsOutOfRange() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,99");
            assertThat(output()).contains(LOTTO_NUMBER_IS_OUT_OF_RANGE.getMessage());
        });
    }

    @DisplayName("당첨번호 개수가 6개가 아니면 예외가 발생한다")
    @Test
    void shouldThrowExceptionWhenWinningNumbersCountIsInvalid() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4");
            assertThat(output()).contains(WINNING_NUMBER_COUNT_IS_INVALID.getMessage());
        });
    }

    @DisplayName("당첨번호에 중복된 숫자가 존재하면 예외가 발생한다")
    @Test
    void shouldThrowExceptionWhenWinningNumberIsDuplicate() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,4,5");
            assertThat(output()).contains(WINNING_NUMBER_IS_DUPLICATE.getMessage());
        });
    }

    @DisplayName("당첨번호와 보너스 번호가 겹치면 예외가 발생한다")
    @Test
    void shouldThrowExceptionWhenWinningNumbersIsSameAsBonusNumber() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,45", "45");
            assertThat(output()).contains(WINNING_NUMBER_AND_BONUS_NUMBER_IS_SAME.getMessage());
        });
    }

    @DisplayName("두 번 1등해도 결과를 반환한다")
    @Test
    void shouldReturnCorrectResultWhenWinTwoFirst() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("2000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "2개를 구매했습니다.",
                            "[1, 2, 3, 4, 5, 6]",
                            "[1, 2, 3, 4, 5, 6]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 2개",
                            "총 수익률은 200000000.0%입니다."
                    );
                },
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 6)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
