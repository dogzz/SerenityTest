/*
* @Author: dogzz
* @Created: 6/3/2016
*/

package com.dogzz.testing.stepdefinitions;

import com.dogzz.testing.TestProperties;
import com.dogzz.testing.steps.CalculatorSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


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
    public void initEverything() throws IOException {
        System.out.println("init test context");
        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream("test.properties");
            prop.load(input);
            TestProperties.jiraUrl = prop.getProperty("jiraurl");
            TestProperties.angularServicesUrl = prop.getProperty("angularServicesUrl");
            TestProperties.withProxy = Boolean.valueOf(prop.getProperty("proxy"));
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
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
