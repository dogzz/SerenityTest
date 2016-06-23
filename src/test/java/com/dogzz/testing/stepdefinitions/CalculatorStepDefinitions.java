/*
* @Author: dogzz
* @Created: 6/3/2016
*/

package com.dogzz.testing.stepdefinitions;

import com.dogzz.testing.steps.CalculatorSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.*;


public class CalculatorStepDefinitions {

    @Steps
    CalculatorSteps calculatorSteps;

    @Given("a calculator $sd open")
    public void openCalculator() {
        calculatorSteps.openCalculatorPage();
    }

    @When(value = "I $operation $firstNum and $secondNum")
    public void performAdding(String operation, int firstNum, int secondNum) {
        switch (operation) {
            case "add":
                calculatorSteps.calculateAddition(firstNum, secondNum);
                break;
            case "multiply":
                calculatorSteps.calculateMultiplication(firstNum, secondNum);
                break;
        }

    }

    @Then("result $result is displayed")
    public void openCalculator(String result) {
        calculatorSteps.shouldDisplayCalculationResult(result);
    }

    @BeforeStories
    public void initEverything() {
        System.out.println("init test context");
    }

    @AfterStories
    public void shutDownEverything() {
        System.out.println("shutdown test context");
    }

    @BeforeStory
    public void startBrowser() {
        System.out.println("starting and init browser");
    }

    @AfterStory
    public void stopBrowser() {
        System.out.println("stopping browser");
    }

}