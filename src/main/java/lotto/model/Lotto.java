package lotto.model;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
        Set<LottoNumber> existings = new HashSet<>();
        for(LottoNumber number : numbers){
            if(existings.contains(number)){
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복된 숫자가 없어야 합니다.");
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
