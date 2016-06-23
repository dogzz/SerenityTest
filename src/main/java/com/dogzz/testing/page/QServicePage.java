/*
* @Author: dogzz
* @Created: 6/13/2016
*/

package com.dogzz.testing.page;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebDriver;

@DefaultUrl("http://www.angularjshub.com/code/examples/servercalls/02_QService/index.demo.php")
public class QServicePage extends BasePage{

    @FindBy(xpath = "//button[@ng-click='aggregatedHTTPAsyncFunc(true, true, true)']")
    private WebElementFacade httpSuccess;

    @FindBy(xpath = "//button[@ng-click='whenAsyncFunc(true, true)']")
    private WebElementFacade fakeSuccess;

    @FindBy(xpath = "//button[@ng-click='aggregatedHTTPAsyncFunc(false, false, false)']")
    private WebElementFacade httpFailure;

    @FindBy(xpath = "//button[@ng-click='whenAsyncFunc(true, false)']")
    private WebElementFacade fakeFailure;

    @FindBy()
    private WebElementFacade fakeResult;

    @FindBy()
    private WebElementFacade httpResult;

    @FindBy(xpath = "//div")
    private WebElementFacade allResults;

    public QServicePage(WebDriver driver) {
        super(driver);
    }

    public void executeSuccessForHttpService() {
        httpSuccess.click();
    }

    public void executeSuccessForFakeService() {
        fakeSuccess.click();
    }

    public void executeFailureForHttpService() {
        httpFailure.click();
    }

    public void executeFailureForFakeService() {
        fakeFailure.click();
    }

    public String getHttpServiceActionResult() {
        return null;
    }

    public String getFakeServiceActionResult() {
        return null;
    }

    public String getAllResults() {
        waitForAngular();
        waitForTextToDisappear("Waiting for all the results", 10000);
        return allResults.getText();
    }
}
