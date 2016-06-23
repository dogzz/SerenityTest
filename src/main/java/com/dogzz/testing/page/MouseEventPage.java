/*
* @Author: dogzz
* @Created: 6/22/2016
*/

package com.dogzz.testing.page;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

@DefaultUrl("http://www.angularjshub.com/code/examples/eventhandlers/01_MouseEvents/index.demo.php")
public class MouseEventPage  extends BasePage {

    @FindBy(css = "[ng-dblclick*='onDblClick']")
    private WebElementFacade doubleClickShape;

    @FindBy(css = "[ng-mousemove*='onMouseMove']")
    private WebElementFacade moveMouseShape;

    @FindBy(xpath = "//div")
    private WebElementFacade allResults;

    public MouseEventPage(WebDriver driver) {
        super(driver);
    }

    public void doubleClickOnShape() {
        new Actions(getDriver()).doubleClick(doubleClickShape).perform();
    }

    public String getAllResults() {
        return allResults.getText();
    }

    public void moveMouseOverShape(int x, int y) {
        new Actions(getDriver()).moveToElement(moveMouseShape, x, y).perform();
    }
}
