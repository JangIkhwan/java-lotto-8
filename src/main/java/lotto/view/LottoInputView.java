package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.LottoNumber;
import lotto.model.LottoPayment;
import lotto.model.LottoWiningNumbers;

import static lotto.common.ErrorMessage.*;

public class LottoInputView {
    private LottoInputParser lottoInputParser;

    public LottoInputView(){
        lottoInputParser = new LottoInputParser();
    }

    public LottoPayment getPayment() {
        while(true){
            System.out.println("구입금액을 입력해 주세요.");
            String line = Console.readLine();
            try {
                LottoPayment lottoPayment = lottoInputParser.parseLottoPayment(line);
                System.out.println();
                return lottoPayment;
            }
            catch (RuntimeException e){
                printPaymentError(e);
            }
        }
    }

    private void printPaymentError(RuntimeException e) {
        if (e instanceof NumberFormatException){
            System.out.println(PAYMENT_IS_NOT_INTEGER.getMessage());
            return;
        }
        if(e instanceof IllegalArgumentException){
            System.out.println(e.getMessage());
        }
    }

    public LottoWiningNumbers getWiningNumbers() {
        while(true) {
            System.out.println("당첨 번호를 입력해 주세요.");
            String line = Console.readLine();
            try {
                LottoWiningNumbers winingNumbers = lottoInputParser.parseWinningNumbers(line);
                System.out.println();
                return winingNumbers;
            } catch (RuntimeException e) {
                printWinningNumbersError(e);
            }
        }
    }

    private void printWinningNumbersError(RuntimeException e) {
        if(e instanceof NumberFormatException ){
            System.out.println(WINNING_NUMBER_IS_NOT_INTEGER.getMessage());
            return;
        }
        if (e instanceof IllegalArgumentException){
            System.out.println(e.getMessage());
        }
    }


    public LottoNumber getBonusNumber(LottoWiningNumbers lottoWiningNumbers) {
        while(true){
            System.out.println("보너스 번호를 입력해 주세요.");
            String line = Console.readLine();
            try{
                LottoNumber bonusNumber = lottoInputParser.parseBonusNumber(lottoWiningNumbers, line);
                System.out.println();
                return bonusNumber;
            }
            catch (RuntimeException e){
                printBonuseNumberError(e);
            }
        }
    }

    private void printBonuseNumberError(RuntimeException e) {
        if(e instanceof NumberFormatException ){
            System.out.println(BONUS_NUMBER_IS_NOT_INTEGER.getMessage());
            return;
        }
        if (e instanceof IllegalArgumentException ){
            System.out.println(e.getMessage());
        }
    }
}

