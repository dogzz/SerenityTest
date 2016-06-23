/*
* @Author: dogzz
* @Created: 6/22/2016
*/

package com.dogzz.testing.stepdefinitions;

import com.dogzz.testing.steps.MouseActionsSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class MouseActionsStepDefinitions {

    @Steps
    MouseActionsSteps mouseActionsSteps;

    @Given("a mouse event is open")
    public void openMouseEventsPage() {
        mouseActionsSteps.openMouseEventsPage();
    }

    @When(value = "I double click on DoubleClickShape element", priority = 1)
    public void doubleClickOnShape() {
        mouseActionsSteps.performDoubleClickOnShape();
    }

    @Then("result is $result")
    public void resultIs(String result) {
        mouseActionsSteps.doubleClickResultShouldBe(result);
    }

    @When(value = "I move mouse over MouseMoveShape element with $x, $y coordinates", priority = 1)
    public void moveMouseWithCoordinates(int x, int y) {
        mouseActionsSteps.moveMouseOverShapeWithCoordinates(x, y);
    }

    @Then("$x, $y coordinates are displayed in $result RESULT")
    public void verifyCoordinates(int x, int y, String result) {
        mouseActionsSteps.moveCoordinatesShouldDisplayForResult(x, y, result);
    }
}
