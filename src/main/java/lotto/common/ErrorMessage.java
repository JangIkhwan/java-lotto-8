package lotto.common;

public enum ErrorMessage {
    PAYMENT_IS_NOT_INTEGER("[ERROR] 구입금액은 숫자여야 합니다."),
    WINNING_NUMBER_IS_NOT_INTEGER("[ERROR] 당첨 번호는 숫자여야 합니다."),
    BONUS_NUMBER_IS_NOT_INTEGER("[ERROR] 보너스 번호는 숫자여야 합니다."),
    INVALID_WINNING_NUMBERS_FORMAT("[ERROR] 구분자 다음에 숫자가 나와야 합니다."),
    LOTTO_NUMBER_COUNT_IS_INVALID("[ERROR] 로또 번호는 6개여야 합니다."),
    LOTTO_NUMBER_IS_DUPLICATE("[ERROR] 로또 번호는 중복된 숫자가 없어야 합니다."),
    LOTTO_NUMBER_IS_OUT_OF_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    WINNING_NUMBER_IS_DUPLICATE("[ERROR] 당첨 번호에는 중복된 번호가 존재할 수 없습니다."),
    WINNING_NUMBER_COUNT_IS_INVALID("[ERROR] 로또 당첨 번호는 6개여야 합니다."),
    WINNING_NUMBER_AND_BONUS_NUMBER_IS_SAME("[ERROR] 보너스 번호는 로또 당첨 번호와 겹칠 수 없습니다."),
    PAYMENT_IS_OUT_OF_RANGE("[ERROR] 구매 금액은 음수일 수 없습니다."),
    PAYMENT_UNIT_IS_INVALID("[ERROR] 구매 금액은 1000원 단위로 나누어 떨어져야 합니다."),
    PARAMETER_IS_NULL("[ERROR] 인자는 null일 수 없습니다");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
