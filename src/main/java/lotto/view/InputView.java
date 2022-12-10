package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.io.StringReader;

public class InputView {

    public static String readPurchasingAmount() {
        System.out.println("구입 금액을 입력해주세요");
        String input = Console.readLine();
        isBlank(input);
        isDigit(input);
        return input;
    }

    public static String readWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        isBlank(input);
        validateDigitAndComma(input);
        validateComma(input);
        return input;
    }

    public static String readBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        isBlank(input);
        isDigit(input);
        return input;
    }

    private static void isBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 공백은 입력할 수 없습니다");
        }
    }

    private static void isDigit(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                throw new IllegalArgumentException("[ERROR] 정수가 아닙니다.");
            }
        }

    }
    private static void validateDigitAndComma(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != ',' && !Character.isDigit(input.charAt(i))) {
                throw new IllegalArgumentException("[ERROR] 정수 및 콤마 외에 입력할 수 없습니다.");
            }
        }
    }

    private static void validateComma(String input) {
        if (input.contains(",,") || input.startsWith(",") || input.endsWith(",")) {
            throw new IllegalArgumentException("[ERROR] 콤마를 바르게 입력하세요.");
        }
    }
}
