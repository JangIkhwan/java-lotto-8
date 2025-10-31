package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.LottoPayment;
import lotto.model.LottoWiningNumbers;

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
                int amount = Integer.parseInt(line);
                return new LottoPayment(amount);
            }
            catch (NumberFormatException e){
                System.out.println("[ERROR] 구입금액은 정수여야 합니다.");
            }
            catch (IllegalArgumentException e){
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    public LottoWiningNumbers getWiningNumbers() {
        while(true){
            System.out.println("당첨 번호를 입력해 주세요.");
            String line = Console.readLine();
            try{
                return lottoInputParser.parseWinningNumbers(line);
            }
            catch (NumberFormatException e){
                System.out.println("[ERROR] 당첨 번호는 숫자여야 합니다.");
            }
            catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
