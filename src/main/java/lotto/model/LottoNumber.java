package lotto.model;

import java.util.Objects;

import static lotto.common.ErrorMessage.LOTTO_NUMBER_IS_OUT_OF_RANGE;

public class LottoNumber {
    private final int number;

    public LottoNumber(int number) {
        validateRange(number);
        this.number = number;
    }

    public LottoNumber(LottoNumber lottoNumber){
        this.number = lottoNumber.number;
    }

    private static void validateRange(int number) {
        if(number < 1 || number > 45){
            throw new IllegalArgumentException(LOTTO_NUMBER_IS_OUT_OF_RANGE.getMessage());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(number);
    }

    public int getValue() {
        return number;
    }

    public String convertToString() {
        return String.valueOf(number);
    }
}
