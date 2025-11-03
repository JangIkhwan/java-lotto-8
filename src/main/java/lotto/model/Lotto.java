package lotto.model;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static lotto.common.ErrorMessage.LOTTO_NUMBER_COUNT_IS_INVALID;
import static lotto.common.ErrorMessage.LOTTO_NUMBER_IS_DUPLICATE;

public class Lotto {
    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        validate(numbers);
        numbers.sort(Comparator.comparing(LottoNumber::getValue));
        this.numbers = numbers;
    }

    public Lotto(Lotto lotto){
        List<LottoNumber> copyedNumbers = lotto.numbers.stream()
                .map(LottoNumber::new)
                .toList();
        this.numbers = copyedNumbers;
    }

    private void validate(List<LottoNumber> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_NUMBER_COUNT_IS_INVALID.getMessage());
        }
        Set<LottoNumber> existings = new HashSet<>();
        for(LottoNumber number : numbers){
            if(existings.contains(number)){
                throw new IllegalArgumentException(LOTTO_NUMBER_IS_DUPLICATE.getMessage());
            }
            existings.add(number);
        }
    }

    public int matchWinningNumber(LottoWiningNumbers winningNumbers) {
        int matched = 0;
        for(LottoNumber number : numbers){
            if(winningNumbers.contains(number)){
                matched++;
            }
        }
        return matched;
    }

    public boolean matchBonusNumber(LottoNumber bonusNumber) {
        for(LottoNumber number : numbers){
            if(number.equals(bonusNumber)){
                return true;
            }
        }
        return false;
    }

    public String convertToString() {
        String collect = numbers.stream()
                .map(LottoNumber::convertToString)
                .collect(Collectors.joining(", "));
        return "[" + collect + "]";
    }
}
