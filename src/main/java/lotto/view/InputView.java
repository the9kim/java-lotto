package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {

    public static String readPurchasingMoney() {
        System.out.print("구입 금액을 입력해주세요: ");
        String purchasingMoney = Console.readLine();
        isBlank(purchasingMoney);
        isDigit(purchasingMoney);
        return purchasingMoney;
    }

    public static String readWinningNumber() {
        System.out.print("당첨 번호를 입력해주세요: ");
        String winningNumberInput = Console.readLine();
        isBlank(winningNumberInput);
        validateFormat(winningNumberInput);
        return winningNumberInput;
    }

    public static String readBonusNumber() {
        System.out.print("보너스 번호를 입력해주세요: ");
        String bonusNumberInput = Console.readLine();
        isBlank(bonusNumberInput);
        isDigit(bonusNumberInput);
        return bonusNumberInput;
    }

    private static void isBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 공백은 입력할 수 없습니다");
        }
    }

    private static void isDigit(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값은 입력할 수 없습니다.");
            }
        }
    }

    private static void validateFormat(String input) {
        validateStartsAndEnds(input);
        isDuplicationOfComma(input);
        isDigitAndComma(input);

    }
    private static void validateStartsAndEnds(String input) {
        if (input.startsWith(",") || input.endsWith(",")) {
            throw new IllegalArgumentException("[ERROR] 처음과 끝을 콤마로 입력할 수 없습니다.");
        }
    }

    private static void isDuplicationOfComma(String input) {
        if (input.contains(",,")) {
            throw new IllegalArgumentException("[ERROR] 콤마를 중복으로 입력할 수 없습니다.");
        }
    }

    private static void isDigitAndComma(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i)) && input.charAt(i) != ',') {
                throw new IllegalArgumentException("[ERROR] 숫자와 콤마 외에 입력할 수 없습니다.");
            }
        }
    }
}
