package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.LottoPayment;

public class LottoInputView {
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
}
