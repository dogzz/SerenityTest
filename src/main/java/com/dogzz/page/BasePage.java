/*
* @Author: dogzz
* @Created: 6/13/2016
*/

package com.dogzz.page;

import com.paulhammant.ngwebdriver.NgWebDriver;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class BasePage extends PageObject {

    protected NgWebDriver ngDriver = new NgWebDriver((JavascriptExecutor) getDriver());

    public BasePage(WebDriver driver) {
        super(driver);
        getDriver().manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
    }

    protected void waitForAngular() {
        ngDriver.waitForAngularRequestsToFinish();
    }
}
