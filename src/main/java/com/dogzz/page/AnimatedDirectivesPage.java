/*
* @Author: dogzz
* @Created: 6/7/2016
*/

package com.dogzz.page;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.WhenPageOpens;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Collections;
import java.util.List;

import static ch.lambdaj.Lambda.convert;

@DefaultUrl("http://www.angularjshub.com/code/examples/animations/01_AnimatedDirectives/index.demo.php")
public class AnimatedDirectivesPage extends BasePage {

    public AnimatedDirectivesPage(WebDriver driver) {
        super(driver);
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
        waitForAngular();
    }

    public void checkShowClassSquare() {
        setCheckbox(showClassSquare, true);
        waitForAngular();
    }

    public void checkShowCSSSquare() {
        setCheckbox(showCSSSquare, true);
        waitForAngular();
    }

    public void uncheckShowSquare() {
        setCheckbox(showSquare, false);
        waitForAngular();
    }

    public void uncheckShowClassSquare() {
        setCheckbox(showClassSquare, false);
        waitForAngular();
    }

    public void uncheckShowCSSSquare() {
        setCheckbox(showCSSSquare, false);
        waitForAngular();
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
        waitForAngular();
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
