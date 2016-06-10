/*
* @Author: dogzz
* @Created: 6/6/2016
*/

package com.dogzz.stepdefinitions;

import com.dogzz.steps.CalculatorSteps;
import com.dogzz.steps.RepeaterSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class RepeaterStepDefinitions {

    @Steps
    RepeaterSteps repeaterSteps;

    @Given("repeater is open")
    public void openCalculator() {
        repeaterSteps.openRepeaterPage();
    }

    @When("I adding item")
    @Given("one item is added")
    public void addNewItem() {
        repeaterSteps.addNewItem();
    }

    @When("I removing one item")
    public void removeItem() {
        repeaterSteps.removeItem(0);
    }

    @Then("new item is added")
    public void newItemAdded() {
        repeaterSteps.itemShouldExists(0);
    }

    @Then("removed item is not displayed")
    public void removedItemIsNotDisplayed() {
        repeaterSteps.itemShouldNotExists(0);
    }

    @Then("table is not displayed")
    public void tableIsNotDisplayed() {
        repeaterSteps.tableShouldNotExists();
    }

    @Then("new item is added with incremented name")
    public void newItemAddedWithIncrementedName() {
        repeaterSteps.itemShouldExists(1);
        repeaterSteps.twoItemsHaveIncrementedNames(0, 1);
    }
}
