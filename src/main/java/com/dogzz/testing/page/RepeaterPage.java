/*
* @Author: dogzz
* @Created: 6/6/2016
*/

package com.dogzz.testing.page;

import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.ByAngularBinding;
import com.paulhammant.ngwebdriver.ByAngularRepeater;
import com.paulhammant.ngwebdriver.NgWebDriver;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.components.HtmlTable;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@DefaultUrl("http://www.angularjshub.com/code/examples/collections/01_Repeater/index.demo.php")
public class RepeaterPage  extends PageObject {

    NgWebDriver ngDriver = new NgWebDriver((JavascriptExecutor) getDriver());

    public RepeaterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@ng-click='addStringToArray()']")
    private WebElementFacade addItem;

    @FindBy(xpath = "/button")
    private WebElementFacade removeItem;

    @FindBy(xpath = "//table[descendant::button]")
    private WebElementFacade table;

    private HtmlTable itemsTable = new HtmlTable(table, Arrays.asList("removeButton", "itemName"));



    ByAngularBinding item = ByAngular.binding("str");

    ByAngularRepeater itemRow = ByAngular.repeater("str in stringsArray");

    public void addItem() {
        addItem.click();
    }

    public void removeItem(int index) {
//        itemRow.row(index).findElement(getDriver()).click();
        itemsTable.getRowElements().get(index).findElement(By.xpath(".//button")).click();
    }

    public boolean isItemExists(int index) {
//        return element(itemRow.row(index)).isPresent();
        return isTableExists() && getItemsTableContent().get(index) != null;
    }

    public String getTextForItemWithIndex(int index) {
        return getItemsTableContent().get(index).get("itemName");
    }

    public boolean isTableExists() {
        return table.isPresent();
    }

    private List<Map<Object, String>> getItemsTableContent() {
        return itemsTable.getRows();
//        return HtmlTable.withColumns("removeButton", "itemName")
//                .readRowsFrom(itemsTable);
    }


}
