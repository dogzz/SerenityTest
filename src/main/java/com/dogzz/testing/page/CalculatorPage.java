/*
* @Author: dogzz
* @Created: 6/3/2016
*/

package com.dogzz.testing.page;

import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.ByAngularBinding;
import com.paulhammant.ngwebdriver.NgWebDriver;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

@DefaultUrl("http://juliemr.github.io/protractor-demo/")
public class CalculatorPage extends PageObject {

    NgWebDriver ngDriver = new NgWebDriver((JavascriptExecutor) getDriver());

    @FindBy(ngModel="first")
    private WebElementFacade firstNumber;

    @FindBy(ngModel="second")
    private WebElementFacade secondNumber;

    @FindBy(ngModel="operator")
    private WebElementFacade operator;

    @FindBy(id="gobutton")
    private WebElementFacade goButton;

    @FindBy(xpath = "//h2[@class='ng-binding']")
    private WebElementFacade result;

    public CalculatorPage(WebDriver driver) {
        super(driver);
    }

    public void setFirstNumber(int number) {
        typeInto(firstNumber, String.valueOf(number));
    }

    public void setSecondNumber(int number) {
        typeInto(secondNumber, String.valueOf(number));
    }

    public void selectOperation(String operation) {
        selectFromDropdown(operator, operation);
    }

    public void performSelectedOperation() {
        clickOn(goButton);
    }

    public String getOperationResult() {
        getDriver().manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
        ngDriver.waitForAngularRequestsToFinish();
//        return getDriver().findElement(ByAngular.binding("latest")).getText();
        return result.getText();
    }
}
