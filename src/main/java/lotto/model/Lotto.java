package lotto.model;

import java.util.Comparator;
import java.util.List;

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
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
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
}
