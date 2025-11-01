package lotto.model;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        numbers.sort(Integer::compareTo);
        this.numbers = numbers;
    }

    public Lotto(Lotto lotto){
       this.numbers = lotto.getNumbers();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private List<Integer> getNumbers(){
        List<Integer> copyedNumbers = numbers.stream()
                .map(i -> Integer.valueOf(i))
                .toList();
        return copyedNumbers;
    }
}
