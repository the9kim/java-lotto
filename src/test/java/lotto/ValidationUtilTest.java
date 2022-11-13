package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import static org.assertj.core.api.Assertions.assertThat;

import lotto.util.ValidationUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class ValidationUtilTest {

    @Test
    @DisplayName("로또 구입 금액 입력값 정적성 검토")

    void validatePurchaseAmountInput() {
        int purchaseAmount = -1004;

        boolean isPositiveNum = ValidationUtil.validatePositiveNum(purchaseAmount);
        boolean isRemainder = ValidationUtil.validateRemainder(purchaseAmount);

        assertThat(isPositiveNum).isFalse();
        assertThat(isRemainder).isFalse();
    }

    @Test
    @DisplayName("당첨번호 입력값 길이 및 콤마 검증")

    void validateLengthAndComma() {
        String winningNumInput = "1,2,3,4,5,6";

        boolean valInputLength = ValidationUtil.isLengthIncludingComma(winningNumInput);
        boolean valInputComma = ValidationUtil.isComma(winningNumInput);

        assertThat(valInputLength).isTrue();
        assertThat(valInputComma).isTrue();
    }

    @Test
    @DisplayName("당첨번호 입력값 숫자 여부 검증")

    void IsDigit() {
        String winningNum1 = "11";
        String winningNum2 = "aa";

        boolean isDigit1 = ValidationUtil.isDigit(winningNum1);
        boolean isDigit2 = ValidationUtil.isDigit(winningNum2);

        assertThat(isDigit1).isTrue();
        assertThat(isDigit2).isFalse();
    }

    @Test
    @DisplayName("당첨 번호 입력값 숫자 범위 검증")
    void IsInRange() {
        Integer winningNum1 = 11;
        Integer winningNum2 = 0;
        Integer winningNum3 = 60;

        boolean isDigit1 = ValidationUtil.isInRange(winningNum1);
        boolean isDigit2 = ValidationUtil.isInRange(winningNum2);
        boolean isDigit3 = ValidationUtil.isInRange(winningNum3);

        assertThat(isDigit1).isTrue();
        assertThat(isDigit2).isFalse();
        assertThat(isDigit3).isFalse();
    }

    @Test
    @DisplayName("당첨 번호 입력값 중복 여부 검증")
    void IsDuplicate() {


        Integer winningNum1 = 11;
        Integer winningNum2 = 45;
        List<Integer> winningNumList = Arrays.asList(11);

        boolean isDigit1 = ValidationUtil.isDuplicate(winningNumList, winningNum1);
        boolean isDigit2 = ValidationUtil.isDuplicate(winningNumList, winningNum2);

        assertThat(isDigit1).isTrue();
        assertThat(isDigit2).isFalse();
    }
}