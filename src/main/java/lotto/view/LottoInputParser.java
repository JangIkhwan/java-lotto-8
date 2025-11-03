package lotto.view;

import lotto.model.LottoNumber;
import lotto.model.LottoPayment;
import lotto.model.LottoWiningNumbers;

import java.util.ArrayList;
import java.util.List;

import static lotto.common.ErrorMessage.INVALID_WINNING_NUMBERS_FORMAT;

public class LottoInputParser {
    private final String DELIMITER = ",";

    public LottoWiningNumbers parseWinningNumbers(String line) {
        if(line.endsWith(DELIMITER)){
            throw new IllegalArgumentException(INVALID_WINNING_NUMBERS_FORMAT.getMessage());
        }
        String[] tokens = line.split(DELIMITER);
        List<LottoNumber> numbers = new ArrayList<>();
        for(String token : tokens){
            int number = Integer.parseInt(token);
            numbers.add(new LottoNumber(number));
        }
        return new LottoWiningNumbers(numbers);
    }

    public LottoNumber parseBonusNumber(LottoWiningNumbers lottoWiningNumbers, String line) {
        int number = Integer.parseInt(line);
        LottoNumber bonusNumber = new LottoNumber(number);
        lottoWiningNumbers.validateBonusNumber(bonusNumber);
        return bonusNumber;
    }

    public LottoPayment parseLottoPayment(String line) {
        int amount = Integer.parseInt(line);
        return new LottoPayment(amount);
    }
}
