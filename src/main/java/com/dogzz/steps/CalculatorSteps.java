/*
* @Author: dogzz
* @Created: 6/3/2016
*/

package com.dogzz.steps;

import com.dogzz.page.CalculatorPage;
import com.paulhammant.ngwebdriver.NgWebDriver;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorSteps {

    CalculatorPage calculatorPage;

    @Step
    public void openCalculatorPage() {
        calculatorPage.open();
    }

    @Step
    public void calculateAddition(int firstNumber, int secondNumber) {
        calculateGivenOperation(firstNumber, secondNumber, "+");
    }

    @Step
    public void calculateMultiplication(int firstNumber, int secondNumber) {
        calculateGivenOperation(firstNumber, secondNumber, "*");
    }

    @Step
    public void shouldDisplayCalculationResult(String result) {
        assertThat(getCurrentCalculationResult()).isEqualTo(result);
    }

    private String getCurrentCalculationResult() {
        return calculatorPage.getOperationResult();
    }

    private void calculateGivenOperation(int firstNumber, int secondNumber, String operation) {
        calculatorPage.setFirstNumber(firstNumber);
        calculatorPage.setSecondNumber(secondNumber);
        calculatorPage.selectOperation(operation);
        calculatorPage.performSelectedOperation();
    }
}
