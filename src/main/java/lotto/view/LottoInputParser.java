package lotto.view;

import lotto.model.LottoNumber;
import lotto.model.LottoWiningNumbers;

import java.util.ArrayList;
import java.util.List;

public class LottoInputParser {
    private final String DELIMITER = ",";

    public LottoWiningNumbers parseWinningNumbers(String line) {
        if(line.endsWith(DELIMITER)){
            throw new IllegalArgumentException("[ERROR] 구분자 다음에 숫자가 나와야 합니다.");
        }
        String[] tokens = line.split(DELIMITER);
        List<LottoNumber> numbers = new ArrayList<>();
        for(String token : tokens){
            int number = Integer.parseInt(token);
            numbers.add(new LottoNumber(number));
        }
        return new LottoWiningNumbers(numbers);
    }
}
