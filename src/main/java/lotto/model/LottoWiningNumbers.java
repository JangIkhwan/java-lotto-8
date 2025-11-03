package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.common.ErrorMessage.*;

public class LottoWiningNumbers {
    private List<LottoNumber> winningNumbers;

    public LottoWiningNumbers(List<LottoNumber> numbers) {
        validateLength(numbers);
        validateDuplicateNumber(numbers);
        winningNumbers = numbers;
    }

    private void validateDuplicateNumber(List<LottoNumber> numbers) {
        Set<LottoNumber> existings = new HashSet();
        for(LottoNumber number : numbers){
            if(existings.contains(number)){
                throw new IllegalArgumentException(WINNING_NUMBER_IS_DUPLICATE.getMessage());
            }
            existings.add(number);
        }
    }

    private static void validateLength(List<LottoNumber> numbers) {
        if(numbers.size() != 6){
            throw new IllegalArgumentException(WINNING_NUMBER_COUNT_IS_INVALID.getMessage());
        }
    }

    public void validateBonusNumber(LottoNumber bonusNumber) {
        if(winningNumbers.contains(bonusNumber)){
            throw new IllegalArgumentException(WINNING_NUMBER_AND_BONUS_NUMBER_IS_SAME.getMessage());
        }
    }

    public boolean contains(LottoNumber number) {
        for(LottoNumber winningNumber : winningNumbers){
            if(winningNumber.equals(number)){
                return true;
            }
        }
        return false;
    }
}
