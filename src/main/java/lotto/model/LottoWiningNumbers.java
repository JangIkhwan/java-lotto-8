package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
                throw new IllegalArgumentException("[ERROR] 당첨 번호에는 중복된 번호가 존재할 수 없습니다.");
            }
            existings.add(number);
        }
    }

    private static void validateLength(List<LottoNumber> numbers) {
        if(numbers.size() != 6){
            throw new IllegalArgumentException("[ERROR] 로또 당첨 번호는 6개여야 합니다.");
        }
    }

    public void validateBonusNumber(LottoNumber bonusNumber) {
        if(winningNumbers.contains(bonusNumber)){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 로또 당첨 번호와 겹칠 수 없습니다.");
        }
    }
}
