/*
* @Author: dogzz
* @Created: 6/17/2016
*/

package com.dogzz.testing.page;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebDriver;

import static java.util.concurrent.TimeUnit.SECONDS;

@DefaultUrl("http://www.angularjshub.com/code/examples/animations/03_JavaScriptAnimations/index.demo.php")
public class JavaScriptAnimationPage extends BasePage {

    public JavaScriptAnimationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(ngModel = "enterLeaveSwitch")
    private WebElementFacade showSquare;

    @FindBy(xpath = "//div[@ng-if='enterLeaveSwitch']")
    private WebElementFacade square;

    public void checkShowSquare() {
        setCheckbox(showSquare, true);
//        waitForAngular();
        square.withTimeoutOf(5, SECONDS).waitUntilVisible();
    }

    public void uncheckShowSquare() {
        setCheckbox(showSquare, false);
//        waitForAngular();
        square.withTimeoutOf(5, SECONDS).waitUntilNotVisible();
    }

    public boolean isSquarePresent() {
        return square.isPresent();
    }


}
