/*
* @Author: dogzz
* @Created: 6/7/2016
*/

package com.dogzz.page;

import com.paulhammant.ngwebdriver.NgWebDriver;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.pages.WebElementFacadeImpl;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.WhenPageOpens;
import net.thucydides.core.pages.components.HtmlTable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static ch.lambdaj.Lambda.convert;

@DefaultUrl("http://www.angularjshub.com/code/examples/animations/01_AnimatedDirectives/index.demo.php")
public class AnimatedDirectivesPage extends PageObject {

    NgWebDriver ngDriver = new NgWebDriver((JavascriptExecutor) getDriver());

    public AnimatedDirectivesPage(WebDriver driver) {
        super(driver);
        getDriver().manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
    }

    @FindBy(ngModel = "enterLeaveSwitch")
    private WebElementFacade showSquare;

    @FindBy(ngModel = "addRemoveClassSwitch")
    private WebElementFacade showClassSquare;

    @FindBy(ngModel = "enterLeaveCSSSwitch")
    private WebElementFacade showCSSSquare;

//    @FindBy(className = "box animated-element ng-scope")
    @FindBy(xpath = "//div[@ng-if='enterLeaveSwitch']")
    private WebElementFacade square;

    @FindBy(xpath = "//div[contains(@class, 'custom-class')]")
    private WebElementFacade classSquare;

    @FindBy(xpath = "//div[@ng-if='enterLeaveCSSSwitch']")
    private WebElementFacade cssSquare;

    @FindBy(xpath = "//*[@ng-click='onReverseArrayClick()']")
    private WebElementFacade reverseArray;

    @FindBy(tagName = "ul")
    private WebElementFacade testList;

    @WhenPageOpens
    public void waitForAngularFinish() {
        ngDriver.waitForAngularRequestsToFinish();
    }

    public void checkShowSquare() {
        setCheckbox(showSquare, true);
        ngDriver.waitForAngularRequestsToFinish();
    }

    public void checkShowClassSquare() {
        setCheckbox(showClassSquare, true);
        ngDriver.waitForAngularRequestsToFinish();
    }

    public void checkShowCSSSquare() {
        setCheckbox(showCSSSquare, true);
        ngDriver.waitForAngularRequestsToFinish();
    }

    public void uncheckShowSquare() {
        setCheckbox(showSquare, false);
        ngDriver.waitForAngularRequestsToFinish();
    }

    public void uncheckShowClassSquare() {
        setCheckbox(showClassSquare, false);
        ngDriver.waitForAngularRequestsToFinish();
    }

    public void uncheckShowCSSSquare() {
        setCheckbox(showCSSSquare, false);
        ngDriver.waitForAngularRequestsToFinish();
    }

    public boolean isSquarePresent(String element) {
        switch (element) {
            case "EnterLeave":
                return square.isPresent();
            case "AddRemoveClass":
                return classSquare.isPresent();
        }
        return cssSquare.isPresent();
    }

    public void reverseArray() {
        reverseArray.click();
        ngDriver.waitForAngularRequestsToFinish();
    }

    public List<String> getCurrentArray() {
        return getListOptions(testList);
    }

    private List<String> getListOptions(WebElementFacade elem) {
        List<WebElement> results = Collections.emptyList();
        if (elem != null) {
            results = elem.findElements(By.tagName("li"));
        }
        return convert(results, WebElement::getText);
    }
}
